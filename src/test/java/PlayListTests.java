import pages.LandingPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {

    @Test
    public void createANewPlaylist() {

        LoginPage loginPage = new LoginPage(getDriver());
        LandingPage landingPage = new LandingPage(getDriver());
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        //loginPage.isUserLoggedIn();
        System.out.println("Logged In Successfully");
        landingPage.clickAddPlaylistPlusButton();
        landingPage.clickAddNewPlaylistButton();
        landingPage.nameNewPlayList("Sprint2test");
        System.out.println("playlist size is now" + landingPage.getPlayListListSize());
    }
}
