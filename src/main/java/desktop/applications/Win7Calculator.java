package desktop.applications;

import enums.CalciKeys;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
import pages.CommonConstants;

/**
 * This is a class to handle Windows 7 calculator app
 *
 * @author Amritansh Diwakar
 */

public class Win7Calculator {
    private final WiniumDriver winiumDriver;
    private static final Logger log = Logger.getLogger(Win7Calculator.class.getSimpleName());

    /**
     * This method is a Constructor
     *
     * @param winiumDriver - Driver
     */
    public Win7Calculator(WiniumDriver winiumDriver) {
        this.winiumDriver = winiumDriver;
    }

    /**
     * This method is used to press any key on Win 7 calculator.
     *
     * @param calciKey This is the enum Calcikeys need to be pressed by mapping the enum to automation_id
     */
    public void pressButton(CalciKeys calciKey) {
        winiumDriver.findElement(By.id(String.valueOf(calciKey))).click();
        log.info("Clicks on the Button : " + calciKey);
    }

    /**
     * This method is used to input a number as a whole to display on calculator screen
     * and perform any operation on it.
     *
     * @param number This is the integer value needed to be input onto calculator screen
     */
    public void inputNumber(int number) {
        for (Character ch : String.valueOf(number).toCharArray()) {
            pressButton(CalciKeys.valueOf(CommonConstants.NUM_STRING + ch));
        }
        log.info("The input number entered on Calci : " + number);
    }

    /**
     * This method is used to fetch the currently displayed number from calculator screen
     *
     * @return This returns a double representing the currently displayed number on calculator screen
     */
    public double getResult() {
        String displayedResult = winiumDriver.findElement(By.id(CommonConstants.CALCULATOR_RESULTS_STRING)).getAttribute(CommonConstants.NAME_ATTRIBUTE);
        log.info("fetching the currently displayed number from calculator screen : " + displayedResult);
        return Double.parseDouble(displayedResult.split("Display is ")[1]);
    }
}
