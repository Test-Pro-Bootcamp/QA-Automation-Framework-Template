import org.testng.annotations.Test;


//import static java.lang.Thread.*;


public class Homework21 extends BaseTest {
    @Test

    public void renamePlaylist()  {
        // openUrl();
        enterEmail("Iparzyan@gmail.com");
        enterPassword("MkoIkaMarkMia-789");
        clickSubmit();
        doubleclickPlaylistName();
        enterNewPlaylistName();



    }
}