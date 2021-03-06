package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameAfterLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/strong/span");
    private final By depositButton = By.xpath("//button[normalize-space()='Deposit']");
    private final By amountOfDepositField = By.xpath("//input[@placeholder='amount']");
    private final By performingDepositAction = By.xpath("//button[@type='submit']");
    private final By balanceValue = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");
    private final By withdrawButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private final By amountOfWithdraw = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private final By performingWithdrawAction = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private final By transactionsButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]");


    public AccountPage nameIsPresent() {
        boolean presenceOfUserName = driver.findElement(userNameAfterLogin).isDisplayed();
        Assert.assertTrue(presenceOfUserName);
        return this;
    }

    public AccountPage performingDeposit(String deposit) {
        driver.findElement(depositButton).click();
        driver.findElement(amountOfDepositField).sendKeys(deposit);

        waitCustom(driver.findElement(performingDepositAction));
        driver.findElement(performingDepositAction).click();
        return this;
    }

    public AccountPage checkingBalanceAfterDeposit(String balance) {
        String resultAfterDeposit = driver.findElement(balanceValue).getText();
        Assert.assertEquals(balance, resultAfterDeposit);
        return this;
    }

    public AccountPage performingWithdraw(String withdraw) {
        driver.findElement(withdrawButton).click();
        try {                                       // ?????????????????? ??????????????
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitCustom(driver.findElement(amountOfWithdraw)).sendKeys(withdraw);

        waitCustom(driver.findElement(performingWithdrawAction)).click();
        return this;
    }

    public AccountPage checkingBalanceAfterWithdraw(String withdrawResult) {
        WebElement resultOfWithdraw = driver.findElement(balanceValue);
        String balanceValueAfterWithdraw = resultOfWithdraw.getText();
        Assert.assertEquals(balanceValueAfterWithdraw, withdrawResult);
        return this;
    }

    public TransactionsPage resetTransactions() {
        driver.findElement(transactionsButton).click();
        return new TransactionsPage(driver);
    }
}
//??????????????:
//1. ?????????????? ???????? https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//???????????????????????? ?????? Customer (for ex Harry Potter)
//?????????? ?? Deposit, ???????????????? 1000 ???? ??????????????
// ?????????? ?? Withdraw, ?????????? 900
// ?????????? ?? Transactions ?????????????? ?????? ????????????