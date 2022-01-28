package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ProductAppleCinemaPage extends BasePage {

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
    private String listRadioBtn = "//input[@name='option[218]' and @value='7']";
    private String chkBox2 = "//input[@name='option[223][]' and @value='9']";
    private String chkBox4 = "//input[@name='option[223][]' and @value='11']";
    private String txtBox = "//input[@name='option[208]' and @value='test']";
    private String selectCinema = "//select[@name='option[217]' and @id='input-option217']";
    private String txtAreaCinema = "//textarea[@name='option[209]' and @id='input-option209']";
    private String messageSuccess = "//h1[contains(text(),'Your order has been placed!')]";

    public ProductAppleCinemaPage() {
        super(driver);
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

    public Boolean messageBuyOk(){
        Boolean condition = false;
        if (elementIsDisplayed(messageSuccess)) {
            condition = true;
        }
        return condition;
    }
}
