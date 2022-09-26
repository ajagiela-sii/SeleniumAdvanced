package driverFactory.manager;

import driverFactory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.logging.Level;
import java.util.logging.Logger;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(CHROME).setup();

        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        if (Boolean.parseBoolean(System.getProperty("headless"))) {
            chromeOptions.addArguments("--headless");
        }

        return new ChromeDriver(chromeOptions);
    }
}
