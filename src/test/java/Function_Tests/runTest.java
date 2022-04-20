package Function_Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/Function_Tests/Function_Tests.html", "json:target/Function_Tests/Function_Tests.json"},
    features = "src/test/java/Function_Tests/"
)

public class runTest {

}
