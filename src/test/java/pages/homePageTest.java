package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import loadConfig.configProperties;
import baseClass.baseTestClass;

public class homePageTest extends baseTestClass {
	@FindBy(xpath = "//*[contains(text(), 'Subscription')]")
	WebElement subscription_text;
	@FindBy(id = "slider")
	WebElement slider;
	@FindBy(id = "susbscribe_email")
	WebElement enter_email_box;

	/*
	1. Launch browser
	2. Navigate to url 'http://automationexercise.com'
	3. Verify that home page is visible successfully
	4. Scroll down to footer
	5. Verify text 'SUBSCRIPTION'
	6. Enter email address in input and click arrow button
	7. Verify success message 'You have been successfully subscribed!' is visible
	 */
	@Test
	public void verify_subscription_in_home_page() throws Exception {
		try {
		System.out.println("Running subscription test");
		PageFactory.initElements(driver, this);
		Thread.sleep(3000);
		if (!slider.isDisplayed()) {
			throw new Exception("Home Page validation failed");
		}
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", subscription_text);
	    if (!subscription_text.isDisplayed()) {
			throw new Exception("Subscription Text not visible");
		}
	    enter_email_box.sendKeys(configProperties.property.getProperty("password"));
	}catch(Exception e) {
		e.printStackTrace();
		Assert.fail();
	}
		
	
		     
		    
	}

}
