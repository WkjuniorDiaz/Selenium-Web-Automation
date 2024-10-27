package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.CartPage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartActions {

    private final CartPage cartPage;
    private final WebDriverWait wait;
    List<String> cartPagePrice = new ArrayList<>();
    int cartIconCount = 0;
    int countProductQuantity;

    public CartActions(CartPage cartPage, WebDriver driver){
        this.cartPage = cartPage;
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    public void selectCheckout(){
        wait.until(ExpectedConditions.visibilityOf(cartPage.getBtnCheckout()));
        cartPage.getBtnCheckout().click();
    }

    public void  setCartPrices(){
        wait.until(ExpectedConditions.visibilityOf(cartPage.getCartTitle()));

        cartPagePrice = cartPage.getListPrices().stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .collect(Collectors.toList());
    }

    public List<String> getCartPrice(){
        return cartPagePrice;
    }

    public void setProductQuantity(String productName){
        int parseProductQuantity = Integer.parseInt(cartPage.getProductQuantityText(productName));
        countProductQuantity = countProductQuantity + parseProductQuantity;
    }

    public int getCountProductQuantity(){
        return countProductQuantity;
    }

    public void  setCartIconCount(){
        cartIconCount = Integer.parseInt(cartPage.getCartIconText());
    }

    public int getCartIconCount(){
        return  cartIconCount;
    }

    public void removeProduct(String productName){
        WebElement removeProductButton = cartPage.getRemoveButtonOfProduct(productName);

        removeProductButton.click();
    }
}
