package pageAsserts;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;

public class LoginAsserts {

    LoginPage loginPage;
    WebDriver driver;

    public LoginAsserts(LoginPage loginPage,WebDriver driver){
        this.driver = driver;
        this.loginPage = loginPage;
    }

    public void verifyErrorMessage(String expectedErrorMessage){
        Assert.assertEquals("Error message did not match UX message",expectedErrorMessage,loginPage.getErrorMessageContainer().getText());
    }
}
