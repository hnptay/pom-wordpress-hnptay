package testcases.com_bankguru_login;

import actions.pageobject_bankguru.HomePageObject;
import actions.pageobject_bankguru.LoginPageObject;
import actions.pageobject_bankguru.PageGeneratorManager;
import actions.pageobject_bankguru.RegisterPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Login_01_RegisterAndLogin {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private String userValue;
    private String passwordValue;
    private String loginPageUrl;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver",".\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/v4");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPageUrl = loginPage.getLoginPageUrl();
    }

    @Test
    public void TC_01_Register(){
        loginPage.clickToHereLink();
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        registerPage.inputToEmailTextbox("autotest1001@gmail.com");
        registerPage.clickToSubmitButton();
        userValue = registerPage.getUserID();
        passwordValue = registerPage.getPasswordValue();
        registerPage.openLoginPage(loginPageUrl);
        loginPage = PageGeneratorManager.getLoginPage(driver);

    }

    @Test
    public void TC_02_Login(){
        loginPage.inputUserID(userValue);
        loginPage.inputPassword(passwordValue);
        loginPage.clickToLoginButton();
        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed());

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
