package pages;

public class HomePage extends BasePage {

    private String searchTextProduct = "//input[@name='search']";
    private String searchButtonProduct = "//header/div[1]/div[1]/div[2]/div[1]/span[1]/button[1]";
    private String enterButttonProduct = "//body/div[@id='product-search']/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[2]/button[1]";
    private String MessageTextValidateAddProduct = "/html[1]/body[1]/div[2]/div[1]";

    public HomePage() {
        super(driver);
    }

    public void navigateToOpencartAbstracta() {
        navigateTo("http://opencart.abstracta.us");
    }

    public void selectSearchOpencartAbstracta() {

        clickElement(searchTextProduct);

    }

    public void eraseSearchTextbox() {

        eraseSearch(searchTextProduct);

    }

    public void writeSearchOpencartAbstracta(String product) {

        write(searchTextProduct, product);

    }

    public void searchProduct() {
        clickElement(searchButtonProduct);

    }

    public void clickAddButtonOpencartAbstracta() {
        clickElement(enterButttonProduct);
    }

    public boolean validateProductOpencart() {

        return elementIsDisplayed(MessageTextValidateAddProduct);
    }

}