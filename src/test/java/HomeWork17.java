import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
public class HomeWork17 {
    @Test
    public void addSongToPlaylist() {
        String song = "Waiting on a train";
//        Login
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--kiosk");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        String url = "https://qa.koel.app/";
        driver.get(url);

        // email
        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
        emailInput.click();
        emailInput.clear();
        emailInput.sendKeys("varjan80@mail.ru");

        // password
        WebElement passwordInput = driver.findElement(By.cssSelector("[type='password']"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("te$t$tudent");

        // login button
        WebElement submitLoginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitLoginButton.click();
        WebElement avatar = driver.findElement(By.cssSelector("a .avatar"));
        Assert.assertTrue(avatar.isDisplayed());
    }
}


