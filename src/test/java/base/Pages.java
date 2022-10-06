package base;

import org.junit.jupiter.api.BeforeEach;
import pages.cart.AddressPage;
import pages.cart.CartPage;
import pages.cart.PaymentPage;
import pages.cart.ShippingPage;
import pages.categoryPages.CategoryPage;
import pages.categoryPages.FilterPage;
import pages.homepage.HeaderPage;
import pages.modalDialog.AddedToCartPage;
import pages.order.OrderDetailsPage;
import pages.order.OrderSummaryPage;
import pages.products.ProductViewPage;
import pages.products.ProductsGridPage;
import pages.user.AccountPage;
import pages.order.OrderHistoryPage;
import pages.user.SignInPage;
import steps.UserSteps;

public class Pages extends TestBase {
    public HeaderPage headerPage;
    public ProductsGridPage productsGridPage;
    public CategoryPage categoryPage;
    public FilterPage filterPage;
    public ProductViewPage productViewPage;
    public AddedToCartPage addedToCartPage;
    public CartPage cartPage;
    public SignInPage signInPage;
    public UserSteps userSteps;
    public AddressPage addressPage;
    public ShippingPage shippingPage;
    public PaymentPage paymentPage;
    public OrderSummaryPage orderSummaryPage;
    public AccountPage accountPage;
    public OrderHistoryPage orderHistoryPage;
    public OrderDetailsPage orderDetailsPage;

    @BeforeEach
    void setPages() {
        headerPage = new HeaderPage(driver);
        productsGridPage = new ProductsGridPage(driver);
        categoryPage = new CategoryPage(driver);
        filterPage = new FilterPage(driver);
        productViewPage = new ProductViewPage(driver);
        addedToCartPage = new AddedToCartPage(driver);
        cartPage = new CartPage(driver);
        signInPage = new SignInPage(driver);
        userSteps = new UserSteps(driver);
        addressPage = new AddressPage(driver);
        shippingPage = new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
        accountPage = new AccountPage(driver);
        orderHistoryPage = new OrderHistoryPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
    }

}
