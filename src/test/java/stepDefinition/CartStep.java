package stepDefinition;

import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObject.CartPage;
import pageObject.ProductPage;
import utils.TestContextSetup;

import java.util.Collections;
import java.util.List;

public class CartStep {
    TestContextSetup testContextSetup;
    protected CartPage cartPage;

    public CartStep(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        cartPage = testContextSetup.pageObjectManager.getCartPage();
    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {
        int productQuantity = cartPage.getCountProductQuantity();
        int  cartIconCount = cartPage.getCartIconCount();

        Assert.assertEquals(productQuantity,cartIconCount);
        cartPage.selectCheckout();
    }

    @When("validate the prices from product page and cart page")
    public void validate_the_prices_from_product_page_and_cart_page() {
        cartPage.setCartPrices();

        List<String> productPrice = ProductPage.getProductPrice();

        List<String> cartPrice = cartPage.getCartPrice();

        Collections.sort(productPrice);
        Collections.sort(cartPrice);
        Assert.assertEquals(productPrice,cartPrice);
    }

    @When("the user remove product {string} from Your cart page")
    public void the_user_remove_product_from_your_cart_page(String productName) {
        cartPage.removeProduct(productName);
        cartPage.setCartIconCount();
    }

    @When("capture the quantity of {string} from the Your Cart page")
    public void capture_the_quantity_of_from_the_your_cart_page(String productName) {
        cartPage.setProductQuantity(productName);
    }

}
