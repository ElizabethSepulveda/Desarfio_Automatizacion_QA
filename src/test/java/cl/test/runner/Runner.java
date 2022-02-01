package cl.test.runner;

/**
 * @author: fjvelascoa
 * @version: 0.1
 * @type: template
 * @definition: controlador runner
 *
 * */

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(glue = {"cl.test.stepdef"},
        features = "src/test/java/cl/test/features",
        tags = {"@run and @TestKey=02"},
        plugin = {"pretty",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber.xml",
                "html:target/cucumber-report"})
public class Runner {
    @BeforeClass
    public static void configure(){
        // TODO: 20/01/2022 activar sí requiero ver la trace session
        //BasicConfigurator.configure();
    }
}


