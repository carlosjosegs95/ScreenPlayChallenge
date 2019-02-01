package com.accenture.BancolombiaChallenge.tasks;

import com.accenture.BancolombiaChallenge.userinterfaces.FormPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class Select implements Task{

	private String field;
	
	public Select(String field) {
		this.field = field;
	}
	
	@Override
	@Step("{0} selecciona el campo específico")
	public <T extends Actor> void performAs(T actor) {
		FormPage.setSavingXpathName(field);
		actor.attemptsTo(Click.on(FormPage.SAVING_LIST));
	}

	public static Select theSpecifyField(String field) {
		return Tasks.instrumented(Select.class, field);
	}

}
