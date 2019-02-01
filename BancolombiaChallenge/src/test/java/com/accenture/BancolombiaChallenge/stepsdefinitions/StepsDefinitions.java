package com.accenture.BancolombiaChallenge.stepsdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;

import com.accenture.BancolombiaChallenge.tasks.GoTo;
import com.accenture.BancolombiaChallenge.tasks.OpenTheBrowser;
import com.accenture.BancolombiaChallenge.tasks.Select;
import com.accenture.BancolombiaChallenge.tasks.SendMessage;
import com.accenture.BancolombiaChallenge.questions.TheObject;
import com.accenture.BancolombiaChallenge.exceptions.NoMatchingTheCorrectMessage;
import com.accenture.BancolombiaChallenge.interactions.ChangeThe;
import com.accenture.BancolombiaChallenge.questions.TheButton;
import com.accenture.BancolombiaChallenge.questions.TheButtonStatus;
import com.accenture.BancolombiaChallenge.questions.TheField;
import com.accenture.BancolombiaChallenge.questions.TheNumberOfFields;
import com.accenture.BancolombiaChallenge.questions.TheWarning;
import com.accenture.BancolombiaChallenge.userinterfaces.BancolombiaHomePage;
import com.accenture.BancolombiaChallenge.userinterfaces.BancolombiaMainBar;
import com.accenture.BancolombiaChallenge.userinterfaces.BancolombiaPersonsPage;
import com.accenture.BancolombiaChallenge.userinterfaces.FormPage;
import com.accenture.BancolombiaChallenge.userinterfaces.NumberFields;
import com.accenture.BancolombiaChallenge.utils.ExcelReader;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
public class StepsDefinitions {
	
	@Managed(driver = "chrome")
	private WebDriver hisBrowser;
	
	private Actor carlos = Actor.named("Carlos");
	
	private BancolombiaHomePage bancolombiaHomePage;
	private FormPage formPage;
	private NumberFields numberFields;
	
	@Before
	public void setup() {
		carlos.can(BrowseTheWeb.with(hisBrowser));
		hisBrowser.manage().window().maximize();
	}


    @Given("^que carlos ingresa a la pagina de Bancolombia$")
    public void BancolombiaWebPage() throws Throwable {
       carlos.wasAbleTo(
        		OpenTheBrowser.on(bancolombiaHomePage), 
        		GoTo.specifyAppOf(BancolombiaMainBar.BANCOLOMBIA_BAR_PERSONS));
    }

    @When("^carlos no ingresa ningun valor en los campos del formulario$")
    public void FormWithoutFields() throws Throwable {
    	System.out.println("Se ejecutó el when");
    }
    
    @When("^carlos ingresa al campo de ahorro$")
    public void EnterSavingField() throws Throwable {
    	carlos.attemptsTo(GoTo.specifyAppOf(formPage.SAVING_EDIT_TEXT));
    }
    
    @When("^carlos digita el numero (.*) en el edit text de los meses$")
    public void EnterMonthsField(String months) throws Throwable {
    	carlos.attemptsTo(SendMessage.on(months, formPage.MONTHS_EDIT_TEXT));
    }
    
    @When("^carlos ingresa un valor del archivo de excel en el campo del ahorro y (.*) en el campo de los meses$")
    public void EnterSavingAndMonthsFields(String months) throws Throwable {
    	carlos.attemptsTo(
    			Select.theSpecifyField(ExcelReader.getSaving()),
    			SendMessage.on(months, formPage.MONTHS_EDIT_TEXT)
    			);
    }
    
    @When("^carlos escribe el texto (.*) en el edit text del dinero$")
    public void SetTextOnMonthsField(String money) throws Throwable {
    	carlos.attemptsTo(SendMessage.on(money, formPage.MONEY_EDIT_TEXT));
    }

    @Then("^carlos espera ver los mensajes de alerta (.*) en cada uno de los campos$")
    public void CheckWarningsFields(String msg) throws Throwable {
    	carlos.should(eventually(seeThat(TheWarning.ofField(formPage.SAVING_TEXT), containsString(msg))),
    			eventually(seeThat(TheWarning.ofField(formPage.MONTHS_TEXT), containsString(msg))),
    			eventually(seeThat(TheWarning.ofField(formPage.PRODUCT_TEXT), containsString(msg))),
    			eventually(seeThat(TheWarning.ofField(formPage.MONEY_TEXT), containsString(msg))),
    			eventually(seeThat(TheButton.isPresent(formPage.ADD_BUTTON))),
    			eventually(seeThat(TheButtonStatus.isNotEnable(formPage.ADD_BUTTON)))
    			);
    }
    
    @Then("^carlos espera encontrar (.*) opciones diferentes$")
    public void CheckSevenOptions(Integer options) throws Throwable {
    	carlos.should(eventually(seeThat(TheField.withFollowName("Viaje"), containsString("Viaje"))),
    			eventually(seeThat(TheField.withFollowName("Educación"), containsString("Educación"))),
    			eventually(seeThat(TheField.withFollowName("Vivienda"), containsString("Vivienda"))),
    			eventually(seeThat(TheField.withFollowName("Vehículo"), containsString("Vehículo"))),
    			eventually(seeThat(TheField.withFollowName("Entretenimiento"), containsString("Entretenimiento"))),
    			eventually(seeThat(TheField.withFollowName("Retiro"), containsString("Retiro"))),
    			eventually(seeThat(TheField.withFollowName("Otro"), containsString("Otro"))),
    			eventually(seeThat(TheNumberOfFields.is(numberFields.getSavingList()), comparesEqualTo(options)))
    			);
    }
    
    @Then("^carlos espera que el mensaje de warning no este presente$")
    public void CheckWarningMessage() throws Throwable {
    	carlos.should(eventually(seeThat(TheObject.isNotPresent(formPage.MONTHS_TEXT))));
    }
    
    @Then("^carlos espera que en el campo de los productos hayan (.*) opciones$")
    public void CheckThreeOptions(Integer options) throws Throwable {
    	carlos.should(eventually(seeThat(TheNumberOfFields.is(numberFields.getProductsList()), comparesEqualTo(options))));
    }
    
    @Then("^carlos espera el mensaje (.*) en el primer texto y (.*) en el segundo texto$")
    public void CheckMonthsText(String first, String second) throws Throwable {
    	carlos.should(eventually(seeThat(TheWarning.ofField(formPage.MONEY_FIRST_TEXT), containsString(first))
    			.orComplainWith(NoMatchingTheCorrectMessage.class, NoMatchingTheCorrectMessage.getMissingMessage(first))),
    			eventually(seeThat(TheWarning.ofField(formPage.MONEY_SECOND_TEXT), containsString(second))
    					.orComplainWith(NoMatchingTheCorrectMessage.class, NoMatchingTheCorrectMessage.getMissingMessage(second)))
    			);
    }

    @And("^ingresa en el simulador de ahorro e inversion$")
    public void SavingSimulator() throws Throwable {
        carlos.wasAbleTo(
        		GoTo.specifyAppOf(BancolombiaPersonsPage.BANCOLOMBIA_NEEDS),
        		GoTo.specifyAppOf(BancolombiaPersonsPage.CAR_MOTORCYCLE_NEEDS),
        		GoTo.specifyAppOf(BancolombiaPersonsPage.SIMULATION_SAVINGS_NEEDS),
        		ChangeThe.tab(hisBrowser));
    }

}
