package testcases.com_saucelab_sort;

import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.pageObject_saucelab.PageGeneratorManager;
import actions.pageObject_saucelab.SaucelabPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test123 extends AbstractTest {

    WebDriver driver;
    SaucelabPageObject saucelabPage;
    test321 test;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        DriverManager driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(url);
        saucelabPage = PageGeneratorManager.getSaucelabPage(driver);
        System.out.println(driver.toString());
        test = new test321();
        test.printDriver();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

    @Test
    public void test222(){
        System.out.println("Nothing");
    }
}
