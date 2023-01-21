package registration;

import io.qameta.allure.junit4.DisplayName;
import main.BrowserRule;
import org.junit.Rule;
import org.junit.Test;
import page.MainPage;
import page.RegistrationPage;

public class Registration {
    @Rule
    public BrowserRule browserRule = new BrowserRule();


    @Test
    @DisplayName("провера успешной регистрации через Войти")
    public void successRegistration() throws InterruptedException { //провера успешной регистрации через Войти
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        registrationPage.open();
        registrationPage.clickLoginToAccount();
        registrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }
    @Test
    @DisplayName("провера неуспешной регистрации")

    public void unSuccessRegistration()  { //провера неуспешной регистрации
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        registrationPage.open();
        registrationPage.clickLoginToAccount();
        registrationPage.checkIncorrectlyRegistration();
    }
    @Test
    @DisplayName("успешная регистрация через ЛК")
    public void successLoginPersonalAccount() throws InterruptedException { //успешная регистрация через ЛК
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        MainPage mainPage = new MainPage(browserRule.getDriver());
        registrationPage.open();
        registrationPage.clickPersonalAccount();
        registrationPage.checkRegistration();
        mainPage.checkStellarBurger();
    }
    @Test
    @DisplayName("восстановление пароля")
    public void recoverPassword()  { //восстановление пароля
        RegistrationPage registrationPage = new RegistrationPage(browserRule.getDriver());
        registrationPage.open();
        registrationPage.clickPersonalAccount();
        registrationPage.clickRecoverPassword();
        registrationPage.sendEmailRecoverPassword();
        registrationPage.changeEmail();
    }
}
