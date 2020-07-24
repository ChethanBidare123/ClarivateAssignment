package managers;

import dataProviders.PropertyFileReader;
import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * This is a class to manage Webdrivers
 *
 * @author Amritansh Diwakar
 */

public class WebDriverManager {
    private final Properties configProp;

    /**
     * This method is the  constructor to instantiate WebDriverManager class
     */
    public WebDriverManager() {
        configProp = new PropertyFileReader("config.properties").getProperties();
    }

    /**
     * This highlevel method is used to initialize a driver object wbased on the type of browser driver
     * present as default in property file.
     *
     * @return Webdriver object after initializing
     */
    public WebDriver initDriver() {
        BrowserType browserType = Enum.valueOf(BrowserType.class, configProp.getProperty("browser"));
        return createWebDriverInstance(browserType);
    }

    /**
     * This method is actually responsible for creation of Webdriver
     *
     * @param browserType This is the BrowserType enum. ex BrowserType.CHROME
     * @return Webdriver object after initializing
     */
    private WebDriver createWebDriverInstance(BrowserType browserType) {
        System.setProperty(browserType.getSystemProperty(), configProp.getProperty("drivers_path").concat("chromedriver.exe"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(configProp.getProperty("implicit_wait_timeout")), TimeUnit.SECONDS);
        return driver;
    }
}
