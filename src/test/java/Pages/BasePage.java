package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;


import java.time.Duration;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;
    public static String url = null;
    public static WebElement webElement=null;



    public BasePage(WebDriver givendriver) {
        driver = givendriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        // driver.navigate().to(url);
        PageFactory.initElements(driver,this);

    }


    public  WebElement findElement(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));

    }

    protected void doubleClick(WebElement webElement) {
        actions.doubleClick(findElement(webElement)).perform();

    }

}

