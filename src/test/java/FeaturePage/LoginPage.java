package FeaturePage;

import org.openqa.selenium.support.PageFactory;
import FeatureElements.LoginRepo;

public class LoginPage extends LoginRepo {

	LoginRepo loginRepo;

	public LoginPage() {
		loginRepo = PageFactory.initElements(driver, LoginRepo.class);
	}

	public DashboardPage Logging(String userName, String password) {
		loginRepo.Login(userName, password);
		return new DashboardPage();
	}

}
