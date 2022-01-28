package steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;

public class SearchResultSteps extends BaseSteps {

    @And("^Agrego el producto al carro$")
    public void enterSearchProduct() {
        searchResult.viewProduct();
        productDetail.addProductToCart();
        assertTrue("No se puede agregar el producto al carro", productDetail.validateSuccessMessageToAddProduct());
    }
}
