package actions.pageobject_jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
    public static DataTablePageObject getDataTablePage(WebDriver driver){
        return new DataTablePageObject(driver);
    }
}
