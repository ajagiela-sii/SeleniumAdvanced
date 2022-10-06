package cart;

import base.Pages;
import models.Cart;
import models.Product;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class AddingAndRemovingFromCartTest extends Pages {

    @RepeatedTest(10)
    void shouldAddAndRemoveFromCart() {
        for (int i = 0; i < 5; i++) {
            int quantity = new Random().nextInt(1, 6);
            headerPage.getRandomCategory();
            productsGridPage.clickProduct(productsGridPage.getRandomProduct());
            productViewPage.customizeIfPossible("MY MUG")
                    .setQuantity(quantity);
            productViewPage.addProductToCart();
            addedToCartPage.continueShopping();
        }

        headerPage.goToCart();

        List<Product> inCart = cartPage.getCartItems().stream().map(Product::new).toList();
        assertThat(Cart.getOrderedProducts()).usingRecursiveComparison().isEqualTo(inCart);
        assertThat(Cart.getTotalCartValue()).isEqualTo(cartPage.getTotalPrice());

        int size = cartPage.getCartItems().size();

        for (int i = 0; i < size; i++) {

            String name = cartPage.getCartItems().get(0).getItemName();
            cartPage.getCartItems().get(0).removeFromCart();
            Cart.removeProduct(name);

            List<Product> currentlyInCart = new ArrayList<>(cartPage.getCartItems().stream().map(Product::new).toList());
            if (!currentlyInCart.isEmpty()) {
                assertThat(Cart.getOrderedProducts()).usingRecursiveComparison().isEqualTo(currentlyInCart);
                assertThat(Cart.getTotalCartValue()).isEqualTo(cartPage.getTotalPrice());
            } else {
                assertThat(cartPage.isEmpty()).isTrue();
            }
        }
    }
}
