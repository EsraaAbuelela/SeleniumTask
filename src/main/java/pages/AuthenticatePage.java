package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class AuthenticatePage extends PageBase {

	
	By byEmail= By.id("email_create");
	By createAccount= By.xpath("//button[@id='SubmitCreate']");
	By AuthPage=By.xpath("//form[@id='create-account_form']");
	By accountHeader= By.xpath("//div[@id='noSlide']/h1");
	By emailLogin= By.id("email");
	By passLogin=By.id("passwd");
	By submitbtn=By.id("SubmitLogin");
	By welcomeToAccount = By.xpath("//p[@class='info-account']");
	
	public AuthenticatePage(WebDriver driver) {
		 super(driver);
	//	this.driver=driver;
	    // setDriver(driver);
	}
	
	
	
	public boolean AuthenticationPageOpened() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		boolean pageOpened= driver.findElement(AuthPage).isDisplayed();
		return pageOpened;
	}
	
	
	public boolean createAccount(String email) {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		typeText(byEmail ,email, "email");
		clickElement(createAccount,"Register");
		boolean accountHeaderdisplayed= elementISDisplayed(accountHeader, "Account Header displayed");
		return accountHeaderdisplayed;
		
	}
	
	public boolean Login(String email , String password) {
		
		typeText(emailLogin , email , "email");
		typeText(passLogin ,password , "Password" );
		clickElement(submitbtn , "Login");
		
		 boolean welcomeMsg=elementISDisplayed(welcomeToAccount, "Welcome to account is displayed");
		 return welcomeMsg;
		
	}

}
