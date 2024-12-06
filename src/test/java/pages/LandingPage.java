package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends BasePage {
    public LandingPage (WebDriver givenDriver) {
        super(givenDriver);
    }

    @FindBy (css = "#userBadge.profile")
    WebElement userBadge;
    //By userBadge = By.cssSelector("#userBadge.profile");
    @FindBy (css = "i.fa.fa-plus-circle.create")
    WebElement playListPlusBtn;
    //By playListPlusBtn = By.cssSelector("i.fa.fa-plus-circle.create");
    @FindBy (css = "[data-testid='playlist-context-menu-create-simple']")
            //failed
            // li[data-testid='playlist-context-menu-create-simple']
    WebElement newPlayListBtn;
    @FindBy (css = "input[name=name]")
    WebElement newPlayListField;
    //@FindBy (css = "section#playlists > ul:last-child")
    //WebElement newPlayListName;
    @FindBy (css = "section[id='playlists']>ul>li")
    List<WebElement> playListChildren;
    @FindBy (css = "section[id='playlists']>ul")
    WebElement parentOfPlayLists;

    @FindBy (css = ".recent li:nth-child(1) .favorite")
    WebElement favoriteBtnFirstRecentlyPlayedSongOnHomePage;
    @FindBy (css = "[href='#!/songs']")
    WebElement allSongsBtn;
    @FindBy (css = "tr.song-item:nth-child(1) td.favorite")
    WebElement firstSongInAllSongs;
    @FindBy (css = "tr.song-item:nth-child(2) td.favorite")
    WebElement secondSongInAllSongs;
    @FindBy (css = "[href='#!/favorites']")
    WebElement favoritesbtn;

    @FindBy (css = " .virtual-scroller.scroller .item-container table.items tr:nth-child(1)")
    WebElement firstSongInFavoritesList;
    @FindBy (css = "input[type = 'search']")
    WebElement searchBar;
    @FindBy (css = "a[href='#!/home']")
    WebElement homeButton;




    /*public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }*/

    public LandingPage clickAddPlaylistPlusButton() {
        playListPlusBtn.click();
        return this;
    }

    public LandingPage nameNewPlayList(String playListName) {
        newPlayListField.sendKeys(playListName);
        newPlayListField.sendKeys(Keys.RETURN);
        return this;
    }
    //for By method
    /*public LandingPage clickAddPlaylistPlusButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(playListPlusBtn));
    }*/

    public LandingPage clickAddNewPlaylistButton() {
        newPlayListBtn.click();
        return this;
    }

    public LandingPage getFavoritesPlayListListSize() {
        playListChildren.size();
        return this;
    }

    public LandingPage clickHeartFirstRecentlyPlayedSongHomePage() {
        favoriteBtnFirstRecentlyPlayedSongOnHomePage.click();
        return this;
    }

    public LandingPage clickAllSongs() {
        allSongsBtn.click();
        return this;
    }

    public LandingPage likeFirstSongInAllSongs() {
        firstSongInAllSongs.click();
        return this;
    }

    public LandingPage likeSecondSongInAllSongs() {
        secondSongInAllSongs.click();
        return this;
    }

    public LandingPage clickFavoritesBtn() {
        favoritesbtn.click();
        return this;
    }

    public boolean firstSongInFavoritesIsDisplayed() {
        return firstSongInAllSongs.isDisplayed();
    }

    public LandingPage searchForArtist(String artist) {
        searchBar.sendKeys(artist);
        return this;
    }

    public void clickHomeButton() {
        homeButton.click();
    }
    public void selectAnArtistFromHomePage() {
        //not sure how to make this work consistently without knowing what artist will be displayed
        //in a given child element?
    }








    //cannot use this with By
    // public WebElement getUserAvatar() {
       // return userBadge;
   // }


}
