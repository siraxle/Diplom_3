package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private final WebDriver driver;
    private final By nameInput = By.xpath("//label[contains(text(), 'Имя')]/following-sibling::input");

    private final By emailInput = By.xpath("//label[contains(text(), 'Email')]/following-sibling::input");
    private final By passwordInput = By.xpath("//label[contains(text(), 'Пароль')]/following-sibling::input");

    private final By registrationButton = By.xpath("//button[contains(text(), 'Зарегистрироваться')]");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameInput(String date) {
        WebElement dateField = driver.findElement(nameInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    public void fillEmailInput(String date) {
        WebElement dateField = driver.findElement(emailInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    public void fillPasswordInput(String date) {
        WebElement dateField = driver.findElement(passwordInput);
        dateField.click();
        dateField.clear();
        dateField.sendKeys(date, Keys.ENTER);
    }

    public void clickRegistrationButton() {
        WebElement dateField = driver.findElement(registrationButton);
        dateField.click();
    }


}
