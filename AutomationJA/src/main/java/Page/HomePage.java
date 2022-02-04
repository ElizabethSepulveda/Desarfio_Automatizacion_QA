package Page;
import BaseAutomatizacion.WebBasePage;
import org.openqa.selenium.By;

public class HomePage extends WebBasePage {

    public HomePage(){super();}

    By locatorInputDeBusqueda = By.xpath("//input[@placeholder='Search']");
    By locatorBotonLogoBuscar = By.xpath("//button[@class='btn btn-default btn-lg']");

    public void ingresoTextoInputDeBusquedaProducto(String textoBusqueda) throws InterruptedException {
        ingresarTexto(locatorInputDeBusqueda,textoBusqueda);
    }

    public void clickBotonLogoBuscar() throws InterruptedException {
        iniciarElemento(locatorBotonLogoBuscar).click();
    }

}
