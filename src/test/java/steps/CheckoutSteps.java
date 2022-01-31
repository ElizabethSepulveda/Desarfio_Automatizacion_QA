package steps;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CheckoutSteps extends BaseSteps {

    @And("^Creo cuenta para nuevo usuario$")
    public void registerForNewUser() throws FileNotFoundException, InterruptedException {
        checkout.registerNewUser();
    }

    @And("^Hago login con usuario$")
    public void loginWithUser() throws FileNotFoundException{
        checkout.loginUser();
    }

    @And("^Valido Billing details$")
    public void validateBillingDetails() {
        checkout.billingDetails();
    }

    @And("^Valido Delivery details$")
    public void validateDeliveryDetails() {
        checkout.deliveryDetails();
    }

    @And("^Valido Delivery Methods$")
    public void validateDeliveryMethods() {
        assertTrue("No coincide el método de envio", checkout.deliveryMethod());
    }

    @When("^Acepto el Payment Method$")
    public void agreePaymentMethod() {
        checkout.paymentMethod();
    }

    @And("^Confirmo la orden y valido (.+)$")
    public void confirmOrderOk(String shippingMethod) throws InterruptedException {
        assertTrue("No coincide el shipping", checkout.confirmOrder(shippingMethod));
        Thread.sleep(600);
    }
}
