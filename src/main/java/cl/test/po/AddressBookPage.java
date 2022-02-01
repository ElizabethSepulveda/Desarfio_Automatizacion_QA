package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddressBookPage extends BasePage {

    @FindBy(xpath = "//li/a[contains(text(),'Address Book')]")
    private WebElement opcionAddressBook;

    @FindBy(xpath = "//a[contains(text(),'New Address')]")
    private WebElement botonNewAddress;

    @FindBy(xpath = "//h2[contains(text(),'Add Address')]")
    private WebElement tituloPageAddAddress;

    @FindBy(xpath = "//h2[contains(text(),'Address Book Entries')]")
    private WebElement tituloPreviewAddress;

    @FindBy(xpath = "//div/p[contains(text(),'Your shopping cart is empty!')]")
    private WebElement contentText;

    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement inputFirstNameAddress;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement inputLastNameAddress;

    @FindBy(xpath = "//input[@id='input-company']")
    private WebElement inputCompanyAddress;

    @FindBy(xpath = "//input[@id='input-address-1']")
    private WebElement inputAddress1;

    @FindBy(xpath = "//input[@id='input-address-2']")
    private WebElement inputAddress2;

    @FindBy(xpath = "//input[@id='input-city']")
    private WebElement inputCityAddress;

    @FindBy(xpath = "//input[@id='input-postcode']")
    private WebElement inputCodePostal;

    @FindBy(xpath = "//select[@id='input-country']")
    private WebElement selectCountry;

    @FindBy(xpath = "//select[@id='input-zone']")
    private WebElement selectRegion;

    @FindBy(xpath = "//div/label[1]/input")
    private WebElement defaultAddressYes;

    @FindBy(xpath = "//div/label[2]/input")
    private WebElement defaultAddressNo;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement botonContinueAddress;

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleTituloPageAddAddress(){
        isVisible(tituloPageAddAddress);
        return tituloPageAddAddress.isEnabled();
    }

    public boolean isVisibleTituloPreviewAddress(){
        isVisible(tituloPreviewAddress);
        return tituloPreviewAddress.isEnabled();
    }

    public boolean isVisibleContentText(){
        isVisible(contentText);
        return contentText.isEnabled();
    }

    public void clickOpcionAddressBook() {
        isVisible(opcionAddressBook);
        opcionAddressBook.click();
    }

    public void clickBotonNewAddress() {
        isVisible(botonNewAddress);
        botonNewAddress.click();
    }

    public void sendKeysInputFirstNameAddress(String firtsNameAdd) {
        isVisible(inputFirstNameAddress);
        inputFirstNameAddress.clear();
        inputFirstNameAddress.sendKeys(firtsNameAdd);
    }

    public void sendKeysInputLastNameAddress(String lastNameAdd) {
        isVisible(inputLastNameAddress);
        inputLastNameAddress.clear();
        inputLastNameAddress.sendKeys(lastNameAdd);
    }

    public void sendKeysInputCompanyAddress(String company) {
        isVisible(inputCompanyAddress);
        inputCompanyAddress.clear();
        inputCompanyAddress.sendKeys(company);
    }

    public void sendKeysInputAddress1(String address1) {
        isVisible(inputAddress1);
        inputAddress1.clear();
        inputAddress1.sendKeys(address1);
    }

    public void sendKeysInputAddress2(String address2) {
        isVisible(inputAddress2);
        inputAddress2.clear();
        inputAddress2.sendKeys(address2);
    }

    public void sendKeysInputCityAddress(String city) {
        isVisible(inputCityAddress);
        inputCityAddress.clear();
        inputCityAddress.sendKeys(city);
    }

    public void sendKeysInputCodePostal(String codePostal) {
        isVisible(inputCodePostal);
        inputCodePostal.clear();
        inputCodePostal.sendKeys(codePostal);
    }

    public void clickSelectCountry() {
        isVisible(selectCountry);
        selectCountry.click();
    }

    public void clickSelectRegion() {
        isVisible(selectRegion);
        selectRegion.click();
    }

    public void clickDefaultAddressYes() {
        isVisible(defaultAddressYes);
        defaultAddressYes.click();
    }

    public void clickBotonContinueAddress(){
        isVisible(botonContinueAddress);
        botonContinueAddress.click();
    }

    public void sendKeysSelectCountry(String country) {
        List<WebElement> opcionCountry = selectCountry.findElements(By.tagName("option"));
        for (WebElement element : opcionCountry){
            if (element.getText().equals(country)){
                element.click();
                break;
            }
        }
    }

    public void sendKeysSelectCRegion(String region) {
        List<WebElement> opcionCountry = selectRegion.findElements(By.tagName("option"));
        for (WebElement element : opcionCountry){
            if (element.getText().equals(region)){
                element.click();
                break;
            }
        }
    }


}
