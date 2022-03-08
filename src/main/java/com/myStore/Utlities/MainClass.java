package com.myStore.Utlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainClass {
	public static WebDriver driver;
	Properties prop;

	public MainClass() {
		
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/myStore/properties/data.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void intializeBrowser(String browser) throws InterruptedException {
		System.out.println("Before:"+driver);
		ManageBrowser.manageBrowser(browser);
		System.out.println("After:"+driver);
		if(driver==null) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		//driver.get(prop.getProperty("url"));
		Thread.sleep(2000);
		driver.get("http://automationpractice.com/index.php");
		//driver.get("http://automationpractice.com/index.php");
		ManageBrowser.WaitnMaximize(driver);
		//String reach = driver.getCurrentUrl();

	}
	
	

}
