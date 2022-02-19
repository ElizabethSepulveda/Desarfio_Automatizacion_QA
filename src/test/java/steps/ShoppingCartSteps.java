package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.ShoppingCartPage;

public class ShoppingCartSteps {

    ShoppingCartPage shop = new ShoppingCartPage();

    @Given("^ingreso al carrito de compras$")

    public void viewCart() {
        shop.clickProductCart();

    }

    @When("^hago click en boton checkout$")

    public void checkoutCart() {
        shop.clickCheckoutCart();
    }

}
