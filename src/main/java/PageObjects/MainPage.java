package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By personalCabinetLink = By.xpath("//p[contains(text(), 'Личный Кабинет')]/..");

    public MainPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void clickPersonalCabinetLink() {
        wait.until(ExpectedConditions.presenceOfElementLocated(personalCabinetLink));
        driver.findElement(personalCabinetLink).click();
    }

}
