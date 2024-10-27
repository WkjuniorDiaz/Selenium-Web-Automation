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

public class CartPage {

    WebDriver driver;

    @FindBy(id = "checkout")
    WebElement btnCheckout;

    @FindBys(@FindBy(className = "inventory_item_price"))
    List<WebElement> listPrices;

    @FindBy(className = "title")
    WebElement cartTitle;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getBtnCheckout(){
        return btnCheckout;
    }

    public List<WebElement> getListPrices(){
        return listPrices;
    }

    public WebElement getCartTitle(){
        return cartTitle;
    }

    public WebElement getCartIcon(){
        return cartIcon;
    }

    public WebElement getProductQuantity(String productName){
        By productQuantityElement = By.xpath("//div[.='"+productName+"']/../../../div[@class='cart_quantity']");
        return driver.findElement(productQuantityElement);
    }

    public WebElement getRemoveButtonOfProduct(String productName){
        By removeBtnOfProduct = By.xpath("//div[.='"+productName+"']/../following-sibling::div/button");

        return driver.findElement(removeBtnOfProduct);
    }

    public String getProductQuantityText(String productName){
        return getProductQuantity(productName).getText();
    }

    public String getCartIconText(){
        return cartIcon.getText();
    }

}
