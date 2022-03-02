package com.myStore.Utlities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

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

	public void intializeBrowser(String browser) {
		System.out.println("Before:"+driver);
		driver=ManageBrowser.manageBrowser(browser);
		System.out.println("After:"+driver);
		//driver.get(prop.getProperty("url"));
		driver.get("http://automationpractice.com/index.php");
		//driver.get("http://automationpractice.com/index.php");
		ManageBrowser.WaitnMaximize(driver);
		//String reach = driver.getCurrentUrl();
	}
	
	

}
