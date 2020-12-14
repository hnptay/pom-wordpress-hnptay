package testcases.com_wordpress_posts;

import actions.browserfactory.DriverFactory;
import actions.browserfactory.DriverManager;
import actions.commons.AbstractTest;
import actions.commons.GlobalConstants;
import actions.commons.PageGeneratorManager;
import actions.pageobject_wordpress.*;
import actions.pageobject_wordpress.PostDetailPageObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Post_01_NewAndViewPost extends AbstractTest {
    @Parameters("browser")
    @BeforeClass
    public void beforeClass(String browserName) {
        DriverManager driverManager = DriverFactory.getBrowserManager(browserName);
        driver = driverManager.getDriver(GlobalConstants.WORDPRESS_URL);
        loginPage = PageGeneratorManager.getLoginPage(driver);
        loginPage.inputToEmailTextbox(GlobalConstants.WORDPRESS_USER);
        loginPage.clickToContinueButton();
        loginPage.inputToPasswordTextbox(GlobalConstants.WORDPRESS_PASSWORD);
        homePage = loginPage.clickToLoginButton();
        dashBoardPage = homePage.clickToWPAdminMenu();
        dashBoardPage.switchToDashBoardWindow(dashBoardPage.getPageTitle(driver));
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserAndDriver(driver);
    }

    @Test
    public void Post_01_createNewPost() {
        postPage = (PostPageObject) dashBoardPage.selectPageMenu(driver, "Post");
        newAndEditPostPage = postPage.clickToAddNewButton();
        newAndEditPostPage.inputToTitle(title + " " + tag);
        newAndEditPostPage.sendTabKeyToTextArea();
        newAndEditPostPage.inputToContent(content);
        newAndEditPostPage.clickToPostOption("Post");
        newAndEditPostPage.clickToMenu("Categories");
        newAndEditPostPage.selectCheckBox(category);
        newAndEditPostPage.clickToTagMenu("Tags");
        newAndEditPostPage.inputToTagsTextBox(tag);
        newAndEditPostPage.sendEnterKeyToTextBox();
        newAndEditPostPage.clickToImageMenu("Featured image");
        newAndEditPostPage.clickSelectImage("Select Image");
        newAndEditPostPage.selectMenuButton("Media Library");
        newAndEditPostPage.selectImage("1");
        newAndEditPostPage.clickSetImage();
        newAndEditPostPage.clickToPublicButton("Publish");
        newAndEditPostPage.confirmPublic();
        verifyTrue(newAndEditPostPage.isSuccessMessageDisplayed("Post published."));
        newAndEditPostPage.clickToWordPressIcon();
        postPage = newAndEditPostPage.clickToAllPost();
        postPage.inputToSearchTextBox(title + " " + tag);
        postPage.clickToSearchButton();
        verifyTrue(postPage.isOnlyOnceRowDisplayed(title, author, category, tag));
        homeUserPage = postPage.openEndUserPage();
        verifyTrue(homeUserPage.isPostImageDisplayed(title, imageName));
        verifyTrue(homeUserPage.isPostDisplayedOnLatestPost(title, dateNow));
        postDetailPage = homeUserPage.clickToPostDetailWithTitle(title);
        verifyTrue(postDetailPage.isCategoryNameDisplayed(category));
        verifyTrue(postDetailPage.isTitleNameDisplayed(title));
        verifyTrue(postDetailPage.isImageNameDisplayed(imageName));
        verifyTrue(postDetailPage.isDateCreateDisplayed(dateNow));
        verifyTrue(postDetailPage.isAuthorDisplayed(author));
        verifyTrue(postDetailPage.isTagsDisplayed(tag));
    }

    @Test
    public void Post_02_editPost() {
//        dashBoardPage = postDetailPage.openAdminLoggedPage();
//        postPage = (PostPageObject) dashBoardPage.selectPageMenu(driver, "Post");
//        postPage.inputToSearchTextBox("");
//        postPage.clickToSearchButton();
//        verifyTrue(postPage.isOnlyOnceRowDisplayed("title", "author", "category", "tag"));
//        newAndEditPostPage = postPage.clickToPostDetailByTitle("title");
//        newAndEditPostPage.inputToTitle("");
//        newAndEditPostPage.inputToContent("");
//        newAndEditPostPage.clickToPostOption("Post");
//        newAndEditPostPage.UnselectCategory();
//        newAndEditPostPage.inputToTagsTextBox(tag);
//        newAndEditPostPage.clickToReplaceImage();
//        newAndEditPostPage.selectImage("1");
//        newAndEditPostPage.clickSetImage();
//        newAndEditPostPage.clickToUpdateButton();
//        verifyTrue(newAndEditPostPage.isSuccessMessageDisplayed("Post updated"));
//        newAndEditPostPage.clickToWordPressIcon();
//        postPage = newAndEditPostPage.clickToAllPost();
//        postPage.inputToSearchTextBox("");
//        postPage.clickToSearchButton();
//        verifyTrue(postPage.isOnlyOnceRowDisplayed("edit_title", "author", "edit_category", "edit_tag"));
//        homeUserPage = postPage.openEndUserPage();
//        verifyTrue(homeUserPage.isPostImageDisplayed("edit_title", "edit_image.name"));
//        verifyTrue(homeUserPage.isNewPostDisplayedOnLatestPost("category", "title", "dateNow"));
//        postDetailPage = homeUserPage.clickToPostDetailWithTitle("edit_title");
//        verifyTrue(postDetailPage.isCategoryNameDisplayed("edit_category"));
//        verifyTrue(postDetailPage.isTitleNameDisplayed("edit_title"));
//        verifyTrue(postDetailPage.isImageNameDisplayed("edit_image.name"));
//        verifyTrue(postDetailPage.isDateCreateDisplayed("date"));
//        verifyTrue(postDetailPage.isAuthorDisplayed("author"));
    }

    @Test
    public void Post_03_deletePost() {
//        dashBoardPage = postDetailPage.openAdminLoggedPage();
//        postPage = (PostPageObject) dashBoardPage.selectPageMenu(driver, "Post");
//        postPage.inputToSearchTextBox("");
//        postPage.clickToSearchButton();
//        verifyTrue(postPage.isOnlyOnceRowDisplayed("edit_title", "author", "edit_category", "edit_tag"));
//        postPage.hoverMouseToPostByTitle("edit_tite");
//        postPage.clickToTrashMenu();
//        verifyTrue(postPage.isSuccessMessageDispayed(""));
//        postPage.inputToSearchTextBox("");
//        postPage.clickToSearchButton();
//        verifyFalse(postPage.isOnlyOnceRowDisplayed("edit_title", "author", "edit_category", "edit_tag"));
//        verifyTrue(postPage.isNotFoundMessageDisplayed("No posts found."));
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private HomePageObject homePage;
    private DashBoardPageObject dashBoardPage;
    private PostPageObject postPage;
    private NewAndEditPostPageObject newAndEditPostPage;
    private HomeUserPageObject homeUserPage;
    private PostDetailPageObject postDetailPage;
    private String tag = randomNumber(99999) + "";
    private String title = "Live Coding";
    private String content = "This is content.";
    private String category = "CN Animation 3D";
    private String author = "bananainf";
    private String imageName = "mdt2";
    private String dateNow = dateTimeCustomFormat();
}
