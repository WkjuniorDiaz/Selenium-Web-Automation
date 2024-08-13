package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import org.junit.Assert;
import pageObject.ProductPage;
import pageObject.CheckoutPage;
import utils.TestContextSetup;

import java.util.HashMap;

public class CheckoutStep {
    TestContextSetup testContextSetup;
    protected CheckoutPage checkoutPage;

    public CheckoutStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @When("the user fills the checkout information with {string} information")
    public void the_user_fill_the_checkout_information(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String firstName = testCaseData.get("firstName");
        String lastName = testCaseData.get("lastName");
        String postalCode = testCaseData.get("postalCode");

        checkoutPage.fillCheckoutForm(firstName,lastName,postalCode);
    }

    @When("the user proceeds to checkout overview")
    public void the_user_proceeds_to_checkout_overview(){
        checkoutPage.selectContinue();
    }

    @When("the user proceeds to checkout complete")
    public void the_user_proceeds_to_checkout_complete() {
        Double checkoutPrice = checkoutPage.getItemTotalPrice();
        Double productPrice = ProductPage.getProductPrice();

        checkoutPage.validateCheckoutOverview();

        Assert.assertEquals(productPrice,checkoutPrice);

        checkoutPage.selectFinish();
    }

    @Then("verify that the checkout was successfully and logout")
    public void verify_that_the_checkout_was_successfully_and_logout(){
        checkoutPage.validateCheckoutComplete();
        Assert.assertEquals("Successful checkout message was not displayed","Thank you for your order!",checkoutPage.getTextMessage1());
        checkoutPage.logOut();
    }





}
