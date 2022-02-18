package runner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(

    features = "src/test/resources/features/",
    glue = "steps",
    tags = "@test",
    plugin = {"pretty"}
    
)


public class runner{

 /*@AfterClass
  public static void cleanDriver(){
   BasePage.closeBrowser();
 }
*/
}
