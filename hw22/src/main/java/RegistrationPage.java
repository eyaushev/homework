import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
    private WebDriver webdriver;

    private final By firstName = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By email = By.id("userEmail");
    private final By genderList = By.xpath("//*[@id=\"genterWrapper\"]//label");
    private final By phone = By.id("userNumber");
    private final By birthDate = By.id("dateOfBirthInput");
    private final By yearSelect = By.className("react-datepicker__year-select");
    private final By monthSelect = By.className("react-datepicker__month-select");
    private final By daySelect = By.className("react-datepicker__day");
    private final By subjectInput = By.id("subjectsInput");
    private final By hobbiesList = By.xpath("//*[@id=\"hobbiesWrapper\"]//input");
    private final By currentAddress = By.id("currentAddress");
    private final By stateBtn = By.xpath("//*[@id=\"state\"]/div");
    private final By stateList = By.cssSelector(".css-11unzgr > div");
    private final By cityBtn = By.xpath("//*[@id=\"city\"]/div");
    private final By cityList = By.cssSelector(".css-26l3qy-menu > div > div");
    private final By submitBtn = By.id("submit");


    RegistrationPage(WebDriver driver) {
        webdriver = driver;
        webdriver.get("https://demoqa.com/automation-practice-form");
    }

    public void fillFirstNameField(String firstName) {
        webdriver.findElement(this.firstName).sendKeys(firstName);
    }

    public void fillLastNameField(String lastName) {
        webdriver.findElement(this.lastName).sendKeys(lastName);
    }

    public void fillEmailField(String email) {
        webdriver.findElement(this.email).sendKeys(email);
    }

    public void checkGender(int value) {
        webdriver.findElements(this.genderList).get(value).click();
    }

    public void fillPhoneField(String phone) {
        webdriver.findElement(this.phone).sendKeys(phone);
    }

    public void checkSubject(String subject){
        webdriver.findElement(this.subjectInput).sendKeys(subject);
        webdriver.findElement(this.subjectInput).sendKeys(Keys.RETURN);
    }

    public void checkHobbies(int[] values) {
        for (int value:values) webdriver.findElements(this.hobbiesList).get(value).click();
    }

    public void fillAddress(String address){
        webdriver.findElement(this.currentAddress).sendKeys(address);
    }

    public void checkState(int index){
        webdriver.findElement(stateBtn).click();
        webdriver.findElements(stateList).get(index).click();
    }

    public void checkCity(int index){
        webdriver.findElement(cityBtn).click();
        webdriver.findElements(cityList).get(index).click();
    }

    public void checkBirthDate(String year, String month, int day){
        webdriver.findElement(birthDate).click();
        Select yearMenu = new Select(webdriver.findElement(yearSelect));
        yearMenu.selectByVisibleText(year);
        Select monthMenu = new Select(webdriver.findElement(monthSelect));
        monthMenu.selectByVisibleText(month);
        webdriver.findElements(daySelect).get(day).click();
    }

    public WebDriver getWebdriver() {
        return webdriver;
    }
}
