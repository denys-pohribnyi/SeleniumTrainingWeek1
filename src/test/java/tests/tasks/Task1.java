package tests.tasks;

import org.testng.annotations.Test;
import tests.baseTest.BaseTest;

public class Task1 extends BaseTest {
    @Test
    public void loginTest() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        basePage.choosingUserType();
        basePage.selectingUserName();
        basePage.loginButtonClick();
        accountPage.nameIsPresent();
    }

    @Test(dependsOnMethods = {"loginTest"})
    public void depositTest() {
        accountPage.performingDeposit();
        accountPage.checkingBalanceAfterDeposit();
    }

    @Test(dependsOnMethods = {"depositTest"})
    public void withdrawTest() {
        accountPage.performingWithdraw();
        accountPage.checkingBalanceAfterWithdraw();
    }

    @Test(dependsOnMethods = {"withdrawTest"})
    public void resetAllTransactions() {
        accountPage.resetTransactions();
        transactionsPage.reset();
    }
}


//Домашка:
//1. Открыть сайт
// https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как Customer (for ex Harry Potter)
//Зайти в Deposit, положить 1000 на депозит
//Зайти в Withdraw, снять 900
//Зайти в Transactions удалить все записи
// //select[@id='userSelect']     select button
// //*[@id="userSelect"]/option[3]     harry potter
//    //button[@type='submit']      loginButton
//    /html/body/div/div/div[2]/div/div[1]/strong
//