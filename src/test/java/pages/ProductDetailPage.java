package pages;

public class ProductDetailPage extends BasePage {

    private String inputQuantity = "//input[@name='quantity']";
    private String btnAddToCart = "//button[@id='button-cart']";
    private String successMessageAddProduct = "//div[@class='alert alert-success alert-dismissible']";
    private String btnShoppingCart = "//a[contains(text(),'shopping cart')]";

    public ProductDetailPage() {
        super(driver);
    }

    /**
     * Método para ingresar la cantidad necesaria del producto.
     * 
     * @param cantidad la cantidad necesaria de productos
     */
    public void quantityProduct(String cantidad) {
        clickElement(inputQuantity);
        write(inputQuantity, cantidad);
    }

    /**
     * Método para agregar el producto al carro
     * 
     * @throws InterruptedException
     */
    public void addProductToCart() {
        clickElement(btnAddToCart);
    }

    /**
     * Método para validar que el producto fue agregado con éxito.
     * 
     * @return verdadero si se encuentra el mensaje de éxito.
     */
    public Boolean validateSuccessMessageToAddProduct() {
        Boolean condition = false;
        if (elementIsDisplayed(successMessageAddProduct)) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para ir al carro de compra desde el mensaje de éxito posteior a
     * agregar un producto al carro.
     */
    public void goToShoppingCart() {
        clickElement(btnShoppingCart);
    }
}
