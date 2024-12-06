import pages.LandingPage;
import pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        LandingPage landingPage = new LandingPage(driver);
        loginPage.logIn("chelsea.laurenson@testpro.io", "Koelapp1!!");
        //Assert.assertTrue(landingPage.getUserAvatar().isDisplayed());

        System.out.println("Logged In Successfully");

    }
}
