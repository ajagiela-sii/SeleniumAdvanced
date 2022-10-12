package pages.products;

import base.PageBase;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductViewPage extends PageBase {

    public ProductViewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "h1[itemprop=name]")
    private WebElement productName;
    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(css = "#quantity_wanted")
    private WebElement quantityInput;
    @FindBy(css = "span[itemprop=price]")
    private WebElement price;
    @FindBy(css = ".product-message")
    private WebElement productMessage;
    @FindBy(css = "button[name=submitCustomizedData]")
    private WebElement saveCustomizationBtn;

    private int quantity = 1;

    public double getPrice() {
        return getPrice(price);
    }

    public String getProductName() {
        return productName.getText();
    }

    public int getQuantity() {
        return quantity;
    }

    public Product addProductToCart() {
        addToCartBtn.click();
        return new Product(this);
    }

    public ProductViewPage setQuantity(int quantity) {
        this.quantity = quantity;
        waitToBeVisible(quantityInput);
        sendKeyWithClear(quantityInput, String.valueOf(quantity));
        return this;
    }

    public ProductViewPage customizeIfPossible(String text) {
        if (isVisible(productMessage)) {
            sendKey(productMessage, text);
            click(saveCustomizationBtn);
        }
        return this;
    }

}
