package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pageObject.LoginPage;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginStep {
    TestContextSetup testContextSetup;
    protected LoginPage loginPage;

    public LoginStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginPage = testContextSetup.pageObjectManager.getLoginPage();
    }

    @When("user login with credentials {string}")
    public void user_login_with_username_and_password(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String username = testCaseData.get("username");
        String password = testCaseData.get("password");

        loginPage.login(username,password);
    }

    @When("user select login button")
    public void user_select_login_button(){
        loginPage.selectLoginBtn();
    }

    @When("user type username {string}")
    public void user_type_username(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String username = testCaseData.get("username");

        loginPage.typeUsername(username);
    }

    @Then("an error message {string} should displayed")
    public void the_error_message_should_displayed(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String expectedErrorMessage = testCaseData.get("message");

        loginPage.isErrorMessageDisplayed();

        Assert.assertEquals("Error message did not match UX message",expectedErrorMessage,loginPage.getErrorMessageText());
    }


}
