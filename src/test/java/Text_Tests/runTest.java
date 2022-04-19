package Text_Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/Text/Text.html", "json:target/Text/Text.json"},
    features = "src/test/java/Text_Tests/"
)

public class runTest {

}
