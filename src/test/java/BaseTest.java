import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.*;


import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String koelUrl = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }

    public static void openUrl() {
        driver.navigate().to(koelUrl);

    }

    protected static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);

    }

    protected static void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);

    }

    protected static void clickSubmit() throws InterruptedException{
        WebElement loginBtn = driver.findElement(By.cssSelector("button[type=submit]"));
        loginBtn.click();
        Thread.sleep(3000);
    }

    protected static void clickNextSong() throws InterruptedException{
        WebElement nextSongBtn = driver.findElement(By.cssSelector("[title='Play next song']"));
        nextSongBtn.click();
        Thread.sleep(3000);
    }

    public static void play() throws InterruptedException {
        WebElement playBtn = driver.findElement(By.cssSelector("[title='Play or resume']"));
        playBtn.click();
        Thread.sleep(3000);
    }

    public static void soundBar() {
        boolean sound = driver.findElement(By.cssSelector("div.bars")).isDisplayed();
    }
}

