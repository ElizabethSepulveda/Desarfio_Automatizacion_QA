package cl.test.po;

import cl.test.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

    @FindBy (xpath = "//h1[contains(text(),'Account')]")
    private WebElement tituloAccount;

    @FindBy (xpath = "//legend[contains(text(),'Your Personal Details')]")
    private WebElement tituloFormulario;

    @FindBy (xpath = "//legend[contains(text(),'Your Password')]")
    private WebElement tituloSeccionPassword;

    @FindBy (xpath = "//legend[contains(text(),'Newsletter')]")
    private WebElement tituloSeccionNewsletter;

    @FindBy (xpath = "//label[contains(text(),'First Name')]/..//input[@id='input-firstname']")
    private WebElement inputFirstName;

    @FindBy (xpath = "//label[contains(text(),'Last Name')]/..//input[@id='input-lastname']")
    private WebElement inputLastName;

    @FindBy (xpath = "//label[contains(text(),'E-Mail')]/..//input[@id='input-email']")
    private WebElement inputEmail;

    @FindBy (xpath = "//label[contains(text(),'Telephone')]/..//input[@id='input-telephone']")
    private WebElement inputTelephone;

    @FindBy (id = "input-password")
    private WebElement inputPassword;

    @FindBy (id = "input-confirm")
    private WebElement inputConfirmPassword;

    @FindBy (xpath = "//div[@id='account-register']/..//label[contains(text(),'Subscribe')]/..//label[1]/input")
    private WebElement radioBotonYesSubscribe;

    @FindBy (xpath = "//div[@id='account-register']/..//label[contains(text(),'Subscribe')]/..//label[2]/input")
    private WebElement radioBotonNoSubscribe;

    @FindBy (xpath = "//div[@id='account-register']/..//input[@name='agree']")
    private WebElement checkBotonPrivacyPolicy;

    @FindBy (xpath = "//div[@id='account-register']/..//input[@type='submit' and @value='Continue']")
    private WebElement botonContinue;

    @FindBy (xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
    private WebElement labelRegisterAccount;

    @FindBy (xpath = "//a[contains(text(),'Continue')]")
    private WebElement botonContinueSuccess;

    @FindBy (xpath = "//h2[contains(text(),'My Account')]")
    private WebElement labelTituloAccount;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean isVisibleTituloAccount() {
        isVisible(tituloAccount);
        return tituloAccount.isEnabled();

    }

    public boolean isVisibleTituloFormulario() {
        isVisible(tituloFormulario);
        return tituloFormulario.isEnabled();
    }

    public boolean isVisibleTituloSeccionPassword() {
        isVisible(tituloSeccionPassword);
        return tituloSeccionPassword.isEnabled();
    }

    public boolean isVisibleTituloSeccionNewsletter() {
        isVisible(tituloSeccionNewsletter);
        return tituloSeccionNewsletter.isEnabled();
    }

    public boolean isVisibleLabelRegisterAccount() {
        isVisible(labelRegisterAccount);
        return labelRegisterAccount.isEnabled();
    }

    public boolean isVisibleLabelTituloAccount() {
        isVisible(labelTituloAccount);
        return labelTituloAccount.isEnabled();
    }

    public void sendKeysInputFirstName(String firstName) {
        isVisible(inputFirstName);
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
    }

    public void sendKeysInputLastName(String lastName) {
        isVisible(inputLastName);
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
    }

    public void sendKeysInputEmail(String email) {
        isVisible(inputEmail);
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    public void sendKeysInputTelephone(String phone) {
        isVisible(inputTelephone);
        inputTelephone.clear();
        inputTelephone.sendKeys(phone);
    }

    public void sendKeysInputPassword(String pwd) {
        isVisible(inputPassword);
        inputPassword.clear();
        inputPassword.sendKeys(pwd);
    }

    public void sendKeysInputConfirmPassword(String confirmPwd) {
        isVisible(inputConfirmPassword);
        inputConfirmPassword.clear();
        inputConfirmPassword.sendKeys(confirmPwd);
    }

    public void clickRadioBotonYesSubscribe() {
        isVisible(radioBotonYesSubscribe);
        radioBotonYesSubscribe.click();
    }

    public void clickRadioBotonNoSubscribe() {
        isVisible(radioBotonNoSubscribe);
        radioBotonNoSubscribe.click();
    }

    public void clickCheckBotonPrivacyPolicy() {
        isVisible(checkBotonPrivacyPolicy);
        checkBotonPrivacyPolicy.click();
    }

    public void clickBotonContinue() {
        isVisible(botonContinue);
        botonContinue.click();
    }

    public void clickBotonContinueSuccess() {
        isVisible(botonContinueSuccess);
        botonContinueSuccess.click();
    }


}
