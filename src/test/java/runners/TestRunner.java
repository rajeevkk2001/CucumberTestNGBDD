package runners;

import com.cucumber.listener.Reporter;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

//@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = "src/test/resources/functionalTests",
        glue= {"stepDefinitions"},
        tags = {"@NewVersionTest"},
        plugin = {"pretty:STDOUT","html:src\\test\\Reports\\cucumber-pretty",
                "json:src\\test\\Reports\\cucumber.json"},
        dryRun = false
)

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(dataProvider = "features")
    public void feature(PickleEventWrapper eventwrapper, CucumberFeatureWrapper cucumberFeature) throws Throwable {
        //testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runScenario(eventwrapper.getPickleEvent());
    }

    @DataProvider(parallel=true)
    public Object[][] features() {
        // return testNGCucumberRunner.provideFeatures();
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public  void tearDownClass() throws Exception {
      /*  Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
	        /*Properties p = System.getProperties();
	        p.list(System.out);*/

        /*Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("64 Bit", 	"Windows 10");
        Reporter.setSystemInfo("2.53.0", "Selenium");
        Reporter.setSystemInfo("3.3.9", "Maven");
        Reporter.setSystemInfo("1.8.0_66", "Java Version");
        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");*/
        testNGCucumberRunner.finish();
    }

}