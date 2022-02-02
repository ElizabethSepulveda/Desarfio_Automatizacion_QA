package Page;
import BaseAutomatizacion.WebBasePage;
import org.openqa.selenium.By;

public class CarritoCompraPage extends WebBasePage {

    public CarritoCompraPage(){super();}

    By locatorBotonItemsCarro = By.xpath("//*[contains(text(),'2 item(s) -')]");
    By locatorBotonVerCarro = By.xpath("//strong[contains(text(),' View Cart')]");
    By locatorBotonCheckout = By.linkText("Checkout");

    public void clickBotonItemsCarro() throws InterruptedException {
        iniciarElemento(locatorBotonItemsCarro).click();
    }

    public void clickBotonVerCarro() throws InterruptedException {
        iniciarElemento(locatorBotonVerCarro).click();
    }

    public void clickBotonCheckout() throws InterruptedException {
        iniciarElemento(locatorBotonCheckout).click();
    }

}
