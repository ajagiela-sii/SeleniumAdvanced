package pages.cart;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressPage extends PageBase {

    @FindBy(css = "a[data-link-action=different-invoice-address]")
    private WebElement otherBillingAddress;
    @FindBy(css = "#invoice-addresses")
    private WebElement invoiceAddress;
    @FindBy(css = "input[name=address1]")
    private WebElement addressInput;
    @FindBy(css = "input[name=city]")
    private WebElement cityInput;
    @FindBy(css = "select[name=id_state]")
    private WebElement stateInput;
    @FindBy(css = "input[name=postcode]")
    private WebElement postcodeInput;
    @FindBy(css = "button[name=confirm-addresses]")
    private WebElement continueBtn;

    @FindBy(css = ".add-address a")
    private WebElement addNewInvoiceAddress;
    @FindBy(css = "#invoice-addresses .address-item:last-of-type .delete-address")
    private WebElement deleteAddress;

    public AddressPage(WebDriver driver) {
        super(driver);
    }

    public AddressPage clickOtherBillingAddress() {
        click(otherBillingAddress);
        return this;
    }

    public AddressPage deleteInvoiceAddressIfPossible() {
        if (isVisible(invoiceAddress)) {
            click(deleteAddress);
            return this;
        }
        return this;
    }


    public AddressPage fillAddress(String address, String city, String state, String postcode) {
        sendKey(addressInput, address);
        sendKey(cityInput, city);
        new Select(stateInput).selectByValue(state);
        sendKey(postcodeInput, postcode);
        return this;
    }

    public void clickContinue() {
        waitToBeClickable(continueBtn);
        click(continueBtn);
    }


}
