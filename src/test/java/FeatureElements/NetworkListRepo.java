package FeatureElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class NetworkListRepo extends CommonMethods {

	@FindBy(xpath = "//ng-md-icon[@icon='add']")
	private WebElement btnAddNetwork;

	@FindBy(xpath = "//tbody[@class='md-body']")
	private WebElement tblRowCount;

	@FindBy(xpath = "//md-toast/div/span/b")
	private WebElement txtToastSuccss_Save;

	@FindBy(xpath = "//span[contains(text(),'Apply To APs')]")
	private WebElement btnApplyAP;

	@FindBy(xpath = "//table[@ng-model='selectedAps']//tbody/tr")
	private WebElement tblAplist;

	@FindBy(xpath = "//ng-md-icon[@icon='done']")
	private WebElement icnAPAssignDone;

	@FindBy(xpath = "//span[@class='md-toast-text info flex']")
	private WebElement txtToastAP_Config;
	
	@FindBy(xpath = "//button[@aria-label='Remove From All APs']")
	private WebElement btnRemoveAllAp;
	
	@FindBy(xpath = "//button[@aria-label='Delete Networks']")
	private WebElement btnDeleteNetworks;
	
	@FindBy(xpath = "//button/span[contains(text(),'Yes')]")
	private WebElement btnConfirmYes;
	
	@FindBy(xpath = "//body[@id='wms-body']/md-toast/div/span/b")
	private WebElement txtToastDeleteNetwork;
	

	public void clickAddNetwork() {
		btnAddNetwork.click();
	}

	public int GetRowCount() {
		waitUntilElementisDisplayed(tblRowCount);
		return Integer.valueOf(driver.findElements(By.xpath("//tbody[@class='md-body']/tr")).size());
	}

	public boolean VerifyNetworkName(String networkName) {
		boolean flag = false;

		for (int i = 1; i <= GetRowCount(); i++) {

			System.out.println(driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[2]/a/span"))
					.getText().trim());
			if (networkName.equals(driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[2]/a/span"))
					.getText().trim())) {
				flag = true;
			}
		}
		return flag;

	}

	public String getTostMsg() {
		waitUntilElementisDisplayed(txtToastSuccss_Save);
		return txtToastSuccss_Save.getText();
	}

	public boolean applyAcessPoint(String networkName, String accessPoint) {
		boolean flag = false;

		for (int i = 1; i <= GetRowCount(); i++) {

			if (networkName.equals(driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[2]/a/span"))
					.getText().trim())) {
				driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[1]")).click();
			}
		}
		btnApplyAP.click();
		waitUntilElementisDisplayed(tblAplist);
		int count = driver.findElements(By.xpath("//table[@ng-model='selectedAps']//tbody/tr")).size();
		System.out.println(count);
		for (int j = 1; j <= count; j++) {

			if (accessPoint
					.equals(driver.findElement(By.xpath("//table[@ng-model='selectedAps']//tbody/tr[" + j + "]/td[4]"))
							.getText().trim())) {
				driver.findElement(By.xpath("//table[@ng-model='selectedAps']//tbody/tr[7]/td[1]/md-checkbox")).click();
			}
		}
		icnAPAssignDone.click();
		return flag;

	}

	public String getTostMsg_APConfig() {
		waitUntilElementisDisplayed(txtToastAP_Config);
		return txtToastAP_Config.getText();
	}

	public void selectNetworkName(String networkName) {

		for (int i = 1; i <= GetRowCount(); i++) {

			System.out.println(driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[2]/a/span"))
					.getText().trim());
			if (networkName.equals(driver.findElement(By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[2]/a/span"))
					.getText().trim())) {
				if (driver.findElement(By
								.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[1]/md-checkbox[@role='checkbox']"))
									.getAttribute("aria-checked").equals("false")) {
					driver.findElement(
							By.xpath("//tbody[@class='md-body']/tr[" + i + "]//td[1]")).click();
				}

			}
		}
	}

	public void clickRemoveAccessPoints() {
		btnRemoveAllAp.click();
		waitUntilElementisDisplayed(btnConfirmYes);
		btnConfirmYes.click();
		waitUntilElementDisAppear(txtToastSuccss_Save);

	}
	public void clickDeleteNetworks() {
		btnDeleteNetworks.click();
		waitUntilElementisDisplayed(btnConfirmYes);
		btnConfirmYes.click();

	}
	
	public String getDeleteNetworkMsg() {
		waitUntilElementisDisplayed(txtToastDeleteNetwork);
		return txtToastDeleteNetwork.getText();
	}

}
