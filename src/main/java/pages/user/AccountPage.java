package pages.user;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends PageBase {

    @FindBy(css = "#history-link")
    private WebElement orderHistory;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void goToOrderHistory() {
        click(orderHistory);
    }
}
