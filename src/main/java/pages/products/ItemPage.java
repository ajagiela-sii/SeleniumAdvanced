package pages.products;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends PageBase {

    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement price;

    @FindBy(css = ".product-miniature")
    private WebElement product;

    public ItemPage(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public double getProductPrice() {
        return getPrice(price);
    }

    public WebElement getProduct() {
        return product;
    }
}
