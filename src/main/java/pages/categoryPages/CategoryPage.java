package pages.categoryPages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage extends PageBase {

    @FindBy(css = "#js-product-list-header h1")
    private WebElement categoryBlock;

    @FindBy(css = ".total-products")
    private WebElement totalProdNumber;

    @FindBy(css = "#search_filters")
    private WebElement filterBlock;

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryHeader() {
        return categoryBlock.getText();
    }

    public boolean filterIsDisplayed() {
        return isVisible(filterBlock);
    }

    public String getTotalProductsNumber() {
        return totalProdNumber.getText();
    }
}
