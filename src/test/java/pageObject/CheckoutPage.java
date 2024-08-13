package pageObject;

import io.cucumber.java.eo.Do;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Base;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage extends Base {

    @FindBy(className = "title")
    WebElement checkoutTitle;
    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(id = "cancel")
    WebElement btnCancel;
    @FindBy(id = "continue")
    WebElement btnContinue;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;
    @FindBy(className = "title")
    WebElement checkoutOverViewTitle;
    @FindBy(className = "cart_desc_label")
    WebElement descriptionTxt;
    @FindBy(xpath = "//div[.='Payment Information:']")
    WebElement paymentInformationTxt;
    @FindBy(xpath = "//div[.='Shipping Information:']")
    WebElement shippingInformationTxt;
    @FindBy(xpath = "//div[.='Price Total']")
    WebElement priceTotalTxt;
    @FindBy(className = "summary_subtotal_label")
    WebElement itemTotalTxt;
    @FindBy(id = "finish")
    WebElement btnFinish;
    @FindBy(className = "title")
    WebElement checkoutCompleteTitle;
    @FindBy(className = "pony_express")
    WebElement checkImg;
    @FindBy(xpath = "//h2[.='Thank you for your order!']")
    WebElement txtMessage1;
    @FindBy(xpath = "//div[.='Your order has been dispatched, and will arrive just as fast as the pony can get there!']")
    WebElement txtMessage2;
    @FindBy(id = "back-to-products")
    WebElement btnBackHome;
    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;
    @FindBy(xpath = "//a[.='Logout']")
    WebElement btnLogout;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void fillCheckoutForm(String firstName,String lastName,String postalCode){
        waitVisibilityOf(checkoutTitle);
        enterData(firstNameField,firstName);
        enterData(lastNameField,lastName);
        enterData(postalCodeField,postalCode);
    }

    public void selectContinue(){
        clickOn(btnContinue);
    }

    public void validateCheckoutOverview(){
        waitVisibilityOf(checkoutOverViewTitle);
        waitVisibilityOf(descriptionTxt);
        waitVisibilityOf(paymentInformationTxt);
        waitVisibilityOf(shippingInformationTxt);
        waitVisibilityOf(priceTotalTxt);
        waitVisibilityOf(btnFinish);
    }

    public void selectFinish(){
        clickOn(btnFinish);
    }

    public void validateCheckoutComplete(){
        waitVisibilityOf(checkoutCompleteTitle);
        waitVisibilityOf(checkImg);
    }

    public String getTextMessage1(){
        return getElementText(txtMessage1);
    }

    public double getItemTotalPrice(){
        String itemTotalPrice = getElementText(itemTotalTxt).replace("Item total: $","");
        double totalPriceToDouble = Double.parseDouble(itemTotalPrice);
        return totalPriceToDouble;
    }

    public void logOut(){
        clickOn(burgerMenu);
        waitVisibilityOf(btnLogout);
        clickOn(btnLogout);
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
