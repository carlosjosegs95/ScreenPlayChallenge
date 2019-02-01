package com.accenture.BancolombiaChallenge.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FormPage extends PageObject{
	public static Target SAVING_LIST;
	public Target SAVING_EDIT_TEXT = Target.the("Texto de alerta para los ahorros").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[2]/select");
	public Target SAVING_TEXT = Target.the("Texto de alerta para los ahorros").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[2]/div/div/span");
	public Target MONTHS_EDIT_TEXT = Target.the("Barra de los meses").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[3]/input");
	public Target MONTHS_TEXT = Target.the("Texto alerta para los meses").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[3]/div/div/span[1]");
	public Target PRODUCT_EDIT_TEXT = Target.the("Barra del producto").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[4]/select");
	public Target PRODUCT_TEXT = Target.the("Texto de alerta para el producto").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[4]/div/div/span");
	public Target MONEY_EDIT_TEXT = Target.the("Barra del dinero").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[5]/input");
	public Target MONEY_FIRST_TEXT = Target.the("Barra del dinero").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[5]/div/div/span[3]");
	public Target MONEY_SECOND_TEXT = Target.the("Barra del dinero").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[5]/div/div/span[4]");
	public Target MONEY_TEXT = Target.the("Texto de alerta para el dinero").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[5]/div/div/span[1]");
	public Target ADD_BUTTON = Target.the("Boton de agregar").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[8]/button");
	
	public static void setSavingXpathName(String name) {
		FormPage.SAVING_LIST = Target.the("Lista de ahorros").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[2]/select//option[contains(text(), '"+name+"')]");
	}
}
