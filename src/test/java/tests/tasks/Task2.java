package tests.tasks;

import org.testng.annotations.Test;
import tests.baseTest.BaseTest;

public class Task2 extends BaseTest {
    @Test
    public void loginAsManager() {
        basePage.open("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        basePage.loginAsBankManager();
    }

    @Test(dependsOnMethods = {"loginAsManager"})
    public void addingNewCustomer() {
        bankManagerAccountPage
                .addNewCustomer()
                .AddingNewCustomer("Denys", "Pohribnyi", "18000")
                .acceptingNewCustomer();
    }

    @Test(dependsOnMethods = {"addingNewCustomer"})
    public void checkingThatCustomerWasCreated() {
        bankManagerAccountPage.checkingCreatedCustomerInTheList("Denys");
    }
}
// https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
//Залогиниться как manager
//Добавить любого клиента (Add Customer)
//Чтобы похендлить alert (нажать ok) можно использовать след:
//driver.switchTo().alert().accept();
//driver.switchTo().defaultContent();
//Перейти на вкладку “Open Account”
