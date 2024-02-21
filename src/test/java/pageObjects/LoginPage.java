package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath = "//a[text()='Register']")
	private WebElement Register;

	@FindBy(id = "userEmail")
	private WebElement useremail;

	@FindBy(id = "userPassword")
	private WebElement userpassword;

	@FindBy(id = "login")
	private WebElement loginbtn;

	public WebElement RegisterLink() {
		return Register;
	}

	public WebElement usernamefield() {
		return useremail;
	}

	public WebElement passwordfield() {
		return userpassword;
	}

	public WebElement loginbutton() {
		return loginbtn;
	}

	public void clickRegisterlink() {
		clickWebElement(RegisterLink());
	}

	public void inputUsername(String username) {
		
		usernamefield().clear();
		inputTextUsingSendkeys(usernamefield(), username);
	}

	public void inputPassword(String password) {
		
		usernamefield().clear();
		inputTextUsingSendkeys(passwordfield(), password);
	}

	public void clickLoginBtn() {
		clickWebElement(loginbutton());
	}

}
