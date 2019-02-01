package com.accenture.BancolombiaChallenge.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TheWarning implements Question<String>{

	private Target target;
	
	public TheWarning(Target target) {
		this.target = target;
	}
	
	@Override
	@Step("{0} verifica los textos de los warning")
	public String answeredBy(Actor actor) {
		return Text.of(target).viewedBy(actor).asString();
	}

	public static TheWarning ofField(Target target) {
		return new TheWarning(target);
	}

}
