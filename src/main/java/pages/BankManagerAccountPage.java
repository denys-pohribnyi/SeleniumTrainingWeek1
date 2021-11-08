package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class BankManagerAccountPage extends BasePage {
    public BankManagerAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private String alertInfo;     // Переменная для хранения информации из алерта в котором содержится ID

    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    private WebElement addCustomerButton;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement postCodeField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement addCustomerAfterFillingForm;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[3]")
    private WebElement customersList;
    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    private WebElement searchCustomerField;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    private WebElement openAccountButton;
    @FindBy(xpath = "//*[@id=\"userSelect\"]")
    private WebElement customerNameDropDownMenu;
    @FindBy(xpath = "//*[@id=\"currency\"]")
    private WebElement customerCurrencyDropDownMenu;
    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/div/div/form/button")
    private WebElement processButton;

    public void addNewCustomer() {
        addCustomerButton.click();
    }

    public void AddingNewCustomer(String firstName, String lastName, String postCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
    }

    public void acceptingNewCustomer() {
        addCustomerAfterFillingForm.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void checkingCreatedCustomerInTheList(String firstName) {
        customersList.click();
        searchCustomerField.sendKeys(firstName);
        WebElement result = driver.findElement(By.cssSelector("tbody td:nth-child(1)"));
        boolean customerIsPresentInTheList = result.isDisplayed();
        Assert.assertTrue(customerIsPresentInTheList);
    }

    public void openAccount() {
        openAccountButton.click();
    }

    public void selectingName(String name) {
        Select dropdownName = new Select(customerNameDropDownMenu);
        dropdownName.selectByVisibleText(name);
    }

    public void selectingCurrency(String currency) {
        Select dropdownCurrency = new Select(customerCurrencyDropDownMenu);
        dropdownCurrency.selectByVisibleText(currency);
    }

    public void processingAccountCreation() {
        processButton.click();
        alertInfo = driver.switchTo().alert().getText();
        System.out.println(alertInfo);
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    public void checkingAccountWasCreated() {
        String[] splittedAlertInfo = alertInfo.split(":");
        customersList.click();
        searchCustomerField.sendKeys(splittedAlertInfo[1]);   // Поиск по айдишнику который сохраняли в переменную
        WebElement resultOfSearchByAccountID = driver.findElement(By.cssSelector("tbody td:nth-child(1)"));
        boolean customerIsPresentInTheList = resultOfSearchByAccountID.isDisplayed();
        Assert.assertTrue(customerIsPresentInTheList);   // Проверка есть ли он в списке по поиску
    }

    public void removingAllAccounts() {
        customersList.click();  // Используем коллекцию элементов чтобы записать их и потом удалить все
        List<WebElement> listOfUsers = driver.findElements(By.xpath("//tr[contains(@class,'ng-scope')]"));
        for (WebElement t : listOfUsers) {
            System.out.println(t.getText());
            t.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
        }
    }
}
