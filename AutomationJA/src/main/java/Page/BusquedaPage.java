package Page;
import BaseAutomatizacion.WebBasePage;
import org.openqa.selenium.By;

public class BusquedaPage extends WebBasePage {

    public BusquedaPage(){super();}

    By locatorBotonAnadirAlCarrito = By.xpath("//span[text()='Add to Cart']");


    public void clickBotonAnadirAlCarrito() throws InterruptedException {
        iniciarElemento(locatorBotonAnadirAlCarrito).click();
    }

}
