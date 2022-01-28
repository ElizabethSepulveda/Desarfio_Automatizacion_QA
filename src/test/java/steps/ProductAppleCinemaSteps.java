package steps;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.io.FileNotFoundException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductAppleCinemaSteps extends BaseSteps {

    @When("^Veo el detalle del producto$")
    public void veoElDetalle(){
        searchResult.viewProduct();
    }

    @And("^Configuro el producto$")
    public void configureProduct() throws AWTException, InterruptedException {
        productAppleCinema.setProduct();
    }

    @And("^Compro el producto$")
    public void comproElProducto() throws FileNotFoundException, AWTException {
        productDetail.goToShoppingCart();
        shoppingCart.goCheckout();
        checkout.loginUser();
        checkout.billingDetails();
        checkout.deliveryDetails();
        checkout.deliveryMethod();
        checkout.paymentMethod();
        checkout.confirmOrderWithoutShipping();
    }

    @Then("^Valido el mensaje$")
    public void validoElMensaje() {
        assertTrue("No se encuentra el mensaje de compra exitosa", productAppleCinema.messageBuyOk());
    }
}
