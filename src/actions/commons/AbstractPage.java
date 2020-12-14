package actions.commons;

import actions.pageobject_wordpress.DashBoardPageObject;
import actions.pageobject_wordpress.LinkPageObject;
import actions.pageobject_wordpress.MediaPageObject;
import actions.pageobject_wordpress.PostPageObject;
import interfaces.pageUI_bankGuru.AbstractGuruPageUI;
import interfaces.pageUI_wordpress.AbstractPageUI;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testcases.com_wordpress_login.Login_07_WebDriverLifeCycle_SwitchPage;

import javax.print.DocFlavor;
import java.util.*;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    //WebBrowser
    public void openUrl(WebDriver driver, String urlValue) {
        driver.get(urlValue);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void back(WebDriver driver) {
        driver.navigate().back();
    }

    public void forward(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refresh(WebDriver driver) {
        driver.navigate().refresh();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    //Alert
    public void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    public void sendKeyToAlert(WebDriver driver, String value) {
        driver.switchTo().alert().sendKeys(value);
    }

    public String getTextInAlert(WebDriver driver) {
        return driver.switchTo().alert().getText();
    }

    public void waitForAlertPresence(WebDriver driver) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // WebDriverWait
    public void waitForElementVisible(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... values) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(castToObject(locator, values))));
    }

    public void waitForElementsVisible(WebDriver driver, String locator){
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElements(findElementsByXpath(driver, locator)));
    }

    public void waitForElementsVisible(WebDriver driver, String locator, String...values){
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.visibilityOfAllElements(findElementsByXpath(driver, castToObject(locator, values))));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
    }

    public void waitForElementsInvisible(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfAllElements(findElementsByXpath(driver, locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(castToObject(locator, values))));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
    }

    public void waitForElementPresence(WebDriver driver, String locator, String... values) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.presenceOfElementLocated(byXpath(castToObject(locator, values))));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... values) {
        wait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
        wait.until(ExpectedConditions.elementToBeClickable(byXpath(castToObject(locator, values))));
    }

    //Windows
    public String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowsHandle(WebDriver driver) {
        return driver.getWindowHandles();
    }

    public void switchToWindowByID(WebDriver driver, String parentWindow) {
        Set<String> allWin = driver.getWindowHandles();
        for (String runWin : allWin) {
            if (!runWin.equals(parentWindow)) {
                driver.switchTo().window(runWin);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String Title) {
        Set<String> allWin = driver.getWindowHandles();
        for (String runWin : allWin) {
            driver.switchTo().window(runWin);
            String currentWin = driver.getTitle();
            if (runWin.equals(currentWin)) {
                break;
            }
        }
    }

    public boolean areAllSubWindowsClose(WebDriver driver, String parentWindow) {
        Set<String> allWin = driver.getWindowHandles();
        for (String runWin : allWin) {
            if (!runWin.equals(parentWindow)) {
                driver.switchTo().window(runWin);
                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        if (driver.getWindowHandles().size() == 1) {
            return true;
        }
        return false;
    }

    public void sleepInSecond(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //WebElement
    public By byXpath(String locator) {
        return By.xpath(locator);
    }

    public String castToObject(String locator, String... values) {
        return String.format(locator, (Object[]) values);
    }

    public WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(byXpath(locator));
    }

    public List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(byXpath(locator));
    }

    public void clickToElement(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... values) {
        findElementByXpath(driver, castToObject(locator, values)).click();
    }

    public String getElementText(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).getText();
    }

    public String getElementText(WebDriver driver, String locator, String... values) {
        return findElementByXpath(driver, castToObject(locator, values)).getText();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value) {
        element = findElementByXpath(driver, locator);
        element.clear();
        element.sendKeys(value);
    }

    public void sendKeyToElement(WebDriver driver, String locator, String value, String... values) {
        element = findElementByXpath(driver, castToObject(locator, values));
        element.clear();
        element.sendKeys(value);
    }

    public void clearKeyInElement(WebDriver driver, String locator) {
        findElementByXpath(driver, locator).clear();
    }

    public void clearKeyInElement(WebDriver driver, String locator, String... values) {
        findElementByXpath(driver, castToObject(locator, values)).clear();
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value) {
        select = new Select(findElementByXpath(driver, locator));
        select.selectByVisibleText(value);
    }

    public String getSelectedItemInDropdown(WebDriver driver, String locator) {
        select = new Select(findElementByXpath(driver, locator));
        return select.getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        select = new Select(findElementByXpath(driver, locator));
        return select.isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String allItemLocator, String expectedItem) {
        js = (JavascriptExecutor) driver;
        clickToElement(driver, parentLocator);
        sleepInSecond(1);
        List<WebElement> allItem = findElementsByXpath(driver, allItemLocator);
        for (WebElement currentItem : allItem) {
            if (currentItem.getText().equals(expectedItem)) {
                if (currentItem.isDisplayed()) {
                    currentItem.click();
                } else {
                    js.executeScript("arguments[0].scrollIntoView();", currentItem);
                    sleepInSecond(1);
                    js.executeScript("arguments[0].click();", currentItem);
                }
                sleepInSecond(1);
                break;
            }
        }
    }

    public void selectMultipleItemInCustomDropDown(WebDriver driver, String locator, String allItemLocator, String allItemSelectedLocator, String[] expectedItems) {
        js = (JavascriptExecutor) driver;
        clickToElement(driver, locator);
        sleepInSecond(1);
        List<WebElement> allItem = findElementsByXpath(driver, allItemLocator);
        for (WebElement currentItem : allItem) {
            for (String expectedItem : expectedItems) {
                if (currentItem.getText().equals(expectedItem)) {
                    if (currentItem.isDisplayed()) {
                        currentItem.click();
                    } else {
                        js.executeScript("arguments[0].scrollIntoView();", currentItem);
                        sleepInSecond(1);
                        js.executeScript("argument[0].click();", currentItem);
                    }
                }
            }
            List<WebElement> allItemSelected = findElementsByXpath(driver, allItemSelectedLocator);
            if (allItemSelected.size() == expectedItems.length) {
                break;
            }
        }
    }

    public boolean checkItemSelectedInCustomDropDown(WebDriver driver, String allItemSelectedLocator, String[] expectedItems) {
        js = (JavascriptExecutor) driver;
        int numberOfItem = 0;
        List<WebElement> allItemSelected = findElementsByXpath(driver, allItemSelectedLocator);
        for (WebElement itemSelected : allItemSelected) {
            for (String expectedItem : expectedItems) {
                if (itemSelected.getText().contains(expectedItem)) {
                    numberOfItem++;
                } else if (js.executeScript("arguments[0].textContent();", itemSelected).equals(expectedItem)) {
                    numberOfItem++;
                }
            }
        }
        if (numberOfItem == expectedItems.length) {
            return true;
        }
        return false;
    }

    public String getTextByJs(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].textContent();", findElementByXpath(driver, locator)).toString();
    }

    public int countElementNumber(WebDriver driver, String locator) {
        return findElementsByXpath(driver, locator).size();
    }

    public int countElementNumber(WebDriver driver, String locator, String... values) {
        return findElementsByXpath(driver, castToObject(locator, values)).size();
    }

    public String getAttributeValue(WebDriver driver, String locator, String ID) {
        return findElementByXpath(driver, locator).getAttribute(ID);
    }

    public String getAttributeValue(WebDriver driver, String locator, String ID, String...values) {
        return findElementByXpath(driver, castToObject(locator, values)).getAttribute(ID);
    }

    public void checkTheCheckbox(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void unCheckTheCheckbox(WebDriver driver, String locator) {
        element = findElementByXpath(driver, locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locator) {
        try {
            return findElementByXpath(driver, locator).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementDisplay(WebDriver driver, String locator, String... values) {
        try {
            return findElementByXpath(driver, castToObject(locator, values)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isElementSelected(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isSelected();
    }

    public boolean isElementEnable(WebDriver driver, String locator) {
        return findElementByXpath(driver, locator).isEnabled();
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = findElementsByXpath(driver, locator);
        if (elements.size() == 0) {
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
            return true;
        } else {
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
            return false;
        }
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator, String... values) {
        overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
        List<WebElement> elements = findElementsByXpath(driver, castToObject(locator, values));
        if (elements.size() == 0) {
            overrideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
            return true;
        } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
            return true;
        } else {
            overrideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
            return false;
        }
    }

    //Frame Iframe
    public void switchToFrameOrIframe(WebDriver driver, String locator) {
        driver.switchTo().frame(findElementByXpath(driver, locator));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //Actions
    public void hoverMouseToElement(WebDriver driver, String locator) {
        actions = new Actions(driver);
        actions.moveToElement(findElementByXpath(driver, locator)).perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        actions = new Actions(driver);
        actions.doubleClick(findElementByXpath(driver, locator)).perform();
    }

    public void rightClick(WebDriver driver, String locator) {
        actions = new Actions(driver);
        actions.contextClick(findElementByXpath(driver, locator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keys) {
        actions = new Actions(driver);
        element = findElementByXpath(driver, locator);
        actions.sendKeys(element, keys).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keys, String... values) {
        actions = new Actions(driver);
        element = findElementByXpath(driver, castToObject(locator, values));
        actions.sendKeys(element, keys).perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        actions = new Actions(driver);
        WebElement from = findElementByXpath(driver, sourceLocator);
        WebElement to = findElementByXpath(driver, targetLocator);
        actions.dragAndDrop(from, to).build().perform();
    }

    //JavascriptExecutor
    public void clickToElementByJs(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        js.executeScript("arguments[0].click();", element);
    }

    public Object executeForBrowser(WebDriver driver, String javaScript) {
        js = (JavascriptExecutor) driver;
        return js.executeScript(javaScript);
    }

    public boolean verifyInnerText(WebDriver driver, String expectedText) {
        js = (JavascriptExecutor) driver;
        String actualText = (String) js.executeScript(
                "return document.documentElement.innerText.match('" + expectedText + "')[0]");
        return actualText.equals(expectedText);
    }

    public void scrollIntoView(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void highlightElement(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
                element, "style", "border: 5px solid red; border-style: dashed;");
        sleepInSecond(1);
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])",
                element, "style", originalStyle);
    }

    public void sendKeyToElementByJs(WebDriver driver, String locator, String value) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        js.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "')", element);
    }

    public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove, String...values) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, castToObject(locator, values));
        js.executeScript("arguments[0].removeAttribute('" + attributeRemove + "')", element);
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        js = (JavascriptExecutor) driver;
        element = findElementByXpath(driver, locator);
        boolean status = (boolean) js.executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", element);
        if (status == true) {
            return true;
        } else {
            return false;
        }
    }

    public void uploadMultipleFiles(WebDriver driver, String locator, String... fileNames) {
        String allFiles = "";
        for (String file : fileNames) {
            allFiles += GlobalConstants.UPLOAD_FOLDER + file + "\n";
        }
        allFiles = allFiles.trim();
        sendKeyToElement(driver, locator, allFiles);
    }

    /* Open common Pages */
    public DashBoardPageObject clickToDashBoardMenu(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.DASHBOARD_MENU);
        clickToElement(driver, AbstractPageUI.DASHBOARD_MENU);
        return PageGeneratorManager.getDashBoardPage(driver);
    }

    public MediaPageObject clickToMediaMenu(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.MEDIA_MENU);
        clickToElement(driver, AbstractPageUI.MEDIA_MENU);
        return PageGeneratorManager.getMediaPage(driver);
    }

    public PostPageObject clickToPostMenu(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.POST_MENU);
        clickToElement(driver, AbstractPageUI.POST_MENU);
        return PageGeneratorManager.getPostPage(driver);
    }

    public LinkPageObject clickToLinkMenu(WebDriver driver) {
        waitForElementClickable(driver, AbstractPageUI.LINK_MENU);
        clickToElement(driver, AbstractPageUI.LINK_MENU);
        return PageGeneratorManager.getLinkPage(driver);
    }

    //Dynamic Page: Apply cho app it page(10-20 pages):
    public AbstractPage selectPageMenu(WebDriver driver, String pageName) {
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
        clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
        switch (pageName) {
            case "Media":
                return PageGeneratorManager.getMediaPage(driver);
            case "Post":
                return PageGeneratorManager.getPostPage(driver);
            case "Link":
                return PageGeneratorManager.getLinkPage(driver);
            default:
                return PageGeneratorManager.getDashBoardPage(driver);
        }
    }

    //Dynamic Page: Apply more than 20 page:
    public void selectPageMenus(WebDriver driver, String pageName) {
        waitForElementClickable(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
        clickToElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
    }

    /* BankGuru Dynamic Page Component */
    public void inputToDynamicTextBox(WebDriver driver, String value, String...values){
        waitForElementVisible(driver, AbstractGuruPageUI.DYNAMIC_TEXTBOX, values);
        sendKeyToElement(driver, AbstractGuruPageUI.DYNAMIC_TEXTBOX, value, values);
    }

    public void inputToDynamicTextarea(WebDriver driver, String value, String...values){
        waitForElementVisible(driver, AbstractGuruPageUI.DYNAMIC_TEXTREA, values);
        sendKeyToElement(driver, AbstractGuruPageUI.DYNAMIC_TEXTREA, value, values);
    }

    public void clickToDynamicRadioButton(WebDriver driver, String...values){
        waitForElementClickable(driver, AbstractGuruPageUI.DYNAMIC_RADIO_BUTTON, values);
        clickToElement(driver, AbstractGuruPageUI.DYNAMIC_RADIO_BUTTON, values);
    }

    public void clickToDynamicButton(WebDriver driver, String...values){
        waitForElementClickable(driver, AbstractGuruPageUI.DYNAMIC_BUTTON, values);
        clickToElement(driver, AbstractGuruPageUI.DYNAMIC_BUTTON, values);
    }

    public void clickToDynamicMenuLink(WebDriver driver, String...values){
        waitForElementClickable(driver, AbstractGuruPageUI.DYNAMIC_MENU_LINK, values);
        clickToElement(driver, AbstractGuruPageUI.DYNAMIC_MENU_LINK, values);
    }

    public boolean isInfoMessageDisplayed(WebDriver driver, String...values){
        waitForElementVisible(driver, AbstractGuruPageUI.DYNAMIC_MESSAGE, values);
        return isElementDisplay(driver, AbstractGuruPageUI.DYNAMIC_MESSAGE, values);
    }

    public String getDynamicColumnValue(WebDriver driver, String...values){
        waitForElementVisible(driver, AbstractGuruPageUI.DYNAMIC_VALUE_COLUMNNAME, values);
        return getElementText(driver, AbstractGuruPageUI.DYNAMIC_VALUE_COLUMNNAME, values);
    }

    public boolean isDataSortAscending(WebDriver driver, String locator){
        ArrayList<String> listData = new ArrayList<>();
        List<WebElement> allElement = findElementsByXpath(driver, locator);
        for(WebElement element:allElement) listData.add(element.getText());
        ArrayList<String> sortData = new ArrayList<>(listData);
        Collections.sort(sortData);
        return listData.equals(sortData);
    }

    public boolean isDataSortDescending(WebDriver driver, String locator){
        ArrayList<String> listData = new ArrayList<>();
        List<WebElement> allElement = findElementsByXpath(driver, locator);
        for(WebElement element:allElement) listData.add(element.getText());
        ArrayList<String> sortData = new ArrayList<>(listData);
        Collections.sort(sortData);
        Collections.reverse(sortData);
        return listData.equals(sortData);
    }

    public boolean isPriceSortAscending(WebDriver driver, String locator){
        ArrayList<Float> listPrice = new ArrayList<>();
        List<WebElement> allElement = findElementsByXpath(driver, locator);
        for(WebElement element:allElement){
            listPrice.add(Float.parseFloat(element.getText().trim().replace("$", "")));
        }
        System.out.println("---------------UI-----------------");
        for(Float price:listPrice){
            System.out.println(price);
        }
        ArrayList<Float> sortPrice = new ArrayList<>(listPrice);
        Collections.sort(sortPrice);
        System.out.println("---------------nonUI---------------");
        for(Float price:sortPrice){
            System.out.println(price);
        }
        return listPrice.equals(sortPrice);
    }

    public boolean isPriceSortDescending(WebDriver driver, String locator){
        ArrayList<Float> listPrice = new ArrayList<>();
        List<WebElement> allElement = findElementsByXpath(driver, locator);
        for(WebElement element:allElement){
            listPrice.add(Float.parseFloat(element.getText().trim().replace("$", "")));
        }
        System.out.println("---------------UI-----------------");
        for(Float price:listPrice){
            System.out.println(price);
        }
        ArrayList<Float> sortPrice = new ArrayList<>(listPrice);
        Collections.sort(sortPrice);
        Collections.reverse(sortPrice);
        System.out.println("---------------nonUI---------------");
        for(Float price:sortPrice){
            System.out.println(price);
        }
        return listPrice.equals(sortPrice);
    }


    private Select select;
    private JavascriptExecutor js;
    private WebDriverWait wait;
    private WebElement element;
    private Actions actions;
}
