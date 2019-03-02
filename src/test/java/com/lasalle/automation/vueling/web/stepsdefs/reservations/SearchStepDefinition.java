package com.lasalle.automation.vueling.web.stepsdefs.reservations;

import com.lasalle.automation.vueling.web.pages.ReservationPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lasalle.automation.vueling.web.domain.ReservationDto;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class SearchStepDefinition {
    public static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private ReservationPage reservationPage;

    private List<ReservationDto> reservations;

    @Before
    public void beforeScenario() {
        LOGGER.debug("beforeScenario starts");

        reservationPage.initializeDriver();
    }

    @After
    public void afterScenario() {
        LOGGER.debug("afterScenario() starts");

        reservationPage.getDriver().close();
    }


    @Given("^I'm main page$")
    public void iMMainPage() throws Throwable {
        LOGGER.debug("iMMainPage() starts");
        reservationPage.OpenReservationPage();

    }

    @When("^I try to find a fly$")
    public void iTryToFindAFly(List<ReservationDto> reservationsList) throws Throwable {
        LOGGER.debug("iTryToFindAFly() starts, list size:[{}]", reservationsList.size());

        reservations = reservationsList;
        reservations.forEach(resevation->reservationPage.setReservation(resevation));

    }

    @Then("^I get available flight$")
    public void iGetAvailableFlight() {
        LOGGER.debug("iGetAvailableFlight() starts");
        reservationPage.getFlights();

    }

}
