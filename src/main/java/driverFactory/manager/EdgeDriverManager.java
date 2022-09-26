package driverFactory.manager;

import driverFactory.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.EDGE;

public class EdgeDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(EDGE).setup();

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("start-maximized");

        if (Boolean.parseBoolean(System.getProperty("headless"))){
            edgeOptions.addArguments("--headless");
        }

        return new EdgeDriver(edgeOptions);
    }
}
