package com.accenture.BancolombiaChallenge.questions;

import com.accenture.BancolombiaChallenge.userinterfaces.FormPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.thucydides.core.annotations.Step;

public class TheField implements Question<String>{
	
    private String name;
	
	public TheField(String name) {
		this.name = name;
	}
	
	@Override
	@Step("{0} verifica las opciones del campo de ahorro")
	public String answeredBy(Actor actor) {
		FormPage.setSavingXpathName(name);
		return Text.of(FormPage.SAVING_LIST).viewedBy(actor).asString();
	}

	public static TheField withFollowName(String name) {
		return new TheField(name);
	}

}
