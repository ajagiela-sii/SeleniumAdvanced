package cart;

import base.Pages;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.order.OrderedItemPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CheckoutTest extends Pages {

    @RepeatedTest(10)
    void checkoutProcess_shouldBeSuccessful() {
        String productName = "THE BEST IS YET POSTER";
        String price = "$29.00";
        String quantity = "1";
        String totalPrice = "$36.00";
        String shippingAndHandling = "$7.00";
        String paymentMethod = "Payments by check";
        String shippingMethod = "My carrier";
        String status = "Awaiting check payment";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String today = dateFormat.format(date);
        String deliveryAddress = "John Smith\n" +
                "Montgomery 50\n" +
                "Montgomery, Alabama 12345\n" +
                "United States";
        String invoiceAddress = "John Smith\n" +
                "Akutan 23/45\n" +
                "Akutan, Alaska 12345\n" +
                "United States";


        headerPage.goToSignIn();
        userSteps.signIn();
        headerPage.typeInSearchField(productName)
                        .clickSearchBtn();
        productsGridPage.clickProduct(productName);
        productViewPage.addProductToCart();
        addedToCartPage.proceedToCheckout();
        cartPage.clickProceedToCheckout();
        addressPage.clickOtherBillingAddress()
                .deleteInvoiceAddressIfPossible()
                .fillAddress("Akutan 23/45", "Akutan", "5", "12345")
                .clickContinue();
        shippingPage.chooseDelivery()
                .confirmDelivery();
        paymentPage.selectPayByCheck()
                .acceptTermsOfService()
                .clickPlaceOrder();

        for (OrderedItemPage orderedProduct : orderSummaryPage.getOrderedProducts()) {
            assertThat(orderedProduct.getProductName()).contains(productName);
            assertThat(orderedProduct.getUnitPrice()).isEqualTo(price);
            assertThat(orderedProduct.getQuantity()).isEqualTo(quantity);
        }
        assertThat(orderSummaryPage.getTotalPrice()).isEqualTo(totalPrice);
        assertThat(orderSummaryPage.getShippingAndHandling()).isEqualTo(shippingAndHandling);
        assertThat(orderSummaryPage.getPaymentMethod()).contains(paymentMethod);
        assertThat(orderSummaryPage.getShippingMethod()).contains(shippingMethod);

        String orderReference = orderSummaryPage.getOrderReference();
        System.out.println(orderReference);

        headerPage.goToAccount();
        accountPage.goToOrderHistory();
        orderHistoryPage.getOrder(orderReference).goToDetails();

        assertThat(orderDetailsPage.getDateOfOrder()).isEqualTo(today);
        assertThat(orderDetailsPage.getStatus()).isEqualTo(status);
        assertThat(orderDetailsPage.getDeliveryAddress()).isEqualTo(deliveryAddress);
        assertThat(orderDetailsPage.getInvoiceAddress()).isEqualTo(invoiceAddress);
        assertThat(orderDetailsPage.getTotalPrice()).isEqualTo(totalPrice);

    }
}
