package pages;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class DetailedProductPage extends PageBase {


	
	private Properties properties;
	By addToCart = By.xpath("//button[@name='Submit']");
	//By successMsg = By.xpath("//div[contains(@class,'layer_cart_product col-xs-12 col-md-6')]/h2");
	By successMsg=By.xpath("(//div[contains(@class,'layer_cart')]/h2)[1]");
	By checkoutBtn = By.xpath("//a[@title='Proceed to checkout']");
	By ProItem = By.id("layer_cart_product_title");

	public DetailedProductPage(WebDriver driver, Properties properties) {
		super(driver);
		this.properties = properties;

	}

	// add to Cart and verify the successful msg
	public boolean addProductToCart() {

		
		clickElement(addToCart, " click on AddtoCart button");
		
		//driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	
		String getSuccessMsg = getTextOfElement(successMsg, "success message");
		System.out.println(getSuccessMsg);
		System.out.println(properties.getProperty("sucessMsg"));
	    boolean isEqual = getSuccessMsg.equalsIgnoreCase(properties.getProperty("sucessMsg"));
        return isEqual;}
		
		
	

	// verify Product item is displayed after click on Add to CART
	public boolean ProductExist() {
		
		boolean proDisplayed = elementISDisplayed(ProItem, "blouseIsDisplayed");
		return proDisplayed;
	}

	// proceed to checkout
	public boolean proceedToCheckout() {
		
		clickElement(checkoutBtn, "click on checkout button");
		return elementISDisplayed(By.id("cart_title"), "CART Summary Opened");
	}

}
