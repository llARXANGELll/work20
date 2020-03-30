package work21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver webDriver;

    LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    By username = By.name("username");
    By password = By.name("password");

    public LoginPage loginInput(String setlogin) {
        webDriver.findElement(username).clear();
        webDriver.findElement(username).sendKeys(setlogin);
        return this;
    }

    public LoginPage passwordInput(String setPassword) {
        webDriver.findElement(password).clear();
        webDriver.findElement(password).sendKeys(setPassword);
        return this;
    }

    public LoginPage loginButton() {
        webDriver.findElement(By.id("login-button")).click();
        return this;
    }
}