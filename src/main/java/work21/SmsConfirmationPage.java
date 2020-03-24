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


    @FindBy(id = "otp-code")
    private WebElement otpcode;
    @FindBy(id = "login-otp-button")
    WebElement loginOtpButton;

    public SmsConfirmationPage otpCode (String otpCode) {
        otpcode.sendKeys(otpCode);
        return this;
    }

    public SmsConfirmationPage inputButton () {
        loginOtpButton.click();
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
