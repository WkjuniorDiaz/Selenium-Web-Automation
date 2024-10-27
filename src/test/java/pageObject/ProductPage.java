package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.Base;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement productTitle;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    @FindBy(className = "active_option")
    private WebElement activeSortBy;

    @FindBy(className = "product_sort_container")
    private WebElement sortByOpt;

    @FindBys(@FindBy(className = "inventory_item_price"))
    private List<WebElement> itemsPrice;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductTitle(){
        return productTitle;
    }

    public WebElement getCartIcon(){
        return cartIcon;
    }

    public WebElement getActiveSortBy(){
        return activeSortBy;
    }

    public WebElement getSortByOpt(){
        return sortByOpt;
    }

    public List<WebElement> getItemsPrice(){
        return itemsPrice;
    }

    public WebElement getAddToCartButton(String productName){
        By addToCartBtn = By.xpath("//div[.='"+productName+"']/../../../div/button");
        return driver.findElement(addToCartBtn);
    }

    public WebElement getProductsPrice(String productName){
        By productPriceElement = By.xpath("//div[.='"+productName+"']/../../../div[@class='pricebar']/div");
        return driver.findElement(productPriceElement);
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }

    public String getProductsPriceText(String productName){
        return getProductsPrice(productName).getText();
    }

    public String getCartIconText(){
        return cartIcon.getText();
    }

    public String getSortByText(){
        return activeSortBy.getText();
    }

}
