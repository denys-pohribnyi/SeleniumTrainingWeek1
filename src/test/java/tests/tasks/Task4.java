package tests.tasks;

import org.testng.annotations.Test;
import tests.baseTest.BaseTest;

public class Task4 extends BaseTest {
    @Test
    public void removingAllCustomers() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        basePage.loginAsBankManager();
        bankManagerAccountPage.removingAllAccounts();
        System.out.println("done");
    }
}
//4.  https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как manager
//перейти на вкладку “customers”
//удалить все аккаунты
