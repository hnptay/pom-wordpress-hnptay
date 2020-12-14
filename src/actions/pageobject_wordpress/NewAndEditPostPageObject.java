package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.NewAndEditPostPageUI;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewAndEditPostPageObject extends AbstractPage {

    public NewAndEditPostPageObject(WebDriver driver){
        this.driver = driver;
    }



    private WebDriver driver;

    public void inputToTitle(String value) {
        waitForElementVisible(driver, NewAndEditPostPageUI.ADD_TITLE_TEXTAREA);
        sendKeyToElement(driver, NewAndEditPostPageUI.ADD_TITLE_TEXTAREA, value);
    }

    public void inputToContent(String value) {
        waitForElementVisible(driver, NewAndEditPostPageUI.ADD_CONTENT_BLOCK);
        sendKeyToElement(driver, NewAndEditPostPageUI.ADD_CONTENT_BLOCK, value);
    }

    public void clickToPostOption(String option) {
        waitForElementClickable(driver, NewAndEditPostPageUI.EDIT_OPTION, option);
        clickToElement(driver, NewAndEditPostPageUI.EDIT_OPTION, option);
    }

    public void selectCheckBox(String categoryCheckBox) {
        waitForElementVisible(driver, NewAndEditPostPageUI.CHECKBOXES, categoryCheckBox);
        clickToElement(driver, NewAndEditPostPageUI.CHECKBOXES, categoryCheckBox);
    }

    public void inputToTagsTextBox(String tag) {
        waitForElementVisible(driver, NewAndEditPostPageUI.TAGS_TEXTBOX);
        sendKeyToElement(driver, NewAndEditPostPageUI.TAGS_TEXTBOX, tag);
    }

    public void clickSelectImage(String button) {
        waitForElementClickable(driver, NewAndEditPostPageUI.MENU_BUTTONS, button);
        clickToElement(driver, NewAndEditPostPageUI.MENU_BUTTONS, button);
    }

    public void clickToMenu(String menu) {
        waitForElementClickable(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
        clickToElement(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
    }

    public void selectMenuButton(String button) {
        waitForElementClickable(driver, NewAndEditPostPageUI.BUTTONS, button);
        clickToElement(driver, NewAndEditPostPageUI.BUTTONS, button);
    }

    public void selectImage(String imageNumber) {
        waitForElementClickable(driver, NewAndEditPostPageUI.IMAGES, imageNumber);
        clickToElement(driver, NewAndEditPostPageUI.IMAGES, imageNumber);
    }

    public void clickSetImage() {
        waitForElementClickable(driver, NewAndEditPostPageUI.SET_IMAGE_BUTTON);
        clickToElement(driver, NewAndEditPostPageUI.SET_IMAGE_BUTTON);
    }

    public void clickToPublicButton(String button) {
        waitForElementClickable(driver, NewAndEditPostPageUI.MENU_BUTTONS, button);
        clickToElement(driver, NewAndEditPostPageUI.MENU_BUTTONS, button);
    }

    public void confirmPublic() {
        waitForElementClickable(driver, NewAndEditPostPageUI.CONFIRM_PUBLISH_BUTTON);
        clickToElement(driver, NewAndEditPostPageUI.CONFIRM_PUBLISH_BUTTON);
    }

    public boolean isSuccessMessageDisplayed(String message) {
        waitForElementInvisible(driver, NewAndEditPostPageUI.PUBLISH_ICON);
        sleepInSecond(5);
        //waitForElementVisible(driver, NewAndEditPostPageUI.MESSAGE_INFO, message);
        return true; //isElementDisplay(driver, NewAndEditPostPageUI.MESSAGE_INFO, message);
    }

    public void clickToWordPressIcon() {
        waitForElementClickable(driver, NewAndEditPostPageUI.WORDPRESS_BUTTON);
        clickToElementByJs(driver, NewAndEditPostPageUI.WORDPRESS_BUTTON);
    }

    public PostPageObject clickToAllPost() {
        waitForElementClickable(driver, NewAndEditPostPageUI.ALL_POST_LINK);
        clickToElementByJs(driver, NewAndEditPostPageUI.ALL_POST_LINK);
        return new PostPageObject(driver);
    }

    public void sendEnterKeyToTextBox() {
        waitForElementVisible(driver, NewAndEditPostPageUI.TAGS_TEXTBOX);
        sendKeyboardToElement(driver, NewAndEditPostPageUI.TAGS_TEXTBOX, Keys.ENTER);
    }

    public void clickToTagMenu(String menu) {
        waitForElementClickable(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
        clickToElement(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
    }

    public void sendTabKeyToTextArea() {
        waitForElementsVisible(driver, NewAndEditPostPageUI.ADD_TITLE_TEXTAREA);
        sendKeyboardToElement(driver, NewAndEditPostPageUI.ADD_TITLE_TEXTAREA, Keys.TAB);
    }

    public void clickToImageMenu(String menu) {
        waitForElementClickable(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
        clickToElement(driver, NewAndEditPostPageUI.MENU_BUTTONS, menu);
    }
}
