package OtherTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/cucumber-html-report.html", "json:target/cucumber-json-report.json"},
    features = "src/test/java/CevaTest/"
)

public class runTest {

}
