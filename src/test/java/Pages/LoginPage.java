package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private By emailField = By.cssSelector("[type='email']");
    private By passwordField = By.cssSelector("[type='password']");
    private By submitBtn = By.cssSelector("[type=submit]");

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }

    public void logIn() {
        provideEmail("Iparzyan@gmail.com");
        providePassword("MkoIkaMarkMia-789");
        clickSubmit();
    }
}
