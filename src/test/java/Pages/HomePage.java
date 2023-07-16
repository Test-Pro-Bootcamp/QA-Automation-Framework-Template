package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {
    public HomePage(WebDriver givendriver) {
        super(givendriver);
    }

    // By playlistName=By.cssSelector("#playlists > ul > li:nth-child(3)");
    @FindBy(css = "#playlists > ul > li:nth-child(3)")
    WebElement playlistName;
    // By playlistInputField= By.cssSelector("[name='name']");
    @FindBy(css = "[name='name']")
    WebElement playlistInputField;

    public void doubleClick() {
        doubleClick(playlistName);

    }

    public void enterNewPlaylistName(String newPlaylistName) {
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public boolean playlistExistOrNot(String newPlaylistName) {
        WebElement newPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()= '" + newPlaylistName + "'] ")));

        return newPlaylist.isDisplayed();


    }

}
