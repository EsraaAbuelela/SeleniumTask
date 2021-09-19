package pages;


import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.PageBase;

public class HomePage extends PageBase {
	

	 
	 public By signIn= By.xpath("//a[@title='Log in to your customer account']");
	 public By categoryWomenList= By.xpath("//div[@id='block_top_menu']/ul/li");
	 public By blousesCat=By.xpath("//a[@title='Blouses']");
	 public By BloPageOpened=By.xpath("//div[@class='cat_desc']/span");
	 
	 public HomePage(WebDriver driver) {
		 super(driver);

	    }
	
	public void clickOnSignIn() {
		clickElement(signIn,"SignInButton");
	}
	
	public boolean selectItemMenu() {
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement WomenElement= driver.findElement(categoryWomenList);
		hoverElement(WomenElement, "hover and click on women");
		WebElement Blouses = driver.findElement(blousesCat);
		hoverElement(Blouses, "hover  blouses done");
		clickHoverElement(Blouses," clicked on blouses");
		
		boolean displayed=elementISDisplayed(BloPageOpened,"Blouses Cat selected");
		return displayed;
		
	}
	
}
