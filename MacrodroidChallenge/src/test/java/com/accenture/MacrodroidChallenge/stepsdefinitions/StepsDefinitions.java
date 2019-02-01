package com.accenture.MacrodroidChallenge.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

//import static net.serenitybdd.screenplay.EventualConsequence.eventually;
//import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
//import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;

import com.accenture.MacrodroidChallenge.tasks.GoTo;
import com.accenture.MacrodroidChallenge.tasks.SendMessage;
import com.accenture.MacrodroidChallenge.userinterfaces.MacrodroidButtons;

public class StepsDefinitions {
	
	@Managed(driver = "appium")
	private WebDriver hisMobileDevice;
	
	Actor carlos = Actor.named("Carlos");
	
	@Before
	 public void setUp() {
		carlos.can(BrowseTheWeb.with(hisMobileDevice));
    } 

    @Given("^that carlos open the app MACRODroid in his device$")
    public void BancolombiaWebPage() throws Throwable {
    	carlos.wasAbleTo(GoTo.specifyAppOf(MacrodroidButtons.MACRODROID_MACROS_BUTTON));
    }

    @When("^carlos adds five macros$")
    public void FormWithoutFields() throws Throwable {
    	carlos.attemptsTo(GoTo.specifyAppOf(MacrodroidButtons.ADD_MACRO_BUTTON),
    			GoTo.specifyAppOf(MacrodroidButtons.EMPTY_MACRO_BUTTON),
    			SendMessage.on(MacrodroidButtons.FIELD_MACROS_NAME),
    			GoTo.specifyAppOf(MacrodroidButtons.ADD_ACTIVATOR_BUTTON));
    }

    @Then("^carlos waits for the create confirmation$")
    public void CheckWarningsFields() throws Throwable {
    	System.out.println("Se ejecutó el then");
    }

}
