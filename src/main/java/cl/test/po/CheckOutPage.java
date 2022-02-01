package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage {

    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    private WebElement tituloCheckOut;

    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    private WebElement tituloSeccionLogin;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 1: Checkout Options')]]")
    private WebElement tituloCheckOutOpt;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 2: Billing Details')]]")
    private WebElement tituloBillingDetails;

    @FindBy(xpath = "//div[1]/label[1]/input[@name='payment_address']")
    private WebElement optionPaymentAddress;

    @FindBy(xpath = "//input[@id='button-payment-address' and @value='Continue']")
    private WebElement botonContinueBillingDetails;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 3: Delivery Details')]]")
    private WebElement tituloDeliveryDetails;

    @FindBy(xpath = "//div[1]/label[1]/input[@name='shipping_address']")
    private WebElement optionShippingAddress;

    @FindBy(xpath = "//input[@id='button-shipping-address' and @value='Continue']")
    private WebElement botonContinueDeliveryDetails;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 4: Delivery Method')]]")
    private WebElement tituloDeliveryMethod;

    @FindBy(xpath = "//div[1]/label[1]/input[@name='shipping_method']")
    private WebElement optionShippingMethod;

    @FindBy(xpath = "//p[4]/textarea[1]")
    private WebElement inputTextAreaShippingMethod;

    @FindBy(xpath = "//input[@id='button-shipping-method' and @value='Continue']")
    private WebElement botonContinueShippingMethod;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 5: Payment Method')]]")
    private WebElement tituloPaymentMethod;

    @FindBy(xpath = "//div[1]/label[1]/input[@name='payment_method']")
    private WebElement optionPaymentMethod;

    @FindBy(xpath = "//p[3]/textarea[1]")
    private WebElement inputTextAreaPaymentMethod;

    @FindBy(xpath = "//div[contains(text(),'I have read and agree to the ')]/input[@name='agree']")
    private WebElement optionPaymentMethodAcceptConditions;

    @FindBy(xpath = "//input[@id='button-payment-method' and @value='Continue']")
    private WebElement botonContinuePaymentMethod;

    @FindBy(xpath = "//h4[a[contains(text(),'Step 6: Confirm Order')]]")
    private WebElement tituloConfirmOrder;

    @FindBy(xpath = "//strong[contains(text(),'Flat Shipping Rate:')]")
    private WebElement condicionFlatShipping;

    @FindBy(xpath = "//td[contains(text(),'$5.00')]")
    private WebElement priceFlatShipping;

    @FindBy(xpath = "//input[@id='button-confirm']")
    private WebElement botonConfirmOrder;

    @FindBy(xpath = "//h1[contains(text(),'Your order has been placed!')]")
    private WebElement labelOrdenCompleta;

    @FindBy(xpath = "//p[contains(text(),'Your order has been successfully processed!')]")
    private WebElement mgsOrdenExitoso;

    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    private WebElement botonContinueCierre;

    @FindBy(id = "input-email")
    private WebElement inputEmail;

    @FindBy(id = "input-password")
    private WebElement inputPassword;

    @FindBy(id = "button-login")
    private WebElement botonLogin;

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleTitulo() {
        isVisible(tituloCheckOut);
        return tituloCheckOut.isEnabled();
    }

    public boolean isVisibleTituloLogin() {
        isVisible(tituloSeccionLogin);
        return tituloCheckOut.isEnabled();
    }

    public boolean isVisibleTituloCheckOutOpt() {
        isVisible(tituloCheckOutOpt);
        return tituloCheckOutOpt.isEnabled();
    }

    public boolean isVisibleTituloBillingDetails() {
        isVisible(tituloBillingDetails);
        return tituloBillingDetails.isEnabled();
    }

    public void clickOptionPaymentAddress() {
        isVisible(optionPaymentAddress);
        optionPaymentAddress.click();
    }

    public void clickBotonContinueBillingDetails() {
        isVisible(botonContinueBillingDetails);
        botonContinueBillingDetails.click();
    }

    public boolean isVisibleTituloDeliveryDetails() {
        isVisible(tituloDeliveryDetails);
        return tituloDeliveryDetails.isEnabled();
    }

    public void clickOptionShippingAddress() {
        isVisible(optionShippingAddress);
        optionShippingAddress.click();
    }

    public void clickBotonContinueDeliveryDetails() {
        isVisible(botonContinueDeliveryDetails);
        botonContinueDeliveryDetails.click();
    }

    public boolean isVisibleTituloDeliveryMethod() {
        isVisible(tituloDeliveryMethod);
        return tituloDeliveryMethod.isEnabled();
    }

    public void clickOptionShippingMethod() {
        isVisible(optionShippingMethod);
        optionShippingMethod.click();
    }

    public void sendKeysInputTextAreaShippingMethod(String text1) {
        isVisible(inputTextAreaShippingMethod);
        inputTextAreaShippingMethod.clear();
        inputTextAreaShippingMethod.sendKeys(text1);
    }

    public void clickBotonContinueShippingMethod() {
        isVisible(botonContinueShippingMethod);
        botonContinueShippingMethod.click();
    }

    public boolean isVisibleTituloPaymentMethod() {
        isVisible(tituloPaymentMethod);
        return tituloPaymentMethod.isEnabled();
    }

    public void clickOptionPaymentMethod() {
        isVisible(optionPaymentMethod);
        optionPaymentMethod.click();
    }

    public void sendKeysInputTextAreaPaymentMethod(String text2) {
        isVisible(inputTextAreaPaymentMethod);
        inputTextAreaPaymentMethod.clear();
        inputTextAreaPaymentMethod.sendKeys(text2);
    }

    public void clickOptionPaymentMethodAcceptConditions() {
        isVisible(optionPaymentMethodAcceptConditions);
        optionPaymentMethodAcceptConditions.click();
    }

    public void clickBotonContinuePaymentMethod() {
        isVisible(botonContinuePaymentMethod);
        botonContinuePaymentMethod.click();
    }

    public boolean isVisibleTituloConfirmOrder() {
        isVisible(tituloConfirmOrder);
        return tituloConfirmOrder.isEnabled();
    }

    public boolean isVisibleCondicionFlatShipping() {
        isVisible(condicionFlatShipping);
        return condicionFlatShipping.isEnabled();
    }

    public boolean isVisiblePriceFlatShipping() {
        isVisible(priceFlatShipping);
        return priceFlatShipping.isEnabled();
    }

    public void clickBotonConfirmOrder() {
        isVisible(botonConfirmOrder);
        botonConfirmOrder.click();
    }

    public boolean isVisibleOrderComplete() {
        isVisible(labelOrdenCompleta);
        isVisible(mgsOrdenExitoso);
        return labelOrdenCompleta.isEnabled();
    }

    public void clickBotonContinueCierre() {
        isVisible(botonContinueCierre);
        botonContinueCierre.click();
    }


    public void sendKeysInputEmail(String email) {
        isVisible(inputEmail);
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputPassword(String pass) {
        isVisible(inputPassword);
        inputPassword.clear();
        inputPassword.sendKeys(pass);
    }

    public void clickBotonLogin() {
        isVisible(botonLogin);
        botonLogin.click();
    }



}
