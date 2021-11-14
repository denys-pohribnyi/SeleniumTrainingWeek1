package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.List;

public class BankManagerAccountPage extends BasePage {
    public BankManagerAccountPage(WebDriver driver) {
        super(driver);
    }
    private String alertInfo;     // Переменная для хранения информации из алерта в котором содержится ID

    private final By addCustomerButton = By.xpath("//button[normalize-space()='Add Customer']");
    private final By firstNameField = By.xpath("//input[@placeholder='First Name']");
    private final By lastNameField = By.xpath("//input[@placeholder='Last Name']");
    private final By postCodeField = By.xpath("//input[@placeholder='Post Code']");
    private final By addCustomerAfterFillingForm = By.xpath("//button[@type='submit']");
    private final By customersList = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[3]");
    private final By searchCustomerField = By.xpath("//input[@placeholder='Search Customer']");
    private final By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private final By customerNameDropDownMenu = By.xpath("//*[@id=\"userSelect\"]");
    private final By customerCurrencyDropDownMenu = By.xpath("//*[@id=\"currency\"]");
    private final By processButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public BankManagerAccountPage addNewCustomer() {
        driver.findElement(addCustomerButton).click();
        return this;
    }

    public BankManagerAccountPage AddingNewCustomer(String firstName, String lastName, String postCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postCodeField).sendKeys(postCode);
        return this;
    }

    public BankManagerAccountPage acceptingNewCustomer() {
        driver.findElement(addCustomerAfterFillingForm).click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public BankManagerAccountPage checkingCreatedCustomerInTheList(String firstName) {
        driver.findElement(customersList).click();
        driver.findElement(searchCustomerField).sendKeys(firstName);
        WebElement result = driver.findElement(By.cssSelector("tbody td:nth-child(1)"));
        boolean customerIsPresentInTheList = result.isDisplayed();
        Assert.assertTrue(customerIsPresentInTheList);
        return this;
    }

    public BankManagerAccountPage openAccount() {
        driver.findElement(openAccountButton).click();
        return this;
    }

    public BankManagerAccountPage selectingName(String name) {
        Select dropdownName = new Select(driver.findElement(customerNameDropDownMenu));
        dropdownName.selectByVisibleText(name);
        return this;
    }

    public BankManagerAccountPage selectingCurrency(String currency) {
        Select dropdownCurrency = new Select(driver.findElement(customerCurrencyDropDownMenu));
        dropdownCurrency.selectByVisibleText(currency);
        return this;
    }

    public BankManagerAccountPage processingAccountCreation() {
        driver.findElement(processButton).click();
        alertInfo = driver.switchTo().alert().getText();
        System.out.println(alertInfo);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        return this;
    }

    public BankManagerAccountPage checkingAccountWasCreated() {
        String[] splittedAlertInfo = alertInfo.split(":");
        driver.findElement(customersList).click();
        driver.findElement(searchCustomerField).sendKeys(splittedAlertInfo[1]);   // Поиск по айдишнику который сохраняли в переменную
        WebElement resultOfSearchByAccountID = driver.findElement(By.cssSelector("tbody td:nth-child(1)"));
        boolean customerIsPresentInTheList = resultOfSearchByAccountID.isDisplayed();
        Assert.assertTrue(customerIsPresentInTheList);   // Проверка есть ли он в списке по поиску
        return this;
    }

    public BankManagerAccountPage removingAllAccounts() {
        driver.findElement(customersList).click();  // Используем коллекцию элементов чтобы записать их и потом удалить все
        List<WebElement> listOfUsers = driver.findElements(By.xpath("//tr[contains(@class,'ng-scope')]"));
        for (WebElement t : listOfUsers) {
            System.out.println(t.getText());
            t.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        }
        return this;
    }
}
