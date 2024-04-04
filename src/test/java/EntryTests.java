import Helpers.UserHelper;
import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.RegistrationPage;
import PageObjects.RestorePasswordPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EntryTests extends BaseTest {

    @Test
    @DisplayName("Entry Test with Button on Main Page")
    public void entryTestWithButton() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickEntryButton();
        // перейти на страницу логина
        LoginPage loginPage = new LoginPage(driver, wait);
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
    }

    @Test
    @DisplayName("Entry Test with Link on Main Page")
    public void entryTestWithLink() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickPersonalCabinetLink();
        // перейти на страницу логина
        LoginPage loginPage = new LoginPage(driver, wait);
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
    }

    @Test
    @DisplayName("Entry Via the Button On the Registration Form")
    public void entryViaTheButtonOnTheRegistrationForm() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickEntryButton();
        // перейти на страницу логина
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickRegistrationLink();
        // перейти на страницу регистрации
        RegistrationPage registrationPage = new RegistrationPage(driver, wait);
        registrationPage.clickEntryLink();
        // перейти на страницу логина
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
    }

    @Test
    @DisplayName("Etry On Restore Password Page")
    public void entryOnRestorePasswordPage() {
        // перейти на главную страницу
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickEntryButton();
        // перейти на страницу логина
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.clickRestorePasswordLink();
        // перейти на страницу восстановления пароля
        RestorePasswordPage restorePasswordPage = new RestorePasswordPage(driver, wait);
        restorePasswordPage.clickEntryLink();
        assertTrue("The login page is not loaded", loginPage.isLoginPageLoaded());
    }


}
