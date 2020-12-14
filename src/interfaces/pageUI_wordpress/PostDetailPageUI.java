package interfaces.pageUI_wordpress;

public class PostDetailPageUI {
    public static final String DYNAMIC_LINK = "//footer//a[contains(text(),'%s')]";
    public static final String TIME_LINK = "//footer//time[@class='entry-date published' and contains(text(),'%s')]";
    public static final String TITLE = "//h1[@class='entry-title' and contains(text(),'%s')]";
    public static final String POST_PICTURE = "//figure[@class='post-thumbnail']//img";
}
