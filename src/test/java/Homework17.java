import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    String expectedSongMessage = "Added 1 song into \"TestPro playlist.\"";
    String url = "https://qa.koel.app/";

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        launchBrowser();
        inputEmail("vlad.sadokha@testpro.io");
        inputPassword("democlass");
        clickSubmit();
        searchSong("gummybear");
        clickViewAll();
        selectFirstSongResult();
        clickAdd2Btn();
        choosePlaylist();
        Assert.assertEquals(getAddSongToPlaylistSuccessMsg(), expectedSongMessage);
    }

    public void launchBrowser() {
        driver.get(url);
    }
    public void inputEmail(String email) {
        WebElement openEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        openEmail.clear();
        openEmail.sendKeys(email);
    }
    public void inputPassword(String password) {
        WebElement openPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        openPassword.clear();
        openPassword.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='password']")));
        submitButton.click();
    }
    public void searchSong(String name) {
        WebElement pickSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("div#searchForm input[type='search']")));
        pickSong.sendKeys(name);
    }
    public void clickViewAll() {
        WebElement clickView = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test='view-all-songs-btn']")));
        clickView.click();
    }
    public void selectFirstSongResult() {
        WebElement firstSong = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]")));
        firstSong.click();
    }
    public void clickAdd2Btn() {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//button[@data-test='add-to-btn']")));
        addButton.click();
    }
    public void choosePlaylist() {
        WebElement pickPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(), 'Test Pro Playlist')']")));
        pickPlaylist.click();
    }
    public String getAddSongToPlaylistSuccessMsg() {
        WebElement PlaylistSuccessMsg = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.success.show")));
        return PlaylistSuccessMsg.getText();
    }
}
