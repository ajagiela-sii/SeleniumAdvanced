package base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class PageBase {

    private static Logger logger = LoggerFactory.getLogger(PageBase.class);
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }
    public PageBase(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(webElement), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }

    protected static <T> Object getRandomObject(List<T> objectList) {
        return objectList.get(new Random().nextInt(0, objectList.size()));
    }

    protected void sendKey(WebElement webElement, String text) {
        String webElementName = webElement.getText().isEmpty() ? String.valueOf(webElement).split("->")[1] : webElement.getText();
        logger.info("Typing text: " + text + " in " + webElementName);
        webElement.sendKeys(text);

    }

    protected void sendKeyWithClear(WebElement webElement, String text) {
        webElement.clear();
        String webElementName = webElement.getText().isEmpty() ? String.valueOf(webElement).split("->")[1] : webElement.getText();
        logger.info("Typing text: " + text + " in " + webElementName);
        webElement.sendKeys(text);

    }

    protected void click(WebElement webElement) {
        String webElementName = webElement.getText().isEmpty() ? String.valueOf(webElement).split("->")[1] : webElement.getText();
        logger.info("Clicking on " + webElementName);
        waitToBeClickable(webElement);
        webElement.click();
    }

    protected void waitToBeClickable(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static boolean isVisible(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException err) {
            return false;
        }
    }

    public void waitForVisibility(WebElement webElement) {
        wait.until(driver -> isVisible(webElement));
    }

    protected void waitToBeVisible(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public List<WebElement> waitForVisibility(List<WebElement> elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }


    public void waitForElementDisappear(WebElement webElement) {
        if (isVisible(webElement)) {
            String webElementName = webElement.getText().isEmpty() ? String.valueOf(webElement).split("->")[1] : webElement.getText();
            logger.info("Waiting for invisibility of " + webElementName);
            wait.until(ExpectedConditions.invisibilityOf(webElement));
        }
    }

    public void goToURL(String url) {
        logger.info("Go to url: " + url);
        driver.get(url);
    }

    public String getStringPrice(WebElement webElement) {
        return webElement.getText().replace("$", "");
    }

    public Double getPrice(WebElement webElement) {
        return Double.parseDouble(webElement.getText().replace("$", ""));
    }
}
