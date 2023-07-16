import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import static Pages.BasePage.driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import java.time.Duration;
    @Test
    public class BaseTest {
        public static WebDriver driver = null;
        @BeforeSuite
        public static void setupClass() {
            WebDriverManager.chromedriver().setup();
        }
        @BeforeMethod
        @Parameters({"BaseUrl"})
        public void launchBrowser(String BaseUrl) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            String url = BaseUrl;
            driver.navigate().to(url);


        }

    }