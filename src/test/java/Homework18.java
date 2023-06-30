import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
  public static void playSong() throws InterruptedException {

        openUrl();
        enterEmail("Iparzyan@gmail.com");
        enterPassword("MkoIkaMarkMia-789");
        clickSubmit();
        clickNextSong();
        play();
        soundBar();

    }}