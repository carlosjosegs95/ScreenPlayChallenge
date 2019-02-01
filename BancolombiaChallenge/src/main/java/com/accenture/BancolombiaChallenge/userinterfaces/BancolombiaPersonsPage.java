package com.accenture.BancolombiaChallenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class BancolombiaPersonsPage {
	public static final Target BANCOLOMBIA_NEEDS = Target.the("Pestaña de necesidades").locatedBy("//*[@id=\"main-menu\"]/div[2]/ul[1]/li[2]/a");
	public static final Target CAR_MOTORCYCLE_NEEDS = Target.the("Necesidades de carro o moto").locatedBy("//*[@id=\"necesidadesPersonas\"]/div/div[1]/div[1]/div/div[7]/div/a");
	public static final Target SIMULATION_SAVINGS_NEEDS = Target.the("Simula tus ahorros").locatedBy("//*[@id=\"wizard1\"]/div/div[1]/div/div/div[1]/p[2]/strong/a");
}
