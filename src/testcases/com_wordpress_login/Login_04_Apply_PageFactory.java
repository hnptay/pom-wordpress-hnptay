package testcases.com_wordpress_login;


import actions.pagefactory_wordpress.PageGeneratorManager;
import actions.pagefactory_wordpress.LoginPageObject;
import actions.pagefactory_wordpress.ReadPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_04_Apply_PageFactory {
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
        driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
    }

    @Test
    public void Validate_01_invalidEmail() {
        loginPageObject.sendKeyToEmailTextBox("banana@gmail.com");
        loginPageObject.clickToContinueButton();
        Assert.assertEquals(loginPageObject.getMessageInfo(),
                "Please log in using your WordPress.com username instead of your email address.");
    }

    @Test
    public void Validate_02_incorrectPassword() {
        loginPageObject.sendKeyToEmailTextBox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.sendKeyToPasswordTextBox("1");
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getMessageInfo(),
                "Oops, that's not the right password. Please try again!");
    }

    @Test
    public void Validate_03_emptyEmail() {
        loginPageObject.clickToContinueButton();
        Assert.assertEquals(loginPageObject.getMessageInfo(),
                "Please enter a username or email address.");
    }

    @Test
    public void Validate_04_emptyPassword() {
        loginPageObject.sendKeyToEmailTextBox("banana123");
        loginPageObject.clickToContinueButton();
        loginPageObject.clickToLoginButton();
        Assert.assertEquals(loginPageObject.getMessageInfo(),
                "Don't forget to enter your password.");
    }

    @Test
    public void Validate_05_correctPassword() {
        loginPageObject.sendKeyToEmailTextBox("bananainf");
        loginPageObject.clickToContinueButton();
        loginPageObject.sendKeyToPasswordTextBox("245648zxc");
        loginPageObject.clickToLoginButton();
        readPageObject = PageGeneratorManager.getReadPage(driver);
        Assert.assertTrue(readPageObject.isReadHeaderDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
