import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RegistrationTest {
    RegistrationPage registrationPage = open(RegistrationPage.PAGE_URL, RegistrationPage.class);

    @Before
    public void setUp() {
        browser = "chrome";
    }

    @Test
    @DisplayName("Should a successful registration")
    public void successRegisterNewUserTest() {
        User user = User.getRandomUser();

        registrationPage
                .fillRegistrationForm(user)
                .confirmRegistration();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }

    @Test
    @DisplayName("You cannot register a new user if the password is short.")
    public void regErrorWhenPasswordIsShortTest() {
        User user = User.getRandomUser();
        user.setPassword(RandomStringUtils.randomAlphabetic(5));

        registrationPage
                .fillRegistrationForm(user)
                .confirmRegistration();

        Assert.assertTrue(
                "Error should be shown, when registering with a short password",
                registrationPage.isPasswordErrorVisible()
        );
    }
}
