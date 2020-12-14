package interfaces.pageUI_wordpress;

public class PostPageUI {
    public static final String ADD_NEW_BUTTON = "//span[@id='split-page-title-action']//a[contains(text(),'Add New')]";
    public static final String SEARCH_TEXTBOX = "//input[@id='post-search-input']";
    public static final String SEARCH_BUTTON = "//input[@id='search-submit']";
    public static final String LISTS_POST = "//tbody[@id='the-list']/tr";
    public static final String DYNAMIC_ROW_COLUMN = "//td[@data-colname='Title']//a[text()='%s']" +
            "//ancestor::tr//td[@data-colname='Author']//a[text()='%s']" +
            "//ancestor::tr//td[@data-colname='Categories']//a[text()='%s']" +
            "//ancestor::tr//td[@data-colname='Tags']//a[text()='%s']";
}
