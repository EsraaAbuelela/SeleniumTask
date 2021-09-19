package testCases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.AuthenticatePage;
import pages.DetailedProductPage;
import pages.HomePage;
import pages.OrderHistoryPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import testData.TestDataReader;

public class CheckoutTest extends TestBase {

	HomePage homepageObj;
	AuthenticatePage authPageObj;
	ProductPage prdtPageObj;
	DetailedProductPage detailedpageObj;
	ShoppingCartPage shoppingcatObj;
	OrderHistoryPage historyObj;

	final static Logger logger = LogManager.getLogger(CreateAccountTest.class.getName());

	@BeforeMethod
	public void beforeMethod() {

		openBrowser();
		homepageObj = new HomePage(driver);
		authPageObj = new AuthenticatePage(driver);
		prdtPageObj = new ProductPage(driver);
		detailedpageObj = new DetailedProductPage(driver, properties);
		shoppingcatObj = new ShoppingCartPage(driver);
		historyObj = new OrderHistoryPage(driver);

	}

	@DataProvider(name = "ExcelData")
	public Object[][] UserRegistrationData() throws IOException {
		TestDataReader TD = new TestDataReader();
		Object data[][] = null;
		data = TD.fetchData("CheckoutTest");
		return data;

	}

	@Test(priority = 1, dataProvider = "ExcelData")
	public void CheckoutAndConfirmOrder(String email, String password) {

		homepageObj.clickOnSignIn();

		boolean PageIsOpened = authPageObj.AuthenticationPageOpened();
		Assert.assertTrue(PageIsOpened, "AuthenticationPage Is not Opened successfully");

		Assert.assertTrue(authPageObj.Login(email, password), "Failed to login");
		logger.info("User logged in ..");

		Assert.assertTrue(homepageObj.selectItemMenu(), "Couldn't select Blouses Category");
		logger.info("Selected Bloueses Category done");

		Assert.assertTrue(prdtPageObj.clickBlouseItem(), "Blouse Item is selected");
		logger.info("select resulted product done");

		Assert.assertTrue(detailedpageObj.addProductToCart(), "Couldn't add element to CART");
		logger.info("Item added and got text of success message");

		Assert.assertTrue(detailedpageObj.ProductExist(), "Blouse is not displayed in confirmation page");
		logger.info("blouse is displayed in confirmation page");

		Assert.assertTrue(detailedpageObj.proceedToCheckout(), "couldn't proceed to checkout");
		logger.info("proceed to checkout done");

		String refNumber = shoppingcatObj.proceedToCartAndConfirmOrder();
		Assert.assertNotNull(refNumber, "failed to add order");
		logger.info("order refrence number is " + refNumber);

		Assert.assertTrue(shoppingcatObj.openOrderHistory(), "failed to navigate to order history page");
		logger.info("Navigated to order history page");

		Assert.assertTrue(historyObj.checkOrderPlaced(refNumber), "red number is not displayed");
		logger.info("Refrence order is displayed in history order page");

	}
	
	  @AfterMethod public void afterMethod(ITestResult result) {
		 tearDown(result);
	  }
	 
}