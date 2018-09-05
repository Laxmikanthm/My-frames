package pages.Feed;

import base.gui.controls.browser.Button;
import base.gui.controls.browser.LinkText;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import base.FeedMethodsLibrary;
import org.testng.Assert;
import utils.Logz;


public class FeedArticlePage<T extends RemoteWebDriver> extends FeedMethodsLibrary {

	private static By btn_Bookmark= By.xpath("//button[@class='btn btn-default btn-icon btn-bookmark']");
	private static By btn_Like=By.xpath("//button[@data-liketext='Like']");
	private static By link_HeaderLogo = By.xpath("//a[@class='header-logo']");

	public FeedArticlePage(RemoteWebDriver driver) throws Exception {
		super(driver);
		waitForPageToLoad();
	}
    @Override
    public void waitForPageToLoad() throws Exception {
        if (getLikeButton().getControl().isDisplayed()) {
            Logz.step("Feed Article Landing Page is displayed");
        }
    }


	private Button getBookmarkButton()throws Exception{
		return new Button(driver,btn_Bookmark,"Bookmark");
	}
	private Button getLikeButton()throws Exception{
		return new Button(driver,btn_Like,"Like");
	}
	private LinkText getHeaderLogo() throws Exception {
		return new LinkText(driver, link_HeaderLogo, "HeaderLogo");
	}

	private FeedArticlePage clickLikeButton()throws Exception{
		getLikeButton().click();
		Logz.step("Clicked on Like button");
		return new FeedArticlePage(driver);
	}

	public FeedArticlePage unlikeAnArticle()throws Exception{
		clickLikeButton();
		reloadWebPage();
		if(getLikeButton().getAttribute("class").contains("Liked")){
			Logz.step("Article is Liked and like button is turned into Liked");
			clickLikeButton();
			waitForElement();
			Assert.assertTrue(!getLikeButton().getAttribute("class").contains("Liked"));
			Logz.step("Liked button is turned into Like");
		}else {
			Logz.error("Like button is displayed instead of Liked");
		}

		return new FeedArticlePage(driver);
	}
	public FeedHomePage bookmarkItemAndNavigateToHomePage() throws Exception {
		getBookmarkButton().click();
		Logz.step("Bookmark button is changed to bookmarked ");
		getHeaderLogo().click();
		Logz.step("Clicked on TheFeed title logo");
		return new FeedHomePage(driver);
	}



}