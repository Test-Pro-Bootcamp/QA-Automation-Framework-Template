import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    public WebDriver driver = null;
    public String url = null;
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    protected void navigateToPage() {
        driver.get(url);
    }
    @BeforeSuite
    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws MalformedURLException {
        threadLocal = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadLocal.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        navigateToPage();
    }
    @AfterMethod
    public void tearDown() {
        threadDriver.get().close();
        threadDriver.remove();
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "https://10.0.0.206:4444/";
        switch (browser) {
            case "MicroSoftEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver();
            case "cloud":
                return LambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(chromeOptions);
        }
    }

    public RemoteWebDriver LambdaTest() throws MalformedURLException {
            String HubURL = "https://hub.lambdatest.com/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();

            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 10");
            browserOptions.setBrowserVersion("122.0");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("username", "sadokha.david");
            ltOptions.put("accessKey", "poTHwxG4slaMyczhUE8kIvKa7zJoi2kZtvolIUsU8BlPTOt2wv");
            ltOptions.put("build", "TEST1");
            ltOptions.put("project", "Untitled");
            ltOptions.put("name", "TEST1Lambda");
            ltOptions.put("w3c", true);
            ltOptions.put("plugin", "java-java");
            browserOptions.setCapability("LT:Options", ltOptions);

            return new RemoteWebDriver(new URL(HubURL), capabilities);
        }
    }
}