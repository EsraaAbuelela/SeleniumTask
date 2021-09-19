package pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class ShoppingCartPage extends PageBase {
	
	By proceedCheckoutSummary=By.xpath("(//a[@title='Proceed to checkout'])[2]");
	By proceedCheckout=By.xpath("//p[@class='cart_navigation clearfix']/button");
	By Termscheckout=By.xpath("//button[@name='processCarrier']");
	By Termsconditions=By.id("uniform-cgv");
	By bankwire=By.xpath("//a[@title='Pay by bank wire']");
	By ConfirmOrderBtn=By.xpath("//span[contains(text(),'I confirm my order')]");
	By order_Details=By.xpath("//div[@class='box']");
	By backtoOrdertHistory=By.xpath("//a[@title='Back to orders']");
	 
	 public ShoppingCartPage(WebDriver driver) {
		 super(driver);

	    }
     public String proceedToCartAndConfirmOrder() {
    	 
    	 clickElement(proceedCheckoutSummary,"Summary proceed to checkout");
    	 clickElement(proceedCheckout,"proceed to checkout");
    	 clickElement(Termsconditions, "Terms and condition checked");
    	 clickElement(Termscheckout, "proceed from terms and conditions page");
    	 clickElement(bankwire, "Select Bank wire payment method");
    	 clickElement(ConfirmOrderBtn,"confirm order button");
    	 String orderDetails=getTextOfElement(order_Details,"Order Details");
    	 String parseString=StringUtils.substringAfter(orderDetails, "order reference ");
    	
    	 return parseString.substring(0, parseString.indexOf(' '));
    	 
     }
     
     public boolean openOrderHistory() {
    	 clickElement(backtoOrdertHistory, "back to orders");
    	 String orderhistoryopened=getTextOfElement(By.xpath("//span[@class='navigation_page']"),"order history");
    	 String actualTxt="Order history";
    	 return orderhistoryopened.equals(actualTxt);
     }
}
