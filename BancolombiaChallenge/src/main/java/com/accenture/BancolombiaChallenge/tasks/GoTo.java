package com.accenture.BancolombiaChallenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task{
	
	private Target bancolombiaApp;
	
	public GoTo(Target bancolombiaApp) {
		this.bancolombiaApp = bancolombiaApp;
	}

	@Override
	@Step("{0} presiona un botón específico")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(bancolombiaApp));
	}

	public static GoTo specifyAppOf(Target bancolombiaApp) {
		return Tasks.instrumented(GoTo.class, bancolombiaApp);
	}

}
