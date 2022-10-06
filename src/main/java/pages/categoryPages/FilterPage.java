package pages.categoryPages;

import base.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilterPage extends PageBase {

    @FindBy(css = ".facet")
    private List<WebElement> allFacets;

    @FindBy(css = ".faceted-slider")
    private WebElement slider;

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

    public FilterPage setMinimumPrice(double price) {
        return moveSlider(price, getCurrentMinPrice(), leftPriceSliderHandle);
    }

    public FilterPage setMaximumPrice(double price) {
        return moveSlider(price, getCurrentMaxPrice(), rightPriceSliderHandle);
    }

    private FilterPage moveSlider(double price, double currentPrice, WebElement sliderHandle) {

        if (currentPrice == price) {
            return this;
        }
        double minPrice = Double.parseDouble(slider.getAttribute("data-slider-min"));
        double maxPrice = Double.parseDouble(slider.getAttribute("data-slider-max"));
        int sliderWidth = slider.getSize().width;

        if (price < minPrice || price > maxPrice) {
            return this;
        }

        int direction = getDirection(price, currentPrice);

        actions.clickAndHold(sliderHandle).perform();
        while (getCurrentMaxPrice() != price && getCurrentMinPrice() != price) {
            actions.moveByOffset((int) (direction * (sliderWidth/(maxPrice-minPrice))), 0).perform();
        }
        actions.release().perform();
        waitForElementDisappear(spinner);
        return this;
    }

    private String[] getCurrentPriceFilter() {
        return getStringPrice(currentPriceFilter).split("-");
    }

    private Double getCurrentMinPrice() {
        return Double.parseDouble(getCurrentPriceFilter()[0]);
    }

    private Double getCurrentMaxPrice() {
        return Double.parseDouble(getCurrentPriceFilter()[1]);
    }

    private int getDirection(double price, double currentPrice) {
        double difference = price - currentPrice;
        if (difference > 0) {
            return 1;
        }
        if (difference < 0) {
            return -1;
        }
        return 0;
    }
}
