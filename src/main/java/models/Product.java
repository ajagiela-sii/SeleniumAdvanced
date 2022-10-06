package models;

import org.apache.commons.math3.util.Precision;
import pages.cart.CartItemPage;
import pages.products.ProductViewPage;

public class Product {

    private String name;
    private double price;
    private int quantity;
    private double totalPrice;


    public Product(ProductViewPage productViewPage) {
        this.name = productViewPage.getProductName();
        this.price = productViewPage.getPrice();
        this.quantity = productViewPage.getQuantity();
        this.totalPrice = Precision.round(this.price * this.quantity, 2);
    }

    public Product(CartItemPage cartItemPage) {
        this.name = cartItemPage.getItemName();
        this.price = cartItemPage.getPrice();
        this.quantity = cartItemPage.getQuantity();
        this.totalPrice = cartItemPage.getTotalPrice();
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.totalPrice = Precision.round(this.price * this.quantity, 2);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
