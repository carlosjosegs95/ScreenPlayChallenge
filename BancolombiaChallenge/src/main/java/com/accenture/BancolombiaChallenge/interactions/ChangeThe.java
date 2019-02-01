package com.accenture.BancolombiaChallenge.interactions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class ChangeThe implements Interaction{
	
	private  WebDriver browser;
	
	public ChangeThe(WebDriver browser) {
        this.browser = browser;
    }      

	@Override
	@Step("{0} cambia de pestaña en el navegador")
	public <T extends Actor> void performAs(T actor) {
		String parent = browser.getWindowHandle();   // It will return the parent window name as a String
        Set<String>s1 = browser.getWindowHandles();  // This will return the number of windows opened by Webdriver and will return Set of St//rings
        Iterator<String> I1 = s1.iterator();         // Now we will iterate using Iterator
        
        while(I1.hasNext()) {
           String child_window = I1.next();
        
	       if(!parent.equals(child_window)) {
	           browser.switchTo().window(child_window);
	           System.out.println(browser.switchTo().window(child_window).getTitle());
	       }
        
        }

	}
	
	public static ChangeThe tab(WebDriver browser) {
		return Tasks.instrumented(ChangeThe.class, browser);
	}
}
