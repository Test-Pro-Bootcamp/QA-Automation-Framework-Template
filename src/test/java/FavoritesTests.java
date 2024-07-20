import pages.LandingPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class FavoritesTests extends BaseTest {
    //Story: Create a new playlist



   @Test
    public void addSongsToFavorites() {
        LoginPage loginPage = new LoginPage(getDriver());
        LandingPage landingPage = new LandingPage(getDriver());
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


