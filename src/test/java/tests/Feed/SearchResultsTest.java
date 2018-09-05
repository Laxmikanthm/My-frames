package tests.Feed;

import base.CentralAppContext;
import base.test.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.LoginPage;
import pages.Feed.FeedHomePage;
import pages.Feed.SearchResultsPage;
import pojos.LoginCredentials;
import utils.Logz;

@ContextConfiguration({ "classpath:LoginCredentialsData.xml", "classpath:AuthoringContentData.xml"})
public class SearchResultsTest extends CentralAppContext{
    private LoginPage<RemoteWebDriver> loginPage;
    private FeedHomePage feedHomePage;
    private SearchResultsPage searchResultsPage;


    @Autowired
    LoginCredentials FeedLogin;

    /*
    * Test Case ID: 190413
    * Test Case: Feed-If no results are returned user will see a message indicating no results were found.
    * */
    @Test
    public void verifyNoResultsFoundMessageInSearchResults_190413()throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForAnItem(RandomStringUtils.randomAlphanumeric(5));
            searchResultsPage.verifyNoResultsFoundMessage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
}
