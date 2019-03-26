package FeatureElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonMethods;

public class CreateNetworkRepo extends CommonMethods {

	@FindBy(xpath = "//input[@name='networkName']")
	private WebElement EdtNetworkName;

	@FindBy(xpath = "//input[@id='createSSID']")
	private WebElement EdtSSIDName;

	@FindBy(xpath = "//md-select-value[@class='_md-select-value']")
	private WebElement LstSecurityType;

	@FindBy(xpath = "//input[@name='pri_radius_ip']")
	private WebElement edtIPAddress;

	@FindBy(xpath = "//input[@name='wpa2Epsk']")
	private WebElement edtSharedSecret;

	@FindBy(xpath = "//input[@name='wpa2Ecpsk']")
	private WebElement edtConfirmSharedSecret;

	@FindBy(xpath = "//button[@type='button'][5]")
	private WebElement btnRadiusSettings;

	@FindBy(xpath = "//span[contains(text(),'Save')]")
	private WebElement btnSave;
	
	@FindBy(xpath = "//input[@name='networkName']/parent::*//div[@class='md-input-message-animation ng-binding ng-scope']")
	private WebElement txtErrNetworkName;
	
	@FindBy(xpath = "//input[@id='createSSID']/parent::*//div[@class='md-input-message-animation ng-binding ng-scope']")
	private WebElement txtErrSSIDName;
	
	@FindBy(xpath = "//input[@name='pri_radius_ip']/parent::*//div[@class='md-input-message-animation ng-binding ng-scope']")
	private WebElement txtErrIPAddr;
	
	@FindBy(xpath = "//input[@name='wpa2Epsk']/parent::*//div[@class='md-input-message-animation ng-binding ng-scope']")
	private WebElement txtErrSharedSecrtPasswd;
	
	@FindBy(xpath = "//input[@name='wpa2Ecpsk']/parent::*//div[@class='md-input-message-animation ng-binding ng-scope']")
	private WebElement txtErrConfSharedSecrtPasswd;
	
	

	public void EnterNetworkDetails(String networkName, String ssidName, String securityType) {
		waitUntilElementisDisplayed(EdtNetworkName);
		EdtNetworkName.sendKeys(networkName);
		EdtSSIDName.sendKeys(ssidName);
		LstSecurityType.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//md-option[@value='" + securityType + "']")).click();

	}

	public void EnterSecurityDetails(String ipAddress, String sharedSecret, String confirmSharedSecret) {
		edtIPAddress.sendKeys(ipAddress);
		edtSharedSecret.sendKeys(sharedSecret);
		edtConfirmSharedSecret.sendKeys(confirmSharedSecret);
		
	}

	public void clickSave() {
		btnSave.click();
	}
	
	public String getTextNetworkNameError() {
		System.out.println(txtErrNetworkName.getText());
		return txtErrNetworkName.getText().trim();
	}
	
	public String getTextSSIDNameError() {
		System.out.println(txtErrSSIDName.getText());
		return txtErrSSIDName.getText().trim();
	}
	
	public String getTextipAddrError() {
		System.out.println(txtErrIPAddr.getText());
		return txtErrIPAddr.getText().trim();
	}
	
	public String getErrorSharedSecret() {
		System.out.println(txtErrSharedSecrtPasswd.getText());
		return txtErrSharedSecrtPasswd.getText();
	}
	
	public String getErrorConfirmSharedSecret() {
		edtConfirmSharedSecret.sendKeys(Keys.TAB);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(txtErrConfSharedSecrtPasswd.getText());
		return txtErrConfSharedSecrtPasswd.getText();
	}


}
