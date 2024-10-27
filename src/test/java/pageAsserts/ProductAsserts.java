package pageAsserts;

import org.junit.Assert;
import pageActions.ProductActions;
import pageObject.ProductPage;

public class ProductAsserts {

    private final ProductPage productPage;
    private final ProductActions productActions;

    public ProductAsserts(ProductPage productPage, ProductActions productActions){
        this.productPage = productPage;
        this.productActions = productActions;
    }

    public void verifySuccessfulLogin(){
        String actualProductTitle = productPage.getProductTitleText();
        Assert.assertEquals("Failed attempt to log in","Products",actualProductTitle);
    }

    public void verifySortedDisplayedOption(String expectedSortOption){
        String actualSortedOption = productPage.getSortByText();
        Assert.assertEquals("The selected sort option didn't match the actual value",expectedSortOption,actualSortedOption);
    }

    public void verifyAscendingOrder(){
        Assert.assertTrue("The prices are not sorted by ascending",productActions.verifyAscendingOrder());
    }
}
