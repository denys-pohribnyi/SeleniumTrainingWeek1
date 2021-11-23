package tests.tasks;

import org.testng.annotations.Test;
import pages.BankManagerAccountPage;
import pages.BasePage;
import pages.LoginPage;
import tests.baseTest.BaseTest;

public class Task3 extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    BankManagerAccountPage bankManagerAccountPage = new BankManagerAccountPage(getDriver());
    @Test
    public void loginAsManager() {
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        loginPage.loginAsBankManager();
        bankManagerAccountPage
                .openAccount()
                .selectingName("Harry Potter")
                .selectingCurrency("Dollar")
                .processingAccountCreation()
                .checkingAccountWasCreated();
    }
}
//3. Открыть сайт
// https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как manager
//Открыть вкладку “Open Account”
//Создать счет