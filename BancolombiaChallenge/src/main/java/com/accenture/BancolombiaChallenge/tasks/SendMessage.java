package com.accenture.BancolombiaChallenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class SendMessage implements Task{
	
	private String months;
	private Target target;
	
	public SendMessage(String months, Target target) {
		this.months = months;
		this.target = target;
	}

	@Override
	@Step("{0} escribe un mensaje en el campo específico")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Enter.theValue(months).into(target));
	}

	public static SendMessage on(String months, Target target) {
		return Tasks.instrumented(SendMessage.class, months, target);
	}

}
