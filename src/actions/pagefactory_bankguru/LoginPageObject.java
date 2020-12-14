package actions.pagefactory_bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends AbstractPage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'here')]")
    WebElement hereLink;

    @FindBy(how = How.XPATH, using = "//input[@name='uid']")
    WebElement userTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    WebElement passwordTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
    WebElement loginButton;

    public String getLoginPageUrl() {
        return getCurrentUrl(driver);
    }

    public void clickToHereLink() {
        waitForElementClickAble(driver, hereLink);
        clickToElement(driver, hereLink);
    }

    public void inputUserID(String userID) {
        waitForElementVisible(driver, userTextBox);
        sendKeyToElement(driver, userTextBox, userID);
    }

    public void inputPassword(String password) {
        waitForElementVisible(driver, passwordTextBox);
        sendKeyToElement(driver, passwordTextBox, password);
    }

    public void clickToLoginButton() {
        waitForElementVisible(driver, loginButton);
        clickToElement(driver, loginButton);
    }
}
