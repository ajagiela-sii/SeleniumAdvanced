package pages.order;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderHistoryRowPage extends PageBase {

    @FindBy(css = "th")
    private WebElement orderReference;
    @FindBy(css = "a[data-link-action=view-order-details]")
    private WebElement details;

    public OrderHistoryRowPage(WebDriver driver, WebElement webElement) {
        super(driver, webElement);
    }

    public String getOrderReference() {
        return orderReference.getText();
    }

    public void goToDetails() {
        click(details);
    }
}
