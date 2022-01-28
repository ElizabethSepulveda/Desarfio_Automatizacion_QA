package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ShoppingCartPage extends BasePage {

    private String tableProductInCart = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/";
    private String btnGoToCheckout = "//a[contains(text(),'Checkout')]";

    public ShoppingCartPage() {
        super(driver);
    }

    /**
     * Método para validar los dos productos ingresados en el carro.
     * 
     * @param productoUno nombre del primer producto.
     * @param productoDos nombre del segundo producto.
     * @return verdadero si ambos productos coinciden.
     */
    public Boolean validateProductsInCart(String productoUno, String productoDos) {
        Boolean condition = false;
        String prod1 = getValueFromTable(tableProductInCart, 1, 2).toLowerCase();
        String prod2 = getValueFromTable(tableProductInCart, 2, 2).toLowerCase();
        if (prod1.equals(productoDos.toLowerCase()) && prod2.equals(productoUno.toLowerCase())) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para ir a la página de Checkout desde la página del carro de compras.
     * @throws AWTException
     * 
     */
    public void goCheckout() throws AWTException {
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_END);
        rb.keyRelease(KeyEvent.VK_V);
        clickElement(btnGoToCheckout);
    }
}
