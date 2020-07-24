package enums;
/**
 * This is a enum to handle Browser Types and their corresponding system properties
 *
 * @author Amritansh Diwakar
 */
public enum BrowserType {
    CHROME("webdriver.chrome.driver");

    private final String systemProperty;

    BrowserType(String systemProperty){
        this.systemProperty = systemProperty;
    }

    public String getSystemProperty() {
        return String.valueOf(this.systemProperty);
    }
}
