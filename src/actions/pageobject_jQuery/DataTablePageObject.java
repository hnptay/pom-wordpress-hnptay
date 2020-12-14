package actions.pageobject_jQuery;

import actions.commons.AbstractPage;
import interfaces.pageUI_jQuery.DataTablePageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class DataTablePageObject extends AbstractPage {
    WebDriver driver;

    public DataTablePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToColumnByName(String columnName, String dataName) {
        waitForElementVisible(driver, DataTablePageUI.DYNAMIC_COLUMN, columnName);
        sendKeyToElement(driver, DataTablePageUI.DYNAMIC_COLUMN, dataName, columnName);
        sendKeyboardToElement(driver, DataTablePageUI.DYNAMIC_COLUMN, Keys.ENTER, columnName);
    }

    public boolean isResultUnique(String columnName) {
        waitForElementVisible(driver, DataTablePageUI.DYNAMIC_ROW, columnName);
        int rowNumber = countElementNumber(driver, DataTablePageUI.DYNAMIC_ROW, columnName);
        boolean status = isElementDisplay(driver, DataTablePageUI.DYNAMIC_ROW, columnName);
        return rowNumber == 1 && status;
    }

    public void removeRowData(String columnName, String dataName, String action) {
        waitForElementClickable(driver, DataTablePageUI.DYNAMIC_ACTIONS, columnName, dataName, action);
        clickToElement(driver, DataTablePageUI.DYNAMIC_ACTIONS, columnName, dataName, action);
    }

    public void navigateToPage(String pageNumber) {
        waitForElementClickable(driver, DataTablePageUI.DYNAMIC_PAGE, pageNumber);
        clickToElement(driver, DataTablePageUI.DYNAMIC_PAGE, pageNumber);
    }

    public boolean isPageActive(String pageNumber) {
        waitForElementVisible(driver, DataTablePageUI.DYNAMIC_PAGE_VERIFY, pageNumber);
        return isElementDisplay(driver, DataTablePageUI.DYNAMIC_PAGE_VERIFY, pageNumber);
    }

    public void inputDataToTable(String value, String row, String column) {
        waitForElementVisible(driver, DataTablePageUI.DYNAMIC_COLUMN_INDEX, column);
        int columnIndex = countElementNumber(driver, DataTablePageUI.DYNAMIC_COLUMN_INDEX, column) + 1;
        waitForElementVisible(driver, DataTablePageUI.DYNAMIC_TEXT_BOX, row, Integer.toString(columnIndex));
        sendKeyToElement(driver, DataTablePageUI.DYNAMIC_TEXT_BOX, value, row, Integer.toString(columnIndex));
    }

    public void actionInTable(String action, String row){
        waitForElementClickable(driver, DataTablePageUI.DYNAMIC_ACTION_TABLE, row, action);
        clickToElement(driver, DataTablePageUI.DYNAMIC_ACTION_TABLE, row, action);
    }

}
