package work20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
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
        webDriver.findElement(By.id("login-button")).click();
        webDriver.findElement(By.id("login-otp-button")).click();
        webDriver.findElement(By.id("bank-overview")).click();
        String text = webDriver.findElement(By.xpath("//div[2]/div/div/span/span[@class='amount']")).getText();
        System.out.printf(text);
        Assert.assertEquals(text, "2 718 764.83 ₽");
    }
    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}
