package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public static Actions actions = null;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);

    }

    public static WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();

    }

}
