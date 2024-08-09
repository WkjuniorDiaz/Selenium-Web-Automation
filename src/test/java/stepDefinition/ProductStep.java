package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.ProductPage;
import utils.TestContextSetup;

public class ProductStep {

    TestContextSetup testContextSetup;
    public ProductPage productPage;

    public ProductStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        productPage = testContextSetup.pageObjectManager.getProductPage();
    }

    @Then("the product page should displayed")
    public void the_product_page_should_displayed(){
        productPage.validateProductPage();

        Assert.assertEquals("Failed attempt to log in","Products",productPage.getProductTitle());
    }

    @When("the user adds the product {string} to the cart")
    public void the_user_adds_the_product_to_the_cart(String productName){
        productPage.validateProductPage();
        productPage.addProduct(productName);
        productPage.validateIfRemoveEnabled(productName);
        productPage.setProductPrice(productName);
    }
    @When("the user navigates to the cart")
    public void the_user_navigates_to_the_cart(){
        productPage.selectCart();
    }

    @When("the user changes the product sort to {string}")
    public void the_user_changes_the_product_sort_to(String sortOption){
        productPage.validateProductPage();
        productPage.sortBy(sortOption);
    }

    @Then("the selected sort option should be {string}")
    public void the_selected_sort_option_should_be(String sortOption){
        Assert.assertEquals("The selected sort option didn't match the actual value",sortOption,productPage.getSortByText());
    }

    @Then("all product prices on the page should be in ascending order")
    public void all_products_prices_on_the_page_should_be_in_ascending_order(){
        Assert.assertTrue("The prices are not sorted by ascending",productPage.verifyAscendingOrder());
    }
}
