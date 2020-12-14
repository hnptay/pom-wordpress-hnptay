package actions.pagefactory_wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    private WebDriverWait wait;
    private long waitTime = 15;

    public void openURL(WebDriver driver, String url) {
        driver.get(url);
    }

    public void sendKeyToElement(WebDriver driver, WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickToElement(WebDriver driver, WebElement element) {
        element.click();
    }

    public void waitForElementVisible(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickAble(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getText(WebDriver driver, WebElement element) {
        return element.getText();
    }

    public boolean isElementDisplayed(WebDriver driver, WebElement element) {
        return element.isDisplayed();
    }

}
