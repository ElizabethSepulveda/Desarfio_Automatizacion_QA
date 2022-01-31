package pages;

import java.io.FileNotFoundException;
import static utils.ReadExternalData.readData;

public class CheckoutPage extends BasePage {

    // REGISTER SECTION
    private String radioBtnRegisterAccount = "//input[@name='account' and @value='register']";
    private String btnRegisterNewAccountContinue = "//input[@id='button-account' and @value='Continue']";
    private String inputFirstNameRegister = "//input[@id='input-payment-firstname']";
    private String inputLastNameRegister = "//input[@id='input-payment-lastname']";
    private String inputEmailRegister = "//input[@id='input-payment-email']";
    private String inputPhoneNumberRegister = "//input[@id='input-payment-telephone']";
    private String inputPasswordRegister = "//input[@id='input-payment-password']";
    private String inputPasswordConfirmRegister = "//input[@id='input-payment-confirm']";
    private String inputAddressRegister = "//input[@id='input-payment-address-1']";
    private String inputCityRegister = "//input[@id='input-payment-city']";
    private String inputPostCodeRegister = "//input[@id='input-payment-postcode']";
    private String selectCountryRegister = "//select[@id='input-payment-country']";
    private String selectRegionRegister = "//select[@id='input-payment-zone']";
    private String chkBoxAgreeRegister = "//input[@name='agree']";
    private String btnRegister = "//input[@id='button-register']";
    // LOGIN SECTION
    private String inputEmail = "//input[@name='email']";
    private String inputPassword = "//input[@name='password']";
    private String btnLogin = "//input[@id='button-login']";
    // BILLING SECTION
    private String radioBtnBillingDetails = "//input[@name='payment_address' and @value='existing']";
    private String btnBillingDetailsContinue = "//input[@id='button-payment-address']";
    // DELIVERY DETAILS SECTION
    private String radioBtnDeliveryDetails = "//input[@name='shipping_address' and @value='existing']";
    private String btnDeliveryDetailsContinue = "//input[@id='button-shipping-address']";
    // DELIVERY METHOD SECTION
    private String radioBtnFlatRate = "//input[@name='shipping_method']";
    private String btnDeliveryMethodContinue = "//input[@id='button-shipping-method']";
    // DELIVERY PAYMENT SECTION
    private String radioBtnCashOnDelivery = "//input[@name='payment_method']";
    private String chkBoxAgreeConditions = "//input[@name='agree']";
    private String btnPaymentMethodContinue = "//input[@id='button-payment-method']";
    // CONFIRM ORDER SECTION
    private String tableConfirmOrder = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/table[1]/tfoot[1]/";
    private String btnConfirmOrder = "//input[@id='button-confirm']";
    // SUCCESS SECTION
    private String linkToOrderHistory = "//a[contains(text(),'history')]";

    public CheckoutPage() {
        super(driver);
    }

    /**
     * Método para registrar un usuario con datos pasados desde fichero externo
     * DATA/config.properties.
     * 
     * @throws FileNotFoundException se lanzará una excepción si hay problemas con
     *                               el archivo.
     * @throws InterruptedException  se lanzará una excepción si hay problemas con
     *                               el tiempo de espera.
     */
    public void registerNewUser() throws FileNotFoundException, InterruptedException {
        String firstNameRegister = readData().getProperty("firstNameRegister");
        String lastNameRegister = readData().getProperty("lastNameRegister");
        String emailRegister = readData().getProperty("emailRegister");
        String phoneRegister = readData().getProperty("phoneRegister");
        String passwordRegister = readData().getProperty("passwordRegister");
        String confirmRegister = readData().getProperty("confirmRegister");
        String addressRegister = readData().getProperty("addressRegister");
        String cityRegister = readData().getProperty("cityRegister");
        String postCodeRegister = readData().getProperty("postCodeRegister");
        String countryRegister = readData().getProperty("countryRegister");
        String regionRegister = readData().getProperty("regionRegister");
        if (elementIsSelected(radioBtnRegisterAccount)) {
            clickElement(btnRegisterNewAccountContinue);
            write(inputFirstNameRegister, firstNameRegister);
            write(inputLastNameRegister, lastNameRegister);
            write(inputEmailRegister, emailRegister);
            write(inputPhoneNumberRegister, phoneRegister);
            write(inputPasswordRegister, passwordRegister);
            write(inputPasswordConfirmRegister, confirmRegister);
            write(inputAddressRegister, addressRegister);
            write(inputCityRegister, cityRegister);
            write(inputPostCodeRegister, postCodeRegister);
            selectFromDropdownByText(selectCountryRegister, countryRegister);
            Thread.sleep(600);
            selectFromDropdownByText(selectRegionRegister, regionRegister);
            clickElement(chkBoxAgreeRegister);
            clickElement(btnRegister);
        }
    }

    /**
     * Método para hacer login de usuario con datos proporcionados desde fichero
     * externo DATA/config.properties.
     * 
     * @throws FileNotFoundException se lanzará una excepción si hay problemas con
     *                               el archivo.
     */
    public void loginUser() throws FileNotFoundException {
        String email = readData().getProperty("email");
        String password = readData().getProperty("password");
        clickElement(inputEmail);
        write(inputEmail, email);
        clickElement(inputPassword);
        write(inputPassword, password);
        clickElement(btnLogin);
    }

    /**
     * Método para pasar por el proceso de billing details.
     * Es necesario estar en el proceso de checkout.
     */
    public void billingDetails() {
        if (elementIsSelected(radioBtnBillingDetails)) {
            clickElement(btnBillingDetailsContinue);
        }
    }

    /**
     * Método para pasar por el proceso de delivery details.
     * Es necesario haber pasado por el proceso de billing details.
     */
    public void deliveryDetails() {
        if (elementIsSelected(radioBtnDeliveryDetails)) {
            clickElement(btnDeliveryDetailsContinue);
        }
    }

    /**
     * Método para pasar por el proceso de delivery method.
     * Es necesario haber pasado por el proceso de delivery details.
     * 
     * @return verdadero si se puede continuar con el proceso.
     */
    public Boolean deliveryMethod() {
        Boolean condition = false;
        if (elementIsSelected(radioBtnFlatRate)) {
            clickElement(btnDeliveryMethodContinue);
            condition = true;
        }
        return condition;
    }

    /**
     * Método para pasar el proceso de payment method.
     * Es necesario haber pasado por el proceso de delivery method.
     */
    public void paymentMethod() {
        if (elementIsSelected(radioBtnCashOnDelivery)) {
            clickElement(chkBoxAgreeConditions);
            clickElement(btnPaymentMethodContinue);
        }
    }

    /**
     * Método para confirmar la Orden.
     * Es necesario haber pasado por el proceso de payment method.
     * 
     * @param shipping valor a comparar con el shipping.
     * @return verdadero si el shipping coincide con lo mostrado.
     */
    public Boolean confirmOrder(String shipping) {
        Boolean condition = false;
        String shippingMethod = "";
        shippingMethod = getValueFromTable(tableConfirmOrder, 2, 1).replace(":", "");
        shippingMethod = shippingMethod + " - " + getValueFromTable(tableConfirmOrder, 2, 2);
        if (shippingMethod.equals(shipping)) {
            clickElement(btnConfirmOrder);
            condition = true;
        }
        return condition;
    }

    /**
     * Método para presionar el boton de confirmación de la Orden.
     */
    public void confirmOrderWithoutShipping() {
        clickElement(btnConfirmOrder);
    }

    /**
     * Método para ir al historial de ordenes.
     */
    public void goToOrderHistory() {
        clickElement(linkToOrderHistory);
    }
}
