package tests.baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    static WebDriver driver;
    private final static ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WEBDRIVER_CONTAINER.set(driver);

    }

    public static WebDriver getDriver(){
        return WEBDRIVER_CONTAINER.get();
    }

    @AfterMethod
    public void quit(){

        if (driver !=null){
            driver.manage().deleteAllCookies();
            driver.quit();
            WEBDRIVER_CONTAINER.remove();
        }
    }
}