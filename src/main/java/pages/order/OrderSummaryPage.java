package pages.order;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderSummaryPage extends PageBase {

    @FindBy(css = ".order-line")
    private List<WebElement> orderedProducts;
    @FindBy(css = ".total-value td:last-of-type")
    private WebElement totalPrice;
    @FindBy(xpath = "//td[contains(text(), 'Shipping')]/following-sibling::td")
    private WebElement shippingAndHandling;
    @FindBy(xpath = "//li[contains(text(), 'Payment method:')]")
    private WebElement paymentMethod;
    @FindBy(xpath = "//li[contains(text(), 'Shipping method:')]")
    private WebElement shippingMethod;
    @FindBy(xpath = "//li[contains(text(), 'Order reference:')]")
    private WebElement orderReference;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public List<OrderedItemPage> getOrderedProducts() {
        return orderedProducts.stream().map(e -> new OrderedItemPage(driver, e)).toList();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getShippingAndHandling() {
        return shippingAndHandling.getText();
    }

    public String getPaymentMethod() {
        return paymentMethod.getText();
    }
    public String getShippingMethod() {
        return shippingMethod.getText();
    }

    public String getOrderReference() {
        return orderReference.getText().split(": ")[1];
    }




}
