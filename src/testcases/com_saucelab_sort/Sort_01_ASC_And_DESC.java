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

public class Sort_01_ASC_And_DESC extends AbstractTest {
    private WebDriver driver;
    private SaucelabPageObject saucelabPage;

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        DriverManager driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(url);
        saucelabPage = PageGeneratorManager.getSaucelabPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

    @Test
    public void Sort_01_sortName(){
        saucelabPage.selectitemInSortDropDown("Name (A to Z)");
        verifyTrue(saucelabPage.isNameSortAscending());
        saucelabPage.selectitemInSortDropDown("Name (Z to A)");
        verifyTrue(saucelabPage.isNameSortDescending());
    }

    //@Test
    public void Sort_02_sortPrice(){
        saucelabPage.selectitemInSortDropDown("Price (low to high)");
        verifyTrue(saucelabPage.isPriceSortAscending());
        saucelabPage.selectitemInSortDropDown("Price (high to low)");
        verifyTrue(saucelabPage.isPriceSortDescending());
    }
}
