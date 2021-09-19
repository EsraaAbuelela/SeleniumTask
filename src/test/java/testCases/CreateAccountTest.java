package testCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import base.TestBase;
import pages.AuthenticatePage;
import pages.CreateAccount;
import pages.HomePage;
import testData.TestDataReader;
import utils.CreateRandomNumber;
import com.relevantcodes.extentreports.LogStatus;

public class CreateAccountTest extends TestBase {

	HomePage homepageObj;
	AuthenticatePage authPageObj;
	CreateAccount createAccountObj;
	
	final static Logger logger = LogManager.getLogger(CreateAccountTest.class.getName());

	@BeforeMethod
	public void beforeMethod(Method method) {

		openBrowser();
		homepageObj = new HomePage(driver);
		authPageObj = new AuthenticatePage(driver);
		createAccountObj = new CreateAccount(driver);
		System.out.println(method.getName());
		System.out.println(method.getName());
	

	}

	@DataProvider(name = "ExcelData")
	public Object[][] UserRegistrationData() throws IOException {
		TestDataReader TD = new TestDataReader();
		Object data[][] = null;
		data = TD.fetchData("CreateAccountTest");
		return data;

	}

	@Test(priority = 1, dataProvider = "ExcelData")
	public void testCreateNewAccount(String Title, String FirstName, String LastName, String email, String Password,
			String AddressFirstName, String AddressLastName, String Address, String City, String State,
			String PostalCode, String MobileNo, String AliasAdd) {

		homepageObj.clickOnSignIn();
		
		boolean PageIsOpened = authPageObj.AuthenticationPageOpened();
		Assert.assertTrue(PageIsOpened, "AuthenticationPage Is not Opened successfully");
		logger.info("Authentication Page is opened successfully");
		

		email = CreateRandomNumber.generateNewEmail(email);
		System.out.println(email);

		Assert.assertTrue(authPageObj.createAccount(email), "Create account in OuthPage failed");
		logger.info("Navigation to fill account details done successfully");
		

		boolean AccountCreated = createAccountObj.RegisterUser(Title, FirstName, LastName, Password, AddressFirstName,
				AddressLastName, Address, City, State, PostalCode, MobileNo, AliasAdd);
		Assert.assertTrue(AccountCreated, "Account creation failed");
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		tearDown(result);
	}

}
