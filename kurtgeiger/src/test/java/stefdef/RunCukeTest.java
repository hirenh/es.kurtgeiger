package stefdef;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", dryRun =false, strict = true, plugin = "json:target/cucumber.json",tags = {"~@registration,@regression" +
        ""})
public class RunCukeTest {
}
