package cl.test.stepdef;

import cl.test.po.CheckOutPage;
import cl.test.po.HeaderPage;
import cl.test.po.HomePage;
import cl.test.po.SearchPage;
import cl.test.utils.DataReadProvider;
import cl.test.utils.SharedDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CheckOutDefinition {

    public WebDriver driver;
    public DataReadProvider dataReadProvider;
    public HeaderPage headerPage;
    public HomePage homePage;
    public SearchPage searchPage;
    public CheckOutPage checkOutPage;

    public CheckOutDefinition(SharedDriver driver, HeaderPage headerPage, HomePage homePage, SearchPage searchPage,
                              CheckOutPage checkOutPage) {
        this.driver = driver.getWrappedDriver();
        this.dataReadProvider = new DataReadProvider();
        this.headerPage = headerPage;
        this.homePage = homePage;
        this.searchPage = searchPage;
        this.checkOutPage = checkOutPage;
        this.headerPage.takeScreenshot();
    }

    @Then("Inicio sesion")
    public void iniciar_sesion() {
        Assert.assertTrue(checkOutPage.isVisibleTitulo());
        Assert.assertTrue(checkOutPage.isVisibleTituloCheckOutOpt());
        Assert.assertTrue(checkOutPage.isVisibleTituloLogin());
        checkOutPage.sendKeysInputEmail(dataReadProvider.loadUserLogin().getProperty("email"));
        checkOutPage.sendKeysInputPassword(dataReadProvider.loadUserLogin().getProperty("password"));
        checkOutPage.clickBotonLogin();
    }

    @And("Continuo con la compra")
    public void continuo_con_la_compra() {
        //TODO : todo el order checkout
        //Step 2 Checkout
        Assert.assertTrue(checkOutPage.isVisibleTituloBillingDetails());
        checkOutPage.clickOptionPaymentAddress();
        checkOutPage.clickBotonContinueBillingDetails();

        //Step 3 Checkout
        Assert.assertTrue(checkOutPage.isVisibleTituloDeliveryDetails());
        checkOutPage.clickOptionShippingAddress();
        checkOutPage.clickBotonContinueDeliveryDetails();

        //Step 4 Checkout
        Assert.assertTrue(checkOutPage.isVisibleTituloDeliveryMethod());
        checkOutPage.clickOptionShippingMethod();
        checkOutPage.sendKeysInputTextAreaShippingMethod("test input1");
        checkOutPage.clickBotonContinueShippingMethod();

        //Step 5 Checkout
        Assert.assertTrue(checkOutPage.isVisibleTituloPaymentMethod());
        checkOutPage.clickOptionPaymentMethod();
        checkOutPage.sendKeysInputTextAreaPaymentMethod("test input2");
        checkOutPage.clickOptionPaymentMethodAcceptConditions();
        checkOutPage.clickBotonContinuePaymentMethod();
    }

    @And("Valido la orden completa")
    public void valido_la_orden_completa() {
        //Step 6 Checkout
        Assert.assertTrue(checkOutPage.isVisibleTituloConfirmOrder());
        Assert.assertTrue(checkOutPage.isVisibleCondicionFlatShipping());
        Assert.assertTrue(checkOutPage.isVisiblePriceFlatShipping());
        checkOutPage.clickBotonConfirmOrder();
        Assert.assertTrue(checkOutPage.isVisibleOrderComplete());
        checkOutPage.clickBotonContinueCierre();
        Assert.assertTrue(homePage.isVisibleTituloHome());
    }

}
