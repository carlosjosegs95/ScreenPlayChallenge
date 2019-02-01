package com.accenture.BancolombiaChallenge.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class SavingsSimulatorForm {
	public static final Target MONTHS_SIMULATOR = Target.the("Pestaña de necesidades").locatedBy("//*[@id=\"browser-Off\"]/div/div/div[1]/form/div[3]/input");
	public static final Target CAR_MOTORCYCLE_NEEDS = Target.the("Necesidades de carro o moto").locatedBy("//*[@id=\"necesidadesPersonas\"]/div/div[1]/div[1]/div/div[7]/div/a");
	public static final Target SIMULATION_SAVINGS_NEEDS = Target.the("Necesidades de carro o moto").locatedBy("//*[@id=\"wizard1\"]/div/div[1]/div/div/div[1]/p[2]/strong/a");
}
