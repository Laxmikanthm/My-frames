package tests.Feed;

import base.CentralAppContext;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.Content.DraftPage;
import pages.CommonMethodsPage;
import pages.Feed.FeedHomePage;
import pages.AuthoringCenter.LoginPage;
import pages.Feed.SearchResultsPage;
import pojos.AuthoringContent;
import pojos.LoginCredentials;
import base.test.BaseTest;
import utils.Logz;

@ContextConfiguration({ "classpath:LoginCredentialsData.xml", "classpath:AuthoringContentData.xml"})
public class FilterByContentTypeTest extends CentralAppContext {

    private LoginPage<RemoteWebDriver> loginPage;
    private FeedHomePage feedHomePage;
    private SearchResultsPage searchResultsPage;
    private DraftPage draftPage;
    private CommonMethodsPage commonMethodsPage;

    @Autowired
    LoginCredentials FeedLogin;
    @Autowired
    LoginCredentials ContentApproverLogin;
    @Autowired
    AuthoringContent authoringContentTestData;
    @Autowired
    LoginCredentials AdAgencyContactLogin;

    /*
    * Test Case ID: 128706
    * Test Case: C-Filter by Content Type: Forms
    * */
    @Test
    public void formFilterByContentType_128706()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("relatedContentTypes"),BaseTest.getStringfromBundleFile("forms"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByContentTypes(BaseTest.getStringfromBundleFile("forms"));
            feedHomePage.logout();
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 128790
    * Test Case: C-Filter by Content Type: Manuals
    * */
   @Test
    public void manualsFilterByContentType_128790()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("relatedContentTypes"),BaseTest.getStringfromBundleFile("manuals"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByContentTypes(BaseTest.getStringfromBundleFile("manuals"));
            feedHomePage.logout();
        }catch (Exception ex){
                Logz.error(ex.getMessage());
                throw ex;
        }
    }
    /*
    * Test Case ID: 130680
    * Test Case: Filter by Role - Vendors
     * */
    @Test
    public void vendorsFilterByRole_130680()throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("vendor"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByRoles(BaseTest.getStringfromBundleFile("vendor"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 130681
    * Test Case: Filter by Role - Agencies - Ad Agencies
    * */
    @Test
    public void adAgencyFilterByRole_130681()throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("adAgency"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByRoles(BaseTest.getStringfromBundleFile("adAgency"));
            feedHomePage.logout();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 128793
    * Test Case: C-Filter by Content Type: Articles
    * */
    @Test
    public void articlesFilterByContentType_128793() throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("relatedContentTypes"),BaseTest.getStringfromBundleFile("articles"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByContentTypes(BaseTest.getStringfromBundleFile("articles"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //F - View a video in Search Results
    @Test
    public void searchAndViewContent_161986()throws Exception{
        try
        {
            loginPage = goToHomePage(LoginPage.class,driverName);
            //Navigate to Feed URL.
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            searchResultsPage = feedHomePage.gotoSearchResultsPage();
            searchResultsPage.verifyContentTypes(BaseTest.getStringfromBundleFile("sub"),"");
            loginPage = searchResultsPage.SearchResultPageLogout();

        }catch (Exception e){
            throw e;
        }
    }
    /*
     * Test Case ID: 130679
     * Test Case: Filter by Role - Field Consultants
     * */
    @Test
    public void fieldConsultantFilterByRole_130679()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("fieldConsultant"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByRoles(BaseTest.getStringfromBundleFile("fieldConsultant"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
     * Test Case ID: 130674
     * Test Case: Filter by Role - DA / Development Agent
     * */
    @Test
    public void developmentAgentFilterByRole_130674()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("developmentAgent"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByRoles(BaseTest.getStringfromBundleFile("developmentAgent"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 130676
    * Test Case:
    * */
    @Test
    public void hqEmployeeFilterByRole_130676()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("roles"),BaseTest.getStringfromBundleFile("hqEmployee"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByRoles(BaseTest.getStringfromBundleFile("hqEmployee"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 130668
     * Test Case: Filter by Content Medium/Media - Documents (Word/Excel/PowerPoint/PDF)
     * */
    @Test
    public void filterByContentByDocument_130668() throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("mediaTypes"),BaseTest.getStringfromBundleFile("document"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByMediaTypes(BaseTest.getStringfromBundleFile("document"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 129151
     * Test Case: Filter by Content Medium/Media - Web
     * */
    @Test
    public void filterByContentByWeb_129151() throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("mediaTypes"),BaseTest.getStringfromBundleFile("webContent"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByMediaTypes(BaseTest.getStringfromBundleFile("webContent"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 130667
     * Test Case: Filter by Content Medium/Media - Video
     * */
    @Test
    public void filterByContentByVideo_130667() throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            draftPage=loginPage.loginToAuthoringContentPage(ContentApproverLogin);
            commonMethodsPage = draftPage.gotoCommonMethodsPage();
            draftPage=commonMethodsPage.createContentWithSpecificTagAndApprove(authoringContentTestData,BaseTest.getStringfromBundleFile("mediaTypes"),BaseTest.getStringfromBundleFile("video"));
            loginPage=draftPage.logout();
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByMediaTypes(BaseTest.getStringfromBundleFile("video"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 163134
     * Test Case: Central- Filter by Content Medium-Multiple Select
     * */
    @Test
    public void filterByContentByMultipleTypeSelect_163134() throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage=loginPage.loginToFeed(AdAgencyContactLogin);
            searchResultsPage= feedHomePage.searchForArticle();
            searchResultsPage.filterByMediaTypes(BaseTest.getStringfromBundleFile("multipleMediaTypes"));
            feedHomePage.logout();
        }catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

}
