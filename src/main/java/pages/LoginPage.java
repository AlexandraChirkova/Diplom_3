package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/login";

    @FindBy(xpath = ".//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(xpath = ".//input[@type='text']")
    private SelenideElement emailField;

    @FindBy(xpath = ".//input[@type='password']")
    private SelenideElement passwordField;

    @FindBy(xpath = ".//a[@class='Auth_link__1fOlj'][@href='/register']")
    private SelenideElement registrationLink;

    @FindBy(linkText = "Восстановить пароль")
    private SelenideElement restorePassword;

    @Step("Input Email and Password")
    public LoginPage fillLoginPage(User user){
        emailField.scrollTo();
        emailField.setValue(user.getEmail());

        passwordField.scrollTo();
        passwordField.sendKeys(user.getPassword());

        return this;
    }

    @Step("Click by Entrance")
    public ConstructorPage loginButtonClick(){
        loginButton.shouldBe(Condition.exist);
        loginButton.scrollTo();
        loginButton.click();
        return Selenide.page(ConstructorPage.class);
    }
}
