package utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {

	WebDriver driver;

	public CommonMethods(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clickWebElement(WebElement element) {
		try {
			element.click();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new RuntimeException("Error occured while clicking on web element");
		}
	}

	public void clickUsingActions(WebElement ele) {
		Actions builder;
		try {
			builder = new Actions(driver);
			builder.moveToElement(ele).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error occured while clicking on web element using actions class");
		}
	}

	public void clickUsingJS(WebElement ele) {
		JavascriptExecutor js;
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", ele);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error occured while clicking on web element using JS");
		}
	}

	public void inputTextUsingSendkeys(WebElement ele, String text) {
		try {
			ele.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error occured while passing text into web element using sendkeys method");
		}

	}

	public void selectOptionByVisibleText(WebElement ele, String text) {
		try {
			Select options = new Select(ele);
			options.selectByVisibleText(text);
		} catch (StaleElementReferenceException e) {
			Select options = new Select(ele);
			options.selectByVisibleText(text);
			throw new RuntimeException("Error occured while passing select an option using visible text in dropdown");
		}
	}

	public String getTextFromWebElement(WebElement ele) {
		try {
			return (ele.getText());
		} catch (Exception e) {
			System.out.println("error occured while fetching text from webelement");
			return null;
		}
	}
	
	public boolean isDisplayed(WebElement ele)
	{
		boolean b = false;
		try {
			b = ele.isDisplayed();
			return b;
		}
		catch(Exception e) {
			System.out.println("WebElement is not displayed");
		}
		return b;
	}

	public String RandomString() {
		String randomString = RandomStringUtils.randomAlphabetic(5);
		return (randomString + "12345");
	}

	public String RandomNumber() {
		String randomnum = RandomStringUtils.randomNumeric(9);
		return ("9"+randomnum);
	}

	public String randomAplhanumeric() {
		String randomString = RandomStringUtils.randomAlphabetic(3);
		String randomnum = RandomStringUtils.randomNumeric(3);

		String n = randomString + randomnum + "@" + "gmail.com";
		return n;
	}
	



}
