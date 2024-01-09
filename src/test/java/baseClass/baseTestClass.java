package baseClass;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import loadConfig.configProperties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.ITestResult;

public class baseTestClass extends extentReport {
	protected static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception{
		try {
		//Initialize config properties and create our chrome instance
		configProperties.initializePropertyFile();
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.addExtensions(new java.io.File("adblock.crx"));
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(configProperties.property.getProperty("weburl"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}



@AfterTest
public void tearDown() {
	driver.close();
}


}
