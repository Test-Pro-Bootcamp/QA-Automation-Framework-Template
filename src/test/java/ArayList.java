import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class ArayList extends BaseTest {
    WebDriverWait wait;

    @Test
    public void logIn() throws InterruptedException {
        enterEmail("shikhabidovarusana@gmail.com");
        enterPassword("te$t$tudent");
        clickSubmit();
        clickListOfName();
        setElementsOfList();
        System.out.println(setElementsOfList());
//
//
//                Assert.assertEquals(setElementsOfList().size(),   );

    }

    public void clickSubmit() {
        WebElement buttonLogIn = driver.findElement(By.cssSelector("[type='submit']"));
        buttonLogIn.click();

    }

    public void enterPassword(String password) throws InterruptedException {
        WebElement logPassword = driver.findElement(By.cssSelector("[type='password']"));
        logPassword.click();
        logPassword.clear();
        Thread.sleep(500);
        logPassword.sendKeys(password);

    }

    public void enterEmail(String email) {
        WebElement logEmail = driver.findElement(By.xpath("//input[@type='email']"));
        logEmail.click();
        logEmail.clear();
        logEmail.sendKeys(email);

    }

    public void clickListOfName() throws InterruptedException {
        WebElement listOFName = driver.findElement(By.cssSelector("[class='artists']"));

        listOFName.click();
        Thread.sleep(1000);
    }

    public List setElementsOfList() throws InterruptedException {

        List<WebElement> elementsOfList = driver.findElements(By.xpath("//div[@class='info']"));
        Thread.sleep(500);

        return elementsOfList;

    }


}


