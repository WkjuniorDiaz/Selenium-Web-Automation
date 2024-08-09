package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.LoginPage;
import utils.TestContextSetup;
import utils.TestDataLoader;

public class LoginStep {
    TestContextSetup testContextSetup;
    protected LoginPage loginPage;
    TestDataLoader testDataLoader;

    public LoginStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
        testDataLoader = new TestDataLoader();
    }

    @When("user login with credentials {string}")
    public void user_login_with_username_and_password(String testCase){
        JsonObject testData = testDataLoader.getTestDataForTestCase(testCase);
        String username = testData.get("username").getAsString();
        String password = testData.get("password").getAsString();

        loginPage.login(username,password);
    }

    @When("user select login button")
    public void user_select_login_button(){
        loginPage.selectLoginBtn();
    }

    @When("user type username {string}")
    public void user_type_username(String testCase){
        JsonObject testData = testDataLoader.getTestDataForTestCase(testCase);
        String username = testData.get("username").getAsString();

        loginPage.typeUsername(username);
    }

    @Then("an error message {string} should displayed")
    public void the_error_message_should_displayed(String testCase){
        JsonObject testData = testDataLoader.getTestDataForTestCase(testCase);
        String expectedErrorMessage = testData.get("message").getAsString();

        loginPage.isErrorMessageDisplayed();

        Assert.assertEquals("Error message did not match UX message",expectedErrorMessage,loginPage.getErrorMessageText());
    }


}
