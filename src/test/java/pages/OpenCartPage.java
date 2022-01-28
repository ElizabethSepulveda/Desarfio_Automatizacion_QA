package pages;

import static utils.ReadExternalData.readData;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.util.List;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class OpenCartPage extends BasePage {

    //TO-DO
    //ELIMINAR TODOS LOS ELEMENTOS YA NO UTILIZADOS DESDE ESTA CLASE.

    private String searchTextField = "//input[@name='search']";
    private String searchBtn = "//button[@class='btn btn-default btn-lg']";
    private String cardElement = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']";
    private String imgProduct = "//img[@class='img-responsive']";
    private String btnAddToCart = "//button[@id='button-cart']";
    private String successMessage = "//div[@class='alert alert-success alert-dismissible']";
    private String inputQuantity = "//input[@name='quantity']";
    private String btnCart = "//a[@title='Shopping Cart']";
    private String btnCheckout = "//a[contains(text(),'Checkout')]";
    private String inputEmail = "//input[@name='email']";
    private String inputPassword = "//input[@name='password']";
    private String btnLogin = "//input[@id='button-login']";
    private String btnMyAccount = "//a[@title='My Account']";
    private String btnOrderHistory = "//a[contains(text(),'Order History')]";
    private String btnLogout = "//a[contains(text(),'Logout')]";
    private String radioBtnBillingDetails = "//input[@name='payment_address' and @value='existing']";
    private String btnBillingDetailsContinue = "//input[@id='button-payment-address']";
    private String radioBtnDeliveryDetails = "//input[@name='shipping_address' and @value='existing']";
    private String btnDeliveryDetailsContinue = "//input[@id='button-shipping-address']";
    private String radioBtnFlatRate = "//input[@name='shipping_method']";
    private String btnDeliveryMethodContinue = "//input[@id='button-shipping-method']";
    private String radioBtnCashOnDelivery = "//input[@name='payment_method']";
    private String chkBoxAgreeConditions = "//input[@name='agree']";
    private String btnPaymentMethodContinue = "//input[@id='button-payment-method']";
    private String btnConfirmOrder = "//input[@id='button-confirm']";
    private String tableResponsive = "//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/";
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
    private String alterAccountRegister = "//div[@class='alert alert-danger alert-dismissible']";
    private String tableOrderHistory = "//body[1]/div[2]/div[1]/div[1]/div[1]/table[1]/tbody[1]/";
    private String btnOrderView = "//a[@class='btn btn-info']";
    private String tableOrderAddress = "//body[1]/div[2]/div[1]/div[1]/table[2]/tbody[1]/";
    private String tableConfirmOrder = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[2]/div[1]/div[1]/table[1]/tfoot[1]/";
    // WebElements Apple Cinema 30
    private String listRadioBtn = "//input[@name='option[218]' and @value='7']";
    private String chkBox2 = "//input[@name='option[223][]' and @value='9']";
    private String chkBox4 = "//input[@name='option[223][]' and @value='11']";
    private String txtBox = "//input[@name='option[208]' and @value='test']";
    private String selectCinema = "//select[@name='option[217]' and @id='input-option217']";
    private String txtAreaCinema = "//textarea[@name='option[209]' and @id='input-option209']";
    private String fileUpload = "//button[@id='button-upload222']";
    private String dateCinema = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[7]/div[1]/span[1]/button[1]";
    private String calendarMonth = "//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[2]";
    private String calendarYear = "//body[1]/div[4]/div[1]/div[2]/table[1]/thead[1]/tr[1]/th[2]";
    private String calendarChangeYear = "//body[1]/div[4]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[3]";
    private String calendarYearSelect = "//span[contains(text(),'2022')]";
    private String calendarMonthSelect = "//body[1]/div[4]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[1]";
    private String calendarDaySelect = "//body[1]/div[4]/div[1]/div[1]/table[1]/tbody[1]/tr[5]/td[3]";
    private String timeCinema = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[8]/div[1]/span[1]/button[1]";
    private String calendarTimeHour = "//body[1]/div[6]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]";
    private String calendarChangeHour = "//body[1]/div[6]/div[1]/div[2]/table[1]/tbody[1]/tr[5]/td[2]";
    private String calendarTimeMinute = "//body[1]/div[6]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/span[1]";
    private String calendarChangeMinute = "//body[1]/div[6]/div[1]/div[3]/table[1]/tbody[1]/tr[2]/td[2]";
    private String dateTimeCalendar = "//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[9]/div[1]/span[1]/button[1]";
    private String dateTimeMonth = "//th[contains(text(),'February 2011')]";
    private String dateTimeYear = "//body[1]/div[5]/ul[1]/li[1]/div[1]/div[2]/table[1]/thead[1]/tr[1]/th[2]";
    private String dateTimeChangeDatePage = "//body[1]/div[5]/ul[1]/li[1]/div[1]/div[3]/table[1]/thead[1]/tr[1]/th[3]";
    private String dateTimeChangeYear = "//body[1]/div[5]/ul[1]/li[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/span[3]";
    private String dateTimeChangeMonth = "//body[1]/div[5]/ul[1]/li[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[1]/span[12]";
    private String dateTimeChangeDay = "//body[1]/div[5]/ul[1]/li[1]/div[1]/div[1]/table[1]/tbody[1]/tr[4]/td[5]";
    private String dateTimeChangeTime = "//body/div[5]/ul[1]/li[2]/a[1]";
    private String dateTimeChangeHour = "//body[1]/div[5]/ul[1]/li[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/span[1]";
    private String dateTimeChangeNewHour = "//body[1]/div[5]/ul[1]/li[3]/div[1]/div[2]/table[1]/tbody[1]/tr[6]/td[4]";
    private String dateTimeChangeMinute = "//body[1]/div[5]/ul[1]/li[3]/div[1]/div[1]/table[1]/tbody[1]/tr[2]/td[3]/span[1]";
    private String dateTimeChangeNewMinute = "//body[1]/div[5]/ul[1]/li[3]/div[1]/div[3]/table[1]/tbody[1]/tr[3]/td[4]";
    private String quantityCinema = "//input[@id='input-quantity']";
    private String buttonOkCinema = "//button[@id='button-cart']";
    private String successAlertCinema = "//div[@class='alert alert-success alert-dismissible']";

    public OpenCartPage() {
        super(driver);
    }

    /**
     * Método para abrir la navegación en la página https://opencart.abstracta.us.
     * 
     * @param url dirección URL.
     */
    public void navigateToOpenCartPage(String url) {
        navigateTo(url);
    }

    /**
     * Método para ingresar productos en el buscador de la página.
     * 
     * @param product nombre del producto a buscar.
     */
    public void enterSearchCriteria(String product) {
        write(searchTextField, product);
    }

    /**
     * Método para presionar el activar la busqueda de producto en el buscador.
     * 
     */
    public void clickSearchBtn() {
        clickElement(searchBtn);
    }

    /**
     * Método para ver el producto
     * 
     */
    public void viewProduct() {
        List<WebElement> list = bringMeAllElements(cardElement);
        if (list.size() == 1) {
            clickElement(imgProduct);
        }
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
     * @return verdadero si se muestra el mensaje de exito para agregar el producto.
     * @throws InterruptedException
     */
    public Boolean addProductToCart() throws InterruptedException {
        Boolean condition = false;
        clickElement(btnAddToCart);
        if (elementIsDisplayed(successMessage)) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para ingresar a visualizar el carro.
     * 
     */
    public void viewCart() {
        clickElement(btnCart);
    }

    /**
     * Método para validar los dos productos ingresados en el carro.
     * 
     * @param productoUno nombre del primer producto.
     * @param productoDos nombre del segundo producto.
     * @return verdadero si ambos productos coinciden.
     */
    public Boolean validateProductsInCart(String productoUno, String productoDos) {
        Boolean condition = false;
        String prod1 = getValueFromTable(tableResponsive, 1, 2).toLowerCase();
        String prod2 = getValueFromTable(tableResponsive, 2, 2).toLowerCase();
        if (prod1.equals(productoDos.toLowerCase()) && prod2.equals(productoUno.toLowerCase())) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para ir a la página de Checkout.
     * 
     */
    public void goCheckout() {
        clickElement(btnCheckout);
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
    public void registerUser() throws FileNotFoundException, InterruptedException {
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
            if (elementIsDisplayed(alterAccountRegister)) {
                System.out.println("El email ya se encuentra registrado");
            }
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
    public void cashOnDelivery() {
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
     * Método para desplegar el menu de MyAccount.
     */
    public void viewMyAccountOptions() {
        clickElement(btnMyAccount);
    }

    /**
     * Método para ir al historial de ordenes.
     */
    public void goToOrderHistory() {
        viewMyAccountOptions();
        clickElement(btnOrderHistory);
    }

    /**
     * Método para ir a ver el detalle del primer producto en el listado de ordenes
     * y validar que la dirección de pago coincida con la del usuario registrado.
     * 
     * @return verdadero si la dirección coincide.
     * @throws FileNotFoundException se lanzará una excepción si hay problemas con
     *                               el archivo.
     */
    public Boolean goToOrderView() throws FileNotFoundException {
        String addressRegister = readData().getProperty("addressRegister");
        Boolean condition = false;
        goToOrderHistory();
        clickElement(btnOrderView);
        if (getValueFromTable(tableOrderAddress, 1, 1).contains(addressRegister)) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para devolver el valor del estado de la orden.
     * 
     * @return el estado de la orden.
     */
    public String validateStatusOrder() {
        String status = "";
        status = getValueFromTable(tableOrderHistory, 1, 4);
        return status;
    }

    /**
     * Método para salir de la sesión de Usuario.
     * 
     */
    public void logoutUser() {
        viewMyAccountOptions();
        clickElement(btnLogout);
    }

    /**
     * Método para subir un archivo.
     * 
     * @throws AWTException
     * @throws InterruptedException
     */
    public void upLoadFile() throws AWTException, InterruptedException {
        clickElement(fileUpload);
        Robot rb = new Robot();
        StringSelection str = new StringSelection("C:\\apple.jpg");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

        // press Contol+V for pasting
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);

        // release Contol+V for pasting
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);

        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        dismissAlert();
    }

    /**
     * Método Para Seleccionar la fecha 26-01-2022 desde calendario para fecha.
     * 
     */
    public void dateCalendar() {
        clickElement(dateCinema);
        clickElement(calendarMonth);
        clickElement(calendarYear);
        clickElement(calendarChangeYear);
        clickElement(calendarYearSelect);
        clickElement(calendarMonthSelect);
        clickElement(calendarDaySelect);
    }

    /**
     * Método para seleccionar la hora 17:25 en el calendario.
     * 
     */
    public void timeCalendar() {
        clickElement(timeCinema);
        clickElement(calendarTimeHour);
        clickElement(calendarChangeHour);
        clickElement(calendarTimeMinute);
        clickElement(calendarChangeMinute);
        clickElement(timeCinema);
    }

    /**
     * Método para seleccionar la fecha 2021-12-24 y la hora 23:55 en el calendario.
     * 
     */
    public void dateTimeCalendar() {
        clickElement(dateTimeCalendar);
        clickElement(dateTimeMonth);
        clickElement(dateTimeYear);
        clickElement(dateTimeChangeDatePage);
        clickElement(dateTimeChangeYear);
        clickElement(dateTimeChangeMonth);
        clickElement(dateTimeChangeDay);
        clickElement(dateTimeChangeTime);
        clickElement(dateTimeChangeHour);
        clickElement(dateTimeChangeNewHour);
        clickElement(dateTimeChangeMinute);
        clickElement(dateTimeChangeNewMinute);
        clickElement(dateTimeCalendar);
    }

    /**
     * Método para completar las opciones necesarias para el Apple Cinem 30.
     * 
     * @return
     * @throws AWTException
     * @throws InterruptedException
     */
    public Boolean setProduct() throws AWTException, InterruptedException {
        Boolean condition = false;
        clickElement(listRadioBtn);
        clickElement(chkBox2);
        clickElement(chkBox4);
        clickElement(txtBox);
        write(txtBox, "Test_1");
        selectFromDropdownByValue(selectCinema, "2");
        write(txtAreaCinema, "What is Lorem Ipsum?");
        upLoadFile();
        dateCalendar();
        timeCalendar();
        dateTimeCalendar();
        write(quantityCinema, "2");
        clickElement(buttonOkCinema);
        if (elementIsDisplayed(successAlertCinema)) {
            condition = true;
        }
        return condition;
    }
}
