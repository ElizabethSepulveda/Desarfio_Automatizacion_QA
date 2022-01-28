package pages;

import static utils.ReadExternalData.readData;

import java.io.FileNotFoundException;

public class OrderInformationPage extends BasePage {

    private String tableOrderAddress = "//body[1]/div[2]/div[1]/div[1]/table[2]/tbody[1]/";
    private String tableOrderHistory = "//body/div[@id='account-order']/div[1]/div[1]/table[3]/tbody[1]/";

    public OrderInformationPage() {
        super(driver);
    }

    /**
     * Método que devuelve el contenido del payment Address
     * 
     * @return
     */
    public String getPaymentAddress() {
        String paymentAddress = "";
        paymentAddress = getValueFromTable(tableOrderAddress, 1, 1);
        return paymentAddress;
    }

    /**
     * Método que compara que los datos que tiene el Payment Address sean los mismos
     * del usuario.
     * 
     * @return
     * @throws FileNotFoundException
     */
    public Boolean comparePaymentAddressWithUserAddress() throws FileNotFoundException {
        Boolean condition = false;
        String addressRegister = readData().getProperty("addressRegister");
        String firstNameRegister = readData().getProperty("firstNameRegister");
        String lastNameRegister = readData().getProperty("lastNameRegister");
        String countryRegister = readData().getProperty("countryRegister");
        String regionRegister = readData().getProperty("regionRegister");
        if (getPaymentAddress().contains(addressRegister) &&
                getPaymentAddress().contains(firstNameRegister) &&
                getPaymentAddress().contains(lastNameRegister) &&
                getPaymentAddress().contains(countryRegister) &&
                getPaymentAddress().contains(regionRegister)) {
            condition = true;
        }
        return condition;
    }

    /**
     * Método para devolver el valor del estado de la orden.
     * 
     * @return el estado de la orden.
     */
    public String getStatusOrder() {
        String status = "";
        status = getValueFromTable(tableOrderHistory, 1, 2);
        return status;
    }
}
