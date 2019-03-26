package utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class CommonMethods extends BaseDriver {
	public void selectDropDown(WebElement elementName, String option) {
		Select Elements = new Select(elementName);
		Elements.selectByVisibleText(option);
	}

	public void waitUntilElementisDisplayed(WebElement webElement) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 25);
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			System.out.println("Element is not displayed");
		}

	}

	public void waitUntilElementDisAppear(WebElement webElement) {
		try {
			 new WebDriverWait(driver, 25).until(ExpectedConditions.invisibilityOf(webElement));
		} catch (Exception e) {
			System.out.println("Element is not displayed");
		}

	}

	public void waitUntilXpathisDisplayed(String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void scrolltoElement(WebElement webElement) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", webElement);
	}

	public void scrolltoElement() {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("window.scrollBy(0,700)");
	}

}
