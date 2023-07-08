import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework_17 {

//public class Homework17 extends BaseTest {

    @Test
    public void addSongToPlaylist() {
        String song = "Waiting on a train";
//        Login
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--kiosk");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));

        String url = "https://qa.koel.app/";

        driver.get(url);


        // email
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("varjan80@mail.ru");

        // password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        // login button
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();

        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());


//        click all songs
        WebElement allSongsBtn = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/section[1]/ul/li[3]/a"));
        allSongsBtn.click();
//      Thread.sleep(10000);

//        click song
        //        Search Song
        WebElement clickOnSongBtn = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        clickOnSongBtn.click();


//        click to Add To Btn
        WebElement clickOnAddToBtn = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/span/button[2]"));
        clickOnAddToBtn.click();


//      add song to playlist
        WebElement addSongToBtn = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        addSongToBtn.click();
        driver.quit();
    }
}


