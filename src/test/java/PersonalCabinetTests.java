import Helpers.UserHelper;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.PersonalCabinetPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PersonalCabinetTests extends BaseTest{
    private static final UserHelper USER_HELPER = new UserHelper();

    @Test
    @DisplayName("Entry to Personal Cabinet Authorized User")
    public void entryToPersonalCabinetAuthorizedUser(){
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickPersonalCabinetLink();

        // перейти на страницу логина и выбрать регистрацию
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickRegistrationLink();

        // открыть и заполнить страницу регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        String email = USER_HELPER.generateUniqueEmail();
        String name = USER_HELPER.generateName();
        String password = USER_HELPER.generatePassword();
        registrationPage.fillRegistrationPage(email, name, password);

        // залогиниться
        loginPage.fillLoginPage(email, password);
        mainPage.clickPersonalCabinetLink();

        // переходим в личный кабинет
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver, wait);
        assertTrue("The personal account page is not loaded", personalCabinetPage.isPersonalPageloaded());

        // удаляем пользователя после теста
        Response loginResponse = USER_HELPER.loginUser(email, password);
        USER_HELPER.deleteUser(loginResponse);
    }

    @Test
    @DisplayName("Entry to Personal Cabinet Unauthorized User")
    public void entryToPersonalCabinetUnauthorizedUser(){
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickPersonalCabinetLink();

        // перейти на страницу логина и выбрать регистрацию
        LoginPage loginPage = new LoginPage(driver, wait);
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
    }

    @Test
    @DisplayName("Exit from personal cabinet Test")
    public void exitFromPersonalCabinetTest(){
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickPersonalCabinetLink();

        // перейти на страницу логина и выбрать регистрацию
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickRegistrationLink();

        // открыть и заполнить страницу регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        String email = USER_HELPER.generateUniqueEmail();
        String name = USER_HELPER.generateName();
        String password = USER_HELPER.generatePassword();
        registrationPage.fillRegistrationPage(email, name, password);

        // залогиниться
        loginPage.fillLoginPage(email, password);
        mainPage.clickPersonalCabinetLink();

        // переходим в личный кабинет
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver, wait);
        assertTrue("The personal account page is not loaded", personalCabinetPage.isPersonalPageloaded());
        personalCabinetPage.clickExitButton();
        // переходим на страницу логина
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());

        // удаляем пользователя после теста
        Response loginResponse = USER_HELPER.loginUser(email, password);
        USER_HELPER.deleteUser(loginResponse);
    }

}
