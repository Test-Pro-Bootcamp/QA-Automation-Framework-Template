import Pages.LandingPage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Sprint2Tests extends BaseTest {
    //Story: Create a new playlist



   @Test
    public void addSongsToFavorites() {
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        //landingPage.clickHeartFirstRecentlyPlayedSongHomePage();
        landingPage.clickAllSongs();
        landingPage.likeFirstSongInAllSongs();
        landingPage.likeSecondSongInAllSongs();

    }

    @Test
    public void deleteSongsFromFavorites() {

    }

}


