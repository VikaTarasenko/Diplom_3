package page;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
public class RegistrationPage {
    private final String url = "https://stellarburgers.nomoreparties.site/"; // url входа
    private final By loginToAccount = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");// Войти в аккаунт
    private final By personalAccount = By.xpath(".//p[contains(text(),'Личный Кабинет')]"); //  Личный кабинет
    private final By registration = By.xpath(".//a[contains(text(),'Зарегистрироваться')]"); // Зарегистрироваться
    private final By userName = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[1]/div/div/input"); // поле Имя
    private final By email =  By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[2]/div/div/input"); // поле email
    private final By password = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset[3]/div/div/input"); // поле email
    private final By registrationOnFofm = By.xpath(".//*[@id=\"root\"]/div/main/div/form/button"); //Зарегистрироваться в форме
    private final By errorText = By.xpath(".//p[@class='input__error text_type_main-default']"); // неверный пароль
    private final String formName = RandomStringUtils.randomAlphanumeric(8); // имя пользователя
    private final String userEmail = RandomStringUtils.randomAlphanumeric(10)+"@yandex.ru"; // email пользователя
    private final String userPassword = RandomStringUtils.randomAlphanumeric(10); // пароль пользователя
    private final By loginEmail =  By.xpath(".//input[@name='name']"); // поле Логин, страница логина
    private final By loginPassword =  By.xpath(".//input[@name='Пароль']"); //поле пароль, страница логина
    private final By enter = By.xpath(".//button[contains(text(),'Войти')]"); // кнопка Войти
    private final By recoverPassword = By.xpath(".//a[contains(text(),'Восстановить пароль')]"); // Восстановить пароль
    private final By emailRecoverPassword = By.xpath(".//*[@id=\"root\"]/div/main/div/form/fieldset/div/div/input"); // поле ввода email при восстановлении пароля
    private final By recover = By.xpath(".//button[contains(text(),'Восстановить')]");// кнопка Восстановить
    private final By changeEmail = By.cssSelector("input[name='Введите новый пароль']");// поле ввода нового пароля
    private final By code = By.cssSelector("input[name='name']"); // поле Введите код из письма
    private final By save = By.xpath(".//button[contains(text(),'Сохранить')]"); // кнопка Сохранить

    private WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() { //переход по ссылке
        driver.get(url);
    }
    public void clickLoginToAccount() { //клик на Cоусы
        driver.findElement(loginToAccount).click();
    }
    public void clickPersonalAccount() { //клик на Личный кабинет
        driver.findElement(personalAccount).click();
    }
    public void checkRegistration() throws InterruptedException {
        driver.findElement(registration).click();
        driver.findElement(userName).sendKeys(formName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPassword);
        driver.findElement(registrationOnFofm).click();
        Thread.sleep(500);
        driver.findElement(loginEmail).sendKeys(userEmail);
        driver.findElement(loginPassword).sendKeys(userPassword);
       driver.findElement(enter).click();



    }
    public void checkIncorrectlyRegistration() {
        driver.findElement(registration).click();
        driver.findElement(userName).sendKeys(RandomStringUtils.randomAlphanumeric(7));
        driver.findElement(email).sendKeys(RandomStringUtils.randomAlphanumeric(10));

        driver.findElement(password).sendKeys(RandomStringUtils.randomAlphanumeric(5));
        driver.findElement(registrationOnFofm).click();
        String text = driver.findElement(errorText).getText();
        String expected = "Некорректный пароль";
        Assert.assertEquals(expected, text);

    }
    public void clickRecoverPassword()  {
        driver.findElement(recoverPassword).click();
    }
    public void sendEmailRecoverPassword()  {
        driver.findElement(emailRecoverPassword).sendKeys(userEmail);
        driver.findElement(recover).click();
        String text = driver.findElement(By.xpath(".//h2[contains(text(),'Восстановление пароля')]")).getText(); //появилась страница восстановление пароля
        String expected = "Восстановление пароля";
        Assert.assertEquals(expected, text);
    }
    public void changeEmail(){
        driver.findElement(changeEmail).sendKeys(userPassword);
        driver.findElement(code).sendKeys("kjjgkjhgk");
        driver.findElement(save).click();

    }
}