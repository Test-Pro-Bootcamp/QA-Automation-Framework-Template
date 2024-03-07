import io.cucumber.test.CucumberRunner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

@CucumberOptions {
    features = {"src/test/reasources/features/Login.features"}
}
public class CucumberRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpCucumber() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }


}
