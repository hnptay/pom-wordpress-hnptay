package testcases.com_wordpress_login;

import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageobject_wordpress.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Login_09_UploadMultipleFiles extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPage;
    private DriverManager driverManager;
    private DashBoardPageObject dashBoardPage;
    private MediaPageObject mediaPage;
    private HomePageObject homePage;


    @Parameters ("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_01_loginToWordPress() {
        loginPage.inputToEmailTextbox(GlobalConstants.WORDPRESS_USER);
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox(GlobalConstants.WORDPRESS_PASSWORD);
        homePage = loginPage.clickToLoginButton();
        Assert.assertTrue(homePage.isHomeHeaderDisplayed());
    }

    @Test
    public void TC_02_uploadFiles(){
        dashBoardPage = homePage.clickToWPAdminMenu();
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
        mediaPage = (MediaPageObject) dashBoardPage.selectPageMenu(driver, "Media");
        mediaPage.clickToAddNew();
        mediaPage.uploadFiles("apple1.png", "apple2.png", "apple3.png");
        Assert.assertTrue(mediaPage.isFilesUploaded("apple1.png", "apple2.png", "apple3.png"));
    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }
}
