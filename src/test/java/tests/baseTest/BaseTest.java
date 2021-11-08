package tests.baseTest;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pages.BankManagerAccountPage;
import pages.BasePage;
import pages.AccountPage;
import pages.TransactionsPage;

public class BaseTest {
    protected WebDriver driver = CommonActions.webDriverSetup();
    protected BasePage basePage = new BasePage(driver);
    protected AccountPage accountPage = new AccountPage(driver);
    protected TransactionsPage transactionsPage = new TransactionsPage(driver);
    protected BankManagerAccountPage bankManagerAccountPage = new BankManagerAccountPage(driver);

    @AfterClass
    public void clearCookiesLocalStorage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.manage().deleteAllCookies();
        jsExecutor.executeScript("window.sessionStorage.clear()");
        //driver.quit();
    }


}
