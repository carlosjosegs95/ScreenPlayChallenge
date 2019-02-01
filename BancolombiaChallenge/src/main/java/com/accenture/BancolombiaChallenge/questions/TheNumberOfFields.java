package com.accenture.BancolombiaChallenge.questions;

import java.util.List;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

public class TheNumberOfFields implements Question<Integer>{
	
	private List<WebElementFacade> list;
	
	public TheNumberOfFields(List<WebElementFacade> list) {
		this.list = list;
	}

	@Override
	@Step("{0} verifica el número de opciones de un campo")
	public Integer answeredBy(Actor actor) {
		return list.size();
	}
	
	public static TheNumberOfFields is(List<WebElementFacade> list) {
		return new TheNumberOfFields(list);
	}

}
