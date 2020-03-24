package work21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmsConfirmation {

    private WebDriver webDriver;

    SmsConfirmation (WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SmsConfirmation otpCode (String otpCode) {
        webDriver.findElement(By.id("otp-code")).sendKeys(otpCode);
        return this;
    }

    public SmsConfirmation inputButton () {
        webDriver.findElement(By.id("login-otp-button")).click();
        return this;
    }

    boolean returnTitle() {
        if(webDriver.getTitle().equals("Старт -  Интернет банк - Банк Санкт-Петербург")) {
            return true;
        } else {
            return false;
        }
    }

}
