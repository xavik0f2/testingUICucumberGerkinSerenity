package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.domain.ReservationDto;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DefaultUrl("https://www.vueling.com/es/")
public class ReservationPage extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//*[@id=\"tab-search\"]/div/form/div[1]/div[1]/div[1]/input")
    private WebElement txbOrigin;

    @FindBy(xpath = "//*[@id=\"tab-search\"]/div/form/div[1]/div[2]/div[1]/input")
    private WebElement txbDestination;

    @FindBy(id = "inputGoing")
    private WebElement datePicker;

    @FindBy (id= "idCookiePolicyCloseOption")
    private WebElement btnCloseCookies;

    @FindBy (xpath = "//*[@id=\"passengers-input\"]")
    private WebElement btnPassenger;

    @FindBy (xpath= "//*[@id=\"btnSubmitHomeSearcher\"]")
    private WebElement btnFind;

    @FindBy (xpath = "//*[@id=\"passengers-popup\"]")
    private WebElement popupPassangers;

    @FindBy (xpath = "//*[@id=\"tab-search\"]")
    private WebElement tabDates;

    @FindBy ( xpath = "//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody")
    private WebElement tbodyCalendar;

    private WebDriver driver;

    public void initializeDriver(){
        driver = getDriver();
        driver.manage().window().maximize();
    }

    public void OpenReservationPage() {
        this.open();
        PageFactory.initElements(getDriver(),this);
    }

    public void setReservation(ReservationDto reservation) {
        this.btnCloseCookies.click();
        this.txbOrigin.click();
        typeInto(this.txbOrigin, reservation.getOrigin() +Keys.ENTER);
        typeInto(this.txbDestination, reservation.getDestination() + Keys.ENTER);

        waitFor(tabDates);
        evaluateJavascript("$('#inputGoing').datepicker('setDate', 7);");
        waitFor(tbodyCalendar);
        evaluateJavascript("$('#inputGoing').datepicker('setDate', 7);");

        this.datePicker.sendKeys(Keys.ENTER);
        waitFor(popupPassangers);
        this.btnPassenger.sendKeys(Keys.TAB);
    }
    public void getFlights(){
        this.btnFind.click();
    }

}