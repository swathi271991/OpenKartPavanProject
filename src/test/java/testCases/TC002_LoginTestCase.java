package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTestCase extends BaseClass {

	LoginPage lp;
	HomePage hp;

	@Test(groups= {"master", "sanity"})
	public void validate_login() {

		lp = new LoginPage(driver);
		hp = new HomePage(driver);

		log.info("*********Started Login Method*************");
		log.debug("started Application logs for Login Page");

		try {
			String user = prop.getProperty("username");
			String pass = prop.getProperty("password");

			lp.inputUsername(user);
			log.info("Entered username");
			lp.inputPassword(pass);
			log.info("Entered password");
			lp.clickLoginBtn();
			log.info("clicked on login button");

			if (hp.isDisplay()) {
				log.info("ORDERS button is displayed");
			} else {
				log.info("ORDERS button is not displayed");
				Assert.fail();
			}
			hp.clickSignOutBtn();
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail();
		}

		log.debug("Completed Application logs for Login Page");
		log.info("*********Completed Login Method*************");

	}

}
