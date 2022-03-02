package com.myStore.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.Utlities.MainClass;

import _Reporting.ExtentReporting;
import _Reporting.MainReporting;

public class CaseTest1 extends MainClass {

	CaseTest1() {
		super();
	}

	@Test(enabled=false)
	@Parameters({ "BrowserName" })
	public void test1(String browser) {
		MainReporting.CreateTest("Test-01");
		intializeBrowser(browser);
		ExtentReporting.log("URL is Launched");
		if (driver.getCurrentUrl().equals("http://automatfeffionpractice.com/index.php")) {
			ExtentReporting.pass("URL is same");
		} else {
			ExtentReporting.fail("URL is not same");
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		ExtentReporting.flush();
	}
}
