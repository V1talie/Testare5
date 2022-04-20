package Hyper_Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/Hyper_Tests/Hyper_Tests.html", "json:target/Hyper_Tests/Hyper_Tests.json"},
    features = "src/test/java/Hyper_Tests/"
)

public class runTest {

}
