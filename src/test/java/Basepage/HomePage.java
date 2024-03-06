package Basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "a.view-profile")
    WebElement profileIcon;
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public HomePage clickProfileIcon() {
        click(profileIcon);
        return this;
    }
}
