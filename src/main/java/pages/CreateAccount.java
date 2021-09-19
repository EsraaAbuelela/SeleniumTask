package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.PageBase;

public class CreateAccount extends PageBase {


	By mrTitle = By.id("id_gender1");
	By mrsTitle = By.id("id_gender2");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	// input[@name='passwd']
	By passwd = By.xpath("//input[@name='passwd']");
	// By passwd=By.id("isPasswd");
	By addressFN = By.id("firstname");
	By addressLN = By.id("lastname");
	By address_ = By.id("address1");
	By city_ = By.id("city");
	By state_ = By.id("id_state");
	By postacode = By.id("postcode");
	By mobileNo = By.id("phone_mobile");
	By aliasAdd = By.id("alias");
	By submitBtn = By.id("submitAccount");
	By WelcomeMsg = By.xpath("//p[@class='info-account']");

	public CreateAccount(WebDriver driver) {
		 super(driver);

	}

	public boolean RegisterUser(String title, String fname, String lname, String password, String addressFirstName,
			String addressLastName, String address, String city, String state, String postalCode, String phoneNo,
			String addAlias) {

		if (title.equals("Mr.")) {
			clickElement(mrTitle, "Mr Title");
		} else if (title.equals("Mrs."))
			;
		{
			clickElement(mrsTitle, "Mrs. Title");

			typeText(firstName, fname, "First Name");
			typeText(lastName, lname, "Last Name");
			typeText(passwd, password, "Password");
			typeText(addressFN, addressFirstName, "Address FirstName");
			typeText(addressLN, addressLastName, "Address LastName");
			typeText(address_, address, "address");
			typeText(city_, city, "city");
			selectElementDropdown(state_, state, "State");
			typeText(postacode, postalCode, "PostalCode");
			typeText(mobileNo, phoneNo, "phoneNo");
			typeText(aliasAdd, addAlias, "AddressAlias");

			clickElement(submitBtn, "SubmitButton");

			boolean displayed = elementISDisplayed(WelcomeMsg, "Welcome message");
			return displayed;

		}
	}
}
