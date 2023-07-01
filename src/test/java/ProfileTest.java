import client.UsersApiClient;
import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;
import pages.LoginPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProfileTest {
    private final UsersApiClient usersApiClient = new UsersApiClient();

    private User user;

    @Before
    public void setUp() {
        browser = "chrome";
        user = getNewUser();
    }

    @After
    public void afterTest() {
        usersApiClient.deleteCreatedUsers();
    }

    public User getNewUser() {
        User user = User.getRandomUser();
        usersApiClient.register(user);
        usersApiClient.login(user);
        return user;
    }

    @Test
    @DisplayName("Go to the main page by clicking on the \"Constructor\" from your personal account.")
    public void moveToConstructorPageByClickOnHeaderTest() {
        open(LoginPage.PAGE_URL, LoginPage.class)
                .fillLoginPage(user)
                .loginButtonClick()
                .goToProfilePage()
                .checkVisibleConstructorPageLink()
                .constructorPageLinkClick();

        webdriver().shouldHave(url(ConstructorPage.PAGE_URL));
    }

    @Test
    @DisplayName("Go to the main page by clicking on the logo from your personal account.")
    public void moveToConstructorPageByClickOnLogoTest() {
        open(LoginPage.PAGE_URL, LoginPage.class)
                .fillLoginPage(user)
                .loginButtonClick()
                .goToProfilePage()
                .logoImageClick();

        webdriver().shouldHave(url(ConstructorPage.PAGE_URL));
    }

    @Test
    @DisplayName("Must log out of your account")
    public void logoutWhenClickOnExitTest() {
        open(LoginPage.PAGE_URL, LoginPage.class)
                .fillLoginPage(user)
                .loginButtonClick()
                .goToProfilePage()
                .shouldLogOutButtonBeVisible()
                .logout();

        webdriver().shouldHave(url(LoginPage.PAGE_URL));
    }
}
