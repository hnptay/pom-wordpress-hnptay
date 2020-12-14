package testcases.com_wordpress_login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_01_ValidateLoginForm {
    private WebDriver driver;
    By emailTextBoxBy = By.xpath("//input[@id='usernameOrEmail']");
    By passwordTextBoxBy = By.xpath("//input[@id='password']");
    By confirmButtonBy = By.xpath("//button[contains(text(),'Continue')]");
    By messageInfoBy = By.xpath("//div[@role='alert']//span");
    By loginButtonBy = By.xpath("//button[contains(text(),'Log In')]");

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://wordpress.com/log-in?redirect_to=https%3A%2F%2Fwordpress.com%2F");
    }

    @Test
    public void Validate_01_invalidEmail() {
        driver.findElement(emailTextBoxBy).sendKeys("123123@gmail.com");
        driver.findElement(confirmButtonBy).click();
        Assert.assertEquals(driver.findElement(messageInfoBy).getText(),
                "Please log in using your WordPress.com username instead of your email address.");

    }

    @Test
    public void Validate_02_invalidPassword() {
        driver.findElement(emailTextBoxBy).sendKeys("automation");
        driver.findElement(confirmButtonBy).click();
        driver.findElement(passwordTextBoxBy).sendKeys("1");
        driver.findElement(loginButtonBy).click();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='notice__text']")).getText(),
                "You have exceeded the login limit. Please wait a few minutes and try again.");

    }

    @Test
    public void Validate_03_incorrectPassword() {
        driver.findElement(emailTextBoxBy).sendKeys("automation");
        driver.findElement(confirmButtonBy).click();
        driver.findElement(passwordTextBoxBy).sendKeys("123");
        driver.findElement(loginButtonBy).click();
        Assert.assertEquals(driver.findElement(messageInfoBy).getText(),
                "Oops, that's not the right password. Please try again!");

    }

    @Test
    public void Validate_04_notExistEmail() {
        driver.findElement(emailTextBoxBy).sendKeys("123jhse");
        driver.findElement(confirmButtonBy).click();
        Assert.assertEquals(driver.findElement(messageInfoBy).getText(),
                "User does not exist. Would you like to create a new account?");
    }

    @Test
    public void Validate_05_emptyEmail() {
        driver.findElement(emailTextBoxBy).clear();
        driver.findElement(confirmButtonBy).click();
        Assert.assertEquals(driver.findElement(messageInfoBy).getText(),
                "Please enter a username or email address.");
    }

    @Test
    public void Validate_06_emptyPassword() {
        driver.findElement(emailTextBoxBy).sendKeys("automation");
        driver.findElement(confirmButtonBy).click();
        driver.findElement(passwordTextBoxBy).clear();
        Assert.assertEquals(driver.findElement(messageInfoBy).getText().trim(),
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
