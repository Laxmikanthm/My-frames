package pages;

import base.gui.controls.browser.Button;
import base.gui.controls.browser.LinkText;
import base.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.FeedMethodsLibrary;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import pages.AuthoringCenter.Content.*;
import pages.AuthoringCenter.Distributions.AwaitingApprovalPage;
import pages.AuthoringCenter.Distributions.DistributionApprovedPage;
import pages.AuthoringCenter.Distributions.DistributionDraftPage;
import pages.AuthoringCenter.Distributions.DistributionsPage;
import pages.AuthoringCenter.LoginPage;
import pages.AuthoringCenter.Segments.SegmentsPage;
import pojos.AuthoringContent;
import pojos.SegmentPageData;
import utils.Logz;

import java.util.ArrayList;
import java.util.List;

@ContextConfiguration({ "classpath:AuthoringContentData.xml"})
public class CommonMethodsPage<T extends RemoteWebDriver> extends FeedMethodsLibrary {

    public CommonMethodsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
//        waitForPageToLoad();
    }

    private DraftPage draftPage;
    private ContentPage contentPage;
    private PublishedPage publishedPage;
    private ValidationPage validationPage;
    private SegmentsPage segmentsPage;
    private ApprovedPage approvedPage;
    private DistributionsPage distributionsPage;
    private AwaitingApprovalPage awaitingApprovalPage;
    private DistributionApprovedPage distributionApprovedPage;
    private DistributionDraftPage distributionDraftPage;


    @Autowired
    AuthoringContent authoringContentTestData;

    private By dropdown_Languages=By.xpath("//ul[@class='dropdown-menu']/li");
    private By btn_SwitchLanguage=By.xpath("//button[@class='btn-language dropdown-toggle']//span[contains(text(),'"+BaseTest.getStringfromBundleFile("switchLanguageLink")+"')]");
    private By link_Logout = By.xpath("//a[@class='banner-link']//span[contains(text(),'"+BaseTest.getStringfromBundleFile("logoutLink")+"')]");
    private By link_Segments= By.xpath("//span[contains(text(),'"+BaseTest.getStringfromBundleFile("segmentsLink")+"')]");

    public List<WebElement> getLanguagesList()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(dropdown_Languages));
    }
    public Button getSwitchLanguageButton()throws Exception{
        return new Button(driver,btn_SwitchLanguage,"Switch Language Button");
    }
    private Button getLogOutLink()throws Exception {
        return new Button(driver,link_Logout,"Logout");
    }
    private LinkText getSegmentsLink()throws Exception{
        return new LinkText(driver,link_Segments, "Segments Link");
    }
    public void verifySwitchLanguage(String language)throws Exception
    {
        getSwitchLanguageButton().click();
        waitForJSandJQueryToLoad();
        for(int i=0;i<getLanguagesList().size();i++)
        {
            if(((WebElement)getLanguagesList().get(i)).getText().contains(language))
            {
                ((WebElement)getLanguagesList().get(i)).click();
                Logz.step("Selected language is:"+getLanguagesList().get(i).getText());
                waitForElement();
                break;
            }
            if(i==getLanguagesList().size())
                Logz.step("Please enter valid language");
        }
    }

    //Functional Methods
    public LoginPage logout() throws Exception {
        getLogOutLink().click();
        Logz.step("Successfully clicked on Logout button");
        waitForElement();
        return new LoginPage(driver);
    }

