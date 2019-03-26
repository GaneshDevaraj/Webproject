package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Listener implements ITestListener, ISuiteListener {
	protected static WebDriver driver;
	protected static ExtentReports reports;
	protected static ExtentTest test;
	public static String folder = System.getProperty("user.dir") + "\\src\\test\\resources\\reports\\";
	public static String path = folder + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date());
	public static String browservalue;
	
	public void onStart(ISuite arg0) {
		File newFolder = new File(path);
		newFolder.mkdir();
		System.out.println("on start");
		reports = new ExtentReports(
				path + "\\" + new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		
		//reports.addSystemInfo("browserName", "firefox");
	}
	


	public void onFinish(ITestContext arg0) {
		// Do Nothing

	}

	public void onStart(ITestContext arg0) {
		// Do Nothing

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("on test failure");
		test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test  Failed");
		TakesScreenshot ts = (TakesScreenshot) BaseDriver.driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(path + "\\" + result.getMethod().getMethodName() + ".png"));
			String file = test.addScreenCapture(path + "\\" + result.getMethod().getMethodName() + ".png");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is Failed", file);
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " Test is Failed",
					result.getThrowable().getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skipped");
		test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " Test got Skipped");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("on test start");
		test = reports.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {

		test.log(LogStatus.PASS, result.getMethod().getMethodName() + " Test has Passed");

	}

	public void onFinish(ISuite arg0) {
		System.out.println("on finish");
		reports.endTest(test);
		reports.flush();
		

	}

}