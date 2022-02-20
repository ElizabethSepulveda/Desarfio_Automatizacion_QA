package pages;

public class ShoppingCartPage extends BasePage {

    private String checkoutCart = "//a[contains(text(),'Checkout')]";
    private String addedMessage = "//a[contains(text(),'shopping cart')]";
    private String shoppingCartButton = "//*[@id='top-links']/ul/li[4]/a";
    private String quantityProduct1 = "//tbody/tr[1]/td[4]/div[1]/input[1]";
    private String quantityProduct2 = "//tbody/tr[2]/td[4]/div[1]/input[1]";

    public ShoppingCartPage() {
        super(driver);
    }

    public void enterShoppingCart() {

        clickElement(shoppingCartButton);
        write(quantityProduct1, "1");
        write(quantityProduct2, "1");

    }

    public void clickCheckoutCart() {
        clickElement(checkoutCart);
    }

    public String productAddedToCartMessage() {
        return textFromElement(addedMessage);
    }

}
