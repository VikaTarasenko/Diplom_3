
package designer;
import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import page.MainPage;


public class Designer {
    @Rule
    public BrowserRule browserRule = new BrowserRule();

    @Test
    @DisplayName("провера наличия раздела Соусы в Конструкторе")
    public void checkSauces()  { //провера наличия раздела Соусы в Конструкторе
            MainPage mainPage = new MainPage(browserRule.getDriver());
            mainPage.open();
            mainPage.checkSauces();
        }
   @Test
   @DisplayName("провера наличия раздела Булки в Конструкторе")
    public void checkBuns() { //провера наличия раздела Булки в Конструкторе
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.checkBuns();
    }
    @Test
    @DisplayName("провера наличия раздела Булки в Конструкторе")
    public void checkFillings() { //провера наличия раздела Булки в Конструкторе
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.checkFillings();
    }
    @Test
    @DisplayName("переход по клику на кнопку бренда в хедере")
    public void checkStellarBurger() { // переход по клику на кнопку бренда в хедере
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.clickLoginToAccount();
        mainPage.clickStellarBurger();
        mainPage.checkStellarBurger();
    }
    @Test
    @DisplayName("переход по кнопке Конструктор")
    public void checkDesignerButton() { // переход по кнопке Конструктор
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.clickLoginToAccount();
        mainPage.clickDesignerButton();
    }
    @Test
    @DisplayName("провера перехода через кнопку Войти в аккаунт")
    public void checkLoginToAccount()  { //провера перехода через кнопку Войти в аккаунт
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.clickLoginToAccount();
        mainPage.checkEnterPageOpen();

    }
    @Test
    @DisplayName("провера перехода через кнопку Личный кабинет")
    public void checkPersonalAccount()  { //провера перехода через кнопку Личный кабинет
        MainPage mainPage = new MainPage(browserRule.getDriver());
        mainPage.open();
        mainPage.clickPersonalAccount();
        mainPage.checkEnterPageOpen();

    }
}

