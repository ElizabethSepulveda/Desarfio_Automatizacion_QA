package cl.test.stepdef;

import cl.test.po.HeaderPage;
import cl.test.po.SearchPage;
import cl.test.utils.DataReadProvider;
import cl.test.utils.SharedDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeDefinition {

    public WebDriver driver;
    public DataReadProvider dataReadProvider;
    public HeaderPage headerPage;
    public SearchPage searchPage;

    public HomeDefinition(SharedDriver driver, HeaderPage headerPage, SearchPage searchPage) {
        this.driver = driver.getWrappedDriver();
        this.dataReadProvider = new DataReadProvider();
        this.headerPage = headerPage;
        this.searchPage = searchPage;
    }

    @Given("Ingresando al portal de compras")
    public void ingreso_al_portal_de_compras() {
        headerPage.getUrl(dataReadProvider.loadEnvironment().getProperty("host"));
    }
}
