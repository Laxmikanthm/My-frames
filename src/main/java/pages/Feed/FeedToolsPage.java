package pages.Feed;

import base.FeedMethodsLibrary;
import base.gui.controls.browser.Generic;
import base.gui.controls.browser.LinkText;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Logz;
import java.util.ArrayList;
import java.util.List;

public class FeedToolsPage extends FeedMethodsLibrary {

    private By list_starIcon=By.xpath("//div[@class='app-container']/span");
    private By tools=By.xpath("//div[@id='home-tools-list']//li[@class='list-item']//div[@class='item-title']");
    private By link_Favorites=By.xpath("//a[@class='filter-link'][contains(.,'"+getPropertyText("favorites")+"')]");
    private By list_FavoriteStarIcon = By.xpath("//div[contains(@class,'app-container')]//span[@class='icon icon-star-o']");
    private By link_FeedLogo = By.xpath("//div[@class='nav-wrapper']//div[@class='logo-text']");

    public FeedToolsPage(RemoteWebDriver driver) throws Exception {
        super(driver);
        //waitForPageToLoad();
    }

    private List<WebElement> getFavoriteIcon()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(list_starIcon));
    }
    private List<WebElement> getTools()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(tools));
    }
    private LinkText getFavoritesLink()throws Exception{
        return new LinkText(driver,link_Favorites,"Favorites");
    }

    private LinkText getLogoLink()throws Exception{
        return new LinkText(driver,link_FeedLogo,"Logo");
    }

    private List<WebElement> getFavoriteToolsIcon()throws Exception{
        return new ArrayList<WebElement>(driver.findElements(list_FavoriteStarIcon));
    }
    private Generic getRandomToolTitle(int num)throws Exception{
        return new Generic(driver,By.xpath("(//div[@class='app-container']/span)["+num+"]/following-sibling::a[@class='app-title']"),"Tool Name");
    }
    private LinkText getRandomTool(int favIcon)throws Exception{
        return new LinkText(driver,By.xpath("(//div[@class='app-container']/span)["+favIcon+"]"),"Favorite Icon");
    }


    //Functional Methods
    public FeedHomePage selectFavoriteTool()throws Exception{

            if(getFavoriteIcon().size()>0) {
                for (WebElement ele : getFavoriteIcon()) {
                    ele.click();
                    Logz.step("Selected " + ele.getText() + " as favorite tool");
                }
            }
            getLogoLink().click();
        return new FeedHomePage(driver);
    }

    public void clickFavorites()throws Exception{

            getFavoritesLink().click();
            Logz.step("Clicked on Favorites Link");

    }

    public void unFavoriteTool(FeedHomePage feedHomePage, String toolName)throws Exception{

            feedHomePage.clickTools();
            clickFavorites();
            if(getFavoriteToolsIcon().size()>0){
                for(int i=0;i<=getFavoriteToolsIcon().size();i++){
                    getFavoriteToolsIcon().get(i).click();
                    Logz.step("Clicked on star icon to un-favorite tool");
                }
            }else{
                throw new Exception("There is no Favorite tools available under Favorites Section");
            }
            reloadWebPage();
            clickFavorites();
            if(getFavoriteToolsIcon().size()==0){
                Logz.step("There is no Favorite tools available under Favorites Section");
                feedHomePage.clickHeaderLogo();
                boolean flag=false;
                if(getTools().size()>0){
                    for(int j=0;j<getTools().size();j++){
                        if(!getTools().get(j).getText().contains(toolName)){
                            flag=true;
                            Logz.step(getTools().get(j).getText()+" favorite tool doesn't displayed in Tools section");
                        }
                    }
                    if(!flag){
                        Logz.step("favorite tool is displayed in Tools section");
                    }
                }else {
                    Logz.step("There is no tools present in tools section");
                }

            }else {
                throw new Exception("favorite tools displayed in favorite tools section");
            }
    }
}
