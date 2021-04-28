package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.MainSteps;

public class MainDefinitions {
	
	@Steps
	MainSteps mainSteps;
	
	@Given("^Ingresar a la pagina web$")
	public void ingresarALaPaginaWeb() {
	   mainSteps.iniciarNavegador();
	}

	@When("^seleccionar contact us$")
	public void seleccionarContactUs() {
	    mainSteps.seleccionarOpcionContatUs();
	}
	
	
	@When("^realizar registro completo \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void realizarRegistroCompleto(String subjectHeading, String emailAddress, String orderReference,
			String attachFile, String menssage) {
		mainSteps.diligenciarDatosObligatorios(subjectHeading, emailAddress, menssage);
		mainSteps.diligenciarDatosNoObligatorios(orderReference, attachFile);
	}

	@Then("^verificar registro exitoso$")
	public void verificarRegistroExitoso() {
		mainSteps.verificarRegistroExitoso();
	}
	
}
