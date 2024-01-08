package baseClass;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import loadConfig.configProperties;


public abstract class baseTestClass {
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

public void objSelect(WebElement element,String text) {
	Select select = new Select(element);
	select.selectByVisibleText(text);
}


}
