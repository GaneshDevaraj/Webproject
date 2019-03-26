package FeatureElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.CommonMethods;

public class LoginRepo extends CommonMethods {

	@FindBy(xpath = "//input[@name='email']")
	private WebElement edtUserName;

	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement edtPassword;

	@FindBy(xpath = "//button[@id='loginFormSubmit']")
	private WebElement btnLogin;
	
	
	public void Login(String userName, String password) {
		waitUntilElementisDisplayed(edtUserName);
		edtUserName.sendKeys(userName);
		edtPassword.sendKeys(password);
		btnLogin.click();
	}
}
