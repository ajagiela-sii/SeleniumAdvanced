package categories;

import base.Pages;
import org.junit.jupiter.api.Test;
import pages.homepage.MenuCategoryPage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CatAndSubcatTest extends Pages {

    @Test
    void shouldCheckCategoriesAndSubcategories() {
        List<MenuCategoryPage> categoriesAndSubcategories = headerPage.getAllCategories();
        for (int i = 0; i < categoriesAndSubcategories.size(); i++) {
            String categoryName = categoriesAndSubcategories.get(i).getCategoryName().toLowerCase();
            headerPage.goToCategory(categoryName);
            int totalProductNumber = productsGridPage.getProducts().size();

            assertThat(categoryPage.getCategoryHeader().toLowerCase()).isEqualTo(categoryName);
            assertThat(categoryPage.filterIsDisplayed()).isTrue();
            assertThat(categoryPage.getTotalProductsNumber()).contains(String.valueOf(totalProductNumber));

            categoriesAndSubcategories = headerPage.getAllCategories();
        }
    }
}
