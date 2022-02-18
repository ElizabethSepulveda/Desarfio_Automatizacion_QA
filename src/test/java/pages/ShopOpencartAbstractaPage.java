package pages;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;


public class ShopOpencartAbstractaPage extends BasePage {

    String path = "C:\\Users\\crist\\Desktop\\TEST AUTOMATION PREVIRED\\Desafio_Automatizacion_QA\\dataTest\\accountData.csv";
  
    private String shopCart = "//span[contains(text(),'Shopping Cart')]"; 
    private String checkoutCart = "//a[contains(text(),'Checkout')]";
    private String textBoxEmailLogin = "//input[@id='input-email']";
    private String textBoxPasswordLogin = "//input[@id='input-password']";
    private String loginButton = "//input[@id='button-login']";
    private String registerRadioButton = "//input[@value='register']";
    private String registerButton = "//input[@id='button-account']";
    private String firstName = "//input[@id='input-payment-firstname']";
    private String lastName = "//input[@id='input-payment-lastname']";
    private String email = "//input[@id='input-payment-email']";
    private String phone = "//input[@id='input-payment-telephone']";
    private String password = "//input[@id='input-payment-password']";
    private String passwordConfirm = "//input[@id='input-payment-confirm']";
    private String address = "//input[@id='input-payment-address-1']";
    private String city = "//input[@id='input-payment-city']";
    private String postcode = "//input[@id='input-payment-postcode']";
    private String country = "//select[@id='input-payment-country']";
    private String state = "//select[@id='input-payment-zone']";
    private String stateOption = "//option[contains(text(),'Valparaiso')]";
    private String policy = "//input[@name='agree']";
    private String continueRegisterButton = "//input[@id='button-register']";
    private String addressRegisterButton = "//input[@id='button-shipping-address']";
    private String deliveryRegisterButton = "//input[@id='button-shipping-method']";
    private String conditionsPayment = "//input[@name='agree']";
    private String continuePaymentButton = "//input[@id='button-payment-method']";
    private String confirmOrderButton = "//input[@id='button-confirm']";
    


    public ShopOpencartAbstractaPage(){
        super(driver);
    }

public void clickProductCart(){

    clickElement(shopCart);
}

public void selectTextBoxEmailLogin(){

    clickElement(textBoxEmailLogin);
    
}

public void selectTextBoxPasswordLogin(){

    clickElement(textBoxPasswordLogin);
    
}

public void clickCheckoutCart(){
    clickElement(checkoutCart);
}

public void writeCredencialEmail(String credential){

    write(textBoxEmailLogin,credential);

}

public void writeCredencialPassword(String credential){

    write(textBoxPasswordLogin,credential);


}



public void clickRegisterAccount(){

    clickElement(registerRadioButton);
    clickElement(registerButton);
    
  
}

public void registerAccount() throws IOException{
    
    CSVReader reader = new CSVReader(new FileReader(path));
    
        
    String [] csvCell;

    
        while((csvCell = reader.readNext()) != null){
            String firstNameText = csvCell[0];
            String lastNameText = csvCell[1];
            String emailText = csvCell[2];
            String phoneText = csvCell[3];
            String passwordText = csvCell[4];
            String addressText = csvCell[5];
            String cityText = csvCell[6];
            String postcodeText = csvCell[7];
            String countryText = csvCell[8];
            
            write(firstName, firstNameText);
            write(lastName,lastNameText);
            write(email,emailText);
            write(phone,phoneText);
            write(password,passwordText);
            write(passwordConfirm,passwordText);
            write(address,addressText);
            write(city,cityText);
            write(postcode,postcodeText);
            selectFromDropdownByText(country, countryText);
            clickElement(state);
            clickElement(stateOption);
            clickElement(state);
            clickElement(policy);
            clickElement(continueRegisterButton);
            clickElement(addressRegisterButton);
            clickElement(deliveryRegisterButton);
            clickElement(conditionsPayment);
            clickElement(continuePaymentButton);
            clickElement(confirmOrderButton);


}



}

public void clickLogin(){
    clickElement(loginButton);
}



}
