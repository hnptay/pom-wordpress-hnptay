package testcases.com_jQuery_datatable;

import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.pageobject_jQuery.DataTablePageObject;
import actions.pageobject_jQuery.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class jQuery_01_Handle_DataTable extends AbstractTest {

    DriverManager driverManager;
    WebDriver driver;
    DataTablePageObject dataTablePage;

    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.JQUERY_URL);
        dataTablePage = PageGeneratorManager.getDataTablePage(driver);
    }

    @AfterClass
    public void afterClass() {
        driverManager.quitDriver();
    }

    //@Test
    public void TC_01_inputToCountry() {
        dataTablePage.inputToColumnByName("Country", "Angola");
        Assert.assertTrue(dataTablePage.isResultUnique("country"));
    }

    //@Test
    public void TC_02_Edit_Delete_By_CountryName() {
        dataTablePage.removeRowData("country", "Angola", "remove");
        dataTablePage.removeRowData("country", "Afghanistan", "remove");
        dataTablePage.removeRowData("country", "Algeria", "remove");
    }

    //@Test
    public void TC_03_navigatePage() {
        dataTablePage.navigateToPage("5");
        Assert.assertTrue(dataTablePage.isPageActive("5"));
        dataTablePage.navigateToPage("10");
        Assert.assertTrue(dataTablePage.isPageActive("10"));
    }

    @Test
    public void TC_04_DynamicRow(){
        dataTablePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
        dataTablePage.inputDataToTable("TMA0", "1", "Company");
        dataTablePage.inputDataToTable("TMA1", "2", "Person");
        dataTablePage.inputDataToTable("TMA2", "2", "Company");
        dataTablePage.actionInTable("insert", "2");
        dataTablePage.actionInTable("remove", "3");
        dataTablePage.actionInTable("insert", "1");
        dataTablePage.sleepInSecond(3);
    }
}
