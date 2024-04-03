import Helpers.UserHelper;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.PersonalCabinetPage;
import PageObjects.RegistrationPage;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationTests extends BaseTest {

    private static final UserHelper USER_HELPER = new UserHelper();

    @Test
    @DisplayName("Success Registration Test")
    public void successRegistrationTest() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
//        assertTrue("The home page is not loaded", mainPage.isMainPageLoaded());
        mainPage.clickPersonalCabinetLink();

        // перейти на страницу логина и выбрать регистрацию
        LoginPage loginPage = new LoginPage(driver, wait);
//        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
        loginPage.clickRegistrationLink();

        // открыть и заполнить страницу регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        String email = USER_HELPER.generateUniqueEmail();
        String name = USER_HELPER.generateName();
        String password = USER_HELPER.generatePassword();
//        assertTrue("The registration page is not loaded", registrationPage.isRegistrationPageLoaded());
        registrationPage.fillRegistrationPage(email, name, password);

        // залогиниться
//        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
        loginPage.fillLoginPage(email, password);

        // переходим в личный кабинет
        mainPage.clickPersonalCabinetLink();
        PersonalCabinetPage personalCabinetPage = new PersonalCabinetPage(driver, wait);
//        assertTrue("The personal account page is not loaded", personalCabinetPage.isPersonalPageloaded());
        // получаем значения имени и email из личного кабинета
        String nameFromPersonalCabinet = personalCabinetPage.getNameValue();
        String emailFromPersonalCabinet = personalCabinetPage.getLoginValue();

        // проверяем, что значения совпадают с ожидаемыми
        assertEquals("The text of the name element does not match the expected text", name, nameFromPersonalCabinet);
        assertEquals("The text of the email element does not match the expected text", email, emailFromPersonalCabinet);

        // удаляем пользователя после теста
        Response loginResponse = USER_HELPER.loginUser(email, password);
        USER_HELPER.deleteUser(loginResponse);
    }

    @Test
    @DisplayName("Error message for Invalid Password Test")
    public void errorForInvalidPasswordTest() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
//        assertTrue("The home page is not loaded", mainPage.isMainPageLoaded());
        mainPage.clickPersonalCabinetLink();

        // перейти на страницу логина и выбрать регистрацию
        LoginPage loginPage = new LoginPage(driver, wait);
//        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
        loginPage.clickRegistrationLink();

        // открыть и заполнить страницу регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        String email = USER_HELPER.generateUniqueEmail();
        String name = USER_HELPER.generateName();
        String password = USER_HELPER.generatePassword().replaceAll("password", "");
//        assertTrue("The registration page is not loaded", registrationPage.isRegistrationPageLoaded());
        registrationPage.fillRegistrationPage(email, name, password);
        registrationPage.clickRegistrationButton();
        assertTrue("Error password message is not displayed", registrationPage.isErrorPasswordMessageDisplayed());
    }

}
