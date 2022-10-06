package pages.cart;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartItemPage extends PageBase {

    @FindBy(css = ".product-line-info a")
    private WebElement itemName;
    @FindBy(css = ".current-price .price")
    private WebElement price;
    @FindBy(css = ".js-cart-line-product-quantity")
    private WebElement quantity;
    @FindBy(css = ".product-price strong")
    private WebElement totalPrice;
    @FindBy(css = ".remove-from-cart")
    private WebElement removeFromCartIcon;

    public CartItemPage(WebDriver driver, WebElement cartItem) {
        super(driver, cartItem);
    }

    public String getItemName() {
        return itemName.getText();
    }

    public Double getPrice() {
        return getPrice(price);
    }

    public int getQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public Double getTotalPrice() {
        return getPrice(totalPrice);
    }

    public void removeFromCart() {
        click(removeFromCartIcon);
        waitForElementDisappear(removeFromCartIcon);
    }
}
