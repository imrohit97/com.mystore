package com.myStore.TestCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.Utlities.MainClass;

import _Reporting.ExtentReporting;
import _Reporting.MainReporting;

public class CaseTest2 extends MainClass {
	
	CaseTest2() {
		super();
	}
	
	@Test(enabled=true)
	@Parameters({"BrowserName"})
	public void test1(String browser) throws InterruptedException {
		MainReporting.CreateTest("Test-02");
		intializeBrowser(browser);
		ExtentReporting.log("URL is Launched");	
		if(driver.getCurrentUrl().equals("http://automationpractice.com/index.php")) {
			ExtentReporting.pass("URL is same");
		}
		driver.quit();
		ExtentReporting.flush();
	}
}
