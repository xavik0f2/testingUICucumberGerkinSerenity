package com.lasalle.automation.vueling.web.pages;

import com.lasalle.automation.vueling.web.domain.ReservationDto;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
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
    private WebElement origin;

    @FindBy(xpath = "//*[@id=\"tab-search\"]/div/form/div[1]/div[2]/div[1]/input")
    private WebElement destination;

    @FindBy(id = "inputGoing")
    private WebElement dates;

    @FindBy (id= "idCookiePolicyCloseOption")
    private WebElement cookies;

    @FindBy (xpath = "//*[@id=\"passengers-input\"]")
    private WebElement passengers;

    @FindBy (xpath= "//*[@id=\"btnSubmitHomeSearcher\"]")
    private WebElement toFind;

    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    public void initializeDriver(){
        driver = getDriver();
        jsExecutor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    public void registerReservation(ReservationDto reservation) {
        LOGGER.debug("registerReservation starts, reservation: [{}]", reservation);
    }


    public void OpenReservationPage() {
        this.open();
        PageFactory.initElements(getDriver(),this);
    }

    public void selectFlight(ReservationDto reservation) {
        this.cookies.click();
        this.origin.click();
        typeInto(this.origin, reservation.getOrigin() +Keys.ENTER);
        typeInto(this.destination, reservation.getDestination() + Keys.ENTER);
        jsExecutor.executeScript("$('#inputGoing').datepicker('setDate', 7);");
        this.dates.sendKeys(Keys.ENTER);
        this.passengers.sendKeys(Keys.ENTER);
    }

}