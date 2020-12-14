package actions.pagefactory_wordpress;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static ReadPageObject getReadPage(WebDriver driver){
        return new ReadPageObject(driver);
    }
}
