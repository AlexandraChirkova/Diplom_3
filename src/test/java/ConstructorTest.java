import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import pages.ConstructorPage;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.open;

public class ConstructorTest {
    ConstructorPage constructorPage = open(ConstructorPage.PAGE_URL, ConstructorPage.class);

    @Before
    public void setUp() {
        browser = "chrome";
    }

    @Test
    @DisplayName("It should be possible to select the tab with sauces.")
    public void shouldSouseTabBeSelectedTest() {
        constructorPage
                .clickSouse()
                .shouldSouseTabBeSelected();
    }

    @Test
    @DisplayName("It should be possible to select the toppings tab.")
    public void shouldFillingTabBeSelectedTest() {
        constructorPage
                .clickFilling()
                .shouldFillingTabBeSelected();
    }

    @Test
    @DisplayName("It should be possible to select the buns tab.")
    public void shouldBunTabBeSelectedTest() {
        constructorPage
                .clickSouse()
                .clickBun()
                .shouldBunTabBeSelected();
    }
}
