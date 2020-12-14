package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import actions.commons.GlobalConstants;
import interfaces.pageUI_wordpress.PostPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostPageObject extends AbstractPage {
    private WebDriver driver;

    public PostPageObject (WebDriver driver){
        this.driver = driver;
    }

    public HomeUserPageObject openEndUserPage(){
        openUrl(driver, GlobalConstants.WORDPRESS_USER_PAGE_URL);
        return new HomeUserPageObject(driver);
    }

    public NewAndEditPostPageObject clickToAddNewButton() {
        waitForElementClickable(driver, PostPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, PostPageUI.ADD_NEW_BUTTON);
        return new NewAndEditPostPageObject(driver);
    }

    public void inputToSearchTextBox(String value) {
        waitForElementVisible(driver, PostPageUI.SEARCH_TEXTBOX);
        sendKeyToElement(driver, PostPageUI.SEARCH_TEXTBOX, value);
    }

    public void clickToSearchButton() {
        waitForElementClickable(driver, PostPageUI.SEARCH_BUTTON);
        clickToElement(driver, PostPageUI.SEARCH_BUTTON);
    }

    public boolean isOnlyOnceRowDisplayed(String title, String author, String category, String tag) {
        waitForElementsVisible(driver, PostPageUI.LISTS_POST);
        List<WebElement> allPost = findElementsByXpath(driver, PostPageUI.LISTS_POST);
        if(allPost.size()!= 1) return false;
        waitForElementsVisible(driver, PostPageUI.DYNAMIC_ROW_COLUMN, title, author, category, tag);
        return isElementDisplay(driver, PostPageUI.DYNAMIC_ROW_COLUMN, title, author, category, tag);
    }
}
