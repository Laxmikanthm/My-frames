package pages.Feed;

import base.FeedMethodsLibrary;
import base.gui.controls.browser.Button;
import base.gui.controls.browser.Generic;
import base.gui.controls.browser.LinkText;
import base.gui.controls.browser.TextBox;
import base.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import pages.AuthoringCenter.Content.ContentPage;
import pages.AuthoringCenter.LoginPage;
import utils.Logz;
import java.util.ArrayList;
import java.util.List;

public class ProfileSettingsPage extends FeedMethodsLibrary {

    private static final By btn_SavePreferences = By.id("btnSavePreferences");
    private By link_PushOn = By.xpath("//label[@class='switch switch-push']/input[@checked='checked']");
    private By link_Push = By.xpath("//label[@class='switch switch-push']/span[@class='switch-label']");
    private By link_PushOptDisabled = By.xpath("//span[@class='switch-label disabled']");
    private By link_DeliveryMethodOptIn = By.xpath("//label[@class='switch switch-pushOptIn']/input");
    private By link_PushForDeliveryMethod = By.xpath("//label[@class='switch switch-pushOptIn']");
    private By btn_timeZone=By.xpath("//button[@data-id='dlTimeZone']");
    private By txt_TimezoneValue=By.xpath("//button[@data-id='dlTimeZone']/span[@class='filter-option pull-left']");
    private By btn_preferredLanguage=By.xpath("//button[@data-id='dlLanguage']");
    private By txt_PreferredLanguageValue=By.xpath("//button[@data-id='dlLanguage']/span[@class='filter-option pull-left']");
    private By txt_UserEmail=By.id("txtEmail");
    private By link_EmailPreference = By.xpath("//label[@class='switch switch-email']/span[@class='switch-label']");
    private By alertsTable=By.xpath("//div[@class='alerts-table']");
    private By list_AlertTypes=By.xpath("//tr[@class='notifRow']//div[@class='item-info']");
    private By txt_SuccessMsg = By.xpath("//div[contains(@class,'jq-icon-success')]");
    private By link_FeedLogo=By.xpath("//a[@class='header-logo']");
    private By txt_Copyright = By.xpath("//div[@class='col-sm-6 footer-copyright']");
    private By link_TermsOfUse = By.xpath("//a[contains(text(),'" + BaseTest.getStringfromBundleFile("termsOfUse") + "')]");
    private By link_PrivacyStatement = By.xpath("//a[contains(text(),'" + BaseTest.getStringfromBundleFile("privacyStatement") + "')]");
    private By link_SignOut = By.xpath("//div[@class='dropdown-menu']//a[text()[normalize-space()='" + BaseTest.getStringfromBundleFile("signOut") + "']]");
    private By btn_MyProfileDropdown = By.xpath("//div[@class='dropdown dropdown-profile']//span[@class='caret']");

