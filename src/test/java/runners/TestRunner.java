package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * This is a test runner class to control the execution of Cucumber tests
 *
 * @author Amritansh Diwakar
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/features/AutomationTasks.feature"},
        glue = {"steps"}
        ,strict = true
        ,monochrome = true
        //tags = {"@BrowserAutomation"}
        )

public class TestRunner {

}
