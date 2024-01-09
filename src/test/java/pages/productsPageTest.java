package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import baseClass.baseTestClass;

public class productsPageTest extends baseTestClass {
	@FindBy(id = "slider")
	WebElement slider;
	@FindBy(xpath="//a[@data-product-id='1']") 
	WebElement blue_top_add_to_cart;
	@FindBy(xpath="//a[@data-product-id='2']") 
	WebElement men_tshirt_add_to_cart;
	@FindBy(xpath="//a[@data-product-id='3']") 
	WebElement sleeveless_dress_add_to_cart;
	@FindBy(className = "close-modal")
	WebElement continue_shopping_button;
	@FindBy(xpath = "//u[text()='View Cart']")
	WebElement view_cart_button;
	@FindBy(xpath = "//*[@id=\"cart_info_table\"]/tbody")
	WebElement cart_table;
	
	
	/*
	1. Launch browser
	2. Navigate to url 'http://automationexercise.com'
	3. Verify that home page is visible successfully
	4. Click 'Products' button
	5. Hover over first product and click 'Add to cart'
	6. Click 'Continue Shopping' button
	7. Hover over second product and click 'Add to cart'
	8. Click 'Continue Shopping' button
	9. Hover over third product and click 'Add to cart'
	10. Click 'View Cart' button
	11. Verify all products are added to Cart
	*/
	@Test
	
	public void verify_functionality_of_cart() throws Exception {
		try {
		System.out.println("Running cart test");
		PageFactory.initElements(driver, this);
		if (!slider.isDisplayed()) {
			throw new Exception("Home Page validation failed");
		}
		blue_top_add_to_cart.click();
		continue_shopping_button.click();
		men_tshirt_add_to_cart.click();
		continue_shopping_button.click();
		sleeveless_dress_add_to_cart.click();
		view_cart_button.click();
		if ((cart_table.findElements(By.tagName("tr")).size()) != 3){
			throw new Exception("Cart quantity isn't 3");
		}
		
		
	}catch(Exception e) {
		e.printStackTrace();
		Assert.fail();
	}
	}

}

