package work21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OverviewTab {

    private WebDriver webDriver;

    OverviewTab(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public OverviewTab overviewButton() {
        webDriver.findElement(By.id("bank-overview")).click();
        return this;
    }

    public OverviewTab amountMoney () {
        WebElement amount = webDriver.findElement(By.xpath("//div[2]/div/div/span/span[normalize-space(@class='amount')]"));
        Assert.assertEquals(amount.getText(), "2 718 764.83 ₽");
        return this;
    }

    public OverviewTab myMoney () {
        WebElement amount = webDriver.findElement(By.xpath("//div[2]/div/div/span/span[normalize-space(@class='amount')]"));
        WebElement myMoney = webDriver.findElement(By.className("my-assets"));
        new Actions(webDriver).moveToElement(amount).perform();
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(myMoney));
        Assert.assertEquals(myMoney.getText(), "Моих средств 2 936 972.64 ₽");
        return this;
    }

    boolean verefiTitle () {
        if (webDriver.getTitle().equals("Обзор -  Интернет банк - Банк Санкт-Петербург")) {
            return true;
        } else {
            return false;
        }
    }
}
