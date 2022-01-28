package steps;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import io.cucumber.java.en.When;

public class OrderInformationSteps extends BaseSteps {

    @When("^Valido direccion de usuario corresponda a la direccion de pago$")
    public void validateUserAddressWithPaymenAddress() throws InterruptedException, FileNotFoundException {
        orderHistory.goToOrderView();
        assertTrue("La Dirección de pago no corresponde con la dirección del usuario", openCart.goToOrderView());
    }
}
