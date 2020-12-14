package interfaces.pageUI_wordpress;

public class NewAndEditPostPageUI {
    public static final String ADD_TITLE_TEXTAREA = "//textarea[@id='post-title-0']";
    public static final String ADD_CONTENT_BLOCK = "//p[@role='group']";
    public static final String EDIT_OPTION = "//button[@data-label='%s']";
    public static final String CHECKBOXES = "//label[text()='%s']//preceding-sibling::span/input";
    public static final String TAGS_TEXTBOX = "//div[@class='components-form-token-field']//input";
    public static final String MENU_BUTTONS = "//button[contains(text(),'%s')]";
    public static final String BUTTONS = "//button//span[contains(text(),'%s')]";
    public static final String IMAGES = "//ul[@tabindex='-1']//li[%s]";
    public static final String SET_IMAGE_BUTTON = "//button[contains(@class,'media-button-select') and contains(text(),'Set featured image')]";
    public static final String CONFIRM_PUBLISH_BUTTON = "//div[contains(@class,'publish-button')]//button[contains(text(),'Publish')]";
    public static final String PUBLISH_ICON = "//div[@class='editor-post-publish-panel__content']/span";
    public static final String MESSAGE_INFO = "//div[@class='components-snackbar__content' and contains(text(),'%s')]";
    public static final String WORDPRESS_BUTTON = "//button[@aria-haspopup='dialog']";
    public static final String ALL_POST_LINK = "//h2[contains(text(),'Posts')]//preceding-sibling::a";
}
