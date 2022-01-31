package steps;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;

import io.cucumber.java.en.When;

public class ShoppingCartSteps extends BaseSteps {

    @When("^Valido que el Producto (.+) y el (.+) esten en el carro$")
    public void validateProductsInCar(String productUno, String productDos) throws InterruptedException {
        productDetail.goToShoppingCart();
        assertTrue("No Coinciden los productos con los mostrados en el carro",
                shoppingCart.validateProductsInCart(productUno, productDos));
    }

    @When("^Inicio proceso de checkout$")
    public void goToBuyProducts() throws InterruptedException, AWTException {
        shoppingCart.goCheckout();
    }
}
