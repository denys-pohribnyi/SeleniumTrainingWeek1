package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage extends BasePage {
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/strong/span")
    private WebElement userNameAfterLogin;
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    private WebElement depositButton;
    @FindBy(xpath = "//input[@placeholder='amount']")
    private WebElement amountOfDepositField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement performingDepositAction;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    private WebElement balanceValue;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[3]")
    private WebElement withdrawButton;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/div/input")
    private WebElement amountOfWithdraw;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[4]/div/form/button")
    private WebElement performingWithdrawAction;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[3]/button[1]")
    private WebElement transactionsButton;

    public void nameIsPresent() {
        boolean presenceOfUserName = userNameAfterLogin.isDisplayed();
        Assert.assertTrue(presenceOfUserName);
    }

    public void performingDeposit() {
        depositButton.click();
        amountOfDepositField.sendKeys("1000");

        try {                                       // временное решение
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        performingDepositAction.click();
    }

    public void checkingBalanceAfterDeposit() {
        String resultAfterDeposit = balanceValue.getText();
        Assert.assertEquals("1000", resultAfterDeposit);
    }

    public void performingWithdraw() {
        withdrawButton.click();
        try {                                       // временное решение
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amountOfWithdraw.sendKeys("900");

        try {                                       // временное решение
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        performingWithdrawAction.click();
    }

    public void checkingBalanceAfterWithdraw() {
        WebElement resultOfWithdraw = balanceValue;
        String balanceValueAfterWithdraw = resultOfWithdraw.getText();
        Assert.assertEquals(balanceValueAfterWithdraw, "100");
    }

    public TransactionsPage resetTransactions() {
        transactionsButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new TransactionsPage(driver);
    }
}
//Домашка:
//1. Открыть сайт https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как Customer (for ex Harry Potter)
//Зайти в Deposit, положить 1000 на депозит
// Зайти в Withdraw, снять 900
// Зайти в Transactions удалить все записи