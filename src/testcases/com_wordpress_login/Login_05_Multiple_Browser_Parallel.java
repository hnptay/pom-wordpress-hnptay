package testcases.com_wordpress_login;

import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageobject_wordpress.LoginPageObject;
import actions.pageobject_wordpress.ReadPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class Login_05_Multiple_Browser_Parallel extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private ReadPageObject readPageObject;

    @Parameters ("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, GlobalConstants.WORDPRESS_URL);
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
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
        loginPageObject.refresh(driver);
        loginPageObject.inputToEmailTextbox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.inputToPasswordTextbox("1");
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Oops, that's not the right password. Please try again!");
    }

    @Test
    public void Validate_03_emptyEmail() {
        loginPageObject.refresh(driver);
        loginPageObject.clickToContinueButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Please enter a username or email address.");
    }

    @Test
    public void Validate_04_emptyPassword() {
        loginPageObject.refresh(driver);
        loginPageObject.inputToEmailTextbox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getErrorMessage(),
                "Don't forget to enter your password.");
    }

    @Test
    public void Validate_05_correctPassword() {
        loginPageObject.refresh(driver);
        loginPageObject.inputToEmailTextbox("bananainf");
        loginPageObject.clickToContinueButton();
        loginPageObject.inputToPasswordTextbox("245648zxc");
        loginPageObject.clickToLoginButton();
        readPageObject = PageGeneratorManager.getReadPage(driver);
        Assert.assertTrue(readPageObject.isReadHeaderDisplayed());
    }

    @AfterClass
    public void afterClass() {
        if(driver != null){
            driver.quit();
        }
    }
}
