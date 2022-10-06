package pages.homepage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public class MenuCategoryPage {

    @FindBy(css = "a")
    private WebElement category;

    private String id;

    public MenuCategoryPage(WebElement menuCategory) {
        PageFactory.initElements(new DefaultElementLocatorFactory(menuCategory), this);
        this.id = menuCategory.getAttribute("id");
    }

    public String getCategoryName() {
        return category.getText().isEmpty() ? category.getAttribute("textContent").trim() : category.getText();
    }

    public String getHref() {
        return category.getAttribute("href");
    }

}
