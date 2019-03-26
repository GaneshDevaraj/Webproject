package FeaturePage;

import org.openqa.selenium.support.PageFactory;

import FeatureElements.AccessPointListRepo;


public class AccessPointListPage extends AccessPointListRepo {

	AccessPointListRepo accesspointlistrepo;

	public AccessPointListPage() {
		accesspointlistrepo = PageFactory.initElements(driver, AccessPointListRepo.class);
	}

	public EditAccessPointPage navigatetoSpecificAP(String accesspointname) {
		accesspointlistrepo.ClickConfigure_Acesspoint(accesspointname);
		return new EditAccessPointPage();
	}

}
