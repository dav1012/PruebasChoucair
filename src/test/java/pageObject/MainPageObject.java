package pageObject;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import utils.AccionesWeb;


@DefaultUrl("http://automationpractice.com/index.php")
public class MainPageObject extends PageObject {
	
	private String btnContactUs = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	
	AccionesWeb accionesWeb;
	
	public void clickContactUs() {
		accionesWeb.esperaExplicitaToBeClickable(btnContactUs);
		element(By.xpath(btnContactUs)).click();
	}
}
