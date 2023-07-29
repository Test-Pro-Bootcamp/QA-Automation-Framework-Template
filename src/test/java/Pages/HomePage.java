package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }
    By playlistName=By.cssSelector("#playlists > ul > li:nth-child(3)");
    By playlistInputField= By.cssSelector("[name='name']");

    public  void doubleClick(){
        doubleClick(playlistName);
    }
    public void  enterNewPlaylistName(String newPlaylistName){
        findElement(playlistInputField).sendKeys(newPlaylistName);
        findElement(playlistInputField).sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        findElement(playlistInputField).sendKeys(newPlaylistName);
        findElement(playlistInputField).sendKeys(Keys.ENTER);
    }
    public boolean playlistExistOrNot(String newPlaylistName){
        By newPlaylist= By.xpath("//a[text()= '"+ newPlaylistName+"'] " );
        return findElement(newPlaylist).isDisplayed();
    }
}
