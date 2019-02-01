package com.accenture.BancolombiaChallenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.CurrentlyEnabled;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TheButtonStatus implements Question<Boolean>{

    private Target target;
	
	public TheButtonStatus(Target target) {
		this.target = target;
	}
	
	@Override
	@Step("{0} verifica si el botón no está habilitado")
	public Boolean answeredBy(Actor actor) {
		return !(CurrentlyEnabled.of(target).viewedBy(actor).asBoolean());
	}
	
	public static TheButtonStatus isNotEnable(Target target) {
		return new TheButtonStatus(target);
	}

}
