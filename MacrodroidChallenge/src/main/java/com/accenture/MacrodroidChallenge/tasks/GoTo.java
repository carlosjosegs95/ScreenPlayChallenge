package com.accenture.MacrodroidChallenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class GoTo implements Task{
	
	private Target macrodroidApp;
	
	public GoTo(Target bancolombiaApp) {
		this.macrodroidApp = bancolombiaApp;
	}

	@Override
	@Step("{0} presiona un botón específico")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(macrodroidApp));
	}

	public static GoTo specifyAppOf(Target macrodroidApp) {
		return Tasks.instrumented(GoTo.class, macrodroidApp);
	}

}
