package FeaturePage;

import org.openqa.selenium.support.PageFactory;

import FeatureElements.NetworkListRepo;

public class NetworkListPage extends NetworkListRepo {

	NetworkListRepo networkListRepo;

	public NetworkListPage() {
		networkListRepo = PageFactory.initElements(driver, NetworkListRepo.class);
	}

	public CreateNetworkPage AddNetwork() {
		networkListRepo.clickAddNetwork();
		return new CreateNetworkPage();
	}

	public int GetNetworkRecords() {

		return networkListRepo.GetRowCount();
	}

	public boolean VerifyNetworkName(String networkName) {
		return networkListRepo.VerifyNetworkName(networkName);
	}

	public String getToastSave_SuccessMsg() {
		return networkListRepo.getTostMsg();
	}

	public void assignAcessPoint(String networkName, String accessPoint) {
		networkListRepo.applyAcessPoint(networkName, accessPoint);
	}

	public String getToastAP_ConfigSuccss() {
		return networkListRepo.getTostMsg_APConfig();
	}
	
	public NetworkListPage deleteNetwork(String networkname) {
		networkListRepo.selectNetworkName(networkname);
		networkListRepo.clickRemoveAccessPoints();
		networkListRepo.selectNetworkName(networkname);
		networkListRepo.clickDeleteNetworks();
		
		return new NetworkListPage();
	}
	
	public String getToastDeleteNetworkSuccss() {
		return networkListRepo.getDeleteNetworkMsg();
	}
}
