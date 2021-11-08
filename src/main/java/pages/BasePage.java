package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    private WebElement typeOfUserForLogin;
    @FindBy(xpath = "//select[@id='userSelect']")
    private WebElement selectingNameField;
    @FindBy(xpath = "//*[@id=\"userSelect\"]/option[3]")
    private WebElement nameInTheUsersList;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    private WebElement loginAsBankManagerButton;

    public void choosingUserType() {
        typeOfUserForLogin.click();
    }

    public void selectingUserName() {
        selectingNameField.click();
        nameInTheUsersList.click();
    }

    public AccountPage loginButtonClick() {
        loginButton.click();
        return new AccountPage(driver);
    }

    public BankManagerAccountPage loginAsBankManager() {
        loginAsBankManagerButton.click();
        return new BankManagerAccountPage(driver);
    }

}