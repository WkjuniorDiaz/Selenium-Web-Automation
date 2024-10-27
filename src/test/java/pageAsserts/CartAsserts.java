package pageAsserts;

import org.junit.Assert;
import pageObject.CartPage;

public class CartAsserts {

    private final CartPage cartPage;

    public CartAsserts(CartPage cartPage){
        this.cartPage = cartPage;
    }

    public void verifyItemsCountOfCart(int productQuantity, int cartIconCount){
        Assert.assertEquals(productQuantity,cartIconCount);
    }
}
