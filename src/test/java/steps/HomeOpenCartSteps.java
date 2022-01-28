package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeOpenCartSteps extends BaseSteps {

    @Given("^Navego a la pagina (.+)$")
    public void navigateToOpenCartPage(String url) {
        openCart.navigateToOpenCartPage(url);
    }

    @And("^Busco el producto (.+)$")
    public void searchProduct(String product) {
        openCart.enterSearchCriteria(product);
        openCart.clickSearchBtn();
    }

    @Then("^Cierro sesion$")
    public void logout() {
        openCart.logoutUser();
    }
}
