package tests.Feed;

import base.CentralAppContext;
import base.test.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.Content.DraftPage;
import pages.AuthoringCenter.Distributions.DistributionApprovedPage;
import pages.AuthoringCenter.LoginPage;
import pages.CommonMethodsPage;
import pages.Feed.FeedArticlePage;
import pages.Feed.FeedHomePage;
import pages.Feed.ProfileSettingsPage;
import pages.Feed.SearchResultsPage;
import pojos.AuthoringContent;
import pojos.LoginCredentials;
import utils.Logz;


@ContextConfiguration({ "classpath:LoginCredentialsData.xml", "classpath:AuthoringContentData.xml"})
public class ViewBookMarkedItemsTest  extends CentralAppContext{
    private LoginPage<RemoteWebDriver> loginPage;
    private FeedHomePage feedHomePage;
    private SearchResultsPage searchResultsPage;
    private DraftPage draftPage;
    private CommonMethodsPage commonMethodsPage;
    private FeedArticlePage feedArticlePage;

    @Autowired
    LoginCredentials FeedLogin;
    @Autowired
    LoginCredentials AdAgencyContactLogin;
    @Autowired
    LoginCredentials ContentApproverLogin;
    @Autowired
    AuthoringContent authoringContentTestData;


    //TFS Id:152148
    //TFS Description: C - Bookmark a document on the home page Search Results
    @Test
    public void verifyBookmarkedDocument_152148_152385() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForAnItem(BaseTest.getStringfromBundleFile("sub"));
            feedHomePage = searchResultsPage.verifySearchResultsForDocument(BaseTest.getStringfromBundleFile("document"));
            feedHomePage.verifyBookmarkItem();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:152140
    //TFS Description: C - Bookmark a document on the home page Right Rail
    @Test
    public void verifyBookmarkedRightRailDocument_152140() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.verifyDocumentOnRightTrail();
            feedHomePage = searchResultsPage.verifyDetailsForRightTrailDocument();
            feedHomePage.verifyBookmarkItem();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:115182
    //TFS Description: F - View Bookmark List Most Frequent
    @Test
    public void verifyBookmarkList_115182() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyBookmarkList();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:161023
    //TFS Description: Feed - Verify authenticated user is able to see the number of results configured for the news feed
    @Test
    public void verifyNumberOfResultsConfiguredInFeed_161023() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForAnItem(BaseTest.getStringfromBundleFile("sub"));
            searchResultsPage.verifyNumberOfResultsConfiguredInFeed();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
}
