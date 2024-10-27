package stepDefinition;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pageActions.LoginActions;
import pageAsserts.LoginAsserts;
import pageObject.LoginPage;
import utils.TestContextSetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginStep {
    TestContextSetup testContextSetup;
    private final LoginActions loginActions;
    private final LoginAsserts loginAsserts;

    public LoginStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        loginActions = testContextSetup.pageObjectManager.getLoginActions();
        loginAsserts = testContextSetup.pageObjectManager.getLoginAsserts();
    }

    @When("user login with credentials {string}")
    public void user_login_with_username_and_password(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String username = testCaseData.get("username");
        String password = testCaseData.get("password");
        
        loginActions.login(username,password);
    }

    @When("user select login button")
    public void user_select_login_button(){
        loginActions.selectLoginBtn();
    }

    @When("user type username {string}")
    public void user_type_username(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String username = testCaseData.get("username");

        loginActions.typeUsername(username);
    }

    @Then("an error message {string} should displayed")
    public void the_error_message_should_displayed(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String expectedErrorMessage = testCaseData.get("message");

        loginActions.isErrorMessageDisplayed();

        loginAsserts.verifyErrorMessage(expectedErrorMessage);

    }


}
