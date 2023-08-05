package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy (css="[type='email']")
    WebElement emailFiled;
    @FindBy(css="[type='password']")
    WebElement passwordField;
    @FindBy(css="[type='submit']")
    WebElement submitBtn;
    public LoginPage provideEmail(String email){
        emailFiled.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickSubmitBtn(){
        submitBtn.click();
        return this;

    }
}
