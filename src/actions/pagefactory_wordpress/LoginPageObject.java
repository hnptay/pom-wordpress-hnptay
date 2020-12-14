package actions.pagefactory_wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@id='usernameOrEmail']")
    WebElement emailTexBox;

    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//div[@role='alert']//span")
    WebElement messageInfo;

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Log In')]")
    WebElement loginButton;

    public void sendKeyToEmailTextBox(String email){
        waitForElementVisible(driver, emailTexBox);
        sendKeyToElement(driver, emailTexBox, email);
    }

    public void sendKeyToPasswordTextBox(String password){
        waitForElementVisible(driver, passwordTextBox);
        sendKeyToElement(driver, passwordTextBox, password);
    }

    public void clickToContinueButton(){
        waitForElementClickAble(driver, continueButton);
        clickToElement(driver, continueButton);
    }

    public String getMessageInfo(){
        waitForElementVisible(driver, messageInfo);
        return getText(driver, messageInfo);
    }

    public void clickToLoginButton(){
        waitForElementClickAble(driver, loginButton);
        clickToElement(driver, loginButton);
    }


}
