package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.ProductPage;
import org.junit.Assert;
import pageObject.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutStep {
    TestContextSetup testContextSetup;
    protected CheckoutPage checkoutPage;

    public CheckoutStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @When("the user fills the checkout information with first name {string}, last name {string} and postal code {string}")
    public void the_user_fill_the_checkout_information(String firstName,String lastName,String postalCode){

        checkoutPage.fillCheckoutForm(firstName,lastName,postalCode);
    }

    @When("the user clicks on the continue button")
    public void the_user_clicks_on_the_continue_button(){
        checkoutPage.selectContinue();
    }

    @When("the user clicks on the finish button to complete the checkout")
    public void the_user_clicks_on_the_finish_button_to_complete_the_checkout(){
        checkoutPage.validateCheckoutOverview();
        checkoutPage.selectFinish();
    }

    @Then("verify that the checkout was successfully and logout")
    public void verify_that_the_checkout_was_successfully_and_logout(){
        checkoutPage.validateCheckoutComplete();
        Assert.assertEquals("Successful checkout message was not displayed","Thank you for your order!",checkoutPage.getTextMessage1());
        checkoutPage.logOut();
    }

    @When("validate price from product {string} to price of Item Total")
    public void validate_price_from_product_to_price_of_item_total(String productName) {
        String checkoutPrice = checkoutPage.getItemTotalPrice();
        String productPrice = ProductPage.getPriceOfaProduct(productName);

        Assert.assertEquals(productPrice,checkoutPrice);
    }





}
