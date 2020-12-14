package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.PostDetailPageUI;
import org.openqa.selenium.WebDriver;

public class PostDetailPageObject extends AbstractPage {
    public PostDetailPageObject(WebDriver driver){
        this.driver = driver;
    }

    private WebDriver driver;

    public boolean isCategoryNameDisplayed(String category) {
        waitForElementVisible(driver, PostDetailPageUI.DYNAMIC_LINK, category);
        return isElementDisplay(driver, PostDetailPageUI.DYNAMIC_LINK, category);
    }

    public boolean isTitleNameDisplayed(String title) {
        waitForElementVisible(driver, PostDetailPageUI.TITLE, title);
        return isElementDisplay(driver, PostDetailPageUI.TITLE, title);
    }

    public boolean isImageNameDisplayed(String imageName) {
        waitForElementVisible(driver, PostDetailPageUI.POST_PICTURE);
        String src = getAttributeValue(driver, PostDetailPageUI.POST_PICTURE, "src");
        if(!src.contains(imageName)) return false;
        return isElementDisplay(driver, PostDetailPageUI.POST_PICTURE);
    }

    public boolean isDateCreateDisplayed(String dateNow) {
        waitForElementVisible(driver, PostDetailPageUI.TIME_LINK, dateNow);
        return isElementDisplay(driver, PostDetailPageUI.TIME_LINK, dateNow);
    }

    public boolean isAuthorDisplayed(String author) {
        waitForElementVisible(driver, PostDetailPageUI.DYNAMIC_LINK, author);
        return isElementDisplay(driver, PostDetailPageUI.DYNAMIC_LINK, author);
    }

    public boolean isTagsDisplayed(String tag) {
        waitForElementVisible(driver, PostDetailPageUI.DYNAMIC_LINK, tag);
        return isElementDisplay(driver, PostDetailPageUI.DYNAMIC_LINK, tag);
    }
}
