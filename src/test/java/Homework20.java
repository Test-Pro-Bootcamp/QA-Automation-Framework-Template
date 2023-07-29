
import org.testng.annotations.Test;


import static java.lang.Thread.*;


public class Homework20 extends BaseTest {
    @Test

    public void deletePlaylist()  {
        // openUrl();
        enterEmail("Iparzyan@gmail.com");
        enterPassword("MkoIkaMarkMia-789");
        clickSubmit();
        clickPlaylist();
        deletePlaylistBtn();
        notification();


    }
}