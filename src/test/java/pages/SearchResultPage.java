package pages;

public class SearchResultPage extends BasePage {

    private String linkToProduct = "//img[@class='img-responsive']";
    private String btnAddToCart = "//span[contains(text(),'Add to Cart')]";

    public SearchResultPage() {
        super(driver);
    }

    /**
     * Método para ver el producto
     * 
     */
    public void viewProduct() {
        clickElement(linkToProduct);
    }

    /**
     * Método para agregar un producto al carro sin visualizar el detalle de
     * producto.
     */
    public void addProductToCartWithOutView() {
        clickElement(btnAddToCart);
    }
}
