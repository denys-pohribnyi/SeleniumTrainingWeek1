package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    private final By typeOfUserForLogin = By.xpath("//button[normalize-space()='Customer Login']");
    private final By selectingNameField = By.xpath("//select[@id='userSelect']");
    private final By nameInTheUsersList = By.xpath("//*[@id=\"userSelect\"]/option[3]");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By loginAsBankManagerButton = By.xpath("//button[normalize-space()='Bank Manager Login']");

    public LoginPage(WebDriver driver) {
        super();
    }


    public LoginPage choosingUserType() {
        driver.findElement(typeOfUserForLogin).click();
        return this;
    }

    public LoginPage selectingUserName() {
        driver.findElement(selectingNameField).click();
        driver.findElement(nameInTheUsersList).click();
        return this;
    }

    public LoginPage loginButtonClick() {
        driver.findElement(loginButton).click();
        return this;
    }

    public BankManagerAccountPage loginAsBankManager() {
        driver.findElement(loginAsBankManagerButton).click();
        return new BankManagerAccountPage(driver);
    }

}
