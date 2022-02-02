package StepDefinition;
import BaseAutomatizacion.Cliente;
import BaseAutomatizacion.ReadExelFile;
import BaseAutomatizacion.WebBasePage;
import Page.BusquedaPage;
import Page.CarritoCompraPage;
import Page.HomePage;
import Page.VerificarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class CompraProductoDefinition {

    WebDriver driver;
    WebBasePage webBasePage;
    Cliente cliente;
    HomePage homePage = new HomePage();
    BusquedaPage busquedaPage = new BusquedaPage();
    CarritoCompraPage carritoCompraPage = new CarritoCompraPage();
    VerificarPage verificarPage = new VerificarPage();
    ReadExelFile readFile = new ReadExelFile();
    String filepath = "./src/main/resources/data/data.xlsx";


    public void CompraProductoDefinition(){
        this.driver = Hooks.driver;
        webBasePage = new WebBasePage();
    }

    public void ingresoFormularioDatosCliente(){
        try {
            String emailTest = readFile.getCellValue(filepath,"Hoja1",1,0);
            String passwordTest= readFile.getCellValue(filepath,"Hoja1",1,1);
            cliente = new Cliente(emailTest,passwordTest);
            verificarPage.ingresoTextoInputPrimerNombre(cliente.getPrimerNombre());
            verificarPage.ingresoTextoInputApellido(cliente.getApellido());
            verificarPage.ingresoTextoInputEmail(cliente.getEmail());
            verificarPage.ingresoTextoInputTelefono(cliente.getTelefono());
            verificarPage.ingresoTextoInputDireccion(cliente.getDireccion());
            verificarPage.ingresoTextoInputCiudad(cliente.getCiudad());
            verificarPage.clickComboboxPais();
            verificarPage.clickComboboxOptionAlbania();
            verificarPage.clickComboboxRegion();
            verificarPage.clickComboboxOptionBerat();
            verificarPage.ingresoTextoInputPassword(cliente.getPassword());
            verificarPage.ingresoTextoInputConfirmacionPassword(cliente.getPassword());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Given("ingreso a pagina opencart y busco producto {string}")
    public void ingresoAPaginaOpencartYBuscoProducto(String textoDeBusqueda) throws InterruptedException {
        homePage.ingresoTextoInputDeBusquedaProducto(textoDeBusqueda);
        homePage.clickBotonLogoBuscar();
        homePage.scrollVerticalBajo();
    }

    @And("lo agrego al carrito de compras y tambien agrego producto {string}")
    public void loAgregoAlCarritoDeComprasYTambienAgregoProducto(String textoDeBusqueda) throws InterruptedException {
        busquedaPage.clickBotonAnadirAlCarrito();
        homePage.ingresoTextoInputDeBusquedaProducto(textoDeBusqueda);
        homePage.clickBotonLogoBuscar();
        homePage.scrollVerticalBajo();
        homePage.esperarSegundos(5);
        busquedaPage.clickBotonAnadirAlCarrito();
        homePage.esperarSegundos(5);
    }

    @And("ingreso al carrito de compras y creo una cuenta nueva")
    public void ingresoAlCarritoDeComprasYCreoUnaCuentaNueva() throws InterruptedException,IOException {
        carritoCompraPage.clickBotonItemsCarro();
        carritoCompraPage.esperarSegundos(5);
        carritoCompraPage.clickBotonVerCarro();
        carritoCompraPage.esperarSegundos(5);
        carritoCompraPage.scrollVerticalBajo();
        carritoCompraPage.esperarSegundos(5);
        carritoCompraPage.clickBotonCheckout();
        carritoCompraPage.esperarSegundos(5);
        carritoCompraPage.scrollVerticalBajo();
        verificarPage.clickBotonContinuarOpcDePago();
        carritoCompraPage.esperarSegundos(5);
        ingresoFormularioDatosCliente();
        verificarPage.clickCheckboxHeLeidoYAceptoPoliticaPrivacidad();
        verificarPage.clickBotonContinuarPasoDos();
    }


    @And("continuo con la compra hasta completar la orden")
    public void continuoConLaCompraHastaCompletarLaOrden() throws InterruptedException {
        verificarPage.esperarSegundos(5);
        verificarPage.clickBotonContinuarPasoTres();
        verificarPage.esperarSegundos(5);
        verificarPage.clickBotonContinuarPasoCuatro();
        verificarPage.esperarSegundos(5);
        verificarPage.clickCheckboxHeLeidoYAceptoPoliticaPrivacidad();
        verificarPage.clickBotonContinuarPasoCinco();
        verificarPage.esperarSegundos(5);
        verificarPage.clickBotonConfirmarPedido();
    }

    @When("valido los datos de la compra en el historial de ordenes")
    public void validoLosDatosDeLaCompraEnElHistorialDeOrdenes() throws InterruptedException {
        verificarPage.esperarSegundos(5);
        verificarPage.clickLinkHistorial();
    }

    @Then("cierro sesion")
    public void cierroSesion() throws InterruptedException {
        verificarPage.esperarSegundos(5);
        verificarPage.clickLinkCerrarSesion();
    }
}
