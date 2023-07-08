import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;


import java.time.Duration;

<<<<<<< Updated upstream
public class LoginTests extends BaseTest {
    @Test
    public void LoginEmptyEmailPasswordTest() {
=======
>>>>>>> Stashed changes


    public class LoginTests extends BaseTest {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

<<<<<<< Updated upstream
        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
=======
        @Test(dataProvider = "IncorrectLoginProviders", dataProviderClass = BaseTest.class)
        public void negativeLoginTests(String email, String password) throws InterruptedException {
            PageFactory.initElements(getDriver(), loginPage);
            loginPage.login(email, password);
            Thread.sleep(5000);
            Assert.assertEquals(basePage.getDriver().getCurrentUrl(), url);
        }


        @Test
        public void successfulLoginTest() {
            PageFactory.initElements(getDriver(), loginPage);
            loginPage
                    .enterEmail("varjan80@mail.ru")
                    .enterPassword("te$t$tudent")
                    .clickLoginButton();
            Assert.assertTrue(homePage.getAvatar().isDisplayed());
        }

        @Test
        public void wrongPasswordLoginTest() {
            PageFactory.initElements(getDriver(), loginPage);
            loginPage.login("varjan80@mail.ru", "te$t$tuden");
            Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
        }

        @Test
        public void emptyPasswordLoginTest() {
            PageFactory.initElements(getDriver(), loginPage);
            loginPage.login("varjan80@mail.ru", "");
            Assert.assertTrue(loginPage.getSubmitLoginButton().isDisplayed());
        }
>>>>>>> Stashed changes
    }
