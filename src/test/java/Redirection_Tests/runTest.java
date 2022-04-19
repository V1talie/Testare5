package Redirection_Tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {"pretty", "html:target/Redirections/Redirections.html", "json:target/Redirections/Redirections.json"},
    features = "src/test/java/Redirection_Tests/"
)

public class runTest {

}
