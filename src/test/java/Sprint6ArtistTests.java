import org.testng.annotations.Test;
import pages.LandingPage;
import pages.LoginPage;

public class Sprint6ArtistTests extends BaseTest {

    @Test
    public void searchForArtist() {
        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        landingPage.searchForArtist("Unknown Artist");

    }


}
