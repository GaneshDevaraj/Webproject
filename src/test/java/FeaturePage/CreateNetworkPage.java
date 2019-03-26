package FeaturePage;

import org.openqa.selenium.support.PageFactory;

import FeatureElements.CreateNetworkRepo;

public class CreateNetworkPage extends CreateNetworkRepo {

	CreateNetworkRepo createNetworkRepo;
	
	public CreateNetworkPage() {
		createNetworkRepo=PageFactory.initElements(driver, CreateNetworkRepo.class);
	}
	
	
	public CreateNetworkPage FillNetworkDetails(String networkName, String ssidName, String securityType) {
		createNetworkRepo.EnterNetworkDetails(networkName, ssidName, securityType);
		return this;
	}
	public CreateNetworkPage FillSecurityDetails(String ipAddress, String sharedSecret,String confirmSharedSecret) {
		createNetworkRepo.EnterSecurityDetails(ipAddress, sharedSecret, confirmSharedSecret);
		return this;
	}
	
	public NetworkListPage saveNetwork() {
		createNetworkRepo.clickSave();
		return new NetworkListPage();
	}
	
	public String NetworkNameError() {
		return createNetworkRepo.getTextNetworkNameError();
	}
	
	public String ssIDNameError() {
		return createNetworkRepo.getTextSSIDNameError();
	}
	
	public String ipAddrError() {
		return createNetworkRepo.getTextipAddrError();
	}
	
	public String errorMsgSharedSecret() {
		return createNetworkRepo.getErrorSharedSecret();
	}
	
	public String errorMsgmConfirSharedSecret() {
		return createNetworkRepo.getErrorConfirmSharedSecret();
	}
}
