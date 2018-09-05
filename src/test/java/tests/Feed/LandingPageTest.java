package tests.Feed;

import base.CentralAppContext;
import base.test.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.Content.DraftPage;
import pages.AuthoringCenter.Distributions.DistributionApprovedPage;
import pages.CommonMethodsPage;
import pages.Feed.*;
import pages.AuthoringCenter.LoginPage;
import pojos.AuthoringContent;
import pojos.LoginCredentials;
import utils.Logz;

@ContextConfiguration({ "classpath:LoginCredentialsData.xml", "classpath:AuthoringContentData.xml"})
public class LandingPageTest extends CentralAppContext {
    private LoginPage<RemoteWebDriver> loginPage;
    private FeedArticlePage feedArticlePage;
    private FeedHomePage feedHomePage;
    private SearchResultsPage searchResultsPage;
    private DraftPage draftPage;
    private CommonMethodsPage commonMethodsPage;
    private ProfileSettingsPage profileSettingsPage;
    private DistributionApprovedPage distributionApprovedPage;

    @Autowired
    LoginCredentials FeedLogin;
    @Autowired
    LoginCredentials AdAgencyContactLogin;
    @Autowired
    LoginCredentials ContentApproverLogin;
    @Autowired
    AuthoringContent authoringContentTestData;


