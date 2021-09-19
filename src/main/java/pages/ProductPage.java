package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class ProductPage extends PageBase{
	

	 
	 By blouseItem = By.xpath("//img[@title='Blouse']");
	 By productRef= By.xpath("//p[@id='product_reference']");
	
	public ProductPage(WebDriver driver){

		super(driver);
	}
	
	public boolean clickBlouseItem() {

		WebElement Item=driver.findElement(blouseItem);
		hoverElement(Item, "hover  blouse Item done");
		jsClick(blouseItem, "clicked on blouse to more details");
		boolean selected= elementISDisplayed(productRef, "Product details opened");
		return selected; 
	}
	
	

}
