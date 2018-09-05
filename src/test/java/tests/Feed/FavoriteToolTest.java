package tests.Feed;

import base.CentralAppContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.LoginPage;
import pages.Feed.FeedHomePage;
import pages.Feed.FeedToolsPage;
import pages.Feed.SearchResultsPage;
import pojos.LoginCredentials;
import utils.Logz;

@ContextConfiguration({ "classpath:LoginCredentialsData.xml"})
public class FavoriteToolTest extends CentralAppContext {
    private LoginPage<RemoteWebDriver> loginPage;
    private FeedHomePage feedHomePage;
    private FeedToolsPage feedToolsPage;
    private SearchResultsPage searchResultsPage;
    String url=System.getProperty("loggedCentralURL");

    @Autowired
    LoginCredentials FeedLogin;

    //TFS Id: 119678
    //TFS Description: C - List of Tools is in alphabetical order
    @Test
    public void verifyToolsInAlphabeticalOrder_119677_119678() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedToolsPage = feedHomePage.clickTools();
            feedHomePage = feedToolsPage.selectFavoriteTool();
            feedHomePage.verifyFavoritedListInOrder();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
}
