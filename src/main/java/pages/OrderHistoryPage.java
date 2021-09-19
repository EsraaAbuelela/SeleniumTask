package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.PageBase;

public class OrderHistoryPage extends PageBase {

	public OrderHistoryPage(WebDriver driver) {
		super(driver);

	}

	public boolean checkOrderPlaced(String RefernceNO) {
		WebElement orderRefNo = driver.findElement(By.xpath("descendant::td[1]/a"));
		boolean equal = orderRefNo.getText().equals(RefernceNO);
		return equal;

	}

}
