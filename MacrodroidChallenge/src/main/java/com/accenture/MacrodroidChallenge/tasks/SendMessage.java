package com.accenture.MacrodroidChallenge.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class SendMessage implements Task{
	
    private Target macrodroidApp;
	
	public SendMessage(Target bancolombiaApp) {
		this.macrodroidApp = bancolombiaApp;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		Enter.theValue("Nueva macro").into(macrodroidApp);
	}

	public static SendMessage on(Target macrodroidApp) {
		return Tasks.instrumented(SendMessage.class, macrodroidApp);
	}

}
