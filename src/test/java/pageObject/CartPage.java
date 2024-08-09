package pageObject;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends Base {

    List<String> cartPagePrice = new ArrayList<>();
    int cartIconCount = 0;

    int countProductQuantity;

    @FindBy(id = "checkout")
    WebElement btnCheckout;
    @FindBys(@FindBy(className = "inventory_item_price"))
    List<WebElement> listPrices;
    @FindBy(className = "title")
    WebElement cartTitle;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;


    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void selectCheckout(){
        waitVisibilityOf(btnCheckout);
        clickOn(btnCheckout);
    }

    public void  setCartPrices(){
        waitVisibilityOf(cartTitle);

        List<String> prices = listPrices.stream()
                .map(WebElement::getText)
                .map(price -> price.replace("$", ""))
                .collect(Collectors.toList());

        cartPagePrice = prices;
    }

    public List<String> getCartPrice(){
        return cartPagePrice;
    }

    public void setProductQuantity(String productName){
        By productQuantityElement = By.xpath("//div[.='"+productName+"']/../../../div[@class='cart_quantity']");
        int productQuantity = Integer.parseInt(getElementText(driver.findElement(productQuantityElement)));
        countProductQuantity = countProductQuantity + productQuantity;
    }

    public int getCountProductQuantity(){
        return countProductQuantity;
    }

    public void  setCartIconCount(){
        cartIconCount = Integer.parseInt(getElementText(cartIcon));
    }

    public int getCartIconCount(){
        return  cartIconCount;
    }

    public void removeProduct(String productName){
        By removeBtnOfProduct = By.xpath("//div[.='"+productName+"']/../following-sibling::div/button");

        clickOn(driver.findElement(removeBtnOfProduct));
    }

}
