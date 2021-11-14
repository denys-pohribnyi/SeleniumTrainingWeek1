package tests.baseTest;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.BankManagerAccountPage;
import pages.BasePage;
import pages.AccountPage;
import pages.TransactionsPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver = CommonActions.webDriverSetup();
    protected BasePage basePage = new BasePage(driver);
    protected AccountPage accountPage = new AccountPage(driver);
    protected TransactionsPage transactionsPage = new TransactionsPage(driver);
    protected BankManagerAccountPage bankManagerAccountPage = new BankManagerAccountPage(driver);


    @BeforeMethod
    public void setup(){
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void clearCookiesLocalStorage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        jsExecutor.executeScript("window.sessionStorage.clear()");
        driver.quit();
    }
}
//public class BaseTest {
//
//    static WebDriver driver;
//    private static ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();
//
//    @BeforeClass
//    public static void setupClass(){
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeMethod
//    public void setup(){
//
//        // System.setProperty("webdriver.chrome.driver", "src/main/resources/Drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        WEBDRIVER_CONTAINER.set(driver);
//
//    }
//
//    public static WebDriver getDriver(){
//        return WEBDRIVER_CONTAINER.get();
//    }
//
//    @AfterMethod
//    public void quit(){
//
//        if (driver !=null){
//            driver.manage().deleteAllCookies();
//            driver.quit();
//            WEBDRIVER_CONTAINER.remove();
//        }
//    }
//}