import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public  class Homework16 extends BaseTest {
    @Test
    public void registrationPage(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Preconditions
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://qa.koel.app";
        driver.get(url);

        //Test Steps
        WebElement registration = driver.findElement(By.cssSelector("a[href='registration']"));
        registration.click();

        String regUrl = "https://qa.koel.app/registration";


        //Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), regUrl);


        driver.quit();




    }
}