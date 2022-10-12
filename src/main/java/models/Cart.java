package models;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cart.CartItemPage;
import pages.cart.CartPage;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Logger logger = LoggerFactory.getLogger(Cart.class);
    private List<Product> orderedProducts = new ArrayList<>();

    public Cart() {
    }

    public Cart(CartPage cartPage) {
        for (CartItemPage cartItem : cartPage.getCartItems()) {
            orderedProducts.add(new Product(cartItem));
        }
    }

    public void clear() {
        orderedProducts.clear();
    }

    public void addProduct(Product product) {
        if (containsProduct(product)) {
            Product existingProduct = orderedProducts.stream().filter(p -> p.getName().equals(product.getName())).findFirst().get();
            existingProduct.addQuantity(product.getQuantity());
            logger.info("Update quantity of " + existingProduct);
        } else {
            orderedProducts.add(product);
            logger.info("Added " + product + " to cart");
        }
    }

    public void removeProduct(String name) {
        if (containsProduct(name)) {
            orderedProducts.remove(orderedProducts.stream().filter(p -> p.getName().equals(name)).findFirst().get());
            logger.info("Product " + name + " was removing from cart");
        } else {
            logger.info("There is no such product " + name + " in the cart");
        }
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public double getTotalCartValue() {
        double totalPrice = 0.0;
        for (Product orderedProduct : getOrderedProducts()) {
            totalPrice += orderedProduct.getTotalPrice();
        }
        return Precision.round(totalPrice, 2);
    }

    private boolean containsProduct(Product product) {
        return orderedProducts.stream().anyMatch(p -> p.getName().equals(product.getName()));
    }

    private boolean containsProduct(String name) {
        return orderedProducts.stream().anyMatch(p -> p.getName().equals(name));
    }

}
