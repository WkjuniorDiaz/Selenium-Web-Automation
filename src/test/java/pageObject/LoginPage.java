package pageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Base;

import java.time.Duration;

public class LoginPage extends Base {

    @FindBy(xpath = "//div[@class='login_logo']")
    WebElement loginTitle;
    @FindBy(id = "user-name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        waitVisibilityOf(loginTitle);
        enterData(usernameField, username);
        enterData(passwordField, password);
        clickOn(btnLogin);
    }

    public void typeUsername(String username){
        waitVisibilityOf(loginTitle);
        enterData(usernameField,username);
    }

    public void selectLoginBtn(){
        clickOn(btnLogin);
    }

    public void isErrorMessageDisplayed(){
        try {
            waitVisibilityOf(errorMessageContainer);
        } catch (TimeoutException e) {
            throw new Error("The container of the error message didn't displayed");
        }
    }

    public String getErrorMessageText(){
        return getElementText(errorMessageContainer);
    }
}
