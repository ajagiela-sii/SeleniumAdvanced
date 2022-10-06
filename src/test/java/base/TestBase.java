package base;

import configuration.ConfigReader;
import driver.BrowserList;
import driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    public WebDriver driver;
    public static DriverFactory driverFactory;
    public static ConfigReader configReader;

    @BeforeAll
    static void setUp() {
        configReader = ConfigReader.getInstance();
        driverFactory = new DriverFactory();
    }

    @BeforeEach
    void beforeEach() {
        driver = driverFactory.getDriver(BrowserList.valueOf(System.getProperty("browser_name").toUpperCase()));
        logger.info("**** Driver initialized ****");
        driver.get(System.getProperty("url"));
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            logger.info("Web driver closed successfully");
        } catch (Exception e) {
            logger.error("The web driver has not been closed! \n" + e);
        }
    }
}
