package Page;
import BaseAutomatizacion.WebBasePage;
import org.openqa.selenium.By;

public class VerificarPage extends WebBasePage {

    public VerificarPage(){super();}

    By locatorBotonContinuar = By.id("button-account");
    By locatorInputPrimerNombre = By.id("input-payment-firstname");
    By locatorInputApellido = By.id("input-payment-lastname");
    By locatorInputEmail = By.id("input-payment-email");
    By locatorInputTelefono = By.id("input-payment-telephone");
    By locatorInputDireccion = By.id("input-payment-address-1");
    By locatorInputCiudad = By.id("input-payment-city");
    By locatorComboboxPais = By.id("input-payment-country");
    By locatorOptionAlbania = By.xpath("//*[contains(text(),'Albania')]");
    By locatorComboboxRegion = By.id("input-payment-zone");
    By locatorOptionBerat = By.xpath("//*[contains(text(),'Berat')]");
    By locatorInputPassword = By.id("input-payment-password");
    By locatorInputConfirmacionPassword = By.id("input-payment-confirm");
    By locatorCheckboxHeLeidoYAceptoPoliticaPrivacidad = By.xpath("//input[@name='agree']");
    By locatorBotonContinuarPasoDos = By.id("button-register");
    By locatorBotonContinuarPasoTres = By.id("button-shipping-address");
    By locatorBotonContinuarPasoCuatro = By.id("button-shipping-method");
    By locatorBotonContinuarPasoCinco = By.id("button-payment-method");
    By locatorBotonConfirmarPedido = By.id("button-confirm");
    By locatorLinkHistorial = By.xpath("//font[text()='historial']");
    By locatorLinkCerrarSesion = By.xpath("//font[text() ='Cerrar sesión']");


    public void clickBotonContinuarOpcDePago() throws InterruptedException {
        iniciarElemento(locatorBotonContinuar).click();
    }

    public void ingresoTextoInputPrimerNombre(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputPrimerNombre,textoBusqueda);
    }

    public void ingresoTextoInputApellido(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputApellido,textoBusqueda);
    }

    public void ingresoTextoInputEmail(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputEmail,textoBusqueda);
    }

    public void ingresoTextoInputTelefono(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputTelefono,textoBusqueda);
    }

    public void ingresoTextoInputDireccion(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputDireccion,textoBusqueda);
    }

    public void ingresoTextoInputCiudad(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputCiudad,textoBusqueda);
    }

    public void clickComboboxPais() throws InterruptedException {
        iniciarElemento(locatorComboboxPais).click();
    }

    public void clickComboboxOptionAlbania() throws InterruptedException {
        iniciarElemento(locatorOptionAlbania).click();
    }

    public void clickComboboxRegion() throws InterruptedException {
        iniciarElemento(locatorComboboxRegion).click();
    }

    public void clickComboboxOptionBerat() throws InterruptedException {
        iniciarElemento(locatorOptionBerat).click();
    }

    public void ingresoTextoInputPassword(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputPassword,textoBusqueda);
    }

    public void ingresoTextoInputConfirmacionPassword(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputConfirmacionPassword,textoBusqueda);
    }

    public void clickCheckboxHeLeidoYAceptoPoliticaPrivacidad() throws InterruptedException {
        iniciarElemento(locatorCheckboxHeLeidoYAceptoPoliticaPrivacidad).click();
    }

    public void clickBotonContinuarPasoDos() throws InterruptedException {
        iniciarElemento(locatorBotonContinuarPasoDos).click();
    }

    public void clickBotonContinuarPasoTres() throws InterruptedException {
        iniciarElemento(locatorBotonContinuarPasoTres).click();
    }

    public void clickBotonContinuarPasoCuatro() throws InterruptedException {
        iniciarElemento(locatorBotonContinuarPasoCuatro).click();
    }

    public void clickBotonContinuarPasoCinco() throws InterruptedException {
        iniciarElemento(locatorBotonContinuarPasoCinco).click();
    }

    public void clickBotonConfirmarPedido() throws InterruptedException {
        iniciarElemento(locatorBotonConfirmarPedido).click();
    }

    public void clickLinkHistorial() throws InterruptedException {
        iniciarElemento(locatorLinkHistorial).click();
    }

    public void clickLinkCerrarSesion() throws InterruptedException {
        iniciarElemento(locatorLinkCerrarSesion).click();
    }


}
