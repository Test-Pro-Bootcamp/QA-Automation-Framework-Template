import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    String url = "https://qa.koel.app/";
    @Test
    public void playSong() {
        launchBrowser();
        putinEmail("vlad.sadokha@testpro.io");
        putinPassword("democlass");
        clickSubmit();
        clickPlay();
        Assert.assertTrue(isSongPlaying());
    }

    public void launchBrowser() {
        driver.get(url);
    }
    public void putinEmail(String email) {
        WebElement openEmail = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
        openEmail.clear();
        openEmail.sendKeys(email);
    }
    public void putinPassword(String password) {
        WebElement openPassword = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='password']")));
        openPassword.clear();
        openPassword.sendKeys(password);
    }
    public void clickSubmit() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
        submitButton.click();
    }
    public void clickPlay() {
        WebElement PlayNextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@data-testid='play-next-btn']")));
        WebElement playButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-testid='play-btn']")));
        PlayNextButton.click();
        playButton.click();
    }
    public boolean isSongPlaying() {
        WebElement soundBar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']")));
        return soundBar.isDisplayed();
    }
}
