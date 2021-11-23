package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransactionsPage extends BasePage {

    private final By resetTransactionsButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");

    public TransactionsPage(WebDriver driver) {
        super();
    }

    public TransactionsPage reset() {
        driver.findElement(resetTransactionsButton).click();
        return this;
    }

}
