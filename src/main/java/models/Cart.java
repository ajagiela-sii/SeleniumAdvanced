package models;

import org.apache.commons.math3.util.Precision;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class Cart {
    private static Logger logger = LoggerFactory.getLogger(Cart.class);
    private static List<Product> orderedProducts = new ArrayList<>();

    private static Double shipping = 7.0;

    public static void clear() {
        orderedProducts.clear();
    }

    public static void addProduct(Product product) {
        if (containsProduct(product)) {
            Product existingProduct = orderedProducts.stream().filter(p -> p.getName().equals(product.getName())).findFirst().get();
            existingProduct.setQuantity(existingProduct.getQuantity() + product.getQuantity());
            logger.info("Update quantity of " + existingProduct );
        } else {
            orderedProducts.add(product);
            logger.info("Added " + product + " to cart");
        }
    }

    public static void removeProduct(String name) {
        if (containsProduct(name)) {
            Product existingProduct = orderedProducts.stream().filter(p -> p.getName().equals(name)).findFirst().get();
            orderedProducts.remove(existingProduct);
            logger.info("Product " + name + " was removing from cart");
        } else {
            logger.info("There is no such product " + name + " in the cart");
        }
    }
    public static List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public static double getTotalCartValue() {
        double totalPrice = 0.0;
        for (Product orderedProduct : getOrderedProducts()) {
            totalPrice += orderedProduct.getTotalPrice();
        }
        totalPrice += shipping;
        return Precision.round(totalPrice, 2);
    }
    private static boolean containsProduct(Product product) {
        return orderedProducts.stream().anyMatch(p -> p.getName().equals(product.getName()));
    }

    private static boolean containsProduct(String name) {
        return orderedProducts.stream().anyMatch(p -> p.getName().equals(name));
    }

}
