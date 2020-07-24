package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.CommonConstants;
import pages.GoogleSearchPage;
import pages.SearchResultsPage;

import static org.junit.Assert.assertEquals;

/**
 * This is a step definitions class for Browser Related Steps
 *
 * @author Amritansh Diwakar
 */

public class BrowserAutomationSteps extends BaseUtil {
    private static final Logger log = Logger.getLogger(BrowserAutomationSteps.class.getSimpleName());

    @Given("I open Chrome Browser")
    public void openChromeBrowser() {
        initDriver();
        log.info("Chrome Driver is opened");
    }

    @When("I navigate to google.com")
    public void navigateToGoogleCom() {
        webDriver.get(getConfigProperty(CommonConstants.GOOGLE_URL_STRING));
        log.info("Navigated to google website");
    }

    @And("^search for (.+)$")
    public void searchFor(String searchQuery) {
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.searchForKeyword(searchQuery);
        log.info("Searching for the Keyword : "+searchQuery);
    }

    @Then("^first search result should be (.+)$")
    public void verifyFirstSearchResult(String expectedURL) {
        SearchResultsPage searchResultsPage = new SearchResultsPage(webDriver);
        assertEquals(searchResultsPage.getFirstSearchResult().getAttribute(CommonConstants.HREF_ATTRIBUTE), expectedURL);
        log.info("Verified the first Search Result : "+expectedURL);
    }
}