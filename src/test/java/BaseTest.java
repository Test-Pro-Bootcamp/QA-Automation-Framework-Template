import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver = null;
    protected WebDriverWait wait = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser() {
        ChromeOptions optionsChromeLocal = new ChromeOptions();
        optionsChromeLocal.addArguments("--remote-allow-origins=*", "--remote-allow-origins=*", "--incognito", "--start-maximized", "-lang=en");
        driver = new ChromeDriver(optionsChromeLocal);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseUrl);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}