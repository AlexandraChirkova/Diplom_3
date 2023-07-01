package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class RestorePasswordPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/forgot-password";

    @FindBy(linkText = "Войти")
    private SelenideElement loginButton;

    @Step("Click by Entrance")
    public LoginPage enterLinkClick() {
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }
}
