package steps;

import pageObject.MainPageObject;

public class MainSteps {
	
	MainPageObject mainPageObject;
	
	public void iniciarNavegador() {
		mainPageObject.open();
		mainPageObject.getDriver().manage().window().maximize();
		mainPageObject.waitFor(1).seconds();
	}
	
	public void seleccionarOpcionContatUs() {
		mainPageObject.clickContactUs();
		mainPageObject.waitFor(1).seconds();
	}
	
	
	public void diligenciarDatosObligatorios(String subjectHeading, String emailAddress, String menssage) {
		String mail = emailAddress;
		mainPageObject.selectSubjectHeading(subjectHeading);
		mainPageObject.verificoElementoSeleccionado(subjectHeading);
		mainPageObject.verificoMensajeInformativoCorrespondiente(subjectHeading);
		mainPageObject.inputEmail(emailAddress);
		mainPageObject.inputMessage(menssage);
		
	}
	
	public void diligenciarDatosNoObligatorios(String orderReference, String attachFile) {
		mainPageObject.inputOrderReference(orderReference);
		mainPageObject.inputAttachFile(attachFile);
	}
	
	public void verificarRegistroExitoso() {
	
		mainPageObject.clickSend();
		mainPageObject.verificoRegistroExitoso();
	}

}
