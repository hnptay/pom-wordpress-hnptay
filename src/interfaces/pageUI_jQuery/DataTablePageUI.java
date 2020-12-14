package interfaces.pageUI_jQuery;

public class DataTablePageUI {
    public static final String DYNAMIC_COLUMN = "//div[contains(text(),'%s')]//parent::div//following-sibling::input";
    public static final String DYNAMIC_ROW = "//tr[not(contains(@style,'none'))]//td[@data-key='%s']";
    public static final String DYNAMIC_PAGE = "//li[@class='qgrd-pagination-page']//a[(text()='%s')]";
    public static final String DYNAMIC_ACTIONS = "//td[@data-key='%s' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,'%s')]";
    public static final String DYNAMIC_PAGE_VERIFY = "//li[@class='qgrd-pagination-page']//a[contains(@class,'active') and (text()='%s')]";
    public static final String DYNAMIC_COLUMN_INDEX = "//th[contains(text(),'%s')]//preceding-sibling::th";
    public static final String DYNAMIC_TEXT_BOX = "//tr[%s]//td[%s]/input";
    public static final String DYNAMIC_ACTION_TABLE = "//tr[%s]//button[contains(@id,'%s')]";
}
