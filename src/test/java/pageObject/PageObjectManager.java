package pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public LoginPage loginPage;
    public  ProductPage productPage;
    public CheckoutPage checkoutPage;
    public CartPage cartPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }


    public LoginPage getLoginPage(){
        loginPage = new LoginPage(driver);
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
}
