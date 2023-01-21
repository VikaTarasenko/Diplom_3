package page;

import org.junit.Assert;
import org.openqa.selenium.*;

//import static main.Utils.randomString;

public class MainPage {

    private final String url = "https://stellarburgers.nomoreparties.site/"; // url входа
    private final By loginToAccount = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");// Войти в аккаунт
    private final By personalAccount = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //  Личный кабинет
    private final By designer = By.xpath(".//p[contains(text(),'Конструктор')]"); // Конструктор
    private final By sauces = By.xpath(".//span[contains(text(),'Соусы')]"); // Соусы
    private final By saucesInDesigner = By.xpath(".//h2[contains(text(),'Соусы')]"); // Название соусы в конструкторе

    private final By buns = By.xpath(".//span[contains(text(),'Булки')]"); // Булки
    private final By bunsInDesigner = By.xpath(".//h2[contains(text(),'Булки')]"); // Булки в конструкторе
    private final By fillings = By.xpath(".//*[@id=\"root\"]/div/main/section[1]/div[1]/div[3]"); // Начинки
    private final By fillingsInDesigner = By.xpath(".//h2[contains(text(),'Начинки')]");// Начинки в конструкторе
    private final By stellarBurger = By.xpath(".//*[@id=\"root\"]/div/header/nav/div"); // кнопка Заказать вверху страницы
    private final By collectBurger = By.xpath("//*[@id=\"root\"]/div/main/section[1]/h1"); //
    private final By designerButton = By.xpath("//*[@id=\"root\"]/div/header/nav/ul/li[1]/a/p");
    private final By enterText = By.xpath(".//h2[contains(text(),'Вход')]"); //текст Вход на странице авторизации



    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() { //переход по ссылке
        driver.get(url);
    }


     public void clickLoginToAccount() { //клик на Войти в аккаунт
        driver.findElement(loginToAccount).click();
    }
    public void clickPersonalAccount() { //клик на ЛК
        driver.findElement(personalAccount).click();
    }
    public void checkEnterPageOpen() {
        String text = driver.findElement(enterText).getText();
        String expected = "Вход";
        Assert.assertEquals(expected, text);

    }
    public void checkSauces() {
        driver.findElement(designer).click();
        driver.findElement(sauces).click();

        String text = driver.findElement(saucesInDesigner).getText();
        String expected = "Соусы";
        Assert.assertEquals(expected, text);
    }
    public void checkBuns()  {
        driver.findElement(designer).click();
        driver.findElement(buns);
        String text = driver.findElement(bunsInDesigner).getText();
        String expected = "Булки";
        Assert.assertEquals(expected, text);
    }
    public void checkFillings()  {
        driver.findElement(designer).click();
        driver.findElement(fillings).click();
        String text = driver.findElement(fillingsInDesigner).getText();
        String expected = "Начинки";
        Assert.assertEquals(expected, text);
    }
    public void clickStellarBurger() {
        driver.findElement(stellarBurger).click();
    }
    public  void  checkStellarBurger(){
        String text = driver.findElement(collectBurger).getText();
       String expected = "Соберите бургер";
        Assert.assertEquals(expected, text);
    }
    public void clickDesignerButton()  {
        driver.findElement(designerButton).click();

        String text = driver.findElement(collectBurger).getText();
        String expected = "Соберите бургер";
        Assert.assertEquals(expected, text);
    }

}

