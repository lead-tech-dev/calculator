package acceptance;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/** Acceptance Test */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", plugin = { "pretty", "html:target/html-cucumber-report" })
public class AcceptanceTest {

}
