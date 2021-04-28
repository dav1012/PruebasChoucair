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
		mainPageObject.waitFor(30).seconds();
	}

}
