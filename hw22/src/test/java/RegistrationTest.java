import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import utils.Browser;

public class RegistrationTest {

    private RegistrationPage page;

    @BeforeEach
    void open(){
        page = new RegistrationPage(Browser.get("chrome"));
    }

    @Test
    void regTest() throws InterruptedException {
        page.fillFirstNameField("Eduard");
        page.fillLastNameField("Yaushev");
        page.fillEmailField("eyaushev@yandex.ru");
        page.checkGender(0);
        page.fillPhoneField("89375200493");
        page.checkBirthDate("1993", "October", 7);
        page.checkSubject("Maths");
        page.checkHobbies(new int[]{2});
        page.fillAddress("test address");
        page.checkState(0);
        page.checkCity(0);

        Thread.sleep(5000);
    }


    @AfterEach
    void quite(){
        page.getWebdriver().quit();
    }
}
