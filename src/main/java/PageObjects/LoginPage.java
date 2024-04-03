package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailInput = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordInput = By.xpath("//label[contains(text(), 'Пароль')]/following-sibling::input");
    private final By registrationLink = By.xpath("//a[contains(text(), 'Зарегистрироваться')]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickRegistrationLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationLink));
        driver.findElement(registrationLink).click();
    }

    public void fillEmailInput(String date) {
        wait.until(ExpectedConditions.presenceOfElementLocated(emailInput));
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(date, Keys.ENTER);
    }

    public void fillPasswordInput(String date) {
        WebElement dateField = driver.findElement(passwordInput);
        dateField.click();
        dateField.sendKeys(date, Keys.ENTER);
    }

}
