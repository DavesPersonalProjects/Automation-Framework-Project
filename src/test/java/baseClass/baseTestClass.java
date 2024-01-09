package baseClass;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import loadConfig.configProperties;


public abstract class baseTestClass extends extentReport {
	protected static WebDriver driver;
	
	@BeforeClass
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



@AfterClass
public void tearDown() throws Exception {
	try {
	driver.quit();
	}catch(Exception e) {
		e.printStackTrace();
	}
}


}
