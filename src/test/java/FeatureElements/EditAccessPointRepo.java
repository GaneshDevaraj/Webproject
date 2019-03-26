package FeatureElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonMethods;

public class EditAccessPointRepo extends CommonMethods {

	@FindBy(xpath = "//table[@class='tembo-table layout-margin ng-scope']//tbody/tr")
	private WebElement tblRadioLst;
	
	@FindBy(xpath = "//input[@name='ap_name']")
	private WebElement txtAccessPointName;
	

	public boolean verifyNetworkName(String networkName) {
		boolean flag = false;
		waitUntilElementisDisplayed(txtAccessPointName);
		waitUntilElementisDisplayed(tblRadioLst);
		int count = driver.findElements(By.xpath("//table[@class='tembo-table layout-margin ng-scope']//tbody/tr"))
				.size();
		System.out.println(count);
		int counter = 0;
		for (int j = 1; j <= count; j++) {

			System.out.println(driver
					.findElement(
							By.xpath("//table[@class='tembo-table layout-margin ng-scope']//tbody/tr[" + j + "]/td[7]"))
					.getText().trim());
			if (networkName.equals(driver
					.findElement(
							By.xpath("//table[@class='tembo-table layout-margin ng-scope']//tbody/tr[" + j + "]/td[7]"))
					.getText().trim())) {
				counter = counter + 1;
			}
		}
		if (counter == count) {
			flag = true;
		}
		return flag;
	}
}
