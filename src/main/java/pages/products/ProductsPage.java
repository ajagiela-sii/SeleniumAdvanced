package pages.products;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends PageBase {

    public static Logger logger = LoggerFactory.getLogger(ProductsPage.class);
    @FindBy(css = ".product")
    private List<WebElement> products;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public List<ItemPage> getProducts() {
        return products.stream().map(ItemPage::new).collect(Collectors.toList());
    }

    public ItemPage getRandomProduct() {
        ItemPage item = (ItemPage) getRandomObject(getProducts());
        logger.info("Name of a random product: " + item.getProductTitle());
        return item;
    }
}
