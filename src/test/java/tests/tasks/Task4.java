package tests.tasks;

import org.testng.annotations.Test;
import pages.BankManagerAccountPage;
import pages.BasePage;
import pages.LoginPage;
import tests.baseTest.BaseTest;

public class Task4 extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    BankManagerAccountPage bankManagerAccountPage = new BankManagerAccountPage(getDriver());
    @Test
    public void removingAllCustomers() {
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        loginPage.loginAsBankManager();
        bankManagerAccountPage.removingAllAccounts();
        System.out.println("done");
    }
}
//4.  https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как manager
//перейти на вкладку “customers”
//удалить все аккаунты
