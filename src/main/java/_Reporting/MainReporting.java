package _Reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MainReporting {
	static ExtentHtmlReporter reporter;
	static ExtentReports extent;
	
	public static void CreateTest(String testName) {
		try {
			reporter= ExtentReporting.getHtmlReporter();
			extent=ExtentReporting.getExtentTest(reporter);
			ExtentReporting.createTest(extent,testName );	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
