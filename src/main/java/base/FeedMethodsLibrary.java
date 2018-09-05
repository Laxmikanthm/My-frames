package base;

import base.gui.controls.browser.Generic;
import base.gui.controls.browser.TextBox;
import base.pages.browser.BrowserBasePage;
import base.test.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logz;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class FeedMethodsLibrary extends BrowserBasePage{

    public static String urlText;
    public static String segmentName;
    public static String distributionName;
    public static String notificationText;
    public static String notificationName;
    public static String articleTitle;
    public static String scheduleDate;
    public static String ctaHeadLine;
    public static String ctaSubHeadLine;
    public static String contentTitle;
    public static ArrayList<String> listNotificationText=new ArrayList<String>();
    public static ArrayList<String> listContentTitles=new ArrayList<String>();
    public static ArrayList<String> listSegmentNames=new ArrayList<String>();

    public static String contentCategoryText;
    public FeedMethodsLibrary(RemoteWebDriver driver) throws Exception {
        super(driver);
    }

    	private final String randomSTRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    WebDriverWait wait=new WebDriverWait(driver,60);

    public static String getPropertyText(String strPropertyKey)throws Exception{
        return BaseTest.getStringfromBundleFile(strPropertyKey);
    }
    public void jsClick(By Element,String elemName)throws Exception{
        try{
            WebElement we = driver.findElement(Element);
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("arguments[0].click();", we);
            Logz.step("Clicked on "+elemName);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void typeInTextField(TextBox textBox,String value) throws Exception{
        textBox.click();
        textBox.getControl().sendKeys(value);
    }
    public List<WebElement> getElements(By locator){
        List<WebElement> ele=driver.findElements(locator);
        return ele;
    }
    public void reloadWebPage(){
        try {
            driver.navigate().refresh();
            waitForPageToLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void waitForElement()throws Exception{
        try{
            Thread.sleep(9000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public int randomNumber(List<WebElement> elementsList)throws Exception{
        int randomNum;
        try{
            Random rand = new Random();
            randomNum = rand.nextInt((elementsList.size()-1 - 0) + 1) + 0;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }return randomNum;
    }
    public void scrollUp() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-500)", "");
    }
    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,600)", "");
    }
    public void clickKeyboardDownArrow(By category)throws Exception{
        try{
            WebElement role=driver.findElement(category);
            role.sendKeys(Keys.ARROW_DOWN);
            Logz.step("Clicked on keyboard Down Arrow button");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickKeyboardDownArrow(TextBox users)throws Exception{
        try{
            users.getControl().sendKeys(Keys.ARROW_DOWN);
            Logz.step("Clicked on keyboard arrow down button");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickKeyboardEnter(By element)throws Exception{
        try{
            WebElement search=driver.findElement(element);
            search.sendKeys(Keys.ENTER);
            Logz.step("Clicked on keyboard Enter button");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void clickKeyboardEnter(TextBox element)throws Exception{
        try{
            element.getControl().sendKeys(Keys.ENTER);
            Logz.step("Clicked on keyboard Enter button");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    public void navigateToPageUrl(String url) throws Exception {
        try {
            waitForPageToLoad();
            driver.get(url);
            Logz.step("Navigating to URL: " + url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Timestamp getCurrentTimeStamp() throws Exception {
        long currentTimeInMilliSec = System.currentTimeMillis();
        return new Timestamp(currentTimeInMilliSec);
    }


    public String dateCreator(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat(s);
        String date = sdf.format(new Date());
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DATE, 25);
        cal.getTime();
        System.out.println(date);
        return date;
    }
    /*public void navigateBack()throws Exception{
        try{
            driver.navigate().back();
            Logz.step("Navigating to previous page");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }*/
    public void alertAccept()throws Exception{
        try{
            waitForAlert();
            Alert alert=driver.switchTo().alert();
            alert.accept();
            Logz.step("Clicked on Ok");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public int randInt(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void waitForAlert()throws Exception{
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public boolean isAlertPresent()throws Exception{
        boolean flag=false;
        try{
            if(wait.until(ExpectedConditions.alertIsPresent())==null){
                System.out.println("alert was not present");
            }else{
                flag=true;
                System.out.println("alert is present");
            }
        } catch (Exception ex){
            Logz.error(ex.getMessage());
            throw ex;
        }
        return flag;
    }

    public void waitForElementDisplay(By element)throws Exception{
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForElementPresence(By element)throws Exception{
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public String getAlertText() throws  Exception{
        String alertText = null;
        try{
            waitForAlert();
            alertText = driver.switchTo().alert().getText();
            Logz.step("Alert pop up is displayed");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
       return alertText;
    }

    public void ListOfElements(By item, String name) throws Exception {
        try {
            // List<WebElement> temp = driver.findElements(item);
            List<WebElement> temp = new Generic(driver, item, name).getWebElements(item, name);
            Iterator<WebElement> itr = temp.listIterator();
            while (itr.hasNext()) {
                WebElement ele = itr.next();
                ele.isDisplayed();
                String l = ele.getText();
                Logz.info(l);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public String RandomString(int count) {

		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * randomSTRING.length());
			builder.append(randomSTRING.charAt(character));
		}
		return builder.toString();
	}

	public void pageRefresh(){
        driver.navigate().refresh();
    }

    //This function is used to verify whether the element is present on the web page or not, If element present it returns "true" else returns "false"
    public boolean isElementPresent(By element) throws Exception{
        boolean present;
        try {
            driver.findElement(element);
            present = true;
        } catch (Exception e) {
            present = false;
        }
        return present;
    }
    public void waitForPageToLoad() throws Exception {

        Logz.step("Waiting for page to load.");

        String s = "";       while(!s.equals("complete")) {

            s = (String)this.driver.executeScript("return document.readyState", new Object[0]);           try {

                Thread.sleep(500L);

            } catch (InterruptedException var3) {

                Logz.error("Timed out waiting for page to load.");

                throw var3;

            }

        }       Logz.step("Page loaded.");

    }

    public boolean waitForJSandJQueryToLoad() {

        WebDriverWait wait = new WebDriverWait(driver, 180);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    boolean lValue = ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
                    Logz.step("::jQuery Active Status::" + lValue);
                    return lValue;
                    //return ((Long)((JavascriptExecutor)getDriver()).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                boolean bValue = ((JavascriptExecutor)getDriver()).executeScript("return document.readyState")
                        .toString().equals("complete");
                Logz.step("::Page Status::" + bValue);
                return bValue;
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    public void jQueryAJAXCallsHaveCompleted()
    {
        WebDriverWait wait = new WebDriverWait(driver, 180);
        //WebElement webTable = driver.findElement(By.id("myBtn"));
        try{
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//table[contains(@class,'table footable')]"))));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public int getDownloadedFilesCount() throws Exception{
        String filePath = System.getProperty("user.home")+"\\Downloads\\";
        File f = new File(filePath);
        File[] farr = f.listFiles();

        List<String> li = new ArrayList<String>();

        for(File f1 : farr)
        {
            li.add(f1.getName());
        }
        return li.size();
    }
}
