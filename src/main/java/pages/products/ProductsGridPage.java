package pages.products;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsGridPage extends PageBase {

    public static Logger logger = LoggerFactory.getLogger(ProductsGridPage.class);
    @FindBy(css = ".product")
    private List<WebElement> products;

    public ProductsGridPage(WebDriver driver) {
        super(driver);
    }

    public List<ItemPage> getProducts() {
        return products.stream().map(e -> new ItemPage(driver, e)).collect(Collectors.toList());
    }

    public ItemPage getRandomProduct() {
        ItemPage item = (ItemPage) getRandomObject(getProducts());
        logger.info("Name of a random product: " + item.getProductTitle());
        return item;
    }

    public ItemPage getProduct(String name) {
        return getProducts().stream().filter(p -> p.getProductTitle().equalsIgnoreCase(name)).findFirst().get();
    }

    public void clickProduct(String name) {
        click(getProduct(name).getProduct());
    }

    public void clickProduct(ItemPage product) {
        click(product.getProduct());
    }


}
