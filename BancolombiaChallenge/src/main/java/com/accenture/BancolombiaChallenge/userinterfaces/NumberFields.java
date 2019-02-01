package com.accenture.BancolombiaChallenge.userinterfaces;

import java.util.List;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class NumberFields extends PageObject{
	
	public List<WebElementFacade> getSavingList() {
		List<WebElementFacade> list = findAll(By.xpath("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[2]/select/option[@value]"));
		return list;
	}
	
	public List<WebElementFacade> getProductsList() {
		List<WebElementFacade> list = findAll(By.xpath("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[4]/select/option[@value]"));
		return list;
	}

}
