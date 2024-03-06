import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;

public class LoginTests extends BaseTest {


    @Test
    public void loginWithCorrectCredentials1() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail();
                .providePassword();
                .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatarIcon().isDisplayed());
    }
    @Test
    public void loginEmptyEmailPassword() {

        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail();
                .providePassword();
                .clickSubmit();

        homePage.clickProfileIcon();
        profilePage.chooseVioletTheme();
        Assert.assertTrue(profilePage.isVioletThemeSelected());
    }
    @FindBy(css = "input[type='email']")
    WebElement emailField;
    @FindBy(css = "input[type='password']")
    WebElement passwordField;
    @FindBy("button[type='submit']")
    WebDriver submitButton;
    public void loginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public loginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public loginPage clickSubmit() {
        click(submitButton);
        return this;
    }

}
