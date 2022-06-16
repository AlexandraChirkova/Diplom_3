package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class ConstructorPage {
    public static final String PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    public static final String CURRENT_TAB_CSS_LASS_NAME = "tab_tab_type_current__2BEPc";

    @FindBy(xpath = ".//a[@class='AppHeader_header__link__3D_hX'][@href='/account']")
    private SelenideElement profilePageLink;

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    @FindBy(xpath = ".//div[span[text()='Булки']]")
    private SelenideElement bunsTab;

    @FindBy(xpath = ".//div[span[text()='Соусы']]")
    private SelenideElement saucesTab;

    @FindBy(xpath = ".//div[span[text()='Начинки']]")
    private SelenideElement fillingsTab;

    @Step("Click by Profile Button")
    public ProfilePage goToProfilePage(){
        profilePageLink.click();
        return Selenide.page(ProfilePage.class);
    }

    @Step("Click by Account")
    public LoginPage goToLoginPage(){
        loginButton.click();
        return Selenide.page(LoginPage.class);
    }

    @Step("Click by Souse")
    public ConstructorPage clickSouse() {
        saucesTab.click();
        return this;
    }

    @Step("Click by Filling")
    public ConstructorPage clickFilling() {
        fillingsTab.click();
        return this;
    }

    @Step("Click bu Bun")
    public ConstructorPage clickBun() {
        bunsTab.click();
        return this;
    }

    @Step("Check Souse Tab")
    public ConstructorPage shouldSouseTabBeSelected() {
        saucesTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }

    @Step("Click by Filling Tab")
    public ConstructorPage shouldFillingTabBeSelected() {
        fillingsTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }

    @Step("Check tb Bun")
    public ConstructorPage shouldBunTabBeSelected() {
        bunsTab.shouldBe(Condition.cssClass(CURRENT_TAB_CSS_LASS_NAME));
        return this;
    }
}
