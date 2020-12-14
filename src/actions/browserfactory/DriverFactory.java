package actions.browserfactory;


public class DriverFactory {

    public static DriverManager getBrowserManager(String browserDriver){
        DriverManager driverManager;
        switch (browserDriver){
            case "chrome":
                driverManager = new ChromeDriverManager();
                break;
            case "firefox":
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new EdgeDriverManager();
                break;
        }

        return driverManager;
    }

}
