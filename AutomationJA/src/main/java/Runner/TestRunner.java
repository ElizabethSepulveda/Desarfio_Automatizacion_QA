package Runner;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@PruebaSeleniumPrevired",
        features = {"classpath:cucumber"},
        glue = {"classpath:StepDefinition"})
public class TestRunner {

}

