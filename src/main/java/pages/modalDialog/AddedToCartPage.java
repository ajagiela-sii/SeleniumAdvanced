package pages.modalDialog;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddedToCartPage extends PageBase {

    @FindBy(css = ".cart-content-btn .btn-primary")
    private WebElement proceedToShoppingCartBtn;
    @FindBy(css = ".cart-content-btn .btn-secondary")
    private WebElement continueShoppingBtn;
    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = ".modal-body .product-price")
    private WebElement price;
    @FindBy(css = ".product-quantity strong")
    private WebElement quantity;
    @FindBy(css = ".modal-body .cart-products-count")
    private WebElement cartTotal;
    @FindBy(css = ".shipping")
    private WebElement shipping;
    @FindBy(css = ".product-total .value")
    private WebElement totalCost;

    public AddedToCartPage(WebDriver driver) {
        super(driver);
    }

    public AddedToCartPage proceedToCheckout() {
        waitToBeClickable(proceedToShoppingCartBtn);
        proceedToShoppingCartBtn.click();
        return this;
    }

    public AddedToCartPage continueShopping() {
        waitToBeClickable(continueShoppingBtn);
        continueShoppingBtn.click();
        return this;
    }

    public String getProductName() {
        waitForVisibility(continueShoppingBtn);
        return productName.getText();
    }

    public double getPrice() {
        return getPrice(price);
    }

    public Integer getQuantity() {
        return Integer.valueOf(quantity.getText());
    }

    public String getTotalItemsInCart() {
        return cartTotal.getText();
    }

    public Double getShipping() {
        return getPrice(shipping);
    }

    public Double getTotalCost() {
        return getPrice(totalCost);
    }
}
