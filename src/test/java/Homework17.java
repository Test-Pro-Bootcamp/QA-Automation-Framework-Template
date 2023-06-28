
import org.testng.Assert;
import org.testng.annotations.Test;




public class Homework17 extends BaseTest {
    @Test

public void addSongToPlaylist() throws InterruptedException{
        String text="Added 1 song into";

        openUrl();
        enterEmail("Iparzyan@gmail.com");
        enterPassword("MkoIkaMarkMia-789");
        clickSubmitBtn();

        searchSong("Take my hand");
        viewAllBtn();
        firstSong();
        clickAddToBtn();
        choosePlaylist();
        Assert.assertTrue(notification().contains(text));



    }

    }
