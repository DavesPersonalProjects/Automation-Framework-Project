package tests;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import loadConfig.configProperties;
import baseClass.baseTestClass;

public class registerTest extends baseTestClass {
	@FindBy(linkText = "Home")
	WebElement home_button;
	@FindBy(linkText = "Signup / Login")
	WebElement signuplogin;
	@FindBy(xpath="//input[@data-qa='signup-email']") 
	WebElement signupEmail;
	@FindBy(xpath="//input[@data-qa='signup-name']") 
	WebElement signupName;
	@FindBy(id="id_gender1") 
	WebElement mrButton;
	@FindBy(id="password") 
	WebElement passwordField;
	@FindBy(id="days") 
	WebElement days;
	@FindBy(id="months") 
	WebElement months;
	@FindBy(id="years") 
	WebElement years;
	@FindBy(name="newsletter") 
	WebElement newsletter;
	@FindBy(name="optin") 
	WebElement optin;
	@FindBy(name="first_name") 
	WebElement firstname;
	@FindBy(name="last_name") 
	WebElement lastname;
	@FindBy(id="address1") 
	WebElement address;
	@FindBy(id="country") 
	WebElement country;
	@FindBy(id="state") 
	WebElement state;
	@FindBy(id="city") 
	WebElement city;
	@FindBy(id="zipcode") 
	WebElement zipcode;
	@FindBy(id="mobile_number") 
	WebElement mobile_number;
	@FindBy(xpath="//button[@data-qa= 'create-account']") 
	WebElement create_account_button;
	@FindBy(xpath="//h2[@data-qa= 'account-created']") 
	WebElement account_created_text;
	@FindBy(linkText = "Continue")
	WebElement continue_button;
	@FindBy(xpath="//button[@data-qa= 'signup-button']") 
	WebElement sign_up;
	@FindBy(linkText = "Delete Account")
	WebElement delete_account;
	@FindBy(xpath="//h2[@data-qa= 'account-deleted']") 
	WebElement account_deleted_text;

	

	/*
	 * MANUAL INSTRUCTIONS: (normally would be on Zephyr (Jira) or qTest)
	1.Launch browser
	2. Navigate to url 'http://automationexercise.com'
	3. Verify that home page is visible successfully
	4. Click on 'Signup / Login' button
	5. Verify 'New User Signup!' is visible
	6. Enter name and email address
	7. Click 'Signup' button
	8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
	9. Fill details: Title, Name, Email, Password, Date of birth
	10. Select checkbox 'Sign up for our newsletter!'
	11. Select checkbox 'Receive special offers from our partners!'
	12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
	13. Click 'Create Account button'
	14. Verify that 'ACCOUNT CREATED!' is visible
	15. Click 'Continue' button
	16. Verify that 'Logged in as username' is visible
	17. Click 'Delete Account' button
	18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
	 */
	public void objSelect(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	@Test
	public void registerTest() throws Exception {
		try {
		System.out.println("Running test two");
		PageFactory.initElements(driver, this);
		if (!home_button.isDisplayed()) {
			throw new Exception("Home Page validation failed");
		}
		signuplogin.click();
		signupName.sendKeys(configProperties.property.getProperty("name"));
		signupEmail.sendKeys(configProperties.property.getProperty("email"));
		sign_up.click();
		Thread.sleep(3000);
		mrButton.click();
		passwordField.sendKeys(configProperties.property.getProperty("password"));
		objSelect(days,"1");
		objSelect(months,"January");
		objSelect(years,"2021");
		newsletter.click();
		optin.click();
		firstname.sendKeys(configProperties.property.getProperty("name"));
		lastname.sendKeys(configProperties.property.getProperty("lastname"));
		address.sendKeys(configProperties.property.getProperty("address"));
		objSelect(country,"Canada");
		state.sendKeys(configProperties.property.getProperty("state"));
		city.sendKeys(configProperties.property.getProperty("city"));
		zipcode.sendKeys(configProperties.property.getProperty("zipcode"));
		mobile_number.sendKeys(configProperties.property.getProperty("phone"));
		create_account_button.click();
		Thread.sleep(2000);
		if (!account_created_text.isDisplayed()) {
			throw new Exception("Account failed to create");
		}
		continue_button.click();
		driver.findElement(By.xpath(String.format("//b[text()=\"testuser\"]", configProperties.property.getProperty("name"))));
		delete_account.click();
		continue_button.click();
		}catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
