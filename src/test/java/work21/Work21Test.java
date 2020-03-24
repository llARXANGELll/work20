package work21;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Work21Test {

    private WebDriver webDriver;
    private LoginPage loginPage = new LoginPage(webDriver);
    private SmsConfirmation smsConfirmation = new SmsConfirmation(webDriver);

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://idemo.bspb.ru/");


    }

    @Test
    public void work21() {
        loginPage.loginInput("").passwordInput("").loginButton();
        smsConfirmation.otpCode("").inputButton();




//        // готовое 19
//        webDriver.findElement(By.id("login-button")).click();
        webDriver.findElement(By.id("login-otp-button")).click();
        webDriver.findElement(By.id("bank-overview")).click();
        WebElement amount = webDriver.findElement(By.xpath("//div[2]/div/div/span/span[normalize-space(@class='amount')]"));
        Assert.assertEquals(amount.getText(), "2 718 764.83 ₽");
        WebElement myAssets = webDriver.findElement(By.className("my-assets"));
        new Actions(webDriver).moveToElement(amount).perform();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(myAssets));
        Assert.assertEquals(myAssets.getText(),"Моих средств 2 936 972.64 ₽");
    }

    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}

