package cart;

import base.Pages;
import models.Cart;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AddingAndRemovingFromCartTest extends Pages {

    @RepeatedTest(10)
    void shouldAddAndRemoveFromCart() {
        Cart expectedCart = new Cart();
        for (int i = 0; i < 5; i++) {
            int quantity = new Random().nextInt(1, 6);
            headerPage.getRandomCategory();
            productsGridPage.clickProduct(productsGridPage.getRandomProduct());
            productViewPage.customizeIfPossible("MY MUG")
                    .setQuantity(quantity);
            expectedCart.addProduct(productViewPage.addProductToCart());
            addedToCartPage.continueShopping();
        }

        headerPage.goToCart();
        Cart currentCart = new Cart(cartPage);

        assertThat(expectedCart).usingRecursiveComparison().isEqualTo(currentCart);
        assertThat(expectedCart.getTotalCartValue()).isEqualTo(cartPage.getSubtotalPrice());

        int size = cartPage.getCartItems().size();

        for (int i = 0; i < size; i++) {
            String name = cartPage.getCartItems().get(0).getItemName();
            cartPage.getCartItems().get(0).removeFromCart();
            expectedCart.removeProduct(name);

            currentCart = new Cart(cartPage);
            if (!currentCart.getOrderedProducts().isEmpty()) {
                assertThat(expectedCart).usingRecursiveComparison().isEqualTo(currentCart);
                assertThat(expectedCart.getTotalCartValue()).isEqualTo(cartPage.getSubtotalPrice());
            } else {
                assertThat(cartPage.isEmpty()).isTrue();
            }
        }
    }
}
