package actions.pagefactory_bankguru;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePageObject extends AbstractPage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//marquee[contains(text(),\"Welcome To Manager's Page of Guru99 Bank\")]")
    WebElement welcomeMessage;

    public boolean isWelcomeMessageDisplayed() {
        return isElementDisplayed(driver, welcomeMessage);
    }
}
