package stepDefinitions;

import pages.LandingPage;
import pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FavoritesStepDefinitions {

    WebDriver driver;
    WebDriverWait wait;
    String url;

    //@BeforeSuite
    //public void setupClass() {
    //.chromedriver().setup();
    //}

    @Before
    public void launchBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = "https://qa.koel.app";
        driver.get(url);
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

    @Given("I am logged in")
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        System.out.println("Logged In Successfully");

    }

    @When("I add songs to favorites")
    public void addSongsToFavorites() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickAllSongs();
        landingPage.likeFirstSongInAllSongs();
        landingPage.likeSecondSongInAllSongs();

    }

    /*@Then("I can see the song I liked in Favorites Playlist")
    public void songsAddedSuccessfully() {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.firstSongInFavoritesIsDisplayed());
    }




    @Test
    public void deleteSongsFromFavorites() {

    } */


}
