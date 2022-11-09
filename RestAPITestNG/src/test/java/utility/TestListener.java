package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener implements ITestListener {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		// set the location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Reports/extentReport.html");
		// set title
		htmlReporter.config().setDocumentTitle("Rest API Automation");
		// Tile of report
		// set report name
		htmlReporter.config().setReportName("Automation Practice Tests");
		// Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Project Name", "Employee Database API");
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Environment", "QA");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution started : " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "TEST CASE SUCCESS " + result.getName()); // to add name in extent report
		System.out.println("Test success : " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		test.log(Status.FAIL, result.getThrowable());

		System.out.println("Test Failure : " + result.getName());
	}

	
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
