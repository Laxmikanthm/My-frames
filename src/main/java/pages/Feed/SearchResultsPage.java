package pages.Feed;

import base.FeedMethodsLibrary;
import base.gui.controls.browser.*;
import base.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pages.CommonMethodsPage;
import pages.AuthoringCenter.LoginPage;
import utils.Logz;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class SearchResultsPage extends FeedMethodsLibrary {

    private By contentTypes = By.xpath("//div[@class='panel']//span[text()='" + getPropertyText("contentTypes") + "']/parent::div[contains(@class,'panel')]");

    private By link_ContentTypes = By.xpath("//span[contains(text(),'" + BaseTest.getStringfromBundleFile("contentTypes") + "')]");
    private By link_MediaTypes = By.xpath("//span[contains(text(),'" + BaseTest.getStringfromBundleFile("mediaType") + "')]");
    private By list_ContentTypes = By.xpath("//div[@class='panel-collapse collapse in']//li//span[@class='toggle-label']");

    private By list_FormContentTypes = By.xpath("//div[@id='search-results']//div[@class='grid-item']");
    private By list_ArticlesOnRightTrail = By.xpath("//div[@class='col-xs-12 col-lg-3 right-rail']//div[@class='grid-item grid-item-sm']");
    private By list_results = By.id("pagedResults");
    private By list_resultvideos = By.xpath("//div[@id='pagedResults']/div[@class='grid-item grid-item-video']");
    private By video_player_id = By.id("video-player-modal_html5_api");
    private By txt_ContentArticle = By.xpath("//div[@class='grid-item']//div[contains(@class,'content-type-article')]");
    private By txt_ContentTitle = By.xpath("//div[@class='grid-item']//a[@class='content-title']");
    private By txt_ContentDate = By.xpath("//div[@class='grid-item']//div[@class='content-date']");
    private By search = By.xpath("//div[@class='header-block'][contains(.,'" + getPropertyText("search") + "')]");
    private By txt_SearchBox = By.id("inputSearch");
    private By btn_LoadMore = By.xpath("//div[@id='loadMore']//button[contains(.,'" + getPropertyText("loadMore") + "')]");
    private By txt_searchHeader = By.id("txtSearchHeader");
    private By btn_LangSelected = By.xpath("//button[@id='langSelect']");
    private By btnSearch = By.id("btn-searchclick");
    private By linkArtical = By.xpath("//div[@class='grid-item-thumbnail']/a");
    //    private By dropdownLanguage=By.xpath("//ul[@id='lstLanguage']/li/a");
    private By text_ArticalTitle = By.xpath("//div[@class='article-title']/h1");
    private By btn_Bookmark = By.xpath("//button[@class='btn btn-default btn-icon btn-bookmark']");
    private By btn_IsBookmarked = By.xpath("//button[@class='btn-bookmark isBookmarked']");
    private By link_HeaderLogo = By.xpath("//a[@class='header-logo']");
    private By link_Articles = By.xpath("//div[@class='panel-collapse collapse in']//span[contains(text(), '" + BaseTest.getStringfromBundleFile("articles") + "')]");
    private By link_Document = By.xpath("//div[@class='panel-collapse collapse in']//span[contains(text(), '" + BaseTest.getStringfromBundleFile("document") + "')]");
    private By btn_BookmarkInDocuments = By.xpath("//button[@class='btn-bookmark']");
    private By languageOptions = By.xpath("//ul[@id='lstLanguage']/li/a");
    private By list_timeFrame=By.xpath("//div[@aria-label='Select timeframe']//input/parent::label");
    private By releaseDate=By.xpath("//li[@class='list-item release-date']");
    private static final By link_ShowAll=By.xpath("//div[@aria-label='Select All']//input/parent::label");

    private By link_rolesFilter=By.xpath("//span[contains(text(),'"+BaseTest.getStringfromBundleFile("roles")+"')]");
    private By link_TopicsFilter=By.xpath("//span[contains(text(),'"+BaseTest.getStringfromBundleFile("topics")+"')]");
    private By link_Year = By.xpath("//label[@class='btn btn-default ']/input[@id='last_year']/parent::label");
    private By txt_SearchResults = By.xpath("//div[@class='content-date']");
    private static final By btn_SearchIcon = By.id("btnSearchHeader");
    private By link_Month = By.xpath("//label[@class='btn btn-default ']/input[@id='last_month']/parent::label");
    private By txt_ResultsByTopics = By.id("pagedResults");
    private By topicsHeader=By.xpath("//div[@class='topicFacet']");
    private By noResultsFound=By.id("noResultsFound");
    private By link_Week = By.xpath("//label[@class='btn btn-default ']/input[@id='last_week']/parent::label");
    private By firstResult = By.xpath("//div[@id='pagedResults']/div[position()<2]");

    public SearchResultsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        waitForPageToLoad();
    }

    @Override
	public void waitForPageToLoad() throws Exception {
        if(getShowAllLink().elementIsDisplayedAndEnabled()){
            Logz.step("Search Results Page is displayed");
	}
    }

    private LinkText getContentTypesLink() throws Exception {
        return new LinkText(driver, link_ContentTypes, "Content Types");
    }

    private Generic getFirstResult() throws Exception {
        return new Generic(driver, firstResult, "First Result (Doc Type)");
    }

    private LinkText getMediaTypesLink() throws Exception {
        return new LinkText(driver, link_MediaTypes, "Media Types");
    }

    private Generic getContentTypesPanel() throws Exception {
        return new Generic(driver, contentTypes, "Content Types");
    }

    private List<WebElement> getContentTypes() throws Exception {
        return driver.findElements(list_FormContentTypes);
    }

    private List<WebElement> getArticlesOnRightTrail() throws Exception {
        return driver.findElements(list_ArticlesOnRightTrail);
    }

    private List<WebElement> getSearchResults() throws Exception {
        return driver.findElements(list_results);
    }

    private List<WebElement> getSearchResultsVideos() throws Exception {
        return driver.findElements(list_resultvideos);
    }

    private Generic getModelVideos() throws Exception {
        return new Generic(driver, video_player_id, "Search Video");
    }

    private List<WebElement> getContentArticleText() throws Exception {
        return driver.findElements(txt_ContentArticle);
    }

    private List<WebElement> getContentTitleText() throws Exception {
        return driver.findElements(txt_ContentTitle);
    }

    private List<WebElement> getContentDateText() throws Exception {
        return driver.findElements(txt_ContentDate);
    }

    private List<WebElement> getContentTypesList() throws Exception {
        return driver.findElements(list_ContentTypes);
    }

    private Generic searchHeader() throws Exception {
        return new Generic(driver, search, "Search");
    }

    private Button getLoadMoreButton() throws Exception {
        return new Button(driver, btn_LoadMore, "Load More");
    }

    private Button getBookmarkButton() throws Exception {
        return new Button(driver, btn_Bookmark, "Bookmark");
    }

    private Button getIsBookmarked() throws Exception {
        return new Button(driver, btn_IsBookmarked, "Bookmark");
    }

    private List<WebElement> getBookmarkButtonInDocuments() throws Exception {
        return driver.findElements(btn_BookmarkInDocuments);
    }

    private LinkText getHeaderLogo() throws Exception {
        return new LinkText(driver, link_HeaderLogo, "HeaderLogo");
    }

    private LinkText getArticlesLink() throws Exception {
        return new LinkText(driver, link_Articles, "Articles");
    }

    private LinkText getDocumentLink() throws Exception {
        return new LinkText(driver, link_Document, "Document");
    }

    private TextBox getSearchHeaderTextBox() throws Exception {
        return new TextBox(driver, txt_searchHeader, "Search Header Text box");
    }

    private List<WebElement> getLanguageOptions() throws Exception {
        return driver.findElements(languageOptions);
    }

    private TextBox getSearchTextBox() throws Exception {
        return new TextBox(driver, txt_SearchBox, "Search Text box");
    }

    private Button getLangSelectedButton() throws Exception {
        return new Button(driver, btn_LangSelected, "Default language Selected");
    }

