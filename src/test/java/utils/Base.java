package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {

    public WebDriver driver;
    WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterData(WebElement element, String data) {
        element.sendKeys(data);
    }

    public void clickOn(WebElement element) {
        element.click();
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }

    public void waitVisibilityOf(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitAttributeToBe(WebElement element, String attributeName, String attributeValue) {
        wait.until(ExpectedConditions.attributeToBe(element, attributeName, attributeValue));
    }

    public void waitAttributeContaining(WebElement element, String attributeName, String attributeValue) {
        wait.until(ExpectedConditions.attributeContains(element, attributeName, attributeValue));
    }


}
