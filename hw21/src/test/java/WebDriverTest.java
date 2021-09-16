import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import java.util.Objects;

public class WebDriverTest {
    private WebDriver opera = getWebBrowser("opera");
    private WebDriver chrome = getWebBrowser("chrome");
    private WebDriver edge = getWebBrowser("edge");
    private WebDriver firefox = getWebBrowser("firefox");
    private WebDriver[] webDrivers = {opera, chrome, edge, firefox};

    @BeforeEach
    void open(){
        for (WebDriver driver : webDrivers){
            driver.get("https://www.tanuki.ru/");
        }
    }

    @Test
    @DisplayName("Проверка title")
    void equalTitleTest() {
        String title1440Chrome;
        String title1024Chrome;
        String title650Chrome;
        String title350Chrome;

        chrome.manage().window().setSize(new Dimension(1440,1024));
        title1440Chrome = chrome.getTitle();

        chrome.manage().window().setSize(new Dimension(1024,768));
        title1024Chrome = chrome.getTitle();

        chrome.manage().window().setSize(new Dimension(650,900));
        title650Chrome = chrome.getTitle();

        chrome.manage().window().setSize(new Dimension(350,900));
        title350Chrome = chrome.getTitle();

        Assertions.assertTrue(
                Objects.equals(opera.getTitle(), firefox.getTitle())
                && Objects.equals(firefox.getTitle(), edge.getTitle())
                && Objects.equals(edge.getTitle(), title350Chrome)
                && Objects.equals(title350Chrome, title650Chrome)
                && Objects.equals(title650Chrome, title1024Chrome)
                && Objects.equals(title1024Chrome, title1440Chrome)
        );
    }

    @Test
    @DisplayName("Проверка url")
    void equalURLTest() {
        String url1440Chrome;
        String url1024Chrome;
        String url650Chrome;
        String url350Chrome;

        chrome.manage().window().setSize(new Dimension(1440,1024));
        url1440Chrome = chrome.getCurrentUrl();

        chrome.manage().window().setSize(new Dimension(1024,768));
        url1024Chrome = chrome.getCurrentUrl();

        chrome.manage().window().setSize(new Dimension(650,900));
        url650Chrome = chrome.getCurrentUrl();

        chrome.manage().window().setSize(new Dimension(350,900));
        url350Chrome = chrome.getCurrentUrl();

        Assertions.assertTrue(
                Objects.equals(opera.getCurrentUrl(), firefox.getCurrentUrl())
                        && Objects.equals(firefox.getCurrentUrl(), edge.getCurrentUrl())
                        && Objects.equals(edge.getCurrentUrl(), url350Chrome)
                        && Objects.equals(url350Chrome, url650Chrome)
                        && Objects.equals(url650Chrome, url1024Chrome)
                        && Objects.equals(url1024Chrome, url1440Chrome)
        );
    }

    @AfterEach
    void quite(){
        for (WebDriver driver : webDrivers){
            driver.quit();
        }
    }

    private WebDriver getWebBrowser(String browserName){
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
