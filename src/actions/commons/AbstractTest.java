package actions.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private WebDriver driver;
    protected Log log;

    public AbstractTest() {
        log = LogFactory.getLog(getClass());
    }

    public int randomNumber(int range){
        Random random = new Random();
        return random.nextInt(range);
    }

    public WebDriver getBrowserDriver(String browserDriver, String url) {
        switch (browserDriver){
            case "edge":
                System.setProperty("webdriver.edge.driver", "browserDriver\\msedgedriver.exe");
                driver = new EdgeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "browserDriver\\geckodriver.exe");
                driver = new FirefoxDriver();
            default:
                System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
                driver = new ChromeDriver();
        }
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(GlobalConstants.LONG_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    //Verify
    public boolean checkTrue(boolean condition) {
        boolean status = true;
        try {
            if (condition) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public boolean verifyTrue(boolean condition) {
        return checkTrue(condition);
    }

    public boolean checkFalse(boolean condition) {
        boolean status = true;
        try {
            if (!condition) {
                log.info(" -------------------------- PASSED -------------------------- ");
            } else {
                log.info(" -------------------------- FAILED -------------------------- ");
            }
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            status = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public boolean verifyFalse(boolean condition) {
        return checkFalse(condition);
    }

    public boolean checkEquals(Object actual, Object expected) {
        boolean status = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info(" -------------------------- PASSED -------------------------- ");
        } catch (Throwable e) {
            status = false;
            log.info(" -------------------------- FAILED -------------------------- ");
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return status;
    }

    public boolean verifyEquals(Object actual, Object expected) {
        return checkEquals(actual, expected);
    }

    public void closeBrowserAndDriver(WebDriver driver) {
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            log.info("OS name = " + osName);

            String cmd = "";
            if (driver != null) {
                driver.quit();
            } else {
                return;
            }

            if (driver.toString().toLowerCase().contains("chrome")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill chromedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("internetexplorer")) {
                if (osName.toLowerCase().contains("window")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
                }
            } else if (driver.toString().toLowerCase().contains("firefox")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill geckodriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
                }
            } else if (driver.toString().toLowerCase().contains("edge")) {
                if (osName.toLowerCase().contains("mac")) {
                    cmd = "pkill msedgedriver";
                } else if (osName.toLowerCase().contains("windows")) {
                    cmd = "taskkill /F /FI \"IMAGENAME eq msedgedriver*\"";
                }
            }

            Process process = Runtime.getRuntime().exec(cmd);
            process.waitFor();

            log.info("---------- QUIT BROWSER SUCCESS ----------");
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public String getCurrentDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        int date = localDateTime.getDayOfMonth();
        return date + "";
    }

    public String getCurrentMonthName() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Month month = localDateTime.getMonth();
        return month.getDisplayName(TextStyle.FULL, Locale.US);
    }

    public String getCurrentMonthNumber() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Month month = localDateTime.getMonth();
        int monthNumber = month.getValue();
        if (monthNumber < 10) {
            String monthEdit = "0" + monthNumber;
            return monthEdit;
        }
        return monthNumber + "";
    }

    public String getCurrentTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss a");  //yyyy/MMMM/dd
        return dtf.format(localDateTime);
    }

    public String getCurrentYear() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getYear() + "";
    }

    public String dateTimeCustomFormat(){
        return getCurrentMonthName() + " " + getCurrentDate() + ", " + getCurrentYear();
    }

}
