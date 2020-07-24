package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Hooks extends BaseUtil {
    private static final Logger log = Logger.getLogger(BrowserAutomationSteps.class.getSimpleName());
    private Process process;

    @After("@BrowserAutomation")
    public void quitBrowserDriver() {
        webDriver.quit();
        log.info("Quiting Browser Driver");
    }

    @Before("@DesktopAutomation")
    public void startWiniumDriver() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        process = runtime.exec(configProp.getProperty("drivers_path").concat("Winium.Desktop.Driver.exe"));
        log.info("Executing the Winium.Desktop.Driver.exe file");
    }

    @After("@DesktopAutomation")
    public void quitWiniumDriver() {
        process.destroy();
        log.info("Quitting Winium Driver");
    }
}
