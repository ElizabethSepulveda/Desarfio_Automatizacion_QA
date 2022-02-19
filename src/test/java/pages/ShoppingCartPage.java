package pages;

public class ShoppingCartPage extends BasePage {

    private String shopCart = "//span[contains(text(),'Shopping Cart')]";
    private String checkoutCart = "//a[contains(text(),'Checkout')]";

    public ShoppingCartPage() {
        super(driver);
    }

    public void clickProductCart() {

        clickElement(shopCart);
    }

    public void clickCheckoutCart() {
        clickElement(checkoutCart);
    }

}
