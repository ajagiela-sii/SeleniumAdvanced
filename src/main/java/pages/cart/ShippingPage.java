package pages.cart;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShippingPage extends PageBase {

    @FindBy(css = "#delivery_option_2")
    private WebElement myCarrierDelivery;
    @FindBy(css = "button[name=confirmDeliveryOption]")
    private WebElement confirmDeliveryOptionBtn;

    public ShippingPage(WebDriver driver) {
        super(driver);
    }

    public ShippingPage chooseDelivery() {
        if (myCarrierDelivery.isSelected()) {
            return this;
        }
        click(myCarrierDelivery);
        return this;
    }

    public void confirmDelivery() {
        waitToBeClickable(confirmDeliveryOptionBtn);
        click(confirmDeliveryOptionBtn);
    }


}
