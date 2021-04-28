package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;

public class AccionesWeb  extends PageObject {
	
	public void esperaExplicitaToBeClickable(String localizador) {
		WebDriverWait myWait = new WebDriverWait(getDriver(), 30);
		myWait.until(ExpectedConditions.elementToBeClickable(By.xpath(localizador)));
	
	}
	
	public void esperaExplicitaToBeVisible(String localizador) {
		WebDriverWait myWait = new WebDriverWait(getDriver(), 30);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(localizador)));
	}
	

}
