package testcases.com_saucelab_sort;

import actions.browserfactory.DriverManager;
import org.openqa.selenium.WebDriver;

public class test321 extends DriverManager {
    @Override
    protected void createDriver() {

    }

    public void printDriver(){
        WebDriver driver2 = getDriver2();
        System.out.println(driver2.toString());
    }

}
