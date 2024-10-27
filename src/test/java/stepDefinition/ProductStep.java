package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pageActions.ProductActions;
import pageAsserts.ProductAsserts;
import utils.TestContextSetup;

import java.util.HashMap;

public class ProductStep {

    TestContextSetup testContextSetup;
    private final ProductActions productActions;
    private final ProductAsserts productAsserts;

    public ProductStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        productActions = testContextSetup.pageObjectManager.getProductActions();
        productAsserts = testContextSetup.pageObjectManager.getProductAsserts();
    }

    @Then("the product page should displayed")
    public void the_product_page_should_displayed(){
        productActions.validateProductPage();

        productAsserts.verifySuccessfulLogin();
    }

    @When("the user adds the product {string} to the cart")
    public void the_user_adds_the_product_to_the_cart(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,String> testCaseData = (HashMap<String, String>) jsonData.get(testCase);
        String productName = testCaseData.get("productName");

        productActions.validateProductPage();
        productActions.addProduct(productName);
        productActions.validateIfRemoveEnabled(productName);
        productActions.setProductPrice(productName);
    }
    @When("the user navigates to the cart")
    public void the_user_navigates_to_the_cart(){
        productActions.selectCart();
    }

    @When("the user changes the product sort to {string}")
    public void the_user_changes_the_product_sort_to(String sortOption){
        productActions.validateProductPage();
        productActions.sortBy(sortOption);
    }

    @When("the user adds multiple products {string} to the cart")
    public void the_user_adds_multiple_products_to_the_cart(String testCase){
        JSONObject jsonData = Hooks.jsonData;
        HashMap<String,JSONArray> testCaseData = (HashMap<String, JSONArray>) jsonData.get(testCase);
        JSONArray listProductName = testCaseData.get("productsNames");

        productActions.validateProductPage();

        for (Object productName:listProductName){
            String product = (String) productName;

            productActions.addProduct(product);
            productActions.validateIfRemoveEnabled(product);
            productActions.setProductPrice(product);
        }
    }

    @Then("the selected sort option should be {string}")
    public void the_selected_sort_option_should_be(String expectedSortOption){
        productAsserts.verifySortedDisplayedOption(expectedSortOption);
    }

    @Then("all product prices on the page should be in ascending order")
    public void all_products_prices_on_the_page_should_be_in_ascending_order(){
        productActions.verifyAscendingOrder();
    }
}
