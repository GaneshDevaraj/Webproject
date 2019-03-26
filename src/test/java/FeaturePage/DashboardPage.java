package FeaturePage;

import org.openqa.selenium.support.PageFactory;

import FeatureElements.DashboardRepo;

public class DashboardPage extends DashboardRepo {

	DashboardRepo dashboardRepo;

	public DashboardPage() {
		dashboardRepo = PageFactory.initElements(driver, DashboardRepo.class);
	}

	public NetworkListPage NavigatetoNetworkList() {
		dashboardRepo.clickWirelessNetworks();
		return new NetworkListPage();
	}

	public AccessPointListPage NavigatetoAccessPointList() {
		dashboardRepo.clickAccessPoints();
		return new AccessPointListPage();
	}
	
	


}
