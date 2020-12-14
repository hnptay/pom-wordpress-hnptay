package actions.pageObject_saucelab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static SaucelabPageObject getSaucelabPage(WebDriver driver) {
        return new SaucelabPageObject(driver);
    }
}
