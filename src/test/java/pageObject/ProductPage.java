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

public class ProductPage extends Base {

    static double productPagePrice;
    static String productPageCartCount = "";

    @FindBy(xpath = "//span[@class='title']")
    WebElement productTitle;
    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;
    @FindBy(className = "active_option")
    WebElement activeSortBy;
    @FindBy(className = "product_sort_container")
    WebElement sortByOpt;
    @FindBys(@FindBy(className = "inventory_item_price"))
    List<WebElement> itemsPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void validateProductPage() {
        waitVisibilityOf(productTitle);
    }

    public String getProductTitle() {
        return getElementText(productTitle);
    }

    public void addProduct(String productName) {
        By addToCartBtnOfElement = By.xpath("//div[.='"+productName+"']/../../../div/button");

        waitVisibilityOf(driver.findElement(addToCartBtnOfElement));
        clickOn(driver.findElement(addToCartBtnOfElement));
    }

    public void validateIfRemoveEnabled(String productName) {
        By addToCartBtnOfElement = By.xpath("//div[.='"+productName+"']/../../../div/button");

        try {
            waitAttributeContaining(driver.findElement(addToCartBtnOfElement),"data-test","remove");
        }catch (TimeoutException e){
            throw new Error("Remove button was not enable");
        }
    }

    public void  setProductPrice(String productName){
        By productPriceElement = By.xpath("//div[.='"+productName+"']/../../../div[@class='pricebar']/div");
        String getTextOfElement = getElementText(driver.findElement(productPriceElement));
        String priceText =getTextOfElement.replace("$","");
        double pricetoDouble = Double.parseDouble(priceText);

        productPagePrice = productPagePrice + pricetoDouble;
    }

    public static double getProductPrice(){

        return productPagePrice;
    }

    public void selectCart(){
        clickOn(cartIcon);
    }

    public void setValueOfCart(){
        productPageCartCount = getElementText(cartIcon);
    }

    public static String getValueOfCart(){
        return productPageCartCount;
    }

    public void sortBy(String sortOption){
        Select drpSortBy = new Select(sortByOpt);
        drpSortBy.selectByVisibleText(sortOption);
    }

    public String getSortByText(){
        return getElementText(activeSortBy);
    }

    public boolean verifyAscendingOrder(){
        boolean ascendingOrder;

        List<Double> prices = itemsPrice.stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());

        ascendingOrder = prices.equals(prices.stream().sorted().collect(Collectors.toList()));

        return ascendingOrder;
    }

}
