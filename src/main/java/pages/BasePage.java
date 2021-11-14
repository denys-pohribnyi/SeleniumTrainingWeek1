package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    private final By typeOfUserForLogin = By.xpath("//button[normalize-space()='Customer Login']");
    private final By selectingNameField = By.xpath("//select[@id='userSelect']");
    private final By nameInTheUsersList = By.xpath("//*[@id=\"userSelect\"]/option[3]");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By loginAsBankManagerButton = By.xpath("//button[normalize-space()='Bank Manager Login']");

    public WebElement waitCustom (WebElement element){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public BasePage choosingUserType() {
        driver.findElement(typeOfUserForLogin).click();
        return this;
    }

    public BasePage selectingUserName() {
        driver.findElement(selectingNameField).click();
        driver.findElement(nameInTheUsersList).click();
        return this;
    }

    public BasePage loginButtonClick() {
        driver.findElement(loginButton).click();
        return this;
    }

    public BankManagerAccountPage loginAsBankManager() {
        driver.findElement(loginAsBankManagerButton).click();
        return new BankManagerAccountPage(driver);
    }

}