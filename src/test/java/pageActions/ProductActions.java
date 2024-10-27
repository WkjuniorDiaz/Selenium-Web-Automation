package pageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.ProductPage;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductActions {

    private final ProductPage productPage;
    private final WebDriverWait wait;
    static double productPagePrice;
    static String productPageCartCount = "";

    public ProductActions(ProductPage productPage, WebDriver driver){
        this.productPage = productPage;
        wait = new WebDriverWait(driver, Duration.ofSeconds(6));
    }

    public void validateProductPage() {
        wait.until(ExpectedConditions.visibilityOf(productPage.getProductTitle()));
    }

    public void addProduct(String productName) {
        WebElement addToCartButton =  productPage.getAddToCartButton(productName);

        wait.until(ExpectedConditions.visibilityOf(addToCartButton));
        addToCartButton.click();
    }

    public void validateIfRemoveEnabled(String productName) {
        WebElement addToCartButton = productPage.getAddToCartButton(productName);

        try {
            wait.until(ExpectedConditions.attributeContains(addToCartButton,"data-test","remove"));
        }catch (TimeoutException e){
            throw new Error("Remove button was not enable");
        }
    }

    public void  setProductPrice(String productName){
        String productPriceText = productPage.getProductsPriceText(productName);
        String price = productPriceText.replace("$","");
        double parsePrice = Double.parseDouble(price);

        productPagePrice = productPagePrice + parsePrice;
    }

    public static double getProductPrice(){
        return productPagePrice;
    }

    public void selectCart(){
        productPage.getCartIcon().click();
    }

    public void setValueOfCart(){
        productPageCartCount = productPage.getCartIconText();
    }

    public static String getValueOfCart(){
        return productPageCartCount;
    }

    public void sortBy(String sortOption){
        Select drpSortBy = new Select(productPage.getSortByOpt());
        drpSortBy.selectByVisibleText(sortOption);
    }

    public String getSortByText(){
        return productPage.getSortByText();
    }

    public boolean verifyAscendingOrder(){
        List<WebElement> itemPrice = productPage.getItemsPrice();
        boolean ascendingOrder;

        List<Double> prices = itemPrice.stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .collect(Collectors.toList());

        ascendingOrder = prices.equals(prices.stream().sorted().collect(Collectors.toList()));

        return ascendingOrder;
    }
}
