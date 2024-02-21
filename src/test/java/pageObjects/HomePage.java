package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {

		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//ul//li[3]/button")
	private WebElement orderbtn;

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[4]")
	private WebElement signoutBtn;

	public WebElement orderBtn() {
		return orderbtn;
	}

	public WebElement signOutBtn() {
		return signoutBtn;
	}

	public boolean isDisplay() {
		try {
			return isDisplayed(orderBtn());
		} catch (Exception e) {
			return false;
		}
	}

	public void clickSignOutBtn() {
		clickUsingActions(signOutBtn());
	}

}
