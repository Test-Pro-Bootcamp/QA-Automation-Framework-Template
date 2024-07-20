import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

        //public static WebDriver driver;
        public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
        public static WebDriverWait wait;
        public static String url;
        public static Actions actions;

        public static WebDriver getDriver() {
            return threadDriver.get();
        }


        @BeforeSuite
        static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }



    public static WebDriver pickBrowser(String browserName) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.254.65:4444";
        switch (browserName) {
            case "firefox": //gradle clean test -DbrowserName=firefox
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("start-maximized");
                //return driver = new FirefoxDriver(firefoxOptions);
                return new FirefoxDriver(firefoxOptions);

            case "edge":  //gradle clean test -DbrowserName=edge
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                edgeOptions.addArguments("start-maximized");
                //return driver = new EdgeDriver(edgeOptions);
                return new EdgeDriver(edgeOptions);

            case "grid-edge": //gradle clean test- DbrowserName=grid-edge
                caps.setCapability("browserName", "MicrosoftEdge");
                //return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-firefox": //gradle clean test -DbrowserName= grid-firefox
                caps.setCapability("browserName", "firefox");
                //return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": //gradle clean test -DbrowserName=grid-chrome
                caps.setCapability("browserName", "chrome");
                //return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                return new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("start-maximized");
                //return driver = new ChromeDriver(chromeOptions);
                return new ChromeDriver(chromeOptions);
        }


    }

    public static WebDriver lambdaTest () throws MalformedURLException {
        String hubURL = "https://hub.lambdatest.com/wd/hub";  //found on github

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("macOS Sonoma");
        browserOptions.setBrowserVersion("126");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "cll2");
        ltOptions.put("accessKey", "FHu3fpjupo2UlV2o5dZZE2r29ufWTkPpIwtFTfFe3CIiS5z47x");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubURL), browserOptions);
    }
        @BeforeMethod
        @Parameters({"BaseURL"})
        public void launchBrowser(String BaseURL) throws MalformedURLException {
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--remote-allow-origins=*");
            //options.addArguments("start-maximized");
            //with pickBrowser, we don't need the chrome driver declaration
            //driver = new ChromeDriver(options);

            //driver = pickBrowser(System.getProperty("browser"));
            threadDriver.set(pickBrowser(System.getProperty("browser")));
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
            url = BaseURL;
            getDriver().get(url);
        }

        @AfterMethod
        /*public void closeBrowser() {
            driver.quit();
*/
        public void tearDown() {
            threadDriver.get().close();;
            threadDriver.remove();
        }


}

