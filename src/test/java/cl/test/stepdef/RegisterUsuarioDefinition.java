package cl.test.stepdef;

import cl.test.po.*;
import cl.test.utils.DataReadProvider;
import cl.test.utils.SharedDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class RegisterUsuarioDefinition {

    public WebDriver driver;
    public DataReadProvider dataReadProvider;
    public HeaderPage headerPage;
    public HomePage homePage;
    public SearchPage searchPage;
    public RegisterPage registerPage;
    public AddressBookPage addressBookPage;

    public RegisterUsuarioDefinition(SharedDriver driver, HeaderPage headerPage, HomePage homePage, 
                                     SearchPage searchPage, RegisterPage registerPage, AddressBookPage addressBookPage) {
        this.driver = driver.getWrappedDriver();
        this.dataReadProvider = new DataReadProvider();
        this.headerPage = headerPage;
        this.homePage = homePage;
        this.searchPage = searchPage;
        this.registerPage = registerPage;
        this.addressBookPage = addressBookPage;
        this.headerPage.takeScreenshot();
    }

    @When("Ingreso a la pagina de registrar usuario")
    public void ingreso_a_la_pagina_registrar_usuario() {
        headerPage.clickBotonMyAccount();
        headerPage.sendKeysSelectNombreOpcion("Register");
        Assert.assertTrue(registerPage.isVisibleTituloAccount());
        Assert.assertTrue(registerPage.isVisibleTituloFormulario());
        Assert.assertTrue(registerPage.isVisibleTituloSeccionPassword());
        Assert.assertTrue(registerPage.isVisibleTituloSeccionNewsletter());
    }

    @And("Ingreso los datos personales")
    public void ingreso_datos_personales() {
        registerPage.sendKeysInputFirstName(dataReadProvider.loadRegisterUser().getProperty("firtsName"));
        registerPage.sendKeysInputLastName(dataReadProvider.loadRegisterUser().getProperty("lastName"));
        registerPage.sendKeysInputEmail(dataReadProvider.loadRegisterUser().getProperty("emailNew"));
        registerPage.sendKeysInputTelephone(dataReadProvider.loadRegisterUser().getProperty("phone"));
    }

    @And("Ingreso password")
    public void ingreso_password() {
        registerPage.sendKeysInputPassword(dataReadProvider.loadRegisterUser().getProperty("pass"));
        registerPage.sendKeysInputConfirmPassword(dataReadProvider.loadRegisterUser().getProperty("passConfirm"));
    }

    @And("Me suscribo a noticias")
    public void me_suscribo_a_noticias() {
        registerPage.clickRadioBotonYesSubscribe();
    }

    @And("Acepto la politica de privacidad")
    public void acepto_politicas_privacidad() {
        registerPage.clickCheckBotonPrivacyPolicy();
    }

    @Then("Registro de forma exitosa")
    public void registro_success() {
        registerPage.clickBotonContinue();
        Assert.assertTrue(registerPage.isVisibleLabelRegisterAccount());
        registerPage.clickBotonContinueSuccess();
        Assert.assertTrue(registerPage.isVisibleLabelTituloAccount());
    }

    @Then("Registro una direccion en el libro")
    public void registrar_direccion() {
        addressBookPage.clickOpcionAddressBook();
        Assert.assertTrue(addressBookPage.isVisibleTituloPreviewAddress());
        Assert.assertTrue(addressBookPage.isVisibleContentText());
        addressBookPage.clickBotonNewAddress();
        Assert.assertTrue(addressBookPage.isVisibleTituloPageAddAddress());
        addressBookPage.sendKeysInputFirstNameAddress(dataReadProvider.loadRegisterUser().getProperty("firstNameAdd"));
        addressBookPage.sendKeysInputLastNameAddress(dataReadProvider.loadRegisterUser().getProperty("lastNameAdd"));
        addressBookPage.sendKeysInputCompanyAddress(dataReadProvider.loadRegisterUser().getProperty("company"));
        addressBookPage.sendKeysInputAddress1(dataReadProvider.loadRegisterUser().getProperty("address1"));
        addressBookPage.sendKeysInputAddress2(dataReadProvider.loadRegisterUser().getProperty("address2"));
        addressBookPage.sendKeysInputCityAddress(dataReadProvider.loadRegisterUser().getProperty("city"));
        addressBookPage.sendKeysInputCodePostal(dataReadProvider.loadRegisterUser().getProperty("postalcode"));
        addressBookPage.clickSelectCountry();
        addressBookPage.sendKeysSelectCountry(dataReadProvider.loadRegisterUser().getProperty("country"));
        addressBookPage.clickSelectRegion();
        addressBookPage.sendKeysSelectCRegion(dataReadProvider.loadRegisterUser().getProperty("region"));
        addressBookPage.clickDefaultAddressYes();
        addressBookPage.clickBotonContinueAddress();
    }




}
