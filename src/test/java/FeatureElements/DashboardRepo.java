package FeatureElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonMethods;

public class DashboardRepo extends CommonMethods {

	@FindBy(xpath = "//label[contains(text(),'Dashboard')]")
	private WebElement txtDashboard;

	@FindBy(xpath = "//sm-nav-menu//ng-md-icon[@class='ng-scope']")
	private WebElement icnHmgMenu;

	@FindBy(xpath = "//a[@id='networkBtnMINI']/ng-md-icon")
	private WebElement icnWirelessNetworks;

	//xpath=//a[@id='apBtnMINI']/ng-md-icon
	@FindBy(xpath = "//a[@id='apBtnMINI']/ng-md-icon")
	private WebElement icnAccessPoints;

	public void clickWirelessNetworks() {
		waitUntilElementisDisplayed(icnWirelessNetworks);
		icnWirelessNetworks.click();
	}
	
	public void clickAccessPoints() {
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		waitUntilElementisDisplayed(icnAccessPoints);
		icnAccessPoints.click();
	}

}
