package common;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import java.util.concurrent.TimeUnit;

public class CommonActions {
    public static WebDriver webDriverSetup() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        return driver;
    }
}