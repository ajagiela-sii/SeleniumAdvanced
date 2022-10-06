package pages.order;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.order.OrderHistoryRowPage;

import java.util.List;

public class OrderHistoryPage extends PageBase {

    @FindBy(css = "tbody tr")
    private List<WebElement> orders;

    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    public List<OrderHistoryRowPage> getOrders() {
        return orders.stream().map(e -> new OrderHistoryRowPage(driver, e)).toList();
    }

    public OrderHistoryRowPage getOrder(String orderReference) {
       return getOrders().stream().filter(e -> e.getOrderReference().equalsIgnoreCase(orderReference)).findFirst().get();
    }


}
