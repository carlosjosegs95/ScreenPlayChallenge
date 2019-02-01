package com.accenture.MacrodroidChallenge.userinterfaces;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class MacrodroidButtons {
	public static final Target MACRODROID_MACROS_BUTTON = Target.the("Botón de macros").located(By.id("com.arlosoft.macrodroid:id/macroListButton"));
	public static final Target ADD_MACRO_BUTTON = Target.the("Botón de macros").located(By.id("com.arlosoft.macrodroid:id/macro_list_add_button"));
	public static final Target EMPTY_MACRO_BUTTON = Target.the("Botón de macros").located(By.id("com.arlosoft.macrodroid:id/dialog_wizard_mode_empty_macro_button"));
	public static final Target FIELD_MACROS_NAME = Target.the("Botón de macros").located(By.id("com.arlosoft.macrodroid:id/macroName"));
	public static final Target ADD_ACTIVATOR_BUTTON = Target.the("Botón de macros").located(By.id("com.arlosoft.macrodroid:id/edit_macro_addTriggerButton"));
}
