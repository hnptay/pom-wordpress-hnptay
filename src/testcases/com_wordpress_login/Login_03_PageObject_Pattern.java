package testcases.com_wordpress_login;

import actions.commons.AbstractPage;
import actions.pageobject_wordpress.LoginPageObject;
import actions.commons.PageGeneratorManager;
import actions.pageobject_wordpress.ReadPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_03_PageObject_Pattern extends AbstractPage {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private ReadPageObject readPageObject;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPageObject = PageGeneratorManager.getLoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        openUrl(driver,"https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
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
        driver.quit();
    }
}
