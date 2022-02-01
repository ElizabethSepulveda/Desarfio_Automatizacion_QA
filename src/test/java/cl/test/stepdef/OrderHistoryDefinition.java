package cl.test.stepdef;

import cl.test.po.HeaderPage;
import cl.test.po.OrderHistoryPage;
import cl.test.po.SearchPage;
import cl.test.utils.DataReadProvider;
import cl.test.utils.SharedDriver;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class OrderHistoryDefinition {

    public WebDriver driver;
    public DataReadProvider dataReadProvider;
    public HeaderPage headerPage;
    public SearchPage searchPage;
    public OrderHistoryPage orderHistoryPage;

    public OrderHistoryDefinition(SharedDriver driver, HeaderPage headerPage, SearchPage searchPage,
                                  OrderHistoryPage orderHistoryPage) {
        this.driver = driver.getWrappedDriver();
        this.dataReadProvider = new DataReadProvider();
        this.headerPage = headerPage;
        this.searchPage = searchPage;
        this.orderHistoryPage = orderHistoryPage;
        this.headerPage.takeScreenshot();
        this.searchPage.takeScreenshot();
    }

    @And("Valido el resumen de la orden")
    public void valido_el_resumen_de_la_orden() {
        Assert.assertTrue(orderHistoryPage.isVisibleTituloOrderHistory());
        Assert.assertTrue(orderHistoryPage.isVisibleStatusPending());
        orderHistoryPage.clickBotonViewResumen();
        Assert.assertTrue(orderHistoryPage.isVisibleTituloOrderDetails());
    }

}
