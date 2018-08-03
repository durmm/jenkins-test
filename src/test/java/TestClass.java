import config.Drivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    private Drivers driver = new Drivers();

    @Test()
    public void test() {
//        System.setProperty("webdriver.gecko.driver", driver.getDriverPath('F'));
        System.setProperty("webdriver.chrome.driver", driver.getDriverPath('C'));
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://google.ru");
        WebElement element = webDriver.findElement(By.id("lst-ib"));
    }
}
