package utilities;

import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class PageobjectManager {

	WebDriver driver;
	private LoginPage loginpageobj;
	private RegistrationPage regpageobj;
	private HomePage homepageobj;

	public PageobjectManager(WebDriver driver) {

		this.driver = driver;
	}

	public LoginPage get_LoginPage(WebDriver driver) {
		return (loginpageobj == null) ? loginpageobj = new LoginPage(driver) : loginpageobj;
	}

	public RegistrationPage get_RegistrationPage(WebDriver driver) {
		return (regpageobj == null) ? regpageobj = new RegistrationPage(driver) : regpageobj;
	}

	public HomePage get_HomePage(WebDriver driver) {
		return (homepageobj == null) ? homepageobj = new HomePage(driver) : homepageobj;
	}

}
