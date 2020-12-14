package actions.pageObject_saucelab;

import actions.commons.AbstractPage;
import interfaces.pageUI_saucelab.saucelabPageUI;
import org.openqa.selenium.WebDriver;

public class SaucelabPageObject extends AbstractPage {
    WebDriver driver;

    public SaucelabPageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void selectitemInSortDropDown(String value) {
        waitForElementVisible(driver, saucelabPageUI.DROPDOWN);
        selectItemInDropdown(driver, saucelabPageUI.DROPDOWN, value);
    }

    public boolean isNameSortAscending() {
        waitForElementsVisible(driver, saucelabPageUI.ALL_ITEM_NAME);
        return isDataSortAscending(driver, saucelabPageUI.ALL_ITEM_NAME);
    }

    public boolean isNameSortDescending() {
        waitForElementsVisible(driver, saucelabPageUI.ALL_ITEM_NAME);
        return isDataSortDescending(driver, saucelabPageUI.ALL_ITEM_NAME);
    }

    public boolean isPriceSortAscending() {
        waitForElementsVisible(driver, saucelabPageUI.ALL_ITEM_PRICE);
        return isPriceSortAscending(driver, saucelabPageUI.ALL_ITEM_PRICE);
    }

    public boolean isPriceSortDescending() {
        waitForElementsVisible(driver, saucelabPageUI.ALL_ITEM_PRICE);
        return isPriceSortDescending(driver, saucelabPageUI.ALL_ITEM_PRICE);
    }
}
