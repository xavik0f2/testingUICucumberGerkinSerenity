package com.lasalle.automation.vueling.web.tests.reservations;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/search",
        glue = "com.lasalle.automation.vueling.web.stepsdefs.reservations")
public class SearchTest {
}
