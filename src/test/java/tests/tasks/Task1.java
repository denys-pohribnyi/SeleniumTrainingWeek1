package tests.tasks;

import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import pages.TransactionsPage;
import tests.baseTest.BaseTest;

public class Task1 extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    AccountPage accountPage = new AccountPage(getDriver());
    TransactionsPage transactionsPage = new TransactionsPage(getDriver());

    @Test
    public void loginTest() {
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        loginPage.choosingUserType()
                .selectingUserName()
                .loginButtonClick();
        accountPage.nameIsPresent();
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void depositTest() {
        accountPage.performingDeposit("1000");
        accountPage.checkingBalanceAfterDeposit("1000");
    }

    @Test(dependsOnMethods = {"depositTest"})
    public void withdrawTest() {
        accountPage.performingWithdraw("900");
        accountPage.checkingBalanceAfterWithdraw("100");
    }

    @Test(dependsOnMethods = {"withdrawTest"})
    public void resetAllTransactions() {
        accountPage.resetTransactions();
        transactionsPage.reset();
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