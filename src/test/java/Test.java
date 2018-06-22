import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by durmm on 22/06/18.
 */
public class Test {
    private Drivers driver = new Drivers();

    @org.testng.annotations.Test()
    private void test() {
        WebDriver webDriver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", driver.getDriverPath('F'));
        webDriver.get("google.ru");
        WebElement element = webDriver.findElement(By.xpath("gdgd"));
    }
}
