package tests;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import loadConfig.configProperties;
import baseClass.baseTestClass;

public class contactTest extends baseTestClass {
	@FindBy(linkText = "Contact us")
	WebElement contactUs;
	@FindBy(name = "name")
	WebElement name;
	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "subject")
	WebElement subject;
	@FindBy(name = "message")
	WebElement message;
	@FindBy(name = "submit")
	WebElement submit;
	@FindBy(xpath = "//*[contains(text(), 'Success! Your details have been submitted successfully.')]")
	WebElement successText;
	@FindBy(id = "slider")
	WebElement slider;

	/*
	 * MANUAL INSTRUCTIONS: (normally would be on Zephyr (Jira) or qTest) 
	 * 1.Launch Browser 
	 * 2.Navigate to URL http://automationexercise.com
	 * 3.Click on the
	 * Contact us tab 
	 * 4.Input Name, Email, Subject and Message 
	 * 5.Press Submit Button
	 * 6.Alert Dialog will Appear, press OK 
	 * 7.Verify success text appears
	 */
	@Test
	public void contactTest() throws Exception {
		try {
		System.out.println("Running test one");
		PageFactory.initElements(driver, this);
		if (!slider.isDisplayed()) {
			throw new Exception("Home Page validation failed");
		}
		contactUs.click();
		
		name.sendKeys(configProperties.property.getProperty("name"));
		email.sendKeys(configProperties.property.getProperty("email"));
		subject.sendKeys("test");
		message.sendKeys("test");
		submit.click();
		driver.switchTo().alert().accept();
		if (!successText.isDisplayed()) {
			throw new Exception("Contact Page validation failed");
		}
		Thread.sleep(2000);
	}catch(Exception e) {
		e.printStackTrace();
		Assert.fail();
	}
	}

}
