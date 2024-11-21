package stepDefinition;

import io.cucumber.java.en.When;
import pageActions.CartActions;
import pageAsserts.CartAsserts;
import utils.TestContextSetup;

public class CartStep {
    TestContextSetup testContextSetup;
    private final CartActions cartActions;
    private final CartAsserts cartAsserts;

    public CartStep(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        cartActions = testContextSetup.objectFactory.getCartActions();
        cartAsserts = testContextSetup.objectFactory.getCartAsserts();
    }

    @When("the user proceeds to checkout your information")
    public void the_user_proceeds_to_checkout_your_information() {
        int productQuantity = cartActions.getCountProductQuantity();
        int  cartIconCount = cartActions.getCartIconCount();

        cartAsserts.verifyItemsCountOfCart(productQuantity,cartIconCount);
        cartActions.selectCheckout();
    }

    @When("the user remove product {string} from Your cart page")
    public void the_user_remove_product_from_your_cart_page(String productName) {
        cartActions.removeProduct(productName);
        cartActions.setCartIconCount();
    }

    @When("capture the quantity of {string} from the Your Cart page")
    public void capture_the_quantity_of_from_the_your_cart_page(String productName) {
        cartActions.setProductQuantity(productName);
    }

}
