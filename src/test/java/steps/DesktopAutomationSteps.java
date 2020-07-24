package steps;

import desktop.applications.Win7Calculator;
import enums.CalciKeys;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import pages.CommonConstants;

import java.net.MalformedURLException;

import static org.junit.Assert.assertEquals;

/**
 * This is a step definitions class for Desktop App Related Steps for Win 7 Calculator
 *
 * @author Amritansh Diwakar
 */

public class DesktopAutomationSteps extends BaseUtil{
    private static final Logger log = Logger.getLogger(DesktopAutomationSteps.class.getSimpleName());
    private int inputNumber;
    private Win7Calculator win7Calculator;

    @Given("I open Windows Calculator Application")
    public void openWindowsCalculatorApplication() throws MalformedURLException {
        win7Calculator = new Win7Calculator(initWinium());
        log.info("Initialization Of Windows driver and calculator App is opened");
    }

    @When("I enter number {int}")
    public void enterValue(int number) {
        inputNumber = number;
        win7Calculator.inputNumber(inputNumber);
        log.info("Input Number : "+inputNumber);
    }

    @And("click on square root button")
    public void clickOnSquareRootButton() {
        win7Calculator.pressButton(CalciKeys.SQUAREROOT);
        log.info("Button pressed : "+CalciKeys.SQUAREROOT);
    }

    @Then("the calculate result should be correct")
    public void verifyCalculatorResult() {
        double actual = win7Calculator.getResult();
        double expected = Math.sqrt(inputNumber);
        assertEquals(actual,expected,CommonConstants.ZERO_POINT_ZERO_ZERO_ONE);
    }
}

