package cart;

import base.Pages;
import models.Product;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class AddingToCartTest extends Pages {

    @RepeatedTest(10)
    void shouldBeSuccessfullyAddedToShoppingCart() {
        String productName = "THE BEST IS YET POSTER";
        int quantity = 3;
        headerPage.goToCategory("ART");
        productsGridPage.clickProduct(productName);

        Product product = new Product(productViewPage);

        productViewPage.setQuantity(quantity)
                .addProductToCart();

        assertThat(addedToCartPage.getProductName()).isEqualTo(product.getName());
        assertThat(addedToCartPage.getPrice()).isEqualTo(product.getPrice());
        assertThat(addedToCartPage.getQuantity()).isEqualTo(quantity);
        assertThat(addedToCartPage.getTotalItemsInCart()).isEqualTo("There are " + quantity + " items in your cart.");

        double totalPrice = quantity * product.getPrice() + addedToCartPage.getShipping();

        assertThat(addedToCartPage.getTotalCost()).isEqualTo(totalPrice);

        addedToCartPage.continueShopping();
        assertThat(headerPage.getCartCount()).isEqualTo("(" + quantity + ")");
    }
}
