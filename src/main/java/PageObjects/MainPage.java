package PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By personalCabinetLink = By.xpath("//p[contains(text(), 'Личный Кабинет')]/..");
    private final By pageTitle = By.xpath("//h1[contains(text(), 'Соберите бургер')]");

    private final By entryButton = By.xpath("//button[contains(text(), 'Войти в аккаунт')]");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("Click Personal Cabinet link")
    public void clickPersonalCabinetLink() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(personalCabinetLink));
        driver.findElement(personalCabinetLink).click();
    }

    @Step("Check if Main Page loaded")
    public boolean isMainPageLoaded() {
        try {
            wait.withTimeout(Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(pageTitle));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Step("Click Entry Button")
    public void clickEntryButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(entryButton));
        driver.findElement(entryButton).click();
    }
}
