package tests.tasks;

import org.testng.annotations.Test;
import tests.baseTest.BaseTest;

public class Task3 extends BaseTest {
    @Test
    public void loginAsManager() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        basePage.loginAsBankManager();
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