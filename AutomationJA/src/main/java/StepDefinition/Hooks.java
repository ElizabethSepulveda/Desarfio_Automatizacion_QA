package StepDefinition;
import BaseAutomatizacion.CreateDriver;
import BaseAutomatizacion.ReadExelFile;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    public static WebDriver driver;
    public static ReadExelFile readFile;
    public Scenario scenario = null;
    String urlPage = "http://opencart.abstracta.us";

    public void iniciarDriver(){
        driver = CreateDriver.iniciarDriver();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        iniciarDriver();
        driver.get(urlPage);
    }

    @After
    public void CierreDriver(){
        driver.quit();
    }

}
