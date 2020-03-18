package work20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://idemo.bspb.ru/");
    }

    @Test(enabled = true)
    public void work20() {
        String attributeUsername = webDriver.findElement(By.xpath("//div/input[@value='demo']")).getAttribute("dem");
        Assert.assertEquals(attributeUsername, "demo");
    }
    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}
