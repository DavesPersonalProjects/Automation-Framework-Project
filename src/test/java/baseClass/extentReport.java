package baseClass;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	protected static ExtentReports extent;
	protected static ExtentTest test;

	@BeforeSuite
	public void beforeSuite() {
		extent = new ExtentReports();
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/ExtentReport.html");
		extent.attachReporter(htmlReporter);
	}
	 @BeforeMethod
	    public void beforeMethod(Method method) {
	        // Start a new test before each test method
	        test = extent.createTest(method.getName());
	    }
	@AfterMethod
	public void getResult(ITestResult result) {
		   if (result.getStatus() == ITestResult.FAILURE) {
	            test.fail(result.getThrowable());
	        } else if (result.getStatus() == ITestResult.SKIP) {
	            test.skip("Test Skipped");
	        } else {
	            test.pass("Test Passed");
	        }
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Finished");
		extent.flush();
	}

}
