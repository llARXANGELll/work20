package work21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver webDriver;

    LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage loginInput(String login) {
        webDriver.findElement(By.name("username")).sendKeys(login);
        return this;
    }

    public LoginPage passwordInput(String password) {
        webDriver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public LoginPage loginButton() {
        webDriver.findElement(By.id("login-button")).click();
        return this;
    }
}
