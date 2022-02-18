package steps;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.ShopOpencartAbstractaPage;

public class ShopOpencartAbstractaSteps {

    String path = "C:\\Users\\crist\\Desktop\\TEST AUTOMATION PREVIRED\\Desafio_Automatizacion_QA\\dataTest\\loginData.csv";
    

    ShopOpencartAbstractaPage shop = new ShopOpencartAbstractaPage();
   

    @Given("^ingreso al carrito de compras$") 
    
    public void viewCart(){
       shop.clickProductCart();
    
}
    @When("^hago click en boton checkout$")

    public void checkoutCart(){
        shop.clickCheckoutCart();
    }

    @And("^realizo creacion de cuenta$")

    public void createAccountOpencart() throws IOException {
        
        shop.clickRegisterAccount();
        shop.registerAccount();
         
    }

    @And("^ingreso credenciales desde archivo$")

    public void loginOpencart() throws IOException{
        
        CSVReader reader = new CSVReader(new FileReader(path));
        String [] csvCell;

        while((csvCell = reader.readNext()) != null){
            String email = csvCell[0];
            String password = csvCell[1];

            shop.selectTextBoxEmailLogin();
            shop.writeCredencialEmail(email);
            shop.selectTextBoxPasswordLogin();
            shop.writeCredencialPassword(password);
            shop.clickLogin();

        }

    }



}
