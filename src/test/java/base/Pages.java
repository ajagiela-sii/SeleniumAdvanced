package base;

import org.junit.jupiter.api.BeforeEach;
import pages.categoryPages.CategoryBasePage;
import pages.categoryPages.FilterPage;
import pages.fixedElements.HeaderPage;
import pages.products.ProductsPage;

public class Pages extends TestBase {
    public HeaderPage headerPage;
    public ProductsPage productsPage;
    public CategoryBasePage categoryBasePage;
    public FilterPage filterPage;

    @BeforeEach
    void setPages() {
        headerPage = new HeaderPage(driver);
        productsPage = new ProductsPage(driver);
        categoryBasePage = new CategoryBasePage(driver);
        filterPage = new FilterPage(driver);
    }
}
