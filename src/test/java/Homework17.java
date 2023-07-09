import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{
    @Test
    public void addSongToPlaylist() throws InterruptedException{
        String text ="Added 1 song into";

      openUrl();
        enterEmail("varjan80@mail.ru");
        enterPassword("te$t$tudent");
        clickSubmitBtn();

        searchSong("Pluto");
        viewAllBtn();
        firstSong();
        clickAddToBtn();
        choosePlaylist();
    }
}
