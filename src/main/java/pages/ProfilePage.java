package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;


public class ProfilePage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/account/profile";

    @FindBy(xpath = ".//a[@class='AppHeader_header__link__3D_hX'][@href='/']")
    private SelenideElement constructorPageLink;

    @FindBy(xpath = ".//div[@class='AppHeader_header__logo__2D0X2']/a[@href='/']")
    private SelenideElement logoImage;

    @FindBy(xpath = ".//button[text()='Выход']")
    private SelenideElement logOutButton;

    @Step("Click by Constructor")
    public ConstructorPage constructorPageLinkClick(){
        constructorPageLink.click();
        return Selenide.page(ConstructorPage.class);
    }

    @Step("Click by Logo")
    public ConstructorPage logoImageClick() {
        logoImage.click();
        return Selenide.page(ConstructorPage.class);
    }

    @Step("Click by Entrance")
    public LoginPage logout() {
        logOutButton.click();
        return Selenide.page(LoginPage.class);
    }

    public ProfilePage shouldLogOutButtonBeVisible() {
        logOutButton.shouldBe(Condition.visible);
        return this;
    }

    public ProfilePage checkVisibleConstructorPageLink() {
        constructorPageLink.shouldBe(Condition.visible);
        return this;
    }
}
