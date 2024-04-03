package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browserName) {
        WebDriver driver = null;
        switch (browserName.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "yandexbrowser":
//                TODO разобраться как работать с yandex browser
//                System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Укажите путь к chromedriver
//                driver = new YandexDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        return driver;
    }
}
