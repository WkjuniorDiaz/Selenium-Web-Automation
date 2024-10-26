package pageActions;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoginPage;

import java.time.Duration;

public class LoginActions {

    LoginPage loginPage;
    WebDriver driver;
    WebDriverWait wait;

    public LoginActions(LoginPage loginPage,WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(4));
        this.loginPage = loginPage;
    }

    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginPage.getLoginTitle()));
        loginPage.getUsernameField().sendKeys(username);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getBtnLogin().click();
    }

    public void typeUsername(String username){
        wait.until(ExpectedConditions.visibilityOf(loginPage.getBtnLogin()));
        loginPage.getUsernameField().sendKeys(username);
    }

    public void selectLoginBtn(){
        loginPage.getBtnLogin().click();
    }

    public void isErrorMessageDisplayed(){
        try {
            wait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMessageContainer()));
        } catch (TimeoutException e) {
            throw new Error("The container of the error message didn't displayed");
        }
    }

    public String getErrorMessageText(){
        return loginPage.getErrorMessageContainer() .getText();
    }
}
