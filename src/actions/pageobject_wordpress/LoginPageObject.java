package actions.pageobject_wordpress;


import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends AbstractPage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, email);
    }

    public void clickToContinueButton() {
        waitForElementVisible(driver, LoginPageUI.CONTINUE_BUTTON);
        clickToElement(driver, LoginPageUI.CONTINUE_BUTTON);
    }

    public String getErrorMessage() {
        waitForElementVisible(driver, LoginPageUI.MESSAGE_INFO);
        return getElementText(driver, LoginPageUI.MESSAGE_INFO);
    }

    public void inputToPasswordTextbox(String password) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXT_BOX);
        sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
    }


    public HomePageObject clickToLoginButton() {
        waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return new HomePageObject(driver);
    }

    public void openLoginPage(String url){
        openUrl(driver, url);
    }

    public String getLoginPageUrl(){
        return getCurrentUrl(driver);
    }
}
