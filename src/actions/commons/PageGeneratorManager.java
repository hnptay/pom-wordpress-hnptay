package actions.commons;

import actions.pageobject_wordpress.*;
import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static ReadPageObject getReadPage(WebDriver driver){
        return new ReadPageObject(driver);
    }

    public static PostPageObject getPostPage(WebDriver driver){
        return new PostPageObject(driver);
    }

    public static DashBoardPageObject getDashBoardPage(WebDriver driver){
        return new DashBoardPageObject(driver);
    }

    public static MediaPageObject getMediaPage(WebDriver driver){
        return new MediaPageObject(driver);
    }

    public static LinkPageObject getLinkPage(WebDriver driver){
        return new LinkPageObject(driver);
    }

    public static HomePageObject getHomePage(WebDriver driver){
        return new HomePageObject(driver);
    }
}
