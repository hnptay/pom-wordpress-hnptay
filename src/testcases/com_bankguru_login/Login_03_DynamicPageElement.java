package testcases.com_bankguru_login;


import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.pageobject_bankguru.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Login_03_DynamicPageElement extends AbstractTest {

    @BeforeClass
    public void beforeClass() {
        DriverManager driverManager = DriverFactory.getBrowserManager("chrome");
        log.info("Pre-condition - STEP 01: Open browser");
        driver = driverManager.getDriver(GlobalConstants.BANKGURU_URL);
        log.info("Pre-condition - STEP 02: Open login page");
        loginPage = PageGeneratorManager.getLoginPage(driver);
        log.info("Pre-condition - STEP 03: Get login page url");
        loginPageUrl = loginPage.getLoginPageUrl();

        customerName = "Ronaldo";
        gender = "female";
        dateOfBirth = "2020-11-01";
        address = "3003";
        city = "Bacelona";
        state = "Bacelona";
        pin = "123456";
        mobile = "123456789";
        email = "oldanoR" + randomNumber(9999) + "@hotmail.com";

        editAddress = "3004";
        editCity = "Potato";
        editState = "Apple";
        editPin = "654321";
        editMobile = "987654321";
        editEmail = "apple" + randomNumber(9999) + "@outlook.com";

    }

    @AfterClass (alwaysRun = true)
    public void afterClass() {
        log.info("Post-condition - Close browser and driver");
        closeBrowserAndDriver(driver);
    }

    @Test
    public void TC_01_Register() {
        log.info("TC_01_Register - STEP 01: Click to here link");
        loginPage.clickToDynamicMenuLink(driver,"here");
        registerPage = PageGeneratorManager.getRegisterPage(driver);
        log.info("TC_01_Register - STEP 02: Input email id");
        registerPage.inputToDynamicTextBox(driver,"autotest" + randomNumber(9999) + "@gmail.com", "Email ID");
        log.info("TC_01_Register - STEP 03: click submit button");
        registerPage.clickToDynamicButton(driver, "submit");
        log.info("TC_01_Register - STEP 04: get user name");
        userValue = registerPage.getDynamicColumnValue(driver, "User ID");
        log.info("TC_01_Register - STEP 05: get password");
        passwordValue = registerPage.getDynamicColumnValue(driver, "Password");
        registerPage.openLoginPage(loginPageUrl);
        loginPage = PageGeneratorManager.getLoginPage(driver);
    }

    @Test
    public void TC_02_Login() {
        log.info("TC_02_Login - STEP 01: input user id");
        loginPage.inputToDynamicTextBox(driver, userValue, "UserID");
        log.info("TC_02_Login - STEP 02: input passowrd");
        loginPage.inputToDynamicTextBox(driver, passwordValue, "Password");
        log.info("TC_02_Login - STEP 03: click submit button");
        loginPage.clickToDynamicButton(driver, "submit");
        homePage = PageGeneratorManager.getHomePage(driver);
        log.info("TC_02_Login - STEP 04: verify login success");
        verifyTrue(homePage.isWelcomeMessageDisplayed());
    }

    @Test
    public void TC_03_NewCustomer(){
        homePage.clickToDynamicMenuLink(driver, "New Customer");
        addCustomerPage = PageGeneratorManager.getAddCustomerPage(driver);
        addCustomerPage.inputToDynamicTextBox(driver, customerName, "Customer Name");
        addCustomerPage.clickToDynamicRadioButton(driver, "radio", "f");
        addCustomerPage.sendKeyToDOB(dateOfBirth, "Date of Birth");
        addCustomerPage.inputToDynamicTextarea(driver, address, "addr");
        addCustomerPage.inputToDynamicTextBox(driver, city, "City");
        addCustomerPage.inputToDynamicTextBox(driver, state, "State");
        addCustomerPage.inputToDynamicTextBox(driver, pin, "PIN");
        addCustomerPage.inputToDynamicTextBox(driver, mobile, "Mobile Number");
        addCustomerPage.inputToDynamicTextBox(driver, email, "E-mail");
        addCustomerPage.inputToDynamicTextBox(driver, passwordValue, "Password");
        addCustomerPage.clickToDynamicButton(driver, "submit");
        verifyTrue(addCustomerPage.isInfoMessageDisplayed(driver, "Customer Registered Successfully!!!"));
        customerID = addCustomerPage.getDynamicColumnValue(driver, "Customer ID");

        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Customer Name"), customerName);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Gender"), gender);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Birthdate"), dateOfBirth);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Address"), address);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"City"), city);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"State"), state);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Pin"), pin);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Mobile"), mobile);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Email"), email);
    }

    @Test
    public void TC_04_editCustomer(){
        addCustomerPage.clickToDynamicMenuLink(driver, "Edit Customer");
        editCustomerPage = PageGeneratorManager.getEditCustomerPage(driver);
        editCustomerPage.inputToDynamicTextBox(driver, customerID, "Customer ID");
        editCustomerPage.clickToDynamicButton(driver,"submit");
        addCustomerPage.inputToDynamicTextarea(driver, editAddress, "addr");
        addCustomerPage.inputToDynamicTextBox(driver, editCity, "City");
        addCustomerPage.inputToDynamicTextBox(driver, editState, "State");
        addCustomerPage.inputToDynamicTextBox(driver, editPin, "PIN");
        addCustomerPage.inputToDynamicTextBox(driver, editMobile, "Mobile Number");
        addCustomerPage.inputToDynamicTextBox(driver, editEmail, "E-mail");
        addCustomerPage.clickToDynamicButton(driver, "submit");
        verifyTrue(addCustomerPage.isInfoMessageDisplayed(driver, "Customer details updated Successfully!!!"));

        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Address"), editAddress);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"City"), editCity);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"State"), editState);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Pin"), editPin);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Mobile"), editMobile);
        verifyEquals(addCustomerPage.getDynamicColumnValue(driver,"Email"), editEmail);
    }

    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private AddCustomerPageObject addCustomerPage;
    private EditCustomerPageObject editCustomerPage;
    private String userValue, passwordValue, loginPageUrl, customerName, dateOfBirth, address, city, state, pin, mobile, email, gender, customerID,
            editAddress, editState, editCity, editPin, editMobile, editEmail;
}
