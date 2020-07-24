package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This is a page class to locate elements and perform functions on Google Search HomePage
 *
 * @author Amritansh Diwakar
 */
public class GoogleSearchPage extends BaseSelenium {
    private static final Logger log = Logger.getLogger(GoogleSearchPage.class.getSimpleName());

    @FindBy(name = "q")
    private WebElement txtSearchBox;

    /**
     * This  method is constructor used to initialize all the elements on Google Search home page
     *
     * @param driver This is the Webdriver object
     */
    public GoogleSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        assert isElementPresent(txtSearchBox);
        log.info("Checking the element is Present : "+txtSearchBox);
    }

    /**
     * This method is used to search a keyword on Google Search page
     *
     * @param keyword This is the String need to be searched
     */
    public void searchForKeyword(String keyword) {
        submitText(txtSearchBox, keyword);
        log.info("Text is submitted and searched for : "+keyword);
    }
}
