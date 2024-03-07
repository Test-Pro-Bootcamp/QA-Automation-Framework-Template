package StepDefinitions;
import Basepage.LoginPage;
import  io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

WebDriver driver;
WebDriverWait wait;
public class LoginSteps {


    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I open Login")
    public void openLogin() {
        driver.get("https://qa.koel.app/");
        LoginPage.openLogin();
    }
    @When("I enter email {string}")
    public void enterEmail(String email) {
        //WebElement emailEnter = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']"))).sendKeys(email);
        LoginPage.enterEmail(email);
    }
    @And("I enter password {string}")
    public void enterPassword(String password) {
        //WebElement passwordEntered = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']"))).sendKeys(password);
        LoginPage.enterPassword(password);
    }
    @And("I submit {string}")
    public void submitButton() {
        //WebElement buttonSubmit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']"))).click();
        LoginPage.submitButton();
    }
    @Then("I am logged in {string}")
    public void loggedIn() {
        //Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']"))).isDisplayed());
        LoginPage.loggedIn();
    }
}
