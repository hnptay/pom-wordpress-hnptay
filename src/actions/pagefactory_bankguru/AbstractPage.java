package actions.pagefactory_bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class AbstractPage {

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
        element.sendKeys(value);
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickAble(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

    public void openUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getElementText(WebDriver driver, WebElement element) {
        return element.getText();
    }


    WebDriverWait wait;
    long waitTime = 15;
}
