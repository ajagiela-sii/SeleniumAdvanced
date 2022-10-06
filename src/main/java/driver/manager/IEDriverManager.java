package driver.manager;

import driver.Factory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static io.github.bonigarcia.wdm.config.DriverManagerType.IEXPLORER;

public class IEDriverManager implements Factory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(IEXPLORER).setup();

        return new InternetExplorerDriver();
    }
}
