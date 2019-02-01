package com.accenture.BancolombiaChallenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TheObject implements Question<Boolean>{
	
	private Target target;
	
	public TheObject(Target target) {
		this.target = target;
	}

	@Override
	@Step("{0} verifica la ausencia de un objeto")
	public Boolean answeredBy(Actor actor) {
		return !CurrentVisibility.of(target).viewedBy(actor).asBoolean();
	}

	public static TheObject isNotPresent(Target target) {
		return new TheObject(target);
	}

}
