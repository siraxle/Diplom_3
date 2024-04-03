package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By nameInput = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input");

    private final By emailInput = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordInput = By.xpath("//label[contains(text(), 'Пароль')]/following-sibling::input");

    private final By registrationButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");

    private final By pageTitle = By.xpath("//h2[contains(text(), 'Регистрация')]");


    public RegistrationPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Fill Name Input")
    public void fillNameInput(String date) {
        WebElement dateField = driver.findElement(nameInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    @Step("Fill Email Input")

    public void fillEmailInput(String date) {
        WebElement dateField = driver.findElement(emailInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    @Step("Fill Password Input")
    public void fillPasswordInput(String date) {
        WebElement dateField = driver.findElement(passwordInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    @Step("Click Registration Button")
    public void clickRegistrationButton() {
        WebElement dateField = driver.findElement(registrationButton);
        dateField.click();
    }

    @Step("Fill Registration Page")
    public void fillRegistrationPage(String email, String name, String password) {
        fillNameInput(name);
        fillEmailInput(email);
        fillPasswordInput(password);
    }

    @Step("Check if Registration Page is Loaded")
    public boolean isRegistrationPageLoaded() {
        try {
            wait.withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(pageTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
