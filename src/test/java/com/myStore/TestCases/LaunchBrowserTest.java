package com.myStore.TestCases;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.myStore.Utlities.MainClass;

import _Reporting.ExtentReporting;
import _Reporting.MainReporting;

public class LaunchBrowserTest extends MainClass {
	 /*
	  * 
	  * Added  optional properties 
	  */
	//WebDriver driver;
	@Parameters({"testName","BrowserName"})
	@Test
	public void Validate(@Optional("defaultTest")String testName,@Optional("firefox")String browser) throws InterruptedException {
		System.out.println(testName+"  "+browser);	
		MainReporting.CreateTest(testName);
		intializeBrowser(browser);
		Thread.sleep(4000);
//		Actions action=new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'http://automationpractice.com/img/p/7/7-home_default.jpg')]"))).perform();
//		//WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]"";
//		WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button ajax_add_to_cart_button btn btn-default'  and  contains(@data-id-product,'2')]/descendant::span[text()='Add to cart']")));
//		element.click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//a[@class='btn btn-default button button-medium']/span")).click();
//		Thread.sleep(2000);
//		ActionClass.scrollPage();
//		WebElement element1 = driver.findElement(By.xpath("//span[@id='total_price']"));
//		
//		System.out.println(element1.getText());
//		Thread.sleep(1000);
		System.out.println("Test Completed");
		driver.quit();
		ExtentReporting.log("test case is  completed");
		ExtentReporting.flush();
	}
}