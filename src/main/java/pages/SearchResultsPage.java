package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a page class to locate elements and perform functions on Search Results Page
 *
 * @author Amritansh Diwakar
 */

public class SearchResultsPage extends BaseSelenium {
    private static final Logger log = Logger.getLogger(SearchResultsPage.class.getSimpleName());

    @FindBy(xpath = "//div[@class='r']/a")
    private WebElement firstSearchResult;

    @FindBy(id = "hdtb-tls")
    private WebElement btnTools;

    /**
     * This  method is constructor used to initialize all the elements on Search Results page
     *
     * @param driver This is the Webdriver object
     */
    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        isElementPresent(btnTools);
    }

    /**
     * This method is used to get the url of first search result on Google Search page
     *
     * @return firstSearchResult This is the WebElement representing the first search result
     */
    public WebElement getFirstSearchResult() {
        log.info("Returns the first Search result webelement " + firstSearchResult);
        return firstSearchResult;
    }
}