//    private SelectBox getLanguageDropdown()throws Exception{
//        return new SelectBox(driver,dropdownLanguage,"Language Drop down");
//    }

    private Button getBtnSearch() throws Exception {
        return new Button(driver, btnSearch, "Search Button");
    }

    private LinkText getArticalLink() throws Exception {
        return new LinkText(driver, linkArtical, "Artical Link/Icon");
    }

    private Generic getTxtArticalTitle() throws Exception {
        return new Generic(driver, text_ArticalTitle, "Article title");
    }
    private Generic getSearchBox() throws Exception {
        return new Generic(driver, txt_SearchBox, "Search Text box");
    }
    private List<WebElement> getSearchResultsList()throws Exception{
        return getSearchBox().getWebElements(list_FormContentTypes,"Search Results");
    }
    private Generic getReleaseDate()throws Exception{
        return new Generic(driver,releaseDate,"Release Date");
    }
    private List<WebElement> getTimeFrameList()throws Exception{
        return getReleaseDate().getWebElements(list_timeFrame,"Time Frames");
    }
    private LinkText getShowAllLink()throws Exception{
        return new LinkText(driver,link_ShowAll,"Show All");
    }
    private Generic getContentTypeTags(String tagName)throws Exception{
        return new Generic(driver,By.xpath("//span[contains(text(),'Content Types')]/following::div[@class='panel-collapse collapse in']//span[contains(text(),'"+tagName+"')]"),"Content Types tag");
    }
    private LinkText getContentTitle(String contentTitle)throws Exception{
        return new LinkText(driver,By.xpath("//div//a[contains(text(),'"+contentTitle+"')]"),"");
    }
    private LinkText getRolesFilterLink()throws Exception{
        return new LinkText(driver,link_rolesFilter,"Roles Filter");
    }
    private Generic getRolesTag(String role)throws Exception{
        return new Generic(driver,By.xpath("//span[contains(text(),'Roles')]/following::div[@class='panel-collapse collapse in']//span[contains(text(),'"+role+"')]"),"Roles");
    }
    private LinkText getTopicsFilterLink()throws Exception{
        return new LinkText(driver,link_TopicsFilter,"Topics Filter");
    }
    private Generic getTopicsTag(String topic)throws Exception{
        return new Generic(driver,By.xpath("//span[contains(text(),'Topics')]/following::div[@class='panel-collapse collapse in']//a[contains(text(),'"+topic+"')]"),"Topics");
    }
    private LinkText getYearLink() throws Exception {
        return new LinkText(driver, link_Year, "Year");
    }
    public List<WebElement> getResultsFilterByCurrentDate() throws Exception {
        return getSearchIcon().getWebElements(txt_SearchResults, "Search Results");
    }
    private Generic getSearchIcon()throws Exception{
        return new Generic(driver,btn_SearchIcon,"Search");
    }
    private LinkText getMonthLink() throws Exception {
        return new LinkText(driver, link_Month, "Month");
    }
    private Generic getResultsByTopic() throws Exception {
        return new Generic(driver, txt_ResultsByTopics, "Results by Topic");
    }
    private List<WebElement> getTopicsList()throws Exception{
        return getSearchBox().getWebElements(By.xpath("//span[contains(text(),'Topics')]/following::div[@class='panel-collapse collapse in']//a"),"Topics");
    }
    private Generic getTopicFilterHeader()throws Exception{
        return new Generic(driver,topicsHeader,"Topics Header");
    }
    private List<WebElement> getFilterLanguagesList()throws Exception{
        return getSearchBox().getWebElements(By.xpath("//div[@class='input-group-btn open']//ul[@id='lstLanguage']//a"),"Languages List");
    }
    private Generic getNoResultsFoundText()throws Exception{
        return new Generic(driver,noResultsFound,"No Results Found");
    }
    private LinkText getWeekLink() throws Exception {
        return new LinkText(driver, link_Week, "Week");
    }
    //Functional methods
    public SearchResultsPage verifyContentTypes(String searchText, String contentName) throws Exception {
        if (getContentTypesList().size() > 0) {
            for (int i = 0; i < getContentTypesList().size(); i++) {
                if (getContentTypesList().get(i).getText().contains(contentName)) {
                    getContentTypesList().get(i).click();
                    Logz.step("Clicked on " + contentName);
                    Logz.step("No. of " + contentName + " available to user: " + getContentTypes().size());
                    for (int j = 0; j < getContentTypes().size(); j++) {
                        Logz.step("" + contentName + " type is: " + getContentArticleText().get(j).getText());
                        Logz.step("" + contentName + " title is: " + getContentTitleText().get(j).getText());
                        Logz.step("" + contentName + " Date is: " + getContentDateText().get(j).getText());
                    }
                    break;
                }
            }
        } else {
            Logz.step("No Results Found for searched Condition:: " + searchText);

        }
        return new SearchResultsPage(driver);
    }


    public SearchResultsPage verifySearchResultsForVideo(String searchText) throws Exception {
        if (getSearchResults().size() > 0) {
            Logz.step("Search results count appeared on the page: " + getSearchResults().size());
            if (getSearchResultsVideos().size() > 0) {
                //Click on First Video Every time.
                Logz.step("Videos are available in Search Results");
                getSearchResultsVideos().get(0).click();
                //Verify If Video Opened in Modal Window
                Assert.assertNotNull(getModelVideos().elementIsDisplayedAndEnabled(), "Video Opened in Model Window");
            } else {
                Logz.error("No video results are available");
            }
        } else {
            Logz.error("There is no search results appeared on the page");
        }
        return new SearchResultsPage(driver);
    }
    public FeedArticlePage navigateToArticlePage()throws Exception{
        getContentTitle(contentTitle).getControl().click();
        Logz.step("Clicked on item: "+contentTitle);
        return new FeedArticlePage(driver);
    }

    public FeedHomePage verifySearchResultsAndNavigateToFeedHome(String contentType) throws Exception {
        clickContentTypes();
        getContentTypeTags(contentType).getControl().click();
        Logz.step(contentType+": tag is selected under Content Types");
        waitForElement();
        if (getContentTypes().size() > 0) {
            Logz.step("Search results appeared on the page: " + getSearchResults().size());
            getContentTypes().get(0).click();
            if (getTxtArticalTitle().getControl().isDisplayed()) {
                articleTitle = getTxtArticalTitle().getControl().getText().toString();
                getBookmarkButton().click();
                getHeaderLogo().click();
            }
        } else {
            Logz.error("There is no search results appeared on the page");
        }
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifySearchResultsForDocument(String contentType) throws Exception {
        getContentTypeTags(contentType).getControl().click();
        Logz.step(contentType+": tag is selected under Content Types");
        waitForElement();
        if (getContentTypes().size() > 0) {
            Logz.step("Search results appeared on the page: " + getSearchResults().size());
            getBookmarkButtonInDocuments().get(0).click();
            Logz.step("Checked Bookmark item");
            getBookmarkButtonInDocuments().get(0).click();
            Logz.step("Unchecked Bookmark item");
            getContentTypes().get(0).click();
            if (getTxtArticalTitle().getControl().isDisplayed()) {
                articleTitle = getTxtArticalTitle().getControl().getText().toString();
                getBookmarkButton().click();
                getHeaderLogo().click();
            }
        } else {
            Logz.error("There is no search results appeared on the page");
        }
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyDetailsForRightTrailDocument() throws Exception {
        Assert.assertTrue(getIsBookmarked().elementIsDisplayedAndEnabled(), "Item is opened and indicated that it is not bookmarked");
        Logz.step("Item is opened and indicated that it is bookmarked");
        getHeaderLogo().click();
        return new FeedHomePage(driver);
    }

//    public SearchResultsPage verifySearchResults(String language)throws Exception{
//
//        Assert.assertTrue(getBtnLangSelected().getText().equalsIgnoreCase(BaseTest.getStringfromBundleFile("defaultLanguage")));
//        getSearchTextBox().setText(urlText);
//        if(language != BaseTest.getStringfromBundleFile("defaultLanguage")){
//            getBtnLangSelected().click();
////            getLanguageDropdown().selectFromDropDown(language);
//            getLanguageDropdown().selectOptionFromDropDown(language);
//        }
//        getBtnSearch().click();
//        Assert.assertTrue(getBtnLangSelected().getText().equalsIgnoreCase(language));
//        getArticalLink().click();
//        Assert.assertTrue(getTxtArticalTitle().getControl().getText().equalsIgnoreCase(language));
//        return new SearchResultsPage(driver);
//    }

    public SearchResultsPage verifySearchResults(String language) throws Exception {
        Assert.assertTrue(getLangSelectedButton().getText().equalsIgnoreCase(BaseTest.getStringfromBundleFile("defaultLanguage")));
        if (language != BaseTest.getStringfromBundleFile("defaultLanguage")) {
            getLangSelectedButton().click();
//            getLanguageDropdown().selectFromDropDown(language);
            for (int i = 0; i < getLanguageOptions().size(); i++) {
                if (getLanguageOptions().get(i).getText().equalsIgnoreCase(language)) {
                    getLanguageOptions().get(i).click();
                    break;
                }
            }
        }
        getSearchTextBox().setText(urlText);
        getBtnSearch().click();
        waitForElement();
        Assert.assertTrue(getLangSelectedButton().getText().equalsIgnoreCase(language));
        getArticalLink().click();
        waitForElement();
        Assert.assertTrue(getTxtArticalTitle().getControl().getText().equalsIgnoreCase(language));
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage verifyNumberOfResultsConfiguredInFeed() throws Exception {
        if (getSearchResults().size() > 0) {
            String res = Integer.toString(getSearchResults().size());
            Logz.step("Search results count appeared on the page: " + getSearchResults().size());
            if (getLoadMoreButton().elementIsDisplayedAndEnabled()) {
                clickLoadMore();
                Assert.assertNotSame(Integer.toString(getSearchResults().size()), res);
            }
        } else {
            Logz.error("There is no search results appeared on the page");
        }
        return new SearchResultsPage(driver);
    }

    public LoginPage SearchResultPageLogout() throws Exception {
        return new CommonMethodsPage(driver).logout();
    }

    public SearchResultsPage verifyDefaultLanguage() throws Exception {
        Assert.assertTrue(getLangSelectedButton().getText().equalsIgnoreCase(BaseTest.getStringfromBundleFile("defaultLanguage")));
        Logz.step("English is the default language set on the search results page");
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage verifyArticlesContentType(String contentName) throws Exception {
        clickContentTypes();
        for (int i = 0; i < getContentTypesList().size(); i++) {
            if (getContentTypesList().get(i).getText().contains(contentName)) {
                getContentTypesList().get(i).click();
                Logz.step("Clicked on " + contentName);
            }
        }
            return new SearchResultsPage(driver);
    }
    public SearchResultsPage pagingSearchResults()throws Exception{
        scrollDown();
        Logz.step("User is able to scroll and view the bottom of the page");
        if(getSearchResultsList().size()==Integer.parseInt(BaseTest.getStringfromBundleFile("defaultSearchResultCount"))){
            String res = Integer.toString(getSearchResultsList().size());
            Logz.step("Search results count appeared on the page:"+getSearchResultsList().size());
            if (getLoadMoreButton().elementIsDisplayedAndEnabled()) {
                clickLoadMore();
                Assert.assertNotSame(Integer.toString(getSearchResultsList().size()),res);
                Logz.step("Search results count appeared on the page:"+Integer.toString(getSearchResultsList().size()));
            }
        }else{
            Logz.error("12 search results not appeared on the page");
        }
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage searchResultsWithNoTimeRange()throws Exception{
        for(int i=0;i<getTimeFrameList().size();i++){
            if(!getTimeFrameList().get(i).getAttribute("class").contains("active")){
                Logz.step(getTimeFrameList().get(i).getText()+" Filter is not applied to the Search results");
            }else {
                Logz.error(getTimeFrameList().get(i).getText()+" Filter is applied to the Search results");
            }
        }
        Assert.assertTrue(getShowAllLink().getAttribute("class").contains("active"));
        Logz.step("All Search Results displayed without any date filter ");
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage filterByContentTypes(String contentType)throws Exception {
        clickContentTypes();
        getContentTypeTags(contentType).getControl().click();
        Logz.step(contentType+": tag is selected under Content Types");
        waitForElement();
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        Assert.assertTrue(getContentTitle(contentTitle).getControl().isDisplayed());
        Logz.step("Selected "+contentType+" related articles are displayed in search results page");
        return new SearchResultsPage(driver);

    }
    public SearchResultsPage filterByRoles(String role)throws Exception {
        getRolesFilterLink().click();
        Logz.step("Clicked on Roles Filter");
        getRolesTag(role).getControl().click();
        Logz.step(role+": tag is selected under Roles");
        waitForElement();
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        Assert.assertTrue(getContentTitle(contentTitle).getControl().isDisplayed());
        Logz.step("Selected "+role+" related articles are displayed in search results page");
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickYearLink()throws Exception{
        getYearLink().click();
        Logz.step("Clicked on Year Link");
        waitForJSandJQueryToLoad();
        waitForElement();
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickMonthLink()throws Exception{
        getMonthLink().click();
        Logz.step("Clicked on Month Link");
        waitForJSandJQueryToLoad();
        waitForElement();
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickWeekLink()throws Exception{
        getWeekLink().click();
        Logz.step("Clicked on Week link");
        waitForJSandJQueryToLoad();
        waitForElement();
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage verifySearchResultsByYear() throws Exception {
        clickYearLink();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        for (WebElement ele : getResultsFilterByCurrentDate()) {
            Assert.assertTrue(ele.getText().toString().contains(Integer.toString(year)), "Result is not filter by current Year" + ele);
            Logz.step("Result is filter by current year: " + ele.getText());
        }
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage verifySearchResultsByMonth() throws Exception {
        String month,prevMonth;
        clickMonthLink();
        String[] monthName = {"January", "February",
                "March", "April", "May", "June", "July",
                "August", "September", "October", "November",
                "December"};
        Calendar cal = Calendar.getInstance();
        month = monthName[cal.get(Calendar.MONTH)];
        prevMonth=monthName[cal.get(Calendar.MONTH)-1];
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        for (WebElement ele : getResultsFilterByCurrentDate()) {
            Assert.assertTrue((ele.getText().toString().contains(month)||(ele.getText().toString().contains(prevMonth))), "Result is not filter by current month" + ele);
            Logz.step("Result is filter by current month: " + ele.getText());
        }
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage selectFilterTopic(String topic)throws Exception{
        getTopicsTag(topic).getControl().click();
        Logz.step("Clicked on "+topic+" Filter");
        waitForJSandJQueryToLoad();
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickTopicFilter()throws Exception{
        getTopicsFilterLink().click();
        Logz.step("Clicked on Topics Filter");
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage verifySearchResultsByTopics(String topic,String subTopics) throws Exception {
        clickTopicFilter();
        int count=getTopicsList().size();
        String[] str=subTopics.split(",");
        int k =0,result=0;
        while (count>0){
            for(int j=k;j<str.length;j++){
                selectFilterTopic(str[j]);
                count=getTopicsList().size();
                if(getTopicFilterHeader().getControl().getText().contains(topic)){
                    Assert.assertTrue(getResultsByTopic().getControl().isDisplayed(), "Result is not filter by topic is " + str[j]);
                    Logz.step("Selected "+str[j]+" related articles are displayed in search results page");
                    Logz.step("Search results count appeared on the page:"+getSearchResultsList().size());
                    result++;
                    break;
                }else{
                    Logz.step("No Results appeared in the search results page for "+str[j]+" topic ");
                    result++;
                    break;
                }
            }
            k++;
            if(result!=0){
                break;
            }
        }
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickFilterByLanguageDropdown()throws Exception{
        getLangSelectedButton().click();
        Logz.step("Languages drop down is clicked");
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage verifyFilteringSearchResultsByLanguage()throws Exception{
        clickFilterByLanguageDropdown();
        for(int i=0;i<getFilterLanguagesList().size();i++){
            getFilterLanguagesList().get(i).click();
            Logz.step(getLangSelectedButton().getText()+": Language is selected from drop down");
            waitForElement();
            if(getResultsByTopic().elementIsDisplayedAndEnabled()){
                Logz.step("Selected "+getLangSelectedButton().getText()+" language related articles are displayed in search results page");
            }else {if(getNoResultsFoundText().elementIsDisplayedAndEnabled()){
                Assert.assertEquals(getNoResultsFoundText().getControl().getText(),BaseTest.getStringfromBundleFile("noResultsFound"),"No Results found message is not displayed");
                Logz.step("No Results Found for selected language: " + getLangSelectedButton().getText());
            }else{
                Assert.assertFalse(getNoResultsFoundText().elementIsDisplayedAndEnabled());
                Logz.step("No message/Results found for selected language: "+getLangSelectedButton().getText());
            } }
            getLangSelectedButton().click();
            Logz.step("Languages drop down is clicked");
        }
        return new SearchResultsPage(driver);
    }
    public FeedArticlePage verifySearchingByKeyword()throws Exception{
        Assert.assertTrue(getContentTitle(contentTitle).getControl().isDisplayed());
        Logz.step(contentTitle+": Entered keyword related articles are displayed in search results page");
        getContentTitle(contentTitle).getControl().click();
        Logz.step("Clicked on item: "+contentTitle);
        return new FeedArticlePage(driver);
    }
    public SearchResultsPage verifySearchResultsByWeek() throws Exception {
        clickWeekLink();
        List<String> date123 = new ArrayList<String>();
        SimpleDateFormat sdf=new SimpleDateFormat("MMMM dd, YYYY");
        date123.add(sdf.format(new Date()));
        Calendar cal = Calendar.getInstance();
        for(int i=0;i<6;i++){
            cal.add(Calendar.DATE, -1);
            date123.add(sdf.format(cal.getTime()));
        }
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        for (WebElement ele : getResultsFilterByCurrentDate()) {
            Assert.assertTrue(date123.contains(ele.getText()),"Result is not filter by within a week from current day");
            Logz.step("Result is filter by within a week from current day: " + ele.getText());
        }
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage filterByMediaTypes(String mediaTypes)throws Exception {
        getMediaTypesLink().click();
        Logz.step("Clicked on Media Types Filter");
        String[] contentTypes =  mediaTypes.split(",");
        List<String> contentTypesList=new ArrayList();
        for(int i=0;i<contentTypes.length;i++)
        {
            contentTypesList.add(contentTypes[i].trim());
        }
        for(int i=0;i<contentTypesList.size();i++){
            getContentTypeTags(contentTypesList.get(i)).getControl().click();
            Logz.step(contentTypesList.get(i)+": tag is selected under Media Types");
        }
        waitForElement();
        while (getLoadMoreButton().elementIsDisplayedAndEnabled()){
            clickLoadMore();
        }
        Assert.assertTrue(getSearchResults().size() > 0);
        Logz.step("Selected articles are displayed in search results page");
        return new SearchResultsPage(driver);

    }
    private SearchResultsPage clickLoadMore()throws Exception{
        getLoadMoreButton().click();
        Logz.step("Clicked on LoadMore button");
        waitForJSandJQueryToLoad();
        waitForElement();
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage filterByTopicResultsAndBreadcrumbVerification(String topic)throws Exception{
        clickTopicFilter();
        selectFilterTopic(topic);
        if(getTopicFilterHeader().getControl().getText().contains(topic)){
            Logz.step(topic+": selected topic should appear as breadcrumb");
            Assert.assertTrue(getResultsByTopic().getControl().isDisplayed(), "Result is not filter by topic is " +topic);
            Logz.step("Selected "+topic+" topic related articles are displayed in search results page");
        }else{
            Logz.step("No Results appeared in the search results page for "+topic+" topic ");
        }
        for(int i=0;i<getTopicsList().size();i++){
            Logz.step(getTopicsList().get(i).getText()+": subtopic is displayed under "+topic+" Topic");
        }
        return new SearchResultsPage(driver);
    }
    public FeedArticlePage hqUserAbleToSeeContentOnFeedSearchResults()throws Exception{
        Assert.assertTrue(getContentTitle(contentTitle).getControl().isDisplayed());
        Logz.step("HQ User is able to view Content on search results regardless of the security trimming");
        getContentTitle(contentTitle).getControl().click();
        Logz.step("Clicked on item: "+contentTitle);
        return new FeedArticlePage(driver);
    }

    public FeedHomePage verifyDocumentTypeDownloaded() throws Exception{
        int fileCounrBefore = getDownloadedFilesCount();
        Logz.step("fileCounrBefore: " +fileCounrBefore);
        getFirstResult().getControl().click();
        int fileCounrAfter = getDownloadedFilesCount();
        Logz.step("fileCounrAfter : " +fileCounrAfter);
        Assert.assertNotEquals(fileCounrBefore,fileCounrAfter);
        return new FeedHomePage(driver);
    }
    public SearchResultsPage verifySubTopics() throws Exception {
        boolean flag=false;
        clickTopicFilter();
        for(int i=0;i<getTopicsList().size();i++){
            Logz.step(getTopicsList().get(i).getText()+": subtopic is displayed under Topic filter");
        }
        selectFilterTopic(BaseTest.getStringfromBundleFile("development"));
        for (int topic=0;topic<getTopicsList().size();topic++){
            if(!getTopicsList().get(topic).getText().contains(BaseTest.getStringfromBundleFile("development")));{
                flag=true;
            }
        }
        if (flag){
            Logz.step("User is not be able to choose more than 1 sub topic at a time ");
        }
        return new SearchResultsPage(driver);
    }
    private SearchResultsPage clickContentTypes()throws Exception{
        getContentTypesLink().click();
        Logz.step("Clicked on Content Types Filter");
        return new SearchResultsPage(driver);
    }
    public SearchResultsPage verifyNoResultsFoundMessage()throws Exception{
        Assert.assertEquals(getNoResultsFoundText().getControl().getText(),BaseTest.getStringfromBundleFile("noResultsFound"),"No Results found message is not displayed");
        Logz.step("No Results Found for entered input search criteria");
        return new SearchResultsPage(driver);
    }
}
