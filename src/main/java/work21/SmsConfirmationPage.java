package work21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmsConfirmationPage {

    private WebDriver webDriver;

    SmsConfirmationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By otpcode = By.id("otp-code");
    private By loginOtpButton = By.id("login-otp-button");

    public SmsConfirmationPage otpCode (String otpCode) {
        webDriver.findElement(otpcode).sendKeys(otpCode);
        return this;
    }

    public SmsConfirmationPage inputButton () {
        webDriver.findElement(loginOtpButton).click();
        return this;
    }

    boolean verifyTitle() {
        if(webDriver.getTitle().equals("Старт -  Интернет банк - Банк Санкт-Петербург")) {
            return true;
        } else {
            return false;
        }
    }
}
