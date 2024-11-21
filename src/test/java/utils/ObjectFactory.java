package utils;

import org.openqa.selenium.WebDriver;
import pageActions.CartActions;
import pageActions.LoginActions;
import pageActions.ProductActions;
import pageAsserts.CartAsserts;
import pageAsserts.LoginAsserts;
import pageAsserts.ProductAsserts;
import pageObject.CartPage;
import pageObject.CheckoutPage;
import pageObject.LoginPage;
import pageObject.ProductPage;

public class ObjectFactory {

    public WebDriver driver;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CheckoutPage checkoutPage;
    public CartPage cartPage;
    public LoginActions loginActions;
    public LoginAsserts loginAsserts;
    public ProductActions productActions;
    public ProductAsserts productAsserts;
    public CartActions cartActions;
    public CartAsserts cartAsserts;


    public ObjectFactory(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage getLoginPage(){
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public ProductPage getProductPage(){
        if (productPage == null) {
            productPage = new ProductPage(driver);
        }
        return  productPage;
    }

    public CheckoutPage getCheckoutPage(){
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }

    public CartPage getCartPage(){
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public LoginActions getLoginActions(){
        if (loginActions == null) {
            loginActions = new LoginActions(getLoginPage(),driver);
        }
        return loginActions;
    }

    public LoginAsserts getLoginAsserts(){
        if (loginAsserts == null) {
            loginAsserts = new LoginAsserts(getLoginPage());
        }
        return loginAsserts;
    }

    public ProductActions getProductActions(){
        if (productActions == null) {
            productActions = new ProductActions(getProductPage(),driver);
        }
        return productActions;
    }

    public ProductAsserts getProductAsserts(){
        if (productAsserts == null) {
            productAsserts = new ProductAsserts(getProductPage(),getProductActions());
        }
        return productAsserts;
    }

    public CartActions getCartActions(){
        if (cartActions == null) {
            cartActions = new CartActions(getCartPage(),driver);
        }
        return cartActions;
    }

    public CartAsserts getCartAsserts(){
        if (cartAsserts == null) {
            cartAsserts = new CartAsserts(getCartPage());
        }
        return cartAsserts;
    }


}
