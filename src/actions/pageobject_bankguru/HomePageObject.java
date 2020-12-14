package actions.pageobject_bankguru;

import actions.commons.AbstractPage;
import interfaces.pageUI_bankGuru.HomePageUI;
import org.openqa.selenium.WebDriver;

public class HomePageObject extends AbstractPage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeMessageDisplayed() {
        return isElementDisplay(driver, HomePageUI.WELCOME_MESSAGE);
    }
}
