package com.myStore.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.myStore.Utlities.ActionClass;
import com.myStore.Utlities.ExtentReportsNew;
import com.myStore.Utlities.JScript;
import com.myStore.Utlities.MainClass;
import com.myStore.pageObjects.Homepage_Objects;

public class OrderJourneyTest extends MainClass {
	ExtentReports extent;
	ExtentTest test;
	Homepage_Objects HO;
	OrderJourneyTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		intializeBrowser("edge");
		extent=ExtentReportsNew.getInstance();
		HO=new Homepage_Objects();
		test=extent.createTest("Order Journey","To validate Order Journey");		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		extent.flush();
	}
	
	@Test()
	public void orderJourney() {
		
//		if(HO.summerDress.isDisplayed())
//		{
//			JScript.scrollIntoView(driver, HO.summerDress);
//			try {
//				ActionClass.HoverOverNClick(driver, HO.summerDress, HO.addTocart, test);
//				JScript.waitnClick(driver, HO.proceedToCheckout, test);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		
	}
}
