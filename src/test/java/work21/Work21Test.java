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

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://idemo.bspb.ru/");
    }

    @Test
    public void work21() {
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginInput("").passwordInput("").loginButton();

        SmsConfirmation smsConfirmation = new SmsConfirmation(webDriver);
        smsConfirmation.otpCode("").inputButton().verifyTitle();

        OverviewTab overviewTab = new OverviewTab(webDriver);
        overviewTab.overviewButton().verefiTitle();
        overviewTab.amountMoney().myMoney();
    }

    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}

