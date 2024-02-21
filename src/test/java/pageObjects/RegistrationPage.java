package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(id = "firstName")
	private WebElement firstname;

	@FindBy(id = "lastName")
	private WebElement lastname;

	@FindBy(id = "userEmail")
	private WebElement email;

	@FindBy(id = "userMobile")
	private WebElement phonenumber;

	// from here

	@FindBy(xpath = "//select[@formcontrolname='occupation']")
	private WebElement occupation;

	@FindBy(xpath = "//select[@formcontrolname='occupation']/option")
	private List<WebElement> options;

	@FindBy(xpath = "//input[@value='Male']")
	private WebElement radio_male;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement radio_female;

	@FindBy(id = "userPassword")
	private WebElement pass;

	@FindBy(id = "confirmPassword")
	private WebElement confirm_pass;

	@FindBy(xpath = "//input[@formcontrolname='required']")
	private WebElement agreecheckbox;

	@FindBy(xpath = "//input[@value='Register']")
	private WebElement continueregbutton;
	
	@FindBy(xpath = "//h1[text()='Account Created Successfully']")
	private WebElement confirmationmesg;
	
	public WebElement confirmationMesg(){
		return confirmationmesg;
	}

	public WebElement firstname() {
		return firstname;
	}

	public WebElement lastname() {
		return lastname;
	}

	public WebElement email() {
		return email;
	}

	public WebElement phone() {
		return phonenumber;
	}

	public WebElement occupation() {
		return occupation;
	}

	public List<WebElement> options() {
		return options;
	}

	public WebElement radio_male() {
		return radio_male;
	}

	public WebElement radio_female() {
		return radio_female;
	}

	public WebElement password() {
		return pass;
	}

	public WebElement confirmpasword() {
		return confirm_pass;
	}

	public WebElement agreecheckbox() {
		return agreecheckbox;
	}

	public WebElement continueregbutton() {
		return continueregbutton;
	}

	public void input_firstname(String firstnametext) {
		inputTextUsingSendkeys(firstname(), firstnametext);
	}

	public void input_lastname(String lastnametext) {
		inputTextUsingSendkeys(lastname(), lastnametext);
	}

	public void input_email(String emailtext) {
		inputTextUsingSendkeys(email(), emailtext);
	}

	public void input_phonenumber(String phonenumber) {
		inputTextUsingSendkeys(phone(), phonenumber);
	}

	public void clickOccupation() {
		clickWebElement(occupation());
	}

	public void selectradio() {
		clickUsingActions(radio_female());
	}
	
	public void input_pass(String password) {
		inputTextUsingSendkeys(password(), password);
	}

	public void input_confirmpass(String confirmpassword) {
		inputTextUsingSendkeys(confirmpasword(), confirmpassword);
	}

	public void clickcheckbox() {
		clickWebElement(agreecheckbox());
	}

	public void clickRegisterButton() {
		clickUsingJS(continueregbutton());
	}
	
	public String getconfirmationmesg()
	{
		return getTextFromWebElement(confirmationMesg());
	}

}
