package steps;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OpencartAbstractaPage;


public class OpencartAbstractaSteps {

    OpencartAbstractaPage opencart = new OpencartAbstractaPage();
    
    @Given("^navego al sitio web$") 
    public void navigateToOpencart(){
        opencart.navigateToOpencartAbstracta();
    }

    @When("^hago click en la barra de busqueda$") 
    public void selectSearchOpencart(){
        opencart.selectSearchOpencartAbstracta();

    }

    @And("^ingreso el (.+) en la barra de busqueda$") 
    public void writeSearchOpencart(String product){
        opencart.writeSearchOpencartAbstracta(product);
        opencart.clickSearchButtonOpencartAbstracta();
    }

    @And("^agrego el producto al carro de compras$") 
    public void enterProductOpencart(){
        opencart.clickAddButtonOpencartAbstracta();
    }

    @Then("^valido que el producto haya sido agredado al carro de compras$") 
    
    public void validateProductOpencart(){
        
        
        
    
    }

}