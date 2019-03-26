package FeaturePage;

import org.openqa.selenium.support.PageFactory;

import FeatureElements.EditAccessPointRepo;

public class EditAccessPointPage extends EditAccessPointRepo {

	EditAccessPointRepo editAccessPointRepo;

	public EditAccessPointPage() {
		editAccessPointRepo = PageFactory.initElements(driver, EditAccessPointRepo.class);
	}

	public boolean VerifyNetworkNameinAccessPoint(String networkName) {
		return editAccessPointRepo.verifyNetworkName(networkName);

	}
}
