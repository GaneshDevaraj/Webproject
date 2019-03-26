package FeatureTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.LinkedHashMap;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import FeaturePage.CreateNetworkPage;
import FeaturePage.DashboardPage;
import FeaturePage.EditAccessPointPage;
import FeaturePage.LoginPage;
import FeaturePage.NetworkListPage;

public class LoginTest extends LoginPage {

	FeaturePage.LoginPage loginPage;
	DashboardPage dashboardPage;
	NetworkListPage networkListPage;
	LinkedHashMap<String, String> exl;

	@BeforeMethod
	public void beforeTest() {
		loginPage = new LoginPage();
		dashboardPage = new DashboardPage();
	}

	@Test(priority = 0)
	public void login() {
		loginPage.Logging(c_input("username"), c_input("password"));
	}

	@Test(priority = 1)
	public void createNetwork()  {
		 exl = getExcelinputs();			
		 new DashboardPage().NavigatetoNetworkList().AddNetwork()
						.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
							.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
							.saveNetwork();

	
		assertEquals(new NetworkListPage().getToastSave_SuccessMsg(), c_input("netwrksavesucssmsg") + c_input("networkname"));	
		assertTrue(new NetworkListPage().VerifyNetworkName(c_input("networkname")));
	}

	@Test(priority = 2)
	public void networkNameError() {
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
					  .AddNetwork()
						.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
							.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
								.saveNetwork();

		assertEquals(new CreateNetworkPage().NetworkNameError(), c_input("required"));
	}
	
	@Test(priority = 3)
	public void ssidNameError() {
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
		  .AddNetwork()
			.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
				.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
					.saveNetwork();

		assertEquals(new CreateNetworkPage().ssIDNameError(), c_input("required"));
	}
	
	@Test(priority = 4)
	public void blankIpAddrError() {
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
		  .AddNetwork()
			.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
				.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
					.saveNetwork();

		assertEquals(new CreateNetworkPage().ipAddrError(), c_input("required"));
	}
	
	@Test(priority = 5)
	public void ipAddrInvalidError() {
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
		  .AddNetwork()
			.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
				.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
					.saveNetwork();

		assertEquals(new CreateNetworkPage().ipAddrError(), c_input("invalidipaddr"));
	}
	
	@Test(priority = 6)
	 public void sharedSecretError() {
	 
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
					  .AddNetwork()
						.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
							.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
								.saveNetwork();
	 
	 assertEquals(new CreateNetworkPage().errorMsgSharedSecret(), c_input("required"));
	}
	
	@Test(priority = 7)
	 public void confirmsharedSecretError() {
	 
		exl = getExcelinputs();

		new DashboardPage().NavigatetoNetworkList()
					  .AddNetwork()
						.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
							.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd"))
								.saveNetwork();
		
	 assertEquals(new CreateNetworkPage().errorMsgmConfirSharedSecret(), c_input("required"));
	
	 new DashboardPage().NavigatetoNetworkList()
						 .AddNetwork()
							.FillNetworkDetails(exl.get("networkname"), exl.get("ssidname"), exl.get("securitytype"))
								.FillSecurityDetails(exl.get("ipaddress"), exl.get("shrdsecrtpwd"), exl.get("confrmshrdsecrtpwd")+"1")
									.saveNetwork();	
	 assertEquals(new CreateNetworkPage().errorMsgmConfirSharedSecret(), c_input("pwdmismatch"));
	}

	@Test(priority = 8)
	 public void applyNetworktoAP() {		
		exl = getExcelinputs();
	
	 new DashboardPage().NavigatetoNetworkList()
	 				.assignAcessPoint(exl.get("networkname"), exl.get("accesspointname"));
	 
	 assertEquals(new NetworkListPage().getToastAP_ConfigSuccss(), "Configuration push in progress.");
	 
	 }

	@Test(priority = 9)
	public void verifyNetworkNameinAP() {
		exl = getExcelinputs();

		new DashboardPage().NavigatetoAccessPointList().navigatetoSpecificAP(exl.get("accesspointname"));

		assertTrue(new EditAccessPointPage().VerifyNetworkNameinAccessPoint(exl.get("networkname")));
	}
	
	@Test(priority = 10)
	public void deleteNetwork() {
		exl = getExcelinputs();
		
		new DashboardPage().NavigatetoNetworkList().deleteNetwork(exl.get("networkname"));
		assertEquals(new NetworkListPage().getToastDeleteNetworkSuccss(), "Network Delete in progress.");
	}

	@AfterTest
	public void AfterMethod() {
		
		if (driver != null) {
			driver.quit();
		}
	}
}
