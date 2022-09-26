package pages.products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class ItemPage {

    public ItemPage(WebElement item) {
        PageFactory.initElements(new DefaultElementLocatorFactory(item), this);
    }

    @FindBy(css = ".product-title")
    private WebElement productTitle;

    @FindBy(css = ".price")
    private WebElement price;

    public String getProductTitle() {
        return productTitle.getText();
    }

    public float getProductPrice() {
        return Float.parseFloat(price.getText().replace("$", ""));
    }
}
