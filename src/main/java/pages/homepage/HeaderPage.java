package pages.homepage;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderPage extends PageBase {

    public static Logger logger = LoggerFactory.getLogger(HeaderPage.class);

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#search_widget .ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(css = "#search_widget button")
    private WebElement searchBtn;
    @FindBy(css = ".ui-widget .ui-menu-item")
    private List<WebElement> searchHints;
    @FindBy(css = ".top-menu > .category")
    private List<WebElement> allCategories;
    @FindBy(css = "#_desktop_cart .cart-products-count")
    private WebElement cartCount;
    @FindBy(css = ".blockcart a")
    private WebElement cart;
    @FindBy(css = "a[title=\"Log in to your customer account\"]")
    private WebElement signIn;
    @FindBy(css = ".account")
    private WebElement account;

    public HeaderPage typeInSearchField(String text) {
        sendKey(searchInput, text);
        return this;
    }

    public HeaderPage clickSearchBtn() {
        click(searchBtn);
        return this;
    }

    public String getCartCount() {
        return cartCount.getText();
    }

    public List<String> getFoundHints() {
        waitForVisibility(searchHints);
        return searchHints.stream().map(e -> e.getAttribute("textContent")).collect(Collectors.toList());
    }

    public List<MenuCategoryPage> getAllCategories() {
        return allCategories.stream().map(MenuCategoryPage::new).collect(Collectors.toList());
    }

    public void goToCategory(String name) {
        MenuCategoryPage chosenCategory = null;
        for (MenuCategoryPage category : getAllCategories()) {
            if (category.getCategoryName().equalsIgnoreCase(name)) {
                chosenCategory = category;
            }
        }
        assert chosenCategory != null;
        goToURL(chosenCategory.getHref());
    }

    public void getRandomCategory() {
        MenuCategoryPage chosenCategory = (MenuCategoryPage) getRandomObject(getAllCategories());
        goToURL(chosenCategory.getHref());
    }

    public void goToCart() {
        driver.get(cart.getAttribute("href"));
    }

    public void goToSignIn() {
        click(signIn);
    }

    public void goToAccount() {
        click(account);
    }
}
