package pages.order;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {
    @FindBy(css = "#order-history tbody td:nth-child(1)")
    private WebElement dateOfOrder;
    @FindBy(css = "#order-history tbody .label")
    private WebElement status;
    @FindBy(css = ".line-total td:nth-child(2)")
    private WebElement totalPrice;
    @FindBy(css = "#delivery-address address")
    private WebElement deliveryAddress;
    @FindBy(css = "#invoice-address address")
    private WebElement invoiceAddress;


    public OrderDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getDateOfOrder() {
        return dateOfOrder.getText();
    }

    public String getStatus() {
        return status.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getDeliveryAddress() {
        return deliveryAddress.getText();
    }

    public String getInvoiceAddress() {
        return invoiceAddress.getText();
    }
}
