package pages.categoryPages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterPage extends PageBase {

    @FindBy(css = ".facet")
    private List<WebElement> allFacets;

    @FindBy(css = ".ui-slider-handle:nth-of-type(1)")
    private WebElement leftPriceSliderHandle;

    @FindBy(css = ".ui-slider-handle:nth-of-type(2)")
    private WebElement rightPriceSliderHandle;

    @FindBy(css = "li p")
    private WebElement currentPriceFilter;

    @FindBy(css = ".spinner")
    private WebElement spinner;

    @FindBy(css = ".js-search-filters-clear-all")
    private WebElement clearAllFiltersBtn;


    public FilterPage(WebDriver driver) {
        super(driver);
    }

    public FilterPage clearAll() {
        if (isVisible(clearAllFiltersBtn)) {
            clearAllFiltersBtn.click();
        }
        return this;
    }

    public FilterPage setMinimumPrice(float price) {
        if (getCurrentMinPrice() == price) {
            return this;
        }
        if (getCurrentMinPrice() > price && leftPriceSliderHandle.getAttribute("style").equals("left: 0%;")) {
            return this;
        }

        int direction = getDirection(price, getCurrentMinPrice());

        actions.clickAndHold(leftPriceSliderHandle).perform();
        while (getCurrentMinPrice() != price) {
            actions.moveByOffset(direction * 10, 0).perform();
        }
        actions.release().perform();
        waitForElementDisappear(spinner);
        return this;
    }

    public FilterPage setMaximumPrice(float price) {
        if (getCurrentMaxPrice() == price) {
            return this;
        }
        if (getCurrentMaxPrice() < price && rightPriceSliderHandle.getAttribute("style").equals("left: 100%;")) {
            return this;
        }

        int direction = getDirection(price, getCurrentMaxPrice());

        actions.clickAndHold(rightPriceSliderHandle).perform();
        while (getCurrentMaxPrice() != price) {
            actions.moveByOffset(direction * 10, 0).perform();
        }
        actions.release().perform();
        waitForElementDisappear(spinner);
        return this;
    }

    public String[] getCurrentPriceFilter() {
        return currentPriceFilter.getText().replace("$", "").split("-");
    }

    private Float getCurrentMinPrice() {
        return Float.valueOf(getCurrentPriceFilter()[0]);
    }

    private Float getCurrentMaxPrice() {
        return Float.valueOf(getCurrentPriceFilter()[1]);
    }

    private int getDirection(float price, float currentPrice) {
        float difference = price - currentPrice;
        if (difference > 0) {
            return 1;
        }
        if (difference < 0) {
            return -1;
        }
        return 0;
    }
}
