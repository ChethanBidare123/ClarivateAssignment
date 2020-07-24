package steps;

import dataProviders.PropertyFileReader;
import enums.DesktopApps;
import managers.WebDriverManager;
import managers.WiniumDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.util.Properties;

/**
 * This is a base util class used only for dependency injection using pico-container
 *
 * @author Amritansh Diwakar
 */

public class BaseUtil {
    private static final Logger log = Logger.getLogger(BaseUtil.class.getSimpleName());
    static WebDriver webDriver;
    static Properties configProp;

    public BaseUtil() {
        configProp = new PropertyFileReader("config.properties").getProperties();
        log.info("Property file is loaded");
    }

    /**
     *  This method will Return the property value from the config Property file
     *
     * @param propertyName - Property name for which the value is required
     * @return - Property value for the corresponding Name
     */
    public String getConfigProperty(String propertyName){
        return configProp.getProperty(propertyName);
    }

    /**
     *  Initializes the browser
     */
    public static void initDriver() {
        PropertyConfigurator.configure(System.getProperty("user.dir")+"//log4j.properties");
            WebDriverManager webDriverManager = new WebDriverManager();
            webDriver = webDriverManager.initDriver();
            log.info("WebDriver initialization is Successful" +webDriver);
    }

    /**
     *  Initializing Windows driver
     *
     * @return - WiniumDriver
     *
     * @throws MalformedURLException - Malformed URL Exception
     */
    public static WiniumDriver initWinium() throws MalformedURLException {
        WiniumDriverManager winiumDriverManager = new WiniumDriverManager();
        return winiumDriverManager.initDriver(DesktopApps.CALCULATOR, configProp.getProperty("hostServer"));
    }
}
