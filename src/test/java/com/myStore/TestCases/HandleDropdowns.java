package com.myStore.TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import _Reporting.ExtentReporting;
import _Reporting.MainReporting;

public class HandleDropdowns {
	WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		String projectPath = System.getProperty("user.dir");
		MainReporting.CreateTest("ManageDropdowns");
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/main/java/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.manage().window().maximize();
		ExtentReporting.log("URL is loaded");
		driver.manage().timeouts().pageLoadTimeout(10000, TimeUnit.SECONDS);
		WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
		Select select=new Select(continents);
		select.selectByVisibleText("Europe");
		Thread.sleep(2000);
		WebElement cmd = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
		Select select1=new Select(cmd);
		List<WebElement> options = select1.getOptions();
		int count = options.size();
		for(int i=1;i<count;i++) {
			Thread.sleep(1000);
			select1.selectByIndex(i);
			Thread.sleep(1000);
		}
		List<WebElement> selected = select1.getAllSelectedOptions();
		for(WebElement ele:selected){
			System.out.println(ele.getText());
			
	}
		Thread.sleep(1000);
		ExtentReporting.pass("Test Case is passed");
		
		driver.quit();	
		
		ExtentReporting.flush();
	}
}
