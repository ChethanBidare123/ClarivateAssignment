package enums;
/**
 * This is a enum to handle Desktop Apps and their corresponding location path
 *
 * @author Amritansh Diwakar
 */
public enum DesktopApps {
    CALCULATOR("C:\\Windows\\System32\\calc.exe"),
    NOTEPAD("C:\\Windows\\System32\\notepad.exe");

    private final String applicationPath;

    DesktopApps(String applicationPath){
        this.applicationPath = applicationPath;
    }

    public String getApplicationPath() {
        return String.valueOf(this.applicationPath);
    }
}
