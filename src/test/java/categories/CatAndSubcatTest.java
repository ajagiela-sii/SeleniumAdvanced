package categories;

import base.Pages;
import org.junit.jupiter.api.Test;
import pages.fixedElements.MenuCategoryPage;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CatAndSubcatTest extends Pages {

    @Test
    void shouldCheckCategoriesAndSubcategories() {
        List<MenuCategoryPage> categoriesAndSubcategories = headerPage.getAllCategories();
        for (int i = 0; i < categoriesAndSubcategories.size(); i++) {
            String categoryName = categoriesAndSubcategories.get(i).getCategoryName().toLowerCase();
            headerPage.goToCategory(categoryName);
            int totalProductNumber = productsPage.getProducts().size();

            assertThat(categoryBasePage.getCategoryHeader().toLowerCase()).isEqualTo(categoryName);
            assertThat(categoryBasePage.filterIsDisplayed()).isTrue();
            assertThat(categoryBasePage.getTotalProductsNumber()).contains(String.valueOf(totalProductNumber));

            categoriesAndSubcategories = headerPage.getAllCategories();
        }
    }
}
