package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
    public static WebDriver get(String browserName) {
        switch (browserName) {
            case "opera" -> {
                WebDriverManager.operadriver().setup();
                return new OperaDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "/Users/eyaushev/Documents/homeework2/homework/hw21/src/main/resources/geckodriver");
                return new FirefoxDriver();
            }
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            default -> {
                return null;
            }
        }
    }
}
