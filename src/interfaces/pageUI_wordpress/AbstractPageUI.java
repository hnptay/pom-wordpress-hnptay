package interfaces.pageUI_wordpress;

public class AbstractPageUI {
    public static final String DASHBOARD_MENU = "//div[contains(@class,'dashicons-dashboard')]";
    public static final String MEDIA_MENU = "//div[contains(@class,'dashicons-admin-media')]";
    public static final String POST_MENU = "//div[contains(@class,'dashicons-admin-post')]";
    public static final String LINK_MENU = "//div[contains(@class,'dashicons-admin-links')]";
    public static final String DYNAMIC_PAGE_LINK = "//div[contains(text(),'%s')]//preceding-sibling::div[contains(@class,'image')]";
}
