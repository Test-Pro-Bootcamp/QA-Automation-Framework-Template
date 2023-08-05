package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#playlists > ul > li:nth-child(4)")
    WebElement playlistName;
    @FindBy(css = "[name='name']")
    WebElement plNameInputField;


    public HomePage doubleClick() {
        doubleClick(playlistName);
        return this;
    }
    public HomePage enterNewPlName(String newName){
        plNameInputField.sendKeys(Keys.chord(Keys.CONTROL, "A", Keys.BACK_SPACE));
        plNameInputField.sendKeys(newName);
        plNameInputField.sendKeys(Keys.ENTER);
        return this;


    }
}