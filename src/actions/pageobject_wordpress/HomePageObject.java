package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isHomeHeaderDisplayed() {
        waitForElementVisible(driver, HomePageUI.HOMEPAGE_HEADER);
        return isElementDisplay(driver, HomePageUI.HOMEPAGE_HEADER);
    }

    public DashBoardPageObject clickToWPAdminMenu(){
        waitForElementClickable(driver, HomePageUI.WP_ADMIN);
        clickToElement(driver, HomePageUI.WP_ADMIN);
        return new DashBoardPageObject(driver);
    }
}
