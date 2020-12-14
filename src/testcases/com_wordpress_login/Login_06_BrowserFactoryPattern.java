package testcases.com_wordpress_login;

import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageobject_wordpress.LoginPageObject;
import actions.pageobject_wordpress.ReadPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login_06_BrowserFactoryPattern extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private ReadPageObject readPageObject;
    private DriverManager driverManager;
    private String loginPageUrl;

    @Parameters ("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
        loginPageUrl = loginPageObject.getLoginPageUrl();
    }

    @BeforeMethod
    public void beforeMethod() {
        loginPageObject.openLoginPage(loginPageUrl);
    }

    @Test
    public void Validate_01_invalidEmail() {
        loginPageObject.inputToEmailTextbox("banana@gmail.com");
        loginPageObject.clickToContinueButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Please log in using your WordPress.com username instead of your email address.");
    }

    @Test
    public void Validate_02_incorrectPassword() {
        loginPageObject.inputToEmailTextbox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.inputToPasswordTextbox("1");
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Oops, that's not the right password. Please try again!");
    }

    @Test
    public void Validate_03_emptyEmail() {
        loginPageObject.clickToContinueButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Please enter a username or email address.");
    }

    @Test
    public void Validate_04_emptyPassword() {
        loginPageObject.inputToEmailTextbox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Don't forget to enter your password.");
    }

    @Test
    public void Validate_05_correctPassword() {
        loginPageObject.inputToEmailTextbox("bananainf");
        loginPageObject.clickToContinueButton();
        loginPageObject.inputToPasswordTextbox("245648zxc");
        loginPageObject.clickToLoginButton();
        readPageObject = PageGeneratorManager.getReadPage(driver);
        Assert.assertTrue(readPageObject.isReadHeaderDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driverManager.quitDriver();
    }
}
