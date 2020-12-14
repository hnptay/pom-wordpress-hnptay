package interfaces.pageUI_wordpress;

public class HomeUserPageUI {
    public static final String POST_TITLE = "//a[text()='%s']";
    public static final String POST_TIME = "//a[text()='%s']//ancestor::div[@class='entry-wrapper']//a[text()='Auto Test 01']//ancestor::div[@class='entry-wrapper']" +
            "//time[@class='entry-date published'  and contains(text(),'%s')]";
    public static final String PICTURE_SRC = "//a[text()='%s']//ancestor::div[@class='entry-wrapper']//preceding-sibling::figure//img";
}
