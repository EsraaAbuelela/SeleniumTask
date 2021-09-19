package base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

  public  WebDriver driver;
    private WebDriverWait wait;


    private static Logger log = LogManager.getLogger(PageBase.class.getName());

	public PageBase(WebDriver driver) {
		this.driver = driver;
	}


    public void clickElement(By byElement, String elementLog) {

        waitElementToBeVisible(byElement);
        driver.findElement(byElement).click();
        log.info("Click on " + elementLog);
    }

    public void waitElementToBeVisible(By element) {

        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void hoverElement(WebElement element, String elementLog) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
        log.info("hover on " + elementLog);

    }

    public void clickHoverElement(WebElement element, String elementLog) {
        Actions action = new Actions(driver);
        hoverElement(element, elementLog);
        action.moveToElement(element).click().build().perform();
        log.info("hover on " + elementLog);

    }

    public void typeText(By byElement, String text, String elementlog) {
        waitElementToBeVisible(byElement);
        WebElement element = driver.findElement(byElement);
        element.clear();
        element.sendKeys(text);
        log.info("type" + elementlog + " :" + text);

    }

    public void selectElementDropdown(By byElement, String state, String elementlog) {
        Select dropdown = new Select(driver.findElement(byElement));
        dropdown.selectByVisibleText(state);


    }

    public boolean elementISDisplayed(By byElement, String elementlog) {
		waitElementToBeVisible(byElement);
        boolean displayed = driver.findElement(byElement).isDisplayed();
        log.info(elementlog + " is displayed successfully");
        return displayed;
    }

    public void jsClick(By byElement, String elementLog) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(byElement));
        log.info("Click on " + elementLog);
    }

    public String getTextOfElement(By byElement, String elementLog) {

        String actualTxt;

        waitElementToBeVisible(byElement);
        if (elementISDisplayed(byElement, elementLog)) {

            actualTxt = driver.findElement(byElement).getText();
            log.info(elementLog + " Actual text is " + actualTxt);
            return actualTxt;
        } else {
            log.error(elementLog + " Can't get the text of the element");
            return "";
        }

    }
}
