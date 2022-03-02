package _Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporting {
	static ExtentHtmlReporter htmlreporter;
	static ExtentTest test;
	static ExtentReports extent;

	public static ExtentReports getExtentTest(ExtentHtmlReporter reporter) {
		try {
			if(extent != null)
				return extent;
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return extent;
	}
	
	public static ExtentHtmlReporter getHtmlReporter() {
		
		
		try {
			htmlreporter=new ExtentHtmlReporter("finalreport.html");
			htmlreporter.config().setChartVisibilityOnOpen(true);
			htmlreporter.config().setTheme(Theme.DARK);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		return htmlreporter;
	}
	
	public static void createTest(ExtentReports extent,String testName) {
		try{
			test=extent.createTest(testName);
			pass(testName);
		}catch(Exception e) {
			e.printStackTrace();
			fail(testName);
		}
	}
	
	public static void assignCategory(String category) {
		test.assignCategory(category);
		
	}
	
	public static void log(String msg) {
		test.log(Status.INFO, msg);
	}
	
	public static void pass(String msg) {
		
		test.pass(msg);
	}
	
	public static void fail(String msg) {
		test.fail(msg);
	}
	
	public static void flush() {
		extent.flush();
	}
}
