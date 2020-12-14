package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.ReadPageUI;
import org.openqa.selenium.WebDriver;

public class ReadPageObject extends AbstractPage {
    WebDriver driver;

    public ReadPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isReadHeaderDisplayed() {
        waitForElementVisible(driver, ReadPageUI.READ_HEADER);
        return isElementDisplay(driver, ReadPageUI.READ_HEADER);
    }

}
