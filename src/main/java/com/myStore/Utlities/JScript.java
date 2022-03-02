package com.myStore.Utlities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class JScript {
	static JavascriptExecutor js;
	
	public static void scrollIntoView(WebDriver driver,WebElement element) {
		js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollIntoView=true", element);
	}	
	
	public static WebDriver TakeSS(WebDriver driver,String msg) {
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"/Screenshots/"+msg+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return driver;
		
	}
	
	public static void waitnClick(WebDriver driver,WebElement element,ExtentTest extent) {
		WebDriverWait  wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		ExtentReportsNew.logwithSS(driver, element.getText()+" is Displayed and clickable",extent);
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
		ExtentReportsNew.logwithSS(driver,element.getText()+" is clicked",extent);
	}	
	public static void scrollPage(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("window.scrollBy(0,-500)");
	}
	
}
