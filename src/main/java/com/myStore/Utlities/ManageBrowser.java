package com.myStore.Utlities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManageBrowser extends MainClass{
	//static WebDriver driver;
	static String projectpath = System.getProperty("user.dir");

	public static WebDriver manageBrowser(String BrowserName) {
		
		try {
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver", projectpath+"/src/main/java/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}catch (Exception e) {
				System.out.println("Failed to load ChromeDiver");
		}
				
		}
		else if(BrowserName.equalsIgnoreCase("firefox")) {
			try {
				System.setProperty("webdriver.gecko.driver",projectpath+"/src/main/java/Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
				System.out.println(driver);
			}catch(Exception e) {
				System.out.println("Failed to load Firefox driver");
			}
		}
		else if(BrowserName.equalsIgnoreCase("edge")) {
			try {
				System.setProperty("webdriver.edge.driver",projectpath+"/src/main/java/Drivers/msedgedriver.exe");
				driver=new EdgeDriver();
			}catch(Exception e){
				System.out.println("Failed to load Edge Driver");
			}
		}
		else
		{
			System.setProperty("webdriver.edge.driver",projectpath+"/src/main/java/Drivers/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		}catch(Exception e)  {
			System.out.println("Failed to load Driver");
			
		}
		return driver;	
	}
	
	public static void WaitnMaximize(WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(TimeoutVariables.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeoutVariables.IMPLICIT_WAIT, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
