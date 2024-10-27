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

public class LoginPage {

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement loginTitle;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMessageContainer;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginTitle(){
        return loginTitle;
    }

    public WebElement getUsernameField(){
        return usernameField;
    }

    public WebElement getPasswordField(){
        return passwordField;
    }

    public WebElement getBtnLogin(){
        return btnLogin;
    }

    public WebElement getErrorMessageContainer(){
        return errorMessageContainer;
    }

    public String getErrorMessageText(){
        return errorMessageContainer.getText();
    }


}
