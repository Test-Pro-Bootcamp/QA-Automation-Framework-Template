import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.WebDriver;
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
        options.addArguments("--enable-notifications");
//        options.addArguments("--start-maximized");
        options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();

    }

    protected static void openUrl() {
        driver.navigate().to(koelUrl);
    }

    protected static void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.clear();
        emailField.click();
        emailField.sendKeys(email);

    }
    protected static void enterPassword(String password) throws InterruptedException {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);
        Thread.sleep(2000);
    }

    protected static void clickSubmitBtn() {
        WebElement login = driver.findElement(By.cssSelector("button[type=submit]"));
        login.click();
    }


    protected static void searchSong(String songName) throws InterruptedException {
        WebElement search=driver.findElement(By.cssSelector("[type='search']"));
        search.click();
        search.click();
        search.sendKeys((songName));
        Thread.sleep(2000);
    }

    protected static void viewAllBtn(){
       WebElement view= driver.findElement(By.cssSelector("[data-test='view-all-songs-btn']"));
        view.click();

    }

    public void firstSong() throws InterruptedException {
        WebElement song= driver.findElement(By.cssSelector(".search-results .virtual-scroller .title"));
        song.click();
        Thread.sleep(2000);
    }
    protected static void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("#songResultsWrapper .btn-add-to"));

        addToBtn.click();
    }

    protected static void choosePlaylist()throws InterruptedException {
        WebElement playlistName= driver.findElement(By.xpath("//*[@id=\"songResultsWrapper\"]/header/div[3]/div/section[1]/ul/li[5]"));
        playlistName.click();
        Thread.sleep(5000);
    }

}