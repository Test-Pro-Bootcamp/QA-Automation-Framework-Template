import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

        public static WebDriver driver;
        public static WebDriverWait wait;
        public static String url;
        public static Actions actions;

        @BeforeSuite
        static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

        @BeforeMethod
        @Parameters({"BaseURL"})
        public void launchBrowser(String BaseURL) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            url = BaseURL;
            driver.get(url);
        }

        @AfterMethod
        public void closeBrowser() {
            driver.quit();
        }



}

