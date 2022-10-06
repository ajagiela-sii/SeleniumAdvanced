package search;

import base.Pages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.products.ItemPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTests extends Pages {

    @Test
    public void itemFromHomePage_shouldBeFound() {
        String prodTitle = productsGridPage.getRandomProduct().getProductTitle();
        headerPage.typeInSearchField(prodTitle)
                .clickSearchBtn();

        assertThat(productsGridPage.getProducts().stream().map(ItemPage::getProductTitle)).contains(prodTitle);
    }

    @ParameterizedTest
    @ValueSource(strings = {"HUMMINGBIRD"})
    public void eachHintBlockLine_shouldContainsSearchedText(String text) {
        headerPage.typeInSearchField(text);

        assertThat(headerPage.getFoundHints()).anyMatch(i -> i.contains(text));
    }
}
