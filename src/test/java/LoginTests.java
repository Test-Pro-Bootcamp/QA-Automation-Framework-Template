import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.BasePage.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTests extends BaseTest {
    @Test
    public static void renamePlaylist() {
        String newPlaylistName = "Playlist2023";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("Iparzyan@gmail.com")
                 .providePassword("MkoIkaMarkMia-789")
                .clickSubmit();
        homePage.doubleClick();
        homePage.enterNewPlaylistName(newPlaylistName);

        Assert.assertTrue(homePage.playlistExistOrNot(newPlaylistName));

    }
}
