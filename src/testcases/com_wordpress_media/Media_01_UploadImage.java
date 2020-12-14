package testcases.com_wordpress_media;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Media_01_UploadImage  {

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", ".\\browserDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void TC_01(){
        driver.get("http://jqueryui.com/resources/demos/selectmenu/default.html");
        selectItemCustomDropDown("//span[@id='number-button']");
        sleepInSecond(3);
    }

    public void selectItemCustomDropDown(String parentLocator){
        element = driver.findElement(By.xpath(parentLocator));
        js = (JavascriptExecutor)driver;
        if(element.isDisplayed()){
            element.click();
        } //else if(element.isDisplayed()){
            //js.executeScript("arguments[0].click();",element);
       // }

    }

    public void sleepInSecond(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private WebDriver driver;
    private WebElement element;
    private JavascriptExecutor js;
}
