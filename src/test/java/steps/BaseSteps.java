package steps;

import pages.CheckoutPage;
import pages.OpenCartPage;
import pages.OrderHistoryPage;
import pages.OrderInformationPage;
import pages.ProductAppleCinemaPage;
import pages.ProductDetailPage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

public class BaseSteps {

    protected OpenCartPage openCart = new OpenCartPage();
    protected CheckoutPage checkout = new CheckoutPage();
    protected OrderHistoryPage orderHistory = new OrderHistoryPage();
    protected OrderInformationPage orderInformation = new OrderInformationPage();
    protected ProductDetailPage productDetail = new ProductDetailPage();
    protected ProductAppleCinemaPage productAppleCinema = new ProductAppleCinemaPage();
    protected SearchResultPage searchResult = new SearchResultPage();
    protected ShoppingCartPage shoppingCart = new ShoppingCartPage();

}
