package actions.pageobject_wordpress;

import actions.commons.AbstractPage;
import interfaces.pageUI_wordpress.MediaPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MediaPageObject extends AbstractPage {
    WebDriver driver;

    public MediaPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNew() {
        waitForElementClickable(driver, MediaPageUI.ADD_NEW_BUTTON);
        clickToElement(driver, MediaPageUI.ADD_NEW_BUTTON);
    }

    public void uploadFiles(String... files) {
        uploadMultipleFiles(driver, MediaPageUI.UPLOAD_LOCATOR, files);
    }

    public boolean isFilesUploaded(String... files) {
        waitForElementsInvisible(driver, MediaPageUI.UPLOAD_PROCESS);
        sleepInSecond(2);
        List<WebElement> srcElements = findElementsByXpath(driver, MediaPageUI.UPLOADED_LINKS);
        List<String> srcFiles = new ArrayList<String>();
        int i = 0;
        for (WebElement srcElement : srcElements) {
            srcFiles.add(srcElement.getAttribute("src"));
            i++;
            if (i == files.length) break;
        }
        boolean status = false;
        for (String file : files) {
            String[] fileEdit = file.split("[.]");
            file = fileEdit[0];
            for (int j = 0; j < srcFiles.size(); j++) {
                if (!srcFiles.get(j).contains(file)) {
                    status = false;
                    if (j == srcFiles.size() - 1) return status;
                } else {
                    status = true;
                    break;
                }
            }
        }
        return status;
    }
}