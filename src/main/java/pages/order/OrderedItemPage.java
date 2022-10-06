package pages.order;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderedItemPage extends PageBase {

    @FindBy(css = ".details")
    private WebElement productDetails;
    @FindBy(css = ".qty .row [class=\"col-xs-4 text-sm-center\"]")
    private WebElement quantity;
    @FindBy(css = ".qty .row .text-xs-left")
    private WebElement unitPrice;
    @FindBy(css = ".qty .row .text-xs-right")
    private WebElement totalProducts;


    public OrderedItemPage(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public String getProductName() {
        return productDetails.getText();
    }

    public String getQuantity() {
        return quantity.getText();
    }

    public String getUnitPrice() {
        return unitPrice.getText();
    }

    public String getTotalProducts() {
        return totalProducts.getText();
    }
}
