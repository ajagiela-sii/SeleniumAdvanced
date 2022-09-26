package driverFactory;

import driverFactory.manager.ChromeDriverManager;
import driverFactory.manager.EdgeDriverManager;
import driverFactory.manager.FirefoxDriverManager;
import driverFactory.manager.IEDriverManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverFactory {
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);
    private WebDriver driver;

    public WebDriver getDriver(BrowserList browser) {
        switch (browser) {
            case CHROME -> {
                driver = new ChromeDriverManager().createDriver();
            }
            case FIREFOX -> {
                driver = new FirefoxDriverManager().createDriver();
                driver.manage().window().maximize();
            }
            case IE -> {
                driver = new IEDriverManager().createDriver();
                driver.manage().window().maximize();
            }
            case EDGE -> {
                driver = new EdgeDriverManager().createDriver();
            }
        }
        return this.driver;
    }
}