    //TFS Id:147564
    //TFS Description: Verify text & content in the Footer
    @Test
    public void verifyTextAndContentInFooter_147564() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyFooterLinksInTheHomePage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:146907
    //TFS Description: Feed - Filtering Search Results by Year
    @Test
    public void verifyResultsFilterByYear_146907() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            feedHomePage=profileSettingsPage.changeUserLanguage(BaseTest.getStringfromBundleFile("defaultLanguage"));
            searchResultsPage = feedHomePage.gotoSearchResultsPage();
            searchResultsPage.verifySearchResultsByYear();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:146906
    //TFS Description: Feed- Filtering Search Results by Month
    @Test
    public void verifyResultsFilterByMonth_146906() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            feedHomePage=profileSettingsPage.changeUserLanguage(BaseTest.getStringfromBundleFile("defaultLanguage"));
            searchResultsPage = feedHomePage.gotoSearchResultsPage();
            searchResultsPage.verifySearchResultsByMonth();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:118751
    //TFS Description: Feed - Filtering Search Results by Week
    @Test
    public void verifyResultsFilterByWeek_118751() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage=feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByWeek();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128826
    //TFS Description: C-Filter by Topics: Training
    @Test
    public void verifyTrainingResultsFilterByTopics_128826() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("training"), BaseTest.getStringfromBundleFile("trainingTopic"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128824
    //TFS Description: C-Filter by Topics: Technology
    @Test
    public void verifyTechnologyResultsFilterByTopics_128824() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("technology"), BaseTest.getStringfromBundleFile("technology"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128823
    //TFS Description: C-Filter by Topics: Restaurants and Facilities
    @Test
    public void verifyRestaurantsAndFacilitiesResults_128823() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("restaurantsAndFacilities").replace(",", ""), BaseTest.getStringfromBundleFile("restaurantsAndFacilities"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128822
    //TFS Description: C-Filter by Topics: Products and Food Handling
    @Test
    public void verifyProductsAndFoodHandlingResults_128822() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("products"), BaseTest.getStringfromBundleFile("products"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128797
    //TFS Description: C-Filter by Topics: Business and Financial Management
    @Test
    public void verifyBusinessAndFinancialManagementResults_128797_164759() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("businessAndFinancialManagement"), BaseTest.getStringfromBundleFile("businessAndFinancialManagement"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128819
    //TFS Description: C-Filter by Topics: Company Events & Brand
    @Test
    public void verifyCompanyEventsAndBrandsResults_128819_164760() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("companyEventsAndBrand"), BaseTest.getStringfromBundleFile("companyEventsAndBrand"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128805
    //TFS Description: C-Filter by Topics: Customers
    @Test
    public void verifyResultsByCustomers_128805() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("customers"), BaseTest.getStringfromBundleFile("customersTopic"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128806
    //TFS Description: C-Filter by Topics: Development
    @Test
    public void verifyResultsByDevelopment_128806() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("development"), BaseTest.getStringfromBundleFile("development"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128807
    //TFS Description: C-Filter by Topics: Employees
    @Test
    public void verifyResultsByEmployees_128807() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("employees"), BaseTest.getStringfromBundleFile("employeesTopic"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128820
    //TFS Description: C-Filter by Topics: Legal Under Business and Financial Management
    @Test
    public void verifyResultsByLegal_128820() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("legal"), BaseTest.getStringfromBundleFile("legalTopic"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128821
    //TFS Description: C-Filter by Topics: Marketing & Advertising under Comapany & Brand
    @Test
    public void verifyResultsByMarketingAndAdvertising_128821() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySearchResultsByTopics(BaseTest.getStringfromBundleFile("marketingAndAdvertising"), BaseTest.getStringfromBundleFile("marketing"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:128829
    //TFS Description: C-Filter by Topics: All
    @Test
    public void verifySubTopicsFilterByTopics_128829() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifySubTopics();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 109527
    //TFS Description: Anonymous User - Central Login
    @Test
    public void verifyLogin_109527() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(AdAgencyContactLogin);
            feedHomePage.verifyHomePage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 109539
    //TFS Description: Log Out - Authenticated User
    @Test
    public void verifyLogout_109539() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyHomePage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 109578
    //TFS Description: Viewing the Central Homepage as an Authenticated User
    @Test
    public void verifyFeedHomePage_109578() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyHomePage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 161977
    //TFS Description: Feed - Verify user is able to see English is default language if no languages are selected
    @Test
    public void verifyEnglishDefaultLanguage_161977() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForAnItem(BaseTest.getStringfromBundleFile("sub"));
            searchResultsPage.verifyDefaultLanguage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 116538
     * Test Case: C - Verify Authenticated User can view News Feed
     * */
    @Test
    public void verifyNewsFeedInHomePage_116538() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyNewsFeedSectionInHomePage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 118761
     * Test Case: Feed - Paging for Search Results - browsers
     * */
    @Test
    public void pagingForSearchResults_118761() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.gotoSearchResultsPage();
            searchResultsPage.pagingSearchResults();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 161968
     * Test Case: Feed - Verify If no filter is selected all results will show up for all time.
     * */
    @Test
    public void verifySearchResultsForAllTime_161968() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.gotoSearchResultsPage();
            searchResultsPage.searchResultsWithNoTimeRange();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 167932
     * Test Case: F - Verify a 404 page
     * */
    @Test
    public void verify404Page_167932() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verify404Page();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case iD: 165017
     * Test Case: Feed - Log Out - Authenticated User
     * */
    @Test
    public void authenticatedUserLogout_165017() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 150315
     * Test Case: C - Verify User login with Wrong Credentials
     * */
    @Test
    public void loginToFeedWithWrongCredentials_150315() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            loginPage.loginToFeedWithWrongCredentials(FeedLogin);
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 118749
    * Test Case: Feed - Filtering Search Results by Language
    * */
    @Test
    public void filteringSearchResultsByLanguage_118749() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForArticle();
            searchResultsPage.verifyFilteringSearchResultsByLanguage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 118748, 124340 & 151384
    * Test Case: Feed - Searching by Keyword
    *            C - Unlike an Article
    *            C- View a landing page
    * */
    @Test
    public void searchingByKeywordAndBookmarkItem_118748_124340_151384_122624()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("developmentAgent"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage=feedHomePage.searchForAnItemUsingContentTitle();
            feedArticlePage =searchResultsPage.verifySearchingByKeyword();
            feedArticlePage.unlikeAnArticle();
            feedHomePage=feedArticlePage.bookmarkItemAndNavigateToHomePage();
            feedHomePage.verifyBookmarkItem();
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id:147563
    //TFS Description: C - Verify Footer is seen across all pages
    @Test
    public void verifyFooterInPages_147563() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage.verifyFooterInTheHomePage();
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            feedHomePage = profileSettingsPage.verifyFooterInTheProfileSettingsPage();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 161405
    * Test Case: Feed - Verify user is able to see the Newsfeed with the content targeted to that segment
    * */
    @Test
    public void verifyNewsFeedWithContentTargetedSegment_161405()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            distributionApprovedPage=commonMethodsPage.createContentAndDistribute(authoringContentTestData,BaseTest.getStringfromBundleFile("high"),BaseTest.getStringfromBundleFile("homeNewsFeed"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            feedHomePage.verifyContentInHomeNewsFeedSection();
            feedHomePage.logout();
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 165460 & 165480
    * Test Case: C- Filter by a Topic-Results of that Topic displayed
    *            C-Breadcrumb-Selected Topic
    * */
    @Test
    public void verifyFilterByTopicResultsAndBreadcrumb_165460_165480()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage=feedHomePage.searchForArticle();
            searchResultsPage.filterByTopicResultsAndBreadcrumbVerification(BaseTest.getStringfromBundleFile("companyEventsAndBrand"));
            feedHomePage.logout();
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 161038
    * Test Case: Feed - Verify HQ user is able to see all the content on central
    * */
    @Test
    public void verifyHQUserIsAbleToSeeAllTheContentOnFeed_161038()throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class,driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("adAgency"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(ContentApproverLogin);
            searchResultsPage=feedHomePage.searchForAnItemUsingContentTitle();
            feedArticlePage =searchResultsPage.hqUserAbleToSeeContentOnFeedSearchResults();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 155052
    //TFS Description: Viewing Documents in Search Results
    @Test
    public void verifyViewingDocumentsInSearchResults_155052() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.searchForAnItem(BaseTest.getStringfromBundleFile("document"));
            feedHomePage = searchResultsPage.verifyDocumentTypeDownloaded();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 116537
    //TFS Description: C - Viewing an Article List
    @Test
    public void verifyArticleTimeStampListDisplay_116537() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            feedHomePage=feedHomePage.verifyNewsFeedContentTimeStampOrdering();
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
}