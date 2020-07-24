package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This is a base class to handle repeatable functionalities related to Selenium
 *
 * @author Amritansh Diwakar
 */

class BaseSelenium {
    private static final Logger log = Logger.getLogger(BaseSelenium.class.getSimpleName());
    /**
     * This  method is used to enter a text ad submit form using Enter key
     *
     * @param webElement This is the WebElement on which text needed to be entered.
     * @param charSeq    This is the String needed to be entered
     */
    void submitText(WebElement webElement, String charSeq) {
        clear(webElement);
        enterText(webElement, charSeq);
        enterText(webElement, Keys.ENTER + "");
    }

    /**
     * This  method is used to check if an element is displayed on the page
     *
     * @param webElement This is the WebElement for which the display condition is verified.
     * @return boolean True if element is displayed else false
     */
    boolean isElementPresent(WebElement webElement) {
        log.info("Checking element is displayed : " +webElement);
        return webElement.isDisplayed();
    }

    /**
     * Clears the input field
     *
     * @param webElement - WebElement of the input Field
     */
    private void clear(WebElement webElement) {
        webElement.clear();
        log.info("Clearing the field : " +webElement);
    }

    /**
     * Clears the input field
     *
     * @param webElement - WebElement of the input Field
     */
    private void enterText(WebElement webElement, String textToBeEntered) {
        webElement.sendKeys(textToBeEntered);
        log.info("Text : " + textToBeEntered + " is entered in the field : " +webElement);
    }
}
