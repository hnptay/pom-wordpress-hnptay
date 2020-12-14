package testcases.com_wordpress_login;

import actions.commons.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_02_Apply_AbstractPage extends AbstractPage {
    private WebDriver driver;
    String emailTextBox = "//input[@id='usernameOrEmail']";
    String passwordTextBox = "//input[@id='password']";
    String confirmButton = "//button[contains(text(),'Continue')]";
    String messageInfo = "//div[@role='alert']//span";
    String loginButton = "//button[contains(text(),'Log In')]";

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        openUrl(driver,"https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
    }

    @Test
    public void Validate_01_invalidEmail() {
        sendKeyToElement(driver, emailTextBox, "123123@gmail.com");
        clickToElement(driver, confirmButton);
        Assert.assertEquals(getElementText(driver,messageInfo),
                "Please log in using your WordPress.com username instead of your email address.");


    }

    @Test
    public void Validate_02_invalidPassword() {
        sendKeyToElement(driver, emailTextBox, "automation");
        clickToElement(driver, confirmButton);
        sendKeyToElement(driver, passwordTextBox,"1");
        clickToElement(driver, loginButton);
        Assert.assertEquals(getElementText(driver,messageInfo),
                "You have exceeded the login limit. Please wait a few minutes and try again.");

    }

    @Test
    public void Validate_03_incorrectPassword() {
        sendKeyToElement(driver, emailTextBox, "automation");
        clickToElement(driver, confirmButton);
        sendKeyToElement(driver, passwordTextBox, "123");
        clickToElement(driver, loginButton);
        Assert.assertEquals(getElementText(driver, messageInfo),
                "Oops, that's not the right password. Please try again!");

    }

    @Test
    public void Validate_04_notExistEmail() {
        sendKeyToElement(driver, emailTextBox,"123jse");
        clickToElement(driver,confirmButton);
        Assert.assertEquals(getElementText(driver, messageInfo),
                "User does not exist. Would you like to create a new account?");
    }

    @Test
    public void Validate_05_emptyEmail() {
        clearKeyInElement(driver, emailTextBox);
        clickToElement(driver, confirmButton);
        Assert.assertEquals(getElementText(driver, messageInfo),
                "Please enter a username or email address.");
    }

    @Test
    public void Validate_06_emptyPassword() {
        sendKeyToElement(driver, emailTextBox, "automation");
        clickToElement(driver, confirmButton);
        clearKeyInElement(driver, passwordTextBox);
        Assert.assertEquals(getElementText(driver, messageInfo),
                "Don't forget to enter your password.");
    }

    @Test
    public void Validate_07_correctPassword() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
