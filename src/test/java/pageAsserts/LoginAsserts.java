package pageAsserts;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;

public class LoginAsserts {

    private final LoginPage loginPage;

    public LoginAsserts(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    public void verifyErrorMessage(String expectedErrorMessage){
        String actualErrorMessage = loginPage.getErrorMessageText();
        Assert.assertEquals("Error message did not match UX message",expectedErrorMessage,actualErrorMessage);
    }
}
