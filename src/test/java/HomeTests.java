import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest {
    @Test
    public void renamePlaylist() {
        String newName = "My private playlist";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("Iparzyan@gmail.com")
                .providePassword("MkoIkaMarkMia-789")
                .clickSubmitBtn();

        homePage.doubleClick();
        homePage.enterNewPlName(newName);


    }
}