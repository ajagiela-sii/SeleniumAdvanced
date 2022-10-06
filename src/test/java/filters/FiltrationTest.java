package filters;

import base.Pages;
import org.junit.jupiter.api.Test;
import pages.products.ItemPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FiltrationTest extends Pages {

    @Test
    void shouldSetPriceFilter_AndCheck_ifProductsAreFiltered() {
        double min = 15.00;
        double max = 17.00;
        headerPage.goToCategory("accessories");
        filterPage.setMinimumPrice(min)
                .setMaximumPrice(max);

        List<ItemPage> products = productsGridPage.getProducts();

        assertThat(products).allMatch(p -> p.getProductPrice() >= min && p.getProductPrice() <= max);
    }
}
