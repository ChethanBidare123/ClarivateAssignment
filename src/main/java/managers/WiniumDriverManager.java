package managers;

import enums.DesktopApps;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This is a class to manage Winium Driver
 *
 * @author Amritansh Diwakar
 */

public class WiniumDriverManager {

    /**
     * This  method is used to initialize a winium driver object based on the Desktop application
     *
     * @param desktopApp This is the enum DesktopApps to map the path of the application
     * @param hostServer This is the server - host:port to host the winium driver ex. locslhost:9999
     * @return WiniumDriver object after initializing it.
     */
    public WiniumDriver initDriver(DesktopApps desktopApp, String hostServer) throws MalformedURLException {
        DesktopOptions options = new DesktopOptions();
        options.setApplicationPath(desktopApp.getApplicationPath());
        return new WiniumDriver(new URL(hostServer), options);
    }
}
