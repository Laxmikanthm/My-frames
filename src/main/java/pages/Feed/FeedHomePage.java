package pages.Feed;

import base.FeedMethodsLibrary;
import base.gui.controls.browser.Button;
import base.gui.controls.browser.Generic;
import base.gui.controls.browser.LinkText;
import base.gui.controls.browser.TextBox;
import base.test.BaseTest;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pages.AuthoringCenter.LoginPage;
import pages.CommonMethodsPage;
import pojos.AuthoringContent;
import utils.Logz;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class FeedHomePage<T extends RemoteWebDriver> extends FeedMethodsLibrary {

    public AuthoringContent authoringContent;
    private LoginPage loginPage;

    private By list_Alerts = By.xpath("//div[@id='home-alerts-list']//li[contains(@class,'list-item')]/a");
    private static final By btn_SearchIcon = By.id("btnSearchHeader");

    private By txt_Menu = By.xpath("//a[@class='dropdown-toggle menu-toggle']//span[contains(text(),'Menu')]");
    private By link_Tools = By.xpath("//div[@class='list-header header-block']//span[text()='" + getPropertyText("tools") + "']");
    private By link_HeaderLogo = By.xpath("//a[@class='header-logo']");
    private By bookMarks = By.id("home-bookmarks-list");
    private By link_bookmarks = By.xpath("//div[@id='home-bookmarks-list']//a//span[text()='" + getPropertyText("bookmarks") + "']");
    private By list_BookMarkedItems = By.xpath("//div[@id='home-bookmarks-list']//li[@class='list-item']");
    private By txt_notifications = By.xpath("//div[@id='home-alerts-list']//span[contains(text(),'Notifications')]");
    private By list_Tools = By.xpath("//*[@id='home-tools-list']//li[@class='list-item']");
    private By txt_Copyright = By.xpath("//div[@class='col-sm-6 footer-copyright']");
    private By link_TermsOfUse = By.xpath("//a[contains(text(),'" + BaseTest.getStringfromBundleFile("termsOfUse") + "')]");
    private By link_PrivacyStatement = By.xpath("//a[contains(text(),'" + BaseTest.getStringfromBundleFile("privacyStatement") + "')]");
    private By link_Support = By.xpath("//a[contains(text(),'Support')]");

    private By txt_ArticleTitle = By.xpath("//div[@class='article-title']/h1");
    private By btn_languageText = By.xpath("//div[@class='input-group']/button");
    private By popUp_TermsOfUse = By.xpath("//div[@class='modal-content']");
    private By popUp_privacyStatement = By.xpath("//div[@id='modalPrivacy']//div[@class='modal-content']");
    private By btn_TermsOfUseClose = By.xpath("//button[@class='close']");
    private By popUp_privacyStatementCloseButton = By.xpath("//div[@id='modalPrivacy']//button[@class='close']");
    private By link_Year = By.xpath("//label[@class='btn btn-default ']/input[@id='last_year']/parent::label");
    private By link_Month = By.xpath("//label[@class='btn btn-default ']/input[@id='last_month']/parent::label");
    private By link_Week = By.xpath("//label[@class='btn btn-default ']/input[@id='last_week']/parent::label");
    private By txt_SearchText = By.id("txtSearchHeader");

    private By link_FilterByTopics = By.xpath("//span[contains(text(),'"+BaseTest.getStringfromBundleFile("topics")+"')]");

    private By txt_ResultsByTopics = By.id("pagedResults");
    private By link_SubTopics = By.xpath("//div[@class='panel-collapse collapse in']/a");
    private By link_NotificationItemTitle = By.xpath("//div[@id='home-alerts-list']//div[@class='item-title']");
    private By notificationItemTitle = By.xpath("//span[text()='Notifications']//parent::div/parent::div//li//div[@class='item-title']");
    private By notificationItemTimeStamp = By.xpath("//span[text()='Notifications']//parent::div/parent::div//li//div[@class='item-timestamp']");
    private By btn_BookmarkInDocuments = By.xpath("//button[@class='btn-bookmark']");
    private By list_ArticlesOnRightTrail = By.xpath("//div[@class='col-xs-12 col-lg-3 right-rail']//div[@class='grid-item grid-item-sm']");
    private By list_BookMarkGroups = By.xpath("//div[@class='left-rail-section bookmarks-section section-closed']//li[@class='list-subheader']/span");
    private By linkHeaderTitle = By.xpath("//div[@class='grid-item-description']/a");
    private By linkSubHeaderTitle = By.xpath("//div[@class='grid-item-description']/p");
    private By btn_MyProfileDropdown = By.xpath("//div[@class='dropdown dropdown-profile']//span[@class='caret']");
    private By link_SignOut = By.xpath("//div[@class='dropdown-menu']//a[text()[normalize-space()='" + BaseTest.getStringfromBundleFile("signOut") + "']]");
    private By activeCarouselTitle=By.xpath("//div[@class='owl-item active']//div[@class='item-info img-overlay']/a");
    private By list_CarouselTitle=By.xpath("//div[@class='item-info img-overlay']/a");
    private By list_Favorites = By.xpath("//span[contains(text(),'" + BaseTest.getStringfromBundleFile("favorites") + "')]//parent::li/following-sibling::li//div[@class='item-title']");
    private By list_contentTitlesNewsFeed=By.xpath("//ul[@id='targeted-content']//div[@class='item-title']");
    private By link_ProfileSettings = By.xpath("//div[@class='dropdown-menu']//a[text()[normalize-space()='" + BaseTest.getStringfromBundleFile("profileSettings") + "']]");
    private By btn_ReadMore=By.xpath("//div[@class='load-more-container']/button[contains(text(),'"+BaseTest.getStringfromBundleFile("readMore")+"')]");
    private By list_HomeFeatureTitle=By.xpath("//div[@id='feature-list']//div[@class='content-title']/a");
    private By list_HomeFeatureContentDate = By.xpath("//div[@class='content-date']");
    private By list_NewsFeedTimeStamp=By.xpath("//ul[@id='targeted-content']//time[@class='item-timestamp']");
    private By newsFeedSection=By.xpath("//ul[@id='targeted-content']");
    private By pageFooter=By.xpath("//div[@class='page-footer-edge']");
    private By btnLike=By.xpath("//button[@class='btn btn-default btn-icon btn-like']/span");
    private By btnLiked=By.xpath("//button[@class='btn btn-default btn-icon btn-like isLiked']/span");

    private CommonMethodsPage commonMethodsPage;

    public FeedHomePage(RemoteWebDriver driver) throws Exception {
        super(driver);
        waitForPageToLoad();
        commonMethodsPage = new CommonMethodsPage(driver);
    }

    @Override
    public void waitForPageToLoad() throws Exception {
        if (getSearchIcon().elementIsDisplayedAndEnabled()) {
            Logz.step("Feed Home Page is displayed");
        }
    }

    private Generic getPopUp() throws Exception {
        return new Generic(driver, popUp_TermsOfUse, "Terms Of Use PopUp");
    }

    private TextBox getSearchTextBox() throws Exception {
        return new TextBox(driver, txt_SearchText, "Search Text");
    }

    private LinkText getYearLink() throws Exception {
        return new LinkText(driver, link_Year, "Year");
    }

    private LinkText getMonthLink() throws Exception {
        return new LinkText(driver, link_Month, "Month");
    }

    private LinkText getWeekLink() throws Exception {
        return new LinkText(driver, link_Week, "Week");
    }

    private List<WebElement> getSubTopics() throws Exception {
        return driver.findElements(link_SubTopics);
    }

    private Generic getPrivacyStatementPopUp() throws Exception {
        return new Generic(driver, popUp_privacyStatement, "Privacy Statement PopUp");
    }

    private Button getClose() throws Exception {
        return new Button(driver, btn_TermsOfUseClose, "Terms Of Use PopUp Close button");
    }

    private Button getPrivacyStatementCloseButton() throws Exception {
        return new Button(driver, popUp_privacyStatementCloseButton, "Privacy Statement Close button");
    }

    private Generic getArticleTitle() throws Exception {
        return new Generic(driver, txt_ArticleTitle, "Article Title");
    }

    private Button getLanguageText() throws Exception {
        return new Button(driver, btn_languageText, "Language Text Header");
    }


    private Generic getSearchIcon()throws Exception{
        return new Generic(driver,btn_SearchIcon,"Search");
    }

    private List<WebElement> getAlerts() throws Exception {
        return new ArrayList<WebElement>(driver.findElements(list_Alerts));
    }

    private Generic getMenuText() throws Exception {
        return new Generic(driver, txt_Menu, "Menu");
    }

    private LinkText getToolsLink() throws Exception {
        return new LinkText(driver, link_Tools, "Tools");
    }

    private LinkText getHeaderLogoLink() throws Exception {
        return new LinkText(driver, link_HeaderLogo, "Subway header");
    }

    private Generic getBookMarks() throws Exception {
        return new Generic(driver, bookMarks, "BookMarks");
    }

    private LinkText getBookMarksLink() throws Exception {
        return new LinkText(driver, link_bookmarks, "Bookmarks Link");
    }

    private List<WebElement> getBookMarkedItems() throws Exception {
        return new ArrayList<WebElement>(driver.findElements(list_BookMarkedItems));
    }

    private List<WebElement> getNotificationItemTitles()throws Exception{
        return getSearchIcon().getWebElements(link_NotificationItemTitle, "List of Item Titles");
    }

    private List<WebElement> getNotificationTitles()throws Exception{
        return getSearchIcon().getWebElements(notificationItemTitle, "List of Item Titles");
    }

    private List<WebElement> getNotificationItemTimeStamps()throws Exception{
        return getSearchIcon().getWebElements(notificationItemTimeStamp, "List of Notification Item Time Stamps");
    }

    private Generic getNotificationIconUsingTitle(String title) throws Exception {
        return new Generic(driver, By.xpath("//div[@id='home-alerts-list']//div[@class='item-title'][contains(text(),'" + title + "')]/../../div[@class='item-icon']/span"), "Notification Icon");
    }

    private Button getMyProfileDropdown() throws Exception {
        return new Button(driver, btn_MyProfileDropdown, "My Profile dropdown");
    }

    private LinkText getSignOut() throws Exception {
        return new LinkText(driver, link_SignOut, "Logout link");
    }
    private List<WebElement> getCarouselContentTitles()throws Exception{
        return getSearchIcon().getWebElements(list_CarouselTitle,"List of CarouselContentTitles");
    }

    private Generic getActiveCarouselTitle()throws Exception{
        return new Generic(driver,activeCarouselTitle,"ActiveCarouselTitle");
    }
    private List<WebElement> getHomeFeatureContentTitles()throws Exception{
        return getSearchIcon().getWebElements(list_HomeFeatureTitle,"List of Home Features Content Titles");
    }

    private List<WebElement> getNewsFeedTimeStamps()throws Exception{
        return getSearchIcon().getWebElements(list_NewsFeedTimeStamp,"List of News Feed TimeStamps");
    }

    public List<WebElement> getHomeFeaturesContentDates() throws Exception {
        return getSearchIcon().getWebElements(list_HomeFeatureContentDate, "List of Home Features Content Date");
    }
    private LinkText getProfileSettings() throws Exception {
        return new LinkText(driver, link_ProfileSettings, "Profile Setting link");
    }

    private Button getReadMoreButton()throws Exception{
        return new Button(driver,btn_ReadMore,"Read More Button");
    }

    private Generic getBtnLiked()throws Exception{
        return new Generic(driver,btnLiked,"Like Button After liking");
    }

    private Generic getBtnLike()throws Exception{
        return new Generic(driver,btnLike,"Like Button Before liking");
    }

    //Unused Page element methods
    private LinkText getFooterTermsOfUse() throws Exception {
        return new LinkText(driver, link_TermsOfUse, "Terms Of Use");
    }

    private LinkText getFooterSupportText() throws Exception {
        return new LinkText(driver, link_Support, "Support");
    }

    private List<WebElement> getToolsItemList() throws Exception {
        return new ArrayList<WebElement>(driver.findElements(list_Tools));
    }

    private List<WebElement> getBookmarkGroups() throws Exception {
        return new ArrayList<WebElement>(driver.findElements(list_BookMarkGroups));
    }

    private List<WebElement> getFavorites() throws Exception {
        return getSearchIcon().getWebElements(list_Favorites, "List of favorites");
    }

    private LinkText getPrivacyStatementText() throws Exception {
        return new LinkText(driver, link_PrivacyStatement, "Privacy Statement");
    }

    private Generic getFooterCopyrightText() throws Exception {
        return new Generic(driver, txt_Copyright, "CopyRight");
    }

    private Generic getNotificationsText() throws Exception {
        return new Generic(driver, txt_notifications, "Notifications");
    }

    private LinkText getTopics() throws Exception {
        return new LinkText(driver, link_FilterByTopics, "Topics");
    }

    private LinkText getParticularTopicLink(String topic) throws Exception {
        return new LinkText(driver, By.xpath("//div[@class='panel-heading collapsed']/span[contains(text(),'" + topic + "')]"), "Particular Topic");
    }

    private Generic getResultsByTopic() throws Exception {
        return new Generic(driver, txt_ResultsByTopics, "Results by Topic");
    }

    private LinkText getItemInBookmarkSection(String index) throws Exception {
        return new LinkText(driver, By.xpath("//div[@class='left-rail-section bookmarks-section section-closed']//li['" + index + "']//div[@class='item-title']"), "Most Recent Item In Bookmark");
    }

    private LinkText getItemInRightTrailSection(String index) throws Exception {
        return new LinkText(driver, By.xpath("//div[@class='col-xs-12 col-lg-3 right-rail']//div[@class='grid-item-description']/div['" + index + "']"), "Item On Right Trail");
    }

    private LinkText getLinkHeaderTitle() throws Exception {
        return new LinkText(driver, linkHeaderTitle, "Call To Action Header Title");
    }

    private Generic getLinkSubHeaderTitle() throws Exception {
        return new Generic(driver, linkSubHeaderTitle, "Call To Action Sub Header Title");
    }

    public List<WebElement> getContentTitles() throws Exception {
        return getSearchIcon().getWebElements(list_contentTitlesNewsFeed, "Content Titles News Feed");
    }
    private Generic getHomeNewsFeedContent(String contentTitle)throws Exception{
        return new Generic(driver,By.xpath("//div[@class='news-section']//div[@class='item-title'][text()='"+contentTitle+"']"),"Content Title");
    }
    
    private Generic getMostRecentBookMarkItem(String contentTitle)throws Exception{
        return new Generic(driver,By.xpath("//span[text()='MOST RECENT']/parent::li[@class='list-subheader']/following-sibling::li//div[text()='"+contentTitle+"']"),"Bookmark item");
    }

    //Functional Methods
    public FeedHomePage verifyPreviewContent(AuthoringContent authoringContentTestData,String lang) throws Exception {
        //waitForElementDisplay(txt_ArticleTitle);
        Assert.assertEquals(driver.getTitle(), BaseTest.getStringfromBundleFile("theFeed"));
        Logz.step("Feed Preview page is displayed");
        Assert.assertTrue(getArticleTitle().getControl().getText().trim().contains(authoringContentTestData.getArticleTitle()+lang), "Content Title is not equals");
        //Assert.assertEquals(getLanguageText().getText().trim(),language.getLanguage(),"languages are not equal");
        Logz.step("Successfully verified content in preview");
        return new FeedHomePage(driver);
    }


    public SearchResultsPage gotoSearchResultsPage() throws Exception {
        clickSearchIcon();
        getSearchTextBox().setText(BaseTest.getStringfromBundleFile("sub"));
        clickSearchIcon();
        return new SearchResultsPage(driver);
    }

    public FeedHomePage verifyHomePage() throws Exception {
        try {
            Assert.assertEquals(getHeaderLogoLink().getControl().getText(), BaseTest.getStringfromBundleFile("feedLogoText"));
            Logz.step("Feed Home page is displayed");
            if (getMenuText().getControl().isDisplayed()) {
                Logz.step("verified menu on Dashboard");
            } else {
                throw new Exception("Menu is not present on dashboard");
            }
        } catch (Exception e) {
            throw e;
        }
        return new FeedHomePage(driver);
    }

    public void clickSearchIcon() throws Exception {
        try {
            getSearchIcon().getControl().click();
            Logz.step("Clicked on Search icon");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void verifyItem(String alertName) throws Exception {
        try {
            boolean flag = false;
            for (int i = 0; i < getAlerts().size(); i++) {
                if (getAlerts().get(i).getText().contains(alertName)) {
                    flag = true;
                    getAlerts().get(i).click();
                    Logz.step("Clicked on " + getAlerts().get(i).getText());
                    Assert.assertEquals(driver.getTitle(), getPropertyText("homePageTitle"));
                    Logz.step("User is not redirected anywhere and Stays on the Dashboard");
                    break;
                }
            }
            if (!flag) {
                throw new Exception(alertName + " alert doesn't available in list of alerts");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public FeedToolsPage clickTools() throws Exception {
        getToolsLink().click();
        Logz.step("Clicked on Tools link");
        return new FeedToolsPage(driver);
    }

    public void clickHeaderLogo() throws Exception {
        getHeaderLogoLink().click();
        Logz.step("Clicked on Subway header logo");
        Assert.assertEquals(driver.getTitle(), getPropertyText("homePageTitle"));
        Logz.step(driver.getTitle() + " page is displayed");
    }

    private void clickBookMarks() throws Exception {
        try {
            getBookMarksLink().click();
            Logz.step("Clicked on bookmarks link");
            Assert.assertEquals(driver.getTitle(), getPropertyText("bookmarksPageTitle"));
            Logz.step("BookMarks page is displayed");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private List<WebElement> getBookmarkButtonInDocuments() throws Exception {
        return driver.findElements(btn_BookmarkInDocuments);
    }

    private List<WebElement> getArticlesOnRightTrail() throws Exception {
        return driver.findElements(list_ArticlesOnRightTrail);
    }

    public FeedHomePage verifyBookmarkItem() throws Exception {
        scrollDown();
        if (getBookMarks().getControl().isDisplayed()) {
            Logz.step("BookMarks section is displayed in home page");
            /*if (getBookMarkedItems().size() > 0) {
                Assert.assertEquals(getItemInBookmarkSection(BaseTest.getStringfromBundleFile("indexTwo")).getText().toString(), articleTitle, "Item is not displayed most recent in Bookmark section");
                Logz.step("Item is displayed most recent in Bookmark section");
            }*/
            Assert.assertTrue(getMostRecentBookMarkItem(contentTitle).getControl().isDisplayed(),"Item is not displayed most recent in Bookmark section");
            Logz.step(contentTitle+": Article is displayed most recent in Bookmark section");
        } else {
            Logz.step("BookMarks section is not displayed in home page");
        }
        return new FeedHomePage(driver);
    }

    public SearchResultsPage searchForAnItem(String item) throws Exception {
        clickSearchIcon();
        getSearchTextBox().setText(item);
        clickSearchIcon();
        return new SearchResultsPage(driver);
    }

    public SearchResultsPage verifyDocumentOnRightTrail() throws Exception {
        if (getBookmarkButtonInDocuments().size() > 0) {
            Logz.step("Documents are displayed on right trail: " + getBookmarkButtonInDocuments().size());
            getBookmarkButtonInDocuments().get(0).click();
            Logz.step("Checked Bookmark item");
            articleTitle = getItemInRightTrailSection(BaseTest.getStringfromBundleFile("indexOne")).getText().toString();
            verifyBookmarkItem();
            getArticlesOnRightTrail().get(0).click();
        } else {
            Logz.error("There is no documents appeared on the right trail of the page");
        }
        return new SearchResultsPage(driver);
    }

    public FeedHomePage verifyBookmarkList() throws Exception {
        scrollDown();
        if (getBookMarks().getControl().isDisplayed()) {
            Logz.step("BookMarks section is displayed in home page");

            if (getBookmarkGroups().size() > 0) {
                Assert.assertEquals(getBookmarkGroups().get(0).getText().toString(), BaseTest.getStringfromBundleFile("mostRecent"));
                Logz.step("Bookmarked items categorized by:  Most Recent");
                Assert.assertEquals(getBookmarkGroups().get(1).getText().toString(), BaseTest.getStringfromBundleFile("mostAccessed"));
                Logz.step("Bookmarked items categorized by:  Most Frequently");
            }
        } else {
            Logz.step("BookMarks section is not displayed in home page");
        }
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyFooterLinksInTheHomePage() throws Exception {
        scrollDown();
        if (getFooterCopyrightText().getControl().getText().toString().contains(BaseTest.getStringfromBundleFile("copyright"))) {
            Logz.step("Copyright text is displayed in the footer");
        }
        Assert.assertEquals(getFooterTermsOfUse().getText().toString(), BaseTest.getStringfromBundleFile("termsOfUse"), "Terms of Use link is not displayed in the footer");
        Logz.step("Terms of Use link is displayed in the footer");
        getFooterTermsOfUse().click();
        waitForElement();
        Assert.assertTrue(getPopUp().getControl().isDisplayed(), "Terms Of Use popup is not displayed");
        Logz.step("Terms Of Use popup is displayed");
        getClose().click();
        Assert.assertEquals(getPrivacyStatementText().getText().toString(), BaseTest.getStringfromBundleFile("privacyStatement"), "Privacy Statement link is not displayed in the footer");
        Logz.step("Privacy Statement link is displayed in the footer");
        getPrivacyStatementText().click();
        waitForElement();
        Assert.assertTrue(getPrivacyStatementPopUp().getControl().isDisplayed(), "Privacy Statement popup is not displayed");
        Logz.step("Privacy Statement popup is displayed");
        getPrivacyStatementCloseButton().click();
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyFooterInTheHomePage() throws Exception {
        scrollDown();
        if (getFooterCopyrightText().getControl().getText().toString().contains(BaseTest.getStringfromBundleFile("copyright"))) {
            Logz.step("Copyright text is displayed in the Home page");
        }
        Assert.assertEquals(getFooterTermsOfUse().getText().toString(), BaseTest.getStringfromBundleFile("termsOfUse"), "Terms of Use link is not displayed in the footer");
        Logz.step("Terms of Use link is displayed in the Home page");
        Assert.assertEquals(getPrivacyStatementText().getText().toString(), BaseTest.getStringfromBundleFile("privacyStatement"), "Privacy Statement link is not displayed in the footer");
        Logz.step("Privacy Statement link is displayed in the Home page");
        return new FeedHomePage(driver);
    }
    public SearchResultsPage searchForArticle() throws Exception {
        clickSearchIcon();
        waitForElement();
        clickSearchIcon();
        return new SearchResultsPage(driver);
    }

    public void verifyCallToActionContent() throws Exception {
        Assert.assertTrue(getLinkHeaderTitle().getText().equalsIgnoreCase(ctaHeadLine));
        Assert.assertTrue(getLinkSubHeaderTitle().getControl().getText().equalsIgnoreCase(ctaSubHeadLine));
    }

    private void verifyNotificationItemTitles() throws Exception {
        boolean flag = false;
        waitForElementDisplay(link_NotificationItemTitle);
        for (WebElement element : getNotificationItemTitles()) {
            if (element.getText().equalsIgnoreCase(notificationText)) {
                Logz.step("Verified " + notificationText + " In Feed Notifications Section");
                flag = true;
                break;
            }
        }
        if (!flag)
            Logz.step(notificationText + " is not displayed in Feed Notifications Section");
    }

    public void verifyPriorityOrdering() throws Exception {
        int[] index=new int[3];
        String[] timeStamps=new String [3];
        int j=0,k=0;
        for (String contentTitle:listContentTitles){
            for(int i=0;i<getContentTitles().size();i++){
                if(contentTitle.equalsIgnoreCase(getContentTitles().get(i).getText())){
                    index[j++] = i;
                    timeStamps[k++] = getNewsFeedTimeStamps().get(i).getText();
                }
            }
        }
        if ((index[0]<index[1]) && index[1]<index[2]){
            Logz.step("Content type Titles created using priority are in expected order");
        }
        //Verifying Time Stamps Sorting Order
        String[] arrSorted = (String[]) commonMethodsPage.sortedResults(timeStamps,"Desc");
        Assert.assertEquals(arrSorted,timeStamps);
        listContentTitles.clear();
    }

    public FeedHomePage verifyArticalLikeFunctionality() throws Exception{
        String contentTitle = getContentTitles().get(0).getText();
        getContentTitles().get(0).click();
        if (isElementPresent(btnLiked)){
            getBtnLiked().getControl().click();
        }
        getBtnLike().getControl().click();
        Thread.sleep(5000);
        Assert.assertTrue(getBtnLiked().getControl().getText().equalsIgnoreCase("Liked"));
        getHeaderLogoLink().click();
        for(int i=0;i<getContentTitles().size();i++){
            if(contentTitle.equalsIgnoreCase(getContentTitles().get(i).getText())){
                getContentTitles().get(0).click();
                break;
            }
        }
        Assert.assertTrue(getBtnLiked().getControl().getText().equalsIgnoreCase("Liked"));
        return new FeedHomePage(driver);
    }

    public boolean verifyNewsFeedContentTitles() throws Exception {
        boolean flag=false;
        for(int i=0;i<getContentTitles().size();i++){
            if((getContentTitles().get(i).getText()).equalsIgnoreCase(contentTitle)){
                Logz.step("The content title: "+contentTitle+" which is created under News Feed section is displayed as expected");
                flag=true;
                break;
            }
            if(i==getContentTitles().size()-1)
                Logz.step("The content title: "+contentTitle+" is not displayed");
        }
        return flag;
    }

    public FeedHomePage verifyNewsFeedContentDetailsForExcludedUser()throws Exception{
        Assert.assertFalse(verifyNewsFeedContentTitles(),contentTitle+" is displayed in News Feed Section");
        return new FeedHomePage(driver);
    }

    private void verifyNotificationIcon(String notificationType) throws Exception {
        String notificationIconClass = getNotificationIconUsingTitle(notificationText).getAttribute("class");
        switch (notificationType) {
            case "Critical Update":
                Assert.assertTrue(notificationIconClass.contains("priority_high"));
                Logz.step("Critical Update icon is displayed");
                break;
            case "General Notification":
                Assert.assertTrue(notificationIconClass.contains("info_outline"));
                Logz.step("General Notification icon is displayed");
                break;
            case "Window Kit Notification":
                Assert.assertTrue(notificationIconClass.contains("map-o"));
                Logz.step("Window Kit Notification icon is displayed");
                break;
            case "Ops Manual Update Notification":
                Assert.assertTrue(notificationIconClass.contains("book"));
                Logz.step("Ops Manual Update Notification icon is displayed");
                break;
            case "Technology Update Notification":
                Assert.assertTrue(notificationIconClass.contains("arrow-circle-o-down"));
                Logz.step("Technology Update Notification icon is displayed");
                break;
            case "Technology Outage Alert":
                Assert.assertTrue(notificationIconClass.contains("cloud_off"));
                Logz.step("Technology Outage Alert icon is displayed");
                break;
            case "Technology Alert":
                Assert.assertTrue(notificationIconClass.contains("info_outline"));
                Logz.step("Technology Alert icon is displayed");
                break;
            case "Code Green Product Notification":
                Assert.assertTrue(notificationIconClass.contains("exclamation-triangle"));
                Logz.step("Code Green Product Notification icon is displayed");
                break;
            case "Code Yellow Product Alert":
                Assert.assertTrue(notificationIconClass.contains("exclamation-triangle"));
                Logz.step("Code Yellow Product Alert icon is displayed");
                break;
            case "Code Red Product Alert":
                Assert.assertTrue(notificationIconClass.contains("exclamation-triangle"));
                Logz.step("Code Red Product Alert icon is displayed");
                break;
        }
    }

    public FeedHomePage verifyNotificationDetails(String notificationType) throws Exception {
        verifyNotificationItemTitles();
        verifyNotificationIcon(notificationType);
        return new FeedHomePage(driver);
    }

    private int getNotificationItemIndex(String notifyText) throws Exception {
        int index = 0;
        waitForElementDisplay(link_NotificationItemTitle);
        for (int i = 0; i < getNotificationItemTitles().size(); i++) {
            if (getNotificationItemTitles().get(i).getText().equalsIgnoreCase(notifyText)) {
                Logz.step("Verified " + notifyText + " In Feed Notifications Section");
                index = i;
                break;
            }
            if (i == getNotificationItemTitles().size() - 1)
                Logz.step(notifyText + " is not displayed in Feed Notifications Section");
        }
        return index;
    }

    public FeedHomePage verifyNotificationsDisplayOrder() throws Exception {
        if (getNotificationItemIndex(listNotificationText.get(0)) < getNotificationItemIndex(listNotificationText.get(1))) {
            Logz.step(listNotificationText.get(0) + "is displayed before" + listNotificationText.get(1));
        } else
            Logz.step(listNotificationText.get(0) + "is displayed after" + listNotificationText.get(1));

        listNotificationText.clear();
        return new FeedHomePage(driver);
    }
    public FeedHomePage verifyNotificationsDetailsInDetailsPage()throws Exception{
        boolean flag=false;
        waitForElementDisplay(link_NotificationItemTitle);
        for(WebElement element:getNotificationItemTitles()){
            if(element.getText().equalsIgnoreCase(notificationText)){
                Logz.step("Verified "+notificationText+" In Feed Notifications Section");
                element.click();
                waitForElement();
                Assert.assertTrue(getArticleTitle().getControl().getText().contains(BaseTest.getStringfromBundleFile("defaultLanguage")),"Notification Artical Title is not equal");
                Logz.step("Verified content details after clicking on notification");
                flag=true;
                break;
            }
        }
        if(!flag)
            Logz.step(notificationText+" is not displayed in Feed Notifications Section");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyNotificationsSortingOrder()throws Exception{
        String arrTimeStamps[] = new String[getNotificationItemTimeStamps().size()];
        int i=0;
        waitForElementDisplay(link_NotificationItemTitle);
        for(WebElement element:getNotificationItemTimeStamps()){
            arrTimeStamps[i++] = element.getText();
        }
//        Logz.step("Item TimeStamps: "+arrTimeStamps);
        String[] arrSorted = (String[]) commonMethodsPage.sortedResults(arrTimeStamps,"Desc");
//        Logz.step("arrSorted Item TimeStamps: "+arrSorted);
        Assert.assertEquals(arrSorted,arrTimeStamps);
        return new FeedHomePage(driver);
    }

    public LoginPage logout() throws Exception {
        getMyProfileDropdown().click();
        Logz.step("Clicked on MyProfile");
        Assert.assertTrue(getSignOut().elementIsDisplayedAndEnabled());
        Logz.step("Sign Out link is displayed under My Profile drop down");
        getSignOut().click();
        Logz.step("Clicked on Sign Out");
        waitForElement();
        loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.getSignInButton().elementIsDisplayedAndEnabled(), "Logout not Successful");
        Logz.step("Logout successfully");
        return new LoginPage(driver);
    }

    private boolean verifyContentDisplayInHomeCarousel(String contentTitle)throws Exception{
        boolean flag=false;
        for(WebElement conTitle:getCarouselContentTitles()){
            if(conTitle.getText().contains(contentTitle)){
                Logz.step(contentTitle+"is displayed in carousel home");
                flag=true;
                break;
            }
        }
        return flag;
    }

    public FeedHomePage verifyHomeCarouselContentDisplayBeforeScheduleTime()throws Exception{
        Assert.assertEquals(verifyContentDisplayInHomeCarousel(contentTitle),false,"HomeCarousel content details are displayed before the schedule time");
        return new FeedHomePage(driver);
    }

//    public FeedHomePage verifyHomeCarouselContentDisplayed()throws Exception{
//        Thread.sleep(10000);
//        Assert.assertTrue(verifyContentDisplayInHomeCarousel(contentTitle));
//        Logz.step(contentTitle+" is displayed");
//        return new FeedHomePage(driver);
//    }

    public FeedHomePage verifyHomeCarouselContentDistributionPriority()throws Exception{
        Assert.assertTrue(getActiveCarouselTitle().getControl().getText().contains(listContentTitles.get(1)),listContentTitles.get(1)+" is not displayed in carousel home");
        Assert.assertTrue(verifyContentDisplayInHomeCarousel(listContentTitles.get(0)),listContentTitles.get(0)+" is not displayed in carousel home");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyHomeCarouselContentDetailsForTargetUsers()throws Exception{
        Assert.assertEquals(verifyContentDisplayInHomeCarousel(contentTitle),true,"Created content is not displayed in HomeCarousel section");
        return new FeedHomePage(driver);
    }
    public FeedHomePage verifyHomeCarouselContentDetailsForExcludedUsers()throws Exception{
        Assert.assertEquals(verifyContentDisplayInHomeCarousel(contentTitle),false,"Created content is not displayed in HomeCarousel section");
        return new FeedHomePage(driver);
    }

    private boolean verifyContentDisplayInHomeFeatures(String contentTitle)throws Exception{
        boolean flag=false;
        for(WebElement conTitle:getHomeFeatureContentTitles()){
            if(conTitle.getText().contains(contentTitle)){
                Logz.step(contentTitle+"is displayed in carousel home");
                flag=true;
                break;
            }
        }
        return flag;
    }

    public FeedHomePage verifyHomeFeaturesContentDisplay()throws Exception{
        Assert.assertTrue(verifyContentDisplayInHomeFeatures(contentTitle),contentTitle+" is not displayed in Home Features Section");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyHomeFeaturesContentDetailsForTargetedUser()throws Exception{
        Assert.assertTrue(verifyContentDisplayInHomeFeatures(contentTitle),contentTitle+" is not displayed in Home Features Section");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyHomeFeaturesContentDetailsForExcludedUsers()throws Exception{
        Assert.assertFalse(verifyContentDisplayInHomeFeatures(contentTitle),contentTitle+" is displayed in Home Features Section");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyCountOfHomeFeaturesDisplay()throws Exception{
        Assert.assertTrue(getHomeFeatureContentTitles().size()==5,"Count of HomeFeatures are "+getHomeFeatureContentTitles().size()+" but expected is:5");
        return new FeedHomePage(driver);
    }

    private int getHomeFeaturesContentItemIndex(String contentTitle )throws Exception{
        int index=0;
        for(int i=0;i<getHomeFeatureContentTitles().size();i++){
            if(contentTitle.equalsIgnoreCase(getHomeFeatureContentTitles().get(i).getText())){
                index=i;
            }
        }
        return index;
    }
    public FeedHomePage verifyDistributionPriorityOrderOfHomeFeaturesContent()throws Exception{
        if(getHomeFeaturesContentItemIndex(listContentTitles.get(1))<getHomeFeaturesContentItemIndex(listContentTitles.get(0)))
        {
            Logz.step(listContentTitles.get(1)+" is displayed before:"+listContentTitles.get(0));
        }
        else
            Logz.step(listContentTitles.get(1)+" is displayed after:"+listContentTitles.get(0));

        String []HomeFeaturesContentDates=new String[getHomeFeaturesContentDates().size()];
        int k=0;
        for(WebElement element:getHomeFeaturesContentDates())
        {
            HomeFeaturesContentDates[k++]=element.getText();
        }
        commonMethodsPage = new CommonMethodsPage(driver);
        Assert.assertEquals(HomeFeaturesContentDates,commonMethodsPage.sortedResults(HomeFeaturesContentDates,"Desc"),"Home Features Content dates are not displayed in Descending Order");
        Logz.step("Home Features Section Content Titles are displayed based on submitted date and distribution priority");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyNewsFeedOlderContents()throws Exception{
        verifyNewsFeedContentTitles();
        if(getReadMoreButton().elementIsDisplayedAndEnabled()){
            getReadMoreButton().click();
            if(getContentTitles().size()>5)
                Logz.step("User is able to see NewsFeed OlderContent details");
            else
                Logz.step("User is not able to see NewsFeed OlderContent details");
        }
        else
            Logz.step("AtLeast add 5 News Feed Related Content Types to see ReadMore button");
        return new FeedHomePage(driver);
    }
    private int getNewsFeedContentItemIndex(String contentTitle)throws Exception{
        int index=0;
        for(int i=0;i<getContentTitles().size();i++){
                if(contentTitle.equalsIgnoreCase(getContentTitles().get(i).getText())){
                    index=i;
                }
            }
        return index;
    }

    public FeedHomePage verifyDistributionPriorityOrderOfNewsFeedContent()throws Exception{
        if(getNewsFeedContentItemIndex(listContentTitles.get(1))<getNewsFeedContentItemIndex(listContentTitles.get(0))){
            Logz.step(listContentTitles.get(1)+" is displayed before:"+listContentTitles.get(0));
        }
        else {
            Logz.step(listContentTitles.get(1) + " is displayed after:"+listContentTitles.get(0));
        }
        verifyNewsFeedContentTimeStampOrdering();
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyNewsFeedContentTimeStampOrdering()throws Exception{
        String []NewsFeedContentTimeStamps=new String[getNewsFeedTimeStamps().size()];
        int k=0;
        for(WebElement element:getNewsFeedTimeStamps())
        {
            NewsFeedContentTimeStamps[k++]=element.getText();
        }
        commonMethodsPage = new CommonMethodsPage(driver);
        Assert.assertEquals(NewsFeedContentTimeStamps,commonMethodsPage.sortedResults(NewsFeedContentTimeStamps,"Desc"),"Timestamps are not displayed in Descending Order");
        Logz.step("News Feed Section Content Titles are displayed based on submitted date and distribution priority");
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyFavoritedListInOrder() throws Exception {
        scrollDown();
        List<WebElement> favorites = getFavorites();
        String names[] = new String[favorites.size()];
        int k = 0;
        for (int i = 0; i < favorites.size(); i++) {
            names[k++] = favorites.get(i).getText();
        }
        List<WebElement> actual = getFavorites();
        String actualFavorites[] = new String[actual.size()];
        int j = 0;
        for (int i = 0; i < favorites.size(); i++) {
            actualFavorites[j++] = actual.get(i).getText();
        }
        commonMethodsPage = new CommonMethodsPage(driver);
        Assert.assertEquals(actualFavorites, commonMethodsPage.sortedResults(names, "Asc"));
        Logz.step("Verified Results in alphabetical order");
        return new FeedHomePage(driver);
    }

    public FeedHomePage clickProfileSettings()throws Exception{
        getProfileSettings().click();
        Logz.step("Clicked on Profile Settings");
        return new FeedHomePage(driver);
    }

    public ProfileSettingsPage navigateToProfileSettingsPage() throws Exception {
        getMyProfileDropdown().click();
        Logz.step("Clicked on MyProfile");
        clickProfileSettings();
        waitForElement();
        return new ProfileSettingsPage(driver);
    }
    public FeedHomePage verifyNewsFeedSectionInHomePage()throws Exception{
        isElementPresent(newsFeedSection);
        Logz.step("User is able to see News Feed section in Home Page");
        return new FeedHomePage(driver);
    }
    public FeedHomePage verify404Page()throws Exception{
        String url= getDriver().getCurrentUrl();
        url=url+"/"+ RandomStringUtils.randomAlphanumeric(4);
        Logz.step("Appended "+url+" text to the current URL");
        getDriver().get(url);
        Assert.assertTrue(getDriver().getTitle().equals("404 Page Not Found - The Feed"));
        Logz.step(getDriver().getTitle()+": Page is displayed");
        return new FeedHomePage(driver);
    }
    public FeedHomePage footerSectionInAllPages()throws Exception{
        scrollDown();
        isElementPresent(pageFooter);
        Logz.step("User is able to view footer at the bottom of the screen ");

        return new FeedHomePage(driver);
    }
    public SearchResultsPage searchForAnItemUsingContentTitle() throws Exception {
        clickSearchIcon();
        getSearchTextBox().setText(contentTitle);
        Logz.step("Entered content keyword");
        clickSearchIcon();
        waitForJSandJQueryToLoad();
        return new SearchResultsPage(driver);
    }
    public FeedHomePage verifyContentInHomeNewsFeedSection()throws Exception{
        verifyNewsFeedSectionInHomePage();
        for(int i=0;i<50;i++){
            if(getHomeNewsFeedContent(contentTitle).getControl().isDisplayed()){
                verifyNewsFeedContentTitles();
                break;
            }else{
                waitForElement();
                reloadWebPage();
            }
        }

        return new FeedHomePage(driver);
    }
}
