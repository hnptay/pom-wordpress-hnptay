package actions.pagefactory_bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {
    WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//input[@name='emailid']")
    WebElement emailTextBox;

    @FindBy(how = How.XPATH, using = "//input[@name='btnLogin']")
    WebElement submitButton;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'User ID :')]//following-sibling::td")
    WebElement userText;

    @FindBy(how = How.XPATH, using = "//td[contains(text(),'Password :')]//following-sibling::td")
    WebElement passwordText;

    public void inputToEmailTextbox(String email) {
        waitForElementVisible(driver, emailTextBox);
        sendKeyToElement(driver, emailTextBox, email);
    }

    public void clickToSubmitButton() {
        waitForElementClickAble(driver, submitButton);
        clickToElement(driver, submitButton);
    }

    public String getUserID() {
        waitForElementVisible(driver, userText);
        return getElementText(driver, userText);
    }

    public String getPasswordValue() {
        waitForElementVisible(driver, passwordText);
        return getElementText(driver, passwordText);
    }

    public void openLoginPage(String loginPageUrl) {
        openUrl(driver, loginPageUrl);
    }
}
