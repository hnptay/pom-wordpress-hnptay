package actions.pageobject_bankguru;

import actions.commons.AbstractPage;
import interfaces.pageUI_bankGuru.AbstractGuruPageUI;
import org.openqa.selenium.WebDriver;

public class AddCustomerPageObject extends AbstractPage {

    public AddCustomerPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void sendKeyToDOB(String value, String values){
        waitForElementVisible(driver, AbstractGuruPageUI.DYNAMIC_TEXTBOX,values);
        removeAttributeInDOM(driver,AbstractGuruPageUI.DYNAMIC_TEXTBOX, "type", values);
        sendKeyToElement(driver, AbstractGuruPageUI.DYNAMIC_TEXTBOX, value, values);
    }

    private WebDriver driver;
}
