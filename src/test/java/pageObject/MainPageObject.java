package pageObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import utils.AccionesWeb;


@DefaultUrl("http://automationpractice.com/index.php")
public class MainPageObject extends PageObject {
	
	private String btnContactUs = "//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	
	private String selectSubjectHeading = "//select[@id='id_contact']";
	private String textSelectedHEading = "//span[contains(text(),'#')]";
	private String labelInformativo = "//select[@id='id_contact']/following::p[*]";
	private String inputEmail = "//input[@id='email']";
	private String inputOrden = "//input[@id='id_order']";
	private String inputChooseFile = "//input[@id='fileUpload']";
	private String inputMessage = "//textarea[@id='message']";
	private String btnSent = "//button[@id='submitMessage']";
	private String labelRegistroOk = "//p[@class='alert alert-success']";
	

	
	
	AccionesWeb accionesWeb;
	
	public void clickContactUs() {
		accionesWeb.esperaExplicitaToBeClickable(btnContactUs);
		element(By.xpath(btnContactUs)).click();
	}
	
	
	public void selectSubjectHeading(String subjectHeading) {
		Select selectSubjectHeading = new Select(getDriver().findElement(By.xpath(this.selectSubjectHeading)));
		selectSubjectHeading.selectByVisibleText(subjectHeading);
	}
	
	public void verificoElementoSeleccionado(String subjectHeading) {
		textSelectedHEading = this.textSelectedHEading.replace("#", subjectHeading);
		waitFor(1).second();
		assertTrue(element(By.xpath(textSelectedHEading)).isVisible());
	}
	
	public void verificoMensajeInformativoCorrespondiente(String subjectHeading){
		String texto = "";
		try {
			for (int i = 1; i < 4; i++) {
				if (element(By.xpath(labelInformativo.replace("*", i+""))).isVisible()) {
					texto = element(By.xpath(labelInformativo.replace("*", i+""))).getText();
					System.out.println(texto);
				}			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		assertEquals(textoEsperadoSegunSeleccion(subjectHeading), texto);
	}
	
	public String textoEsperadoSegunSeleccion(String seleccion) {
		if (seleccion.contains("Customer service")) 
			return "For any question about a product, an order";
		else if (seleccion.contains("Webmaster")) 
			return "If a technical problem occurs on this website";
		else
			return "";
	}
	
	
	
	
	
	public void inputEmail(String emailAddress) {
		accionesWeb.esperaExplicitaToBeClickable(inputEmail);
		element(By.xpath(inputEmail)).sendKeys(emailAddress);
	}
	
	public void inputMessage(String message) {
		accionesWeb.esperaExplicitaToBeClickable(inputMessage);
		element(By.xpath(inputMessage)).sendKeys(message);
	}
	
	public void inputOrderReference(String orderReference) {
		accionesWeb.esperaExplicitaToBeClickable(inputOrden);
		element(By.xpath(inputOrden)).sendKeys(orderReference);
	}

	public void inputAttachFile(String attachFile) {
		waitFor(1).second();
		element(By.xpath(inputChooseFile)).sendKeys(attachFile);
	}
	
	public void clickSend() {
		accionesWeb.esperaExplicitaToBeClickable(btnSent);
		element(By.xpath(btnSent)).click();
	}
	
	public void verificoRegistroExitoso() {
		accionesWeb.esperaExplicitaToBeVisible(labelRegistroOk);
		assertTrue(element(By.xpath(labelRegistroOk)).isVisible());
		waitFor(2).seconds();
	}
	
	
	
}
