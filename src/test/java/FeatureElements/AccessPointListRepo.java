package FeatureElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.CommonMethods;

public class AccessPointListRepo extends CommonMethods {

	@FindBy(xpath = "//table[@ng-model='selectedAps']//tbody/tr")
	private WebElement tblAplist;
	
	public void ClickConfigure_Acesspoint(String accessPoint_Name) {
		waitUntilElementisDisplayed(tblAplist);
		int count = driver.findElements(By.xpath("//table[@ng-model='selectedAps']//tbody/tr")).size();
		System.out.println(count);
		for (int j = 1; j <= count; j++) {

			if (accessPoint_Name.equals(driver.findElement(By.xpath("//table[@ng-model='selectedAps']//tbody/tr["+j+"]/td[4]"))
					.getText().trim())) {
				
				driver.findElement(By.xpath("//table[@ng-model='selectedAps']//tbody/tr["+j+"]/td[16]//a[2]")).click();
			}
		}
	}
}
