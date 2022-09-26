package configuration;

import configuration.models.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ConfigReader {

    static Logger logger = LoggerFactory.getLogger(ConfigReader.class);
    YamlReader yamlReader = new YamlReader();
    private Browser browser;

    private ConfigReader() {
        setBrowserProperties();
    }

    public static ConfigReader getInstance() {
        return ConfigReader.ConfigReaderSingleton.INSTANCE;
    }

    private void setBrowserProperties() {
        browser = yamlReader.getConfig().getBrowser();
        Map<String, Object> browserProperties = browser.getBrowserProperties();
        for (Map.Entry entry : browserProperties.entrySet()) {
            System.setProperty(entry.getKey().toString(), entry.getValue().toString());
            logger.info("Load env properties: {} = {}", entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static class ConfigReaderSingleton {
        private static final ConfigReader INSTANCE = new ConfigReader();
    }
}
