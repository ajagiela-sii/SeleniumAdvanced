package pages.cart;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends PageBase {

    @FindBy(css = ".cart-item")
    private List<WebElement> cartItems;
    @FindBy(css = ".cart-total .value")
    private WebElement total;
    @FindBy(css = ".no-items")
    private WebElement emptyCart;
    @FindBy(css = ".cart-summary .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<CartItemPage> getCartItems() {
        return cartItems.stream().map(item -> new CartItemPage(driver, item)).toList();
    }

    public double getTotalPrice() {
        return getPrice(total);
    }

    public boolean isEmpty() {
        return isVisible(emptyCart);
    }

    public CartPage clickProceedToCheckout() {
        click(proceedToCheckoutBtn);
        return this;
    }



}
