package cl.test.stepdef;

import cl.test.po.HeaderPage;
import cl.test.po.HomePage;
import cl.test.po.SearchPage;
import cl.test.utils.DataReadProvider;
import cl.test.utils.SharedDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HeaderDefinition {

    public WebDriver driver;
    public DataReadProvider dataReadProvider;
    public HomePage homePage;
    public HeaderPage headerPage;
    public SearchPage searchPage;

    public HeaderDefinition(SharedDriver driver, HomePage homePage, HeaderPage headerPage, 
                            SearchPage searchPage) {
        this.driver = driver.getWrappedDriver();
        this.dataReadProvider = new DataReadProvider();
        this.homePage = homePage;
        this.headerPage = headerPage;
        this.searchPage = searchPage;
    }

    @When("Agrego al carro de compras un {string}")
    public void agrego_al_carro_de_compras (String producto) {
        headerPage.sendKeysInputSearch(producto);
        headerPage.clickBotonLupaSearch();
        Assert.assertEquals(searchPage.getTituloProducto(),producto.intern());
        searchPage.clickAgregarProducto();
        Assert.assertTrue(homePage.isVisibleMensajeExito());
    }

    @Then("Procedo a realizar la compra")
    public void procedo_a_realizar_la_compra() {
        headerPage.clickBotonCarTotal();
        headerPage.clickBotonCheckOut();
    }

    @Then("Selecciono la opcion en el header {string}")
    public void selecciono_la_opcion_en_el_header(String opcionMenu) {
        headerPage.clickBotonMyAccount();
        headerPage.sendKeysSelectNombreOpcion(opcionMenu);
    }

    @And("Cierro sesion")
    public void cierro_sesion() {
        //TODO: Llamo al metodo anterior para cerrar sesion, paso un parametro del dropdown
        selecciono_la_opcion_en_el_header("Logout");
        Assert.assertTrue(headerPage.isVisibleMensajeLogout());
    }

}
