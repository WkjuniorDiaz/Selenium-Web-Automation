package pageObject;

import org.openqa.selenium.WebDriver;
import pageActions.LoginActions;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public  ProductPage productPage;
    public CheckoutPage checkoutPage;
    public CartPage cartPage;
    public LoginActions loginActions;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public ProductPage getProductPage(){
        productPage = new ProductPage(driver);
        return  productPage;
    }

    public CheckoutPage getCheckoutPage(){
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

    public CartPage getCartPage(){
        cartPage = new CartPage(driver);
        return cartPage;
    }

    public LoginActions getLoginActions(){
        if (loginActions == null) {
            loginActions = new LoginActions(getLoginPage(),driver);
        }
        return loginActions;
    }
}