    public ProfileSettingsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        waitForPageToLoad();
    }

    @Override
    public void waitForPageToLoad() throws Exception {
        if (getSavePreferencesButton().elementIsDisplayedAndEnabled()) {
            Logz.step("Profile Settings Page is displayed");
        }
    }

    private LinkText getSignOut() throws Exception {
        return new LinkText(driver, link_SignOut, "Logout link");
    }

    private Button getMyProfileDropdown() throws Exception {
        return new Button(driver, btn_MyProfileDropdown, "My Profile dropdown");
    }

    private List<WebElement> getPushedOptions()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(link_PushOn));
    }

    private List<WebElement> getPushOptions()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(link_Push));
    }

    private List<WebElement> getPushOptionsDisabled()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(link_PushOptDisabled));
    }

    private Button getSavePreferencesButton()throws Exception{
        return new Button(driver,btn_SavePreferences,"Save Preferences");
    }

    private LinkText getDeliveryMethodOpt()throws Exception{
        return new LinkText(driver,link_DeliveryMethodOptIn,"Delivery Method Opt In");
    }

    private LinkText getDeliveryMethodPush()throws Exception{
        return new LinkText(driver,link_PushForDeliveryMethod,"Delivery Method Push");
    }

    private List<WebElement> getEmailPreference()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(link_EmailPreference));
    }

    private Button getTimeZoneDropdown()throws Exception{
        return new Button(driver,btn_timeZone,"Time zone");
    }
    private Generic getSelectTimezone(String timeZone)throws Exception{
        return new Generic(driver,By.xpath("//ul[@aria-expanded='true']//span[contains(text(),'"+timeZone+"')]/parent::a"),"select timezone");
    }
    private Generic getSelectedTimezoneValue()throws Exception{
        return new Generic(driver,txt_TimezoneValue,"Selected Timezone value");
    }
    private Button getPreferredLangDropdown()throws Exception{
        return new Button(driver,btn_preferredLanguage,"Preferred Language");
    }
    private Generic getSelectPreferredLanguage(String prefLanguage)throws Exception{
        return new Generic(driver,By.xpath("//ul[@aria-expanded='true']//span[contains(text(),'"+prefLanguage+"')]"),"select preferred Language");
    }
    private Generic getSelectedPreferredLangValue()throws Exception{
        return new Generic(driver,txt_PreferredLanguageValue,"Selected Preferred Language value");
    }
    private List<WebElement> getPreferredLanguageList()throws Exception{
        return getSelectedPreferredLangValue().getWebElements(By.xpath("//ul[@aria-expanded='true']/li"),"");
    }
    private TextBox getUserProfileEmailTextBox()throws Exception{
        return new TextBox(driver,txt_UserEmail,"User Profile Email");
    }
    private Generic getAlertsTable()throws Exception{
        return new Generic(driver,alertsTable,"Alerts Table");
    }
    private List<WebElement> getAlertTypesList()throws Exception{
        return getAlertsTable().getWebElements(list_AlertTypes,"Alert Types");
    }
    private Generic getSuccessMessage() throws Exception {
        return new Generic(driver, txt_SuccessMsg, "Success Message");
    }
    private LinkText getTheFeedLogoLink()throws Exception{
        return new LinkText(driver,link_FeedLogo,"TheFeed Logo");
    }

    private LinkText getPrivacyStatementText() throws Exception {
        return new LinkText(driver, link_PrivacyStatement, "Privacy Statement");
    }

    private Generic getFooterCopyrightText() throws Exception {
        return new Generic(driver, txt_Copyright, "CopyRight");
    }

    private LinkText getFooterTermsOfUse() throws Exception {
        return new LinkText(driver, link_TermsOfUse, "Terms Of Use");
    }

    //Functional Methods
    private void verifyEmailPreference()throws Exception{
        boolean temp = false;
        for(WebElement ele:getEmailPreference()) {
            temp = false;
            if (ele.getCssValue("background-color").equals(BaseTest.getStringfromBundleFile("blue"))) {
                temp = true;
            } else{
                ele.click();
                Assert.assertEquals(ele.getCssValue("background-color"), BaseTest.getStringfromBundleFile("blue"));
                temp = true;
            }
        } if (temp) {
            Logz.step("Enabled email preference and button is green");
        }
        else{
            Logz.step("Button is not enabled email preference and color is not green");
        }
    }

    private void verifyPushPreference()throws Exception{
        boolean temp = false;
        for(WebElement element:getPushOptions()) {
            temp = false;
            if (element.getCssValue("background-color").equals(BaseTest.getStringfromBundleFile("blue"))) {
                temp = true;
            } else{
                element.click();
                waitForElement();
                Assert.assertEquals(element.getCssValue("background-color"), BaseTest.getStringfromBundleFile("blue"));
                temp = true;
            }
        } if (temp) {
            Logz.step("Enabled push preference and button is green");
        }
        else{
            Logz.step("Button is not enabled push preference and color is not green");
        }
    }



    public ProfileSettingsPage verifyPushOptions() throws Exception{
        scrollDown();
        int beforeClickPushOption = getPushedOptions().size();
        for(WebElement ele: getPushOptions()){
             ele.click();
        }
        getSavePreferencesButton().click();
        waitForElement();
        driver.navigate().refresh();
        Assert.assertNotEquals(beforeClickPushOption, getPushedOptions().size(), "Push options are not saved under delivery method");
        Logz.step("Push options are saved under delivery method");
        return new ProfileSettingsPage(driver);
    }

    public ProfileSettingsPage verifyTurnOnOrOffNotificationsForPush() throws Exception{
        scrollDown();
        if(getDeliveryMethodOpt().getAttribute("checked").equalsIgnoreCase("true"))
        {
            getDeliveryMethodPush().click();
            Logz.step("Toggle delivery method opt in-push set to NO");

            for(WebElement ele: getPushOptionsDisabled()){
              Assert.assertTrue(ele.isDisplayed(), "unable to enable push notification items after delivery method opt in is set NO for push as not expected :" + ele.getText());
            }
            Logz.step("unable to enable push notification items after delivery method opt in is set NO for push as expected");

        }
        else{
            getDeliveryMethodPush().click();
            Logz.step("Toggle delivery method opt in-push set to Yes");
            verifyPushOptions();
        }
        return new ProfileSettingsPage(driver);
    }

    public ProfileSettingsPage verifyEmailAndPushCheckBoxesAreEnabled()throws Exception{
        scrollDown();
        int beforeClickPushOption = getPushedOptions().size();
        verifyEmailPreference();
        verifyPushPreference();
        getSavePreferencesButton().click();
        waitForElement();
        driver.navigate().refresh();
        scrollDown();
        Assert.assertNotEquals(beforeClickPushOption, getPushedOptions().size(), "Push options are not saved under delivery method");
        Logz.step("Push options are saved under delivery method");
        return new ProfileSettingsPage(driver);
    }

    private ProfileSettingsPage clickSavePreferences()throws Exception{
        getSavePreferencesButton().click();
        Logz.step("Clicked on Save Preferences");
        verifyPopupMessage();
        return new ProfileSettingsPage(driver);
    }
    private ProfileSettingsPage clickTimezoneDropdown()throws Exception{
        getTimeZoneDropdown().click();
        Logz.step("Clicked on Timezone dropdown");
        return new ProfileSettingsPage(driver);
    }
    private ProfileSettingsPage clickPreferredLanguageDropdown()throws Exception{
        getPreferredLangDropdown().click();
        Logz.step("Clicked on Preferred Language dropdown");
        return new ProfileSettingsPage(driver);
    }

    public ProfileSettingsPage changeUserProfileTimeZone(String timeZone)throws Exception{
        clickTimezoneDropdown();
        getSelectTimezone(timeZone).getControl().click();
        Logz.step(timeZone+" :Timezone is selected");
        clickSavePreferences();
        reloadWebPage();
        Assert.assertEquals(timeZone,getSelectedTimezoneValue().getControl().getText(),"Timezone is not Updated");
        Logz.step("TimeZone have been updated");
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage changeUserPreferredLanguage(String preferredLanguage)throws Exception{
        clickPreferredLanguageDropdown();
        if(getPreferredLanguageList().size()>0){
            Logz.step("Languages list is displayed on Preferred language drop down");
        }else{
            Logz.error("There is no languages appeared on the drop down");
        }
        getSelectPreferredLanguage(preferredLanguage).getControl().click();
        Logz.step(preferredLanguage+" :Preferred Language is selected");
        clickSavePreferences();
        reloadWebPage();
        waitForElement();
        Assert.assertEquals(preferredLanguage,getSelectedPreferredLangValue().getControl().getText(),"Preferred Language is not Updated");
        Logz.step("Preferred Language have been updated");
        getPreferredLangDropdown().click();
        getSelectPreferredLanguage(BaseTest.getStringfromBundleFile("english")).getControl().click();
        getSavePreferencesButton().click();
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage verifyUserShouldNotChangeUserPreferredEmail()throws Exception{
        Assert.assertFalse(getUserProfileEmailTextBox().getControl().isEnabled());
        Logz.step(" User is not having option to edit Email");
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage alertTypesInNotificationsSection()throws Exception{
        String[] alerts=BaseTest.getStringfromBundleFile("alertTypes").split(",");
        List<String> alertTypesList=new ArrayList();
        for(int i=0;i<alerts.length;i++)
        {
            alertTypesList.add(alerts[i].trim());
        }
        for(int i=0;i<alertTypesList.size();i++){
            if(alertTypesList.contains(getAlertTypesList().get(i).getText())){
                Logz.step(getAlertTypesList().get(i).getText()+": Alert Type is present in the Notification Settings");
            }else {
                Logz.error(getAlertTypesList().get(i).getText()+": Alert Type is not present in the Notification Settings");
            }
        }
        return new ProfileSettingsPage(driver);
    }
    public ProfileSettingsPage verifyPopupMessage()throws Exception{
        if(!getSuccessMessage().getControl().getAttribute("style").contains("display: none;")){
//        Assert.assertTrue(getSuccessMessage().getControl().getText().contains(message));
            Assert.assertTrue(getSuccessMessage().elementIsDisplayedAndEnabled());
            Logz.step(getSuccessMessage().getControl().getText()+" message is displayed");
        }else{
            Logz.step("Unable to see message");
        }
        return new ProfileSettingsPage(driver);
    }
    public FeedHomePage changeUserLanguage(String preferredLanguage)throws Exception{
        clickPreferredLanguageDropdown();
        getSelectPreferredLanguage(preferredLanguage).getControl().click();
        Logz.step(preferredLanguage+" :Preferred Language is selected");
        clickSavePreferences();
        getTheFeedLogoLink().click();
        Logz.step("Clicked on The Feed logo");
        waitForElement();
        return new FeedHomePage(driver);
    }

    public FeedHomePage verifyFooterInTheProfileSettingsPage() throws Exception {
        scrollDown();
        if (getFooterCopyrightText().getControl().getText().toString().contains(BaseTest.getStringfromBundleFile("copyright"))) {
            Logz.step("Copyright text is displayed in the profile setting page");
        }
        Assert.assertEquals(getFooterTermsOfUse().getText().toString(), BaseTest.getStringfromBundleFile("termsOfUse"), "Terms of Use link is not displayed in the footer");
        Logz.step("Terms of Use link is displayed in the profile setting page");
        Assert.assertEquals(getPrivacyStatementText().getText().toString(), BaseTest.getStringfromBundleFile("privacyStatement"), "Privacy Statement link is not displayed in the footer");
        Logz.step("Privacy Statement link is displayed in the profile setting page");
        getTheFeedLogoLink().click();
        waitForElement();
        return new FeedHomePage(driver);
    }

    public LoginPage changePreferredLanguage(String preferredLanguage)throws Exception{
        clickPreferredLanguageDropdown();
        if(getPreferredLanguageList().size()>0){
            Logz.step("Languages list is displayed on Preferred language drop down");
        }else{
            Logz.error("There is no languages appeared on the drop down");
        }
        getSelectPreferredLanguage(preferredLanguage).getControl().click();
        Logz.step(preferredLanguage+" :Preferred Language is selected");
        clickSavePreferences();
        logout();
        return new LoginPage(driver);
    }

    public ProfileSettingsPage verifyPreferredLanguage(String preferredLanguage)throws Exception{
        Assert.assertEquals(preferredLanguage,getSelectedPreferredLangValue().getControl().getText(),"Preferred Language is not Updated");
        Logz.step("Preferred Language as" +getSelectedPreferredLangValue().getControl().getText());
        return new ProfileSettingsPage(driver);
    }

    public LoginPage logout() throws Exception {
        getMyProfileDropdown().click();
        Logz.step("Clicked on MyProfile");
        Assert.assertTrue(getSignOut().elementIsDisplayedAndEnabled());
        Logz.step("Sign Out link is displayed under My Profile drop down");
        getSignOut().click();
        Logz.step("Clicked on Sign Out");
        waitForElement();
        return new LoginPage(driver);
    }
}
