package com.myStore.Utlities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsNew {

	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	static ExtentTest logger;

	public static ExtentReports startTest() {
		reporter = new ExtentHtmlReporter("htmlNewreport.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.DARK);
		return extent;
	}

	public static void logwithSS(WebDriver driver, String msg,ExtentTest logger) {
		JScript.TakeSS(driver, msg);
		String path = System.getProperty("user.dir") + "/Screenshots/" + msg + ".png";
		try {
			logger.info(msg, MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}

	public static void flush() {
		extent.flush();
	}
	public static ExtentReports getInstance() {
		if(extent == null) {
			extent=startTest();
			return extent;
        }   
        return extent;
    }


	public static ExtentTest createTestNew(String testName) {
		logger=extent.createTest(testName);
		return logger;
	}	
}
