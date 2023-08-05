import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("Iparzyan@gmail.com")
                .providePassword("MkoIkaMarkMia-789")
                .clickSubmitBtn();


    }

    @Test
    public void loginWithInvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("Iparz@mail.ru")
                .providePassword("InvalidPassword")
                .clickSubmitBtn();
    }

    @Test
    public void loginWithValidEmailInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail("Iparzyan@gmail.com")
                .providePassword("InvalidPassword")
                .clickSubmitBtn();

    }

    @Test
    public void loginWithEmptyEmailValidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.provideEmail(" ")
                .providePassword("MkoIkaMarkMia-789")
                .clickSubmitBtn();

    }

}
