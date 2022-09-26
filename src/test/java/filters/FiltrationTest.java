package filters;

import base.Pages;
import org.junit.jupiter.api.Test;
import pages.products.ItemPage;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FiltrationTest extends Pages {

    @Test
    void shouldSetPriceFilter_AndCheck_ifProductsAreFiltered() {
        float min = 8.00F;
        float max = 10.00F;
        headerPage.goToCategory("art");
        filterPage.setMinimumPrice(min)
                .setMaximumPrice(max);
        System.out.println(Arrays.toString(filterPage.getCurrentPriceFilter()));

        List<ItemPage> products = productsPage.getProducts();

        assertThat(products).allMatch(p -> p.getProductPrice() >= min && p.getProductPrice() <= max);
    }
}
