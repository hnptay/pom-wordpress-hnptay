package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.HomeUserPageUI;
import org.openqa.selenium.WebDriver;

public class HomeUserPageObject extends AbstractPage {
    WebDriver driver;

    public HomeUserPageObject(WebDriver driver){
        this.driver = driver;
    }

    public boolean isPostImageDisplayed(String title, String imageName) {
        waitForElementVisible(driver, HomeUserPageUI.PICTURE_SRC, title);
        String src = getAttributeValue(driver, HomeUserPageUI.PICTURE_SRC, imageName, title);
        if(!src.contains(imageName)) return false;
        return isElementDisplay(driver, HomeUserPageUI.PICTURE_SRC, title);
    }

    public boolean isPostDisplayedOnLatestPost(String title, String dateCreate) {
        waitForElementVisible(driver, HomeUserPageUI.POST_TIME, title, dateCreate);
        return isElementDisplay(driver, HomeUserPageUI.POST_TIME, title, dateCreate);
    }

    public PostDetailPageObject clickToPostDetailWithTitle(String title) {
        waitForElementClickable(driver, HomeUserPageUI.POST_TITLE, title);
        clickToElement(driver, HomeUserPageUI.POST_TITLE, title);
        return new PostDetailPageObject(driver);
    }
}
