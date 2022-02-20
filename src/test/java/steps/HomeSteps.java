package steps;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.ShoppingCartPage;

public class HomeSteps {

    HomePage opencart = new HomePage();
    ShoppingCartPage shopping = new ShoppingCartPage();

    @Given("^navego al sitio web$")
    public void navigateToOpencart() {
        opencart.navigateToOpencartAbstracta();
    }

    @When("^ingreso el (.+) en la barra de busqueda y lo agrego al carrito$")

    public void writeSearchOpencart(String product) {

        opencart.selectSearchOpencartAbstracta();
        opencart.eraseSearchTextbox();
        opencart.writeSearchOpencartAbstracta(product);
        opencart.searchProduct();
        String dir = System.getProperty("user.dir");
        opencart.takeScreenshot((dir + "\\test-output\\Screenshots_test\\Evidence_Cart_Product_" + product + ".png"));
        opencart.clickAddButtonOpencartAbstracta();

    }

    @Then("^valido que el producto haya sido agregado al carro de compras$")

    public void validateProductOpencart() {

        Assert.assertEquals("shopping cart", shopping.productAddedToCartMessage());

    }

}