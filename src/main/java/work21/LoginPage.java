package work21;

import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebElement loginInput;
    private WebElement passwordInput;
    private WebElement loginButton;

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
