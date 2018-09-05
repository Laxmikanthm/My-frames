package tests.Feed;

import base.CentralAppContext;
import base.test.BaseTest;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.Test;
import pages.AuthoringCenter.LoginPage;
import pages.Feed.*;
import pojos.LoginCredentials;
import utils.Logz;

@ContextConfiguration({"classpath:LoginCredentialsData.xml"})
public class ProfileSettings extends CentralAppContext {
    private LoginPage<RemoteWebDriver> loginPage;
    private FeedHomePage feedHomePage;
    private ProfileSettingsPage profileSettingsPage;

    @Autowired
    LoginCredentials FeedLogin;

    //TFS Id: 160422
    //TFS Description: F - Receive alert via push notification
    @Test
    public void verifyReceiveAlert_160422_165429() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyPushOptions();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    //TFS Id: 185978
    //TFS Description: Feed - Turn on or off Notification Preferences for each alert severity
    @Test
    public void verifyColorWithTurnONOrOffNotification_185978_137634() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyEmailAndPushCheckBoxesAreEnabled();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    
    //TFS Id: 166819
    //TFS Description: C - Turn on or off Notification Preferences for Push
    @Test
    public void verifyReceiveAlert_166819() throws Exception {
        try {
            loginPage = goToHomePage(LoginPage.class, driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyTurnOnOrOffNotificationsForPush();
        } catch (Exception ex) {
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
    * Test Case ID: 146356
    * Test Case: C - Change User Profile Time Zone
    * */
    @Test
    public void changeUserProfileTimeZone_146356()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.changeUserProfileTimeZone(BaseTest.getStringfromBundleFile("indianTime"));
        }catch (Exception ex){

            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 137631
    * Test Case: C - Change User Profile Preferred Language
    * */
    @Test
    public void changeUserProfilePreferredLanguage_137631()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.changeUserPreferredLanguage(BaseTest.getStringfromBundleFile("germanLanguage"));
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
    * Test Case ID: 146364
    * Test Case: C - Shouldn't Change User Profile Preferred Email
    * */
    @Test
    public void userShouldNotChangeUserPreferredEmail_146364()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyUserShouldNotChangeUserPreferredEmail();
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }
    /*
     * Test Case ID: 185982
     * Test Case: Feed-Verify whether Alert Types Code Red, Code Yellow, Code Green, General are available in the Notification Settings
     * */
    @Test
    public void verifyAlertTypesInNotificationsSection_185982()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.alertTypesInNotificationsSection();
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 151941
     * Test Case: Central - Change Site Language - French
     * */
    @Test
    public void verifyUserProfilePreLanguageFrench_151941()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            loginPage = profileSettingsPage.changePreferredLanguage(BaseTest.getStringfromBundleFile("frenchLanguage"));
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyPreferredLanguage(BaseTest.getStringfromBundleFile("frenchLanguage"));
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 151945
     * Test Case: Central - Change Site Language - German
     * */
    @Test
    public void verifyUserProfilePreLanguageGerman_151945()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            loginPage = profileSettingsPage.changePreferredLanguage(BaseTest.getStringfromBundleFile("germanLanguage"));
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyPreferredLanguage(BaseTest.getStringfromBundleFile("germanLanguage"));
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 151979
     * Test Case: Central - Change Site Language - Portuguese
     * */
    @Test
    public void verifyUserProfilePreLanguagePortuguese_151979()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            loginPage = profileSettingsPage.changePreferredLanguage(BaseTest.getStringfromBundleFile("portugueseLanguage"));
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyPreferredLanguage(BaseTest.getStringfromBundleFile("portugueseLanguage"));
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

    /*
     * Test Case ID: 151931
     * Test Case: Central - Change Site Language - English
     * */
    @Test
    public void verifyUserProfilePreLanguageEnglish_151931()throws Exception{
        try{
            loginPage = goToHomePage(LoginPage.class,driverName);
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage=feedHomePage.navigateToProfileSettingsPage();
            loginPage = profileSettingsPage.changePreferredLanguage(BaseTest.getStringfromBundleFile("english"));
            feedHomePage = loginPage.loginToFeed(FeedLogin);
            profileSettingsPage = feedHomePage.navigateToProfileSettingsPage();
            profileSettingsPage.verifyPreferredLanguage(BaseTest.getStringfromBundleFile("english"));
        }catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
    }

}
