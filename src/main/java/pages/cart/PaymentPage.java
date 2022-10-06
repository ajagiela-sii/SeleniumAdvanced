package pages.cart;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends PageBase {

    @FindBy(css = "input#payment-option-1")
    private WebElement payByCheck;
    @FindBy(css = "#checkout-payment-step [method] .ps-shown-by-js")
    private WebElement termsOfService;
    @FindBy(css = "#checkout-payment-step.js-current-step")
    private WebElement paymentStep;

    @FindBy(css = "#payment-confirmation .btn")
    private WebElement placeOrderBtn;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage selectPayByCheck() {
        waitToBeVisible(paymentStep);
        payByCheck.click();
        return this;
    }

    public PaymentPage acceptTermsOfService() {
        waitToBeVisible(paymentStep);
        termsOfService.click();
        return this;
    }

    public void clickPlaceOrder() {
        waitToBeClickable(placeOrderBtn);
        click(placeOrderBtn);
    }
}
