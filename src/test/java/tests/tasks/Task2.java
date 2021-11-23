package tests.tasks;

import org.testng.annotations.Test;
import pages.BankManagerAccountPage;
import pages.BasePage;
import pages.LoginPage;
import tests.baseTest.BaseTest;

public class Task2 extends BaseTest {
    LoginPage loginPage = new LoginPage(getDriver());
    BankManagerAccountPage bankManagerAccountPage = new BankManagerAccountPage(getDriver());
    @Test
    public void loginAsManager() {
        getDriver().get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        loginPage.loginAsBankManager();
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
