package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionsPage extends BasePage {

    public TransactionsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/button[2]")
    private WebElement resetTransactionsButton;

    public void reset() {
        resetTransactionsButton.click();
    }

}
