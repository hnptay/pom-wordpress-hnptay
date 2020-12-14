package actions.pagefactory_wordpress;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReadPageObject extends AbstractPage{
    WebDriver driver;

    public ReadPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Reader')]")
    WebElement readHeader;

    public boolean isReadHeaderDisplayed(){
        return isElementDisplayed(driver, readHeader);
    }
}