//    public void verifySuccessIcon(By ele) throws Exception {
//        while(isElementPresent(ele)){
//            Thread.sleep(1000);
//        }
//    }

    public DistributionApprovedPage createContentAndDistribute(AuthoringContent authoringContentTestData, String priority,String distLocation) throws Exception {
        draftPage = new DraftPage(driver);
        contentPage = draftPage.clickNewContent();
        validationPage = contentPage.createNewContent(BaseTest.getStringfromBundleFile("singleSectionNewsPage"), authoringContentTestData, BaseTest.getStringfromBundleFile("defaultLanguage"));
        segmentsPage = draftPage.clickSegments();
        segmentsPage = segmentsPage.createSegmentWithRole(BaseTest.getStringfromBundleFile("AdAgencyContact"));
        draftPage=segmentsPage.clickOnContent();
        validationPage = draftPage.clickOnValidation();
        approvedPage = validationPage.verifyApproveContent(BaseTest.getStringfromBundleFile("defaultLanguage"));
        distributionsPage = approvedPage.searchUrlAndSelectDistributeUnderActions(BaseTest.getStringfromBundleFile("defaultLanguage"));
        awaitingApprovalPage = distributionsPage.createDistribution(priority,distLocation);
        distributionApprovedPage = awaitingApprovalPage.submitDistribution();
        distributionApprovedPage.verifyDistributedColumnStatus();
        return new DistributionApprovedPage(driver);
    }

    public SegmentsPage createContentAndApprove(AuthoringContent authoringContentTestData)throws Exception{
        draftPage = new DraftPage(driver);
        contentPage = draftPage.clickNewContent();
        validationPage = contentPage.createNewContent(BaseTest.getStringfromBundleFile("singleSectionNewsPage"), authoringContentTestData, BaseTest.getStringfromBundleFile("defaultLanguage"));
        approvedPage = validationPage.verifyApproveContent(BaseTest.getStringfromBundleFile("defaultLanguage"));
        approvedPage.verifyContentInApprovedPageTable();
        segmentsPage = draftPage.clickSegments();
        segmentsPage = segmentsPage.createSegmentWithRole(BaseTest.getStringfromBundleFile("AdAgencyContact"));
        return new SegmentsPage(driver);
    }

    public DistributionApprovedPage createNotificationAndDistribute(String notificationType,String priority)throws Exception{
        draftPage = new DraftPage(driver);
        approvedPage = draftPage.clickApproved();
        validationPage = approvedPage.createNotification(notificationType);
        approvedPage = validationPage.verifyPublishNotification();
        distributionsPage = approvedPage.searchNotificationAndClickonDistribute();
        awaitingApprovalPage = distributionsPage.createDistributionForNotification(priority);
        distributionApprovedPage = awaitingApprovalPage.verifyApproveDistribution();
        distributionApprovedPage.verifyDistributionInApprovedDistributionTable();
        distributionApprovedPage.verifyDistributedColumnStatus();
        return new DistributionApprovedPage(driver);
    }

    public AwaitingApprovalPage createDistributionForApprovedContent(String priority,String locationType)throws Exception{
        draftPage = new DraftPage(driver);
        approvedPage = draftPage.clickApproved();
        distributionsPage=approvedPage.verifyMenuActionsAndClickOnDistribute(BaseTest.getStringfromBundleFile("defaultLanguage"));
        awaitingApprovalPage=distributionsPage.createDistribution(priority,locationType);
        return new AwaitingApprovalPage(driver);
    }

    public DistributionApprovedPage approveDistribution()throws Exception{
        draftPage = new DraftPage(driver);
        distributionDraftPage=draftPage.clickDistribution();
        awaitingApprovalPage=distributionDraftPage.clickAwaitingApproval();
        distributionApprovedPage=awaitingApprovalPage.verifyApproveDistribution();
        distributionApprovedPage.verifyDistributionInApprovedDistributionTable();
        return new DistributionApprovedPage(driver);
    }

    public DistributionApprovedPage findDocTypeAndDistribute(AuthoringContent authoringContentTestData, String priority,String distLocation) throws Exception {
        draftPage = new DraftPage(driver);
        segmentsPage = draftPage.clickSegments();
        segmentsPage = segmentsPage.createSegmentWithRole(BaseTest.getStringfromBundleFile("AdAgencyContact"));
        draftPage=segmentsPage.clickOnContent();
        publishedPage = draftPage.clickOnPublished();
        approvedPage=publishedPage.getUrlNameOfTypeDoc();
        distributionsPage = approvedPage.searchUrlAndSelectDistributeUnderActions(BaseTest.getStringfromBundleFile("defaultLanguage"));
        awaitingApprovalPage = distributionsPage.createDistribution(priority,distLocation);
        distributionApprovedPage = awaitingApprovalPage.submitDistribution();
        distributionApprovedPage.verifyDistributedColumnStatus();
        return new DistributionApprovedPage(driver);
    }

    public <E extends Comparable<E>> E[] sortedResults(E a[],String sortType)
    {
        int len=a.length;
        E temp;
        if(sortType.equalsIgnoreCase("Asc"))
        {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (a[i].compareTo(a[j]) > 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;

                    }
                }
            }
        }
        else if(sortType.equalsIgnoreCase("Desc"))
        {
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (a[i].compareTo(a[j]) < 0) {
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;

                    }
                }
            }
        }
        return a;
    }
    public DraftPage createContentWithSpecificTagAndApprove(AuthoringContent authoringContentTestData, String tagType, String tagName)throws Exception{
        draftPage = new DraftPage(driver);
        contentPage = draftPage.clickNewContent();
        validationPage = contentPage.CreateContentWithSpecificTags(BaseTest.getStringfromBundleFile("singleSectionNewsPage"), authoringContentTestData, BaseTest.getStringfromBundleFile("defaultLanguage"),tagType,tagName);
        segmentsPage = draftPage.clickSegments();
        segmentsPage = segmentsPage.createSegmentWithRole(BaseTest.getStringfromBundleFile("AdAgencyContact"));
        draftPage=segmentsPage.clickOnContent();
        validationPage = draftPage.clickOnValidation();
        approvedPage = validationPage.verifyApproveContent(BaseTest.getStringfromBundleFile("defaultLanguage"));
        validationPage.navigateToDraftPage();
        return new DraftPage(driver);
    }

    public SegmentsPage clickSegments() throws Exception {
        WebElement element = driver.findElement(By.xpath("//i[@class='icon icon-users']"));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        getSegmentsLink().click();
        Logz.step("Clicked on segments link");
        return new SegmentsPage(driver);
    }

}

