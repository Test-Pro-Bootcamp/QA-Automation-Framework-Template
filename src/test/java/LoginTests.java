import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Pages.BasePage.driver;
import static Pages.BasePage.url;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginTests extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newPlaylistName = "Playlist2023";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("Iparzyan@gmail.com")
                .providePassword("MkoIkaMarkMia-789")
                .clickSubmit();
        homePage.doubleClick();
        homePage.enterNewPlaylistName(newPlaylistName);

        assertTrue(homePage.playlistExistOrNot(newPlaylistName));

    }

    @Test
    public void loginValidEmailEmptyPassword() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.provideEmail("Iparzyan@gmail.com")
                .providePassword("")
                .clickSubmit();

    Assert.assertEquals(getDriver().getCurrentUrl(),url);
    }

    @Test
    public void loginInvalidEmailValidPassword() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("InvalidEmailAddress")
                .providePassword("MkoIkaMarkMia-789")
                .clickSubmit();
        Assert.assertEquals(getDriver().getCurrentUrl(),url);


    }

}