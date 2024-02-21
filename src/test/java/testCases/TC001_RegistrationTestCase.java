package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistrationTestCase extends BaseClass{
	
	@Test(groups={"regression", "master"})
	public void verify_register_account() throws Exception
	{
		
		log.info("************starting register account verification test******************");
		log.debug("started Application logs");
		try {
		LoginPage lp = new LoginPage(driver);
		lp.clickRegisterlink();
		log.info("clicked on Register link");
		System.out.println("Register link has been clicked successfully");
		
		Thread.sleep(2000);
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		String fn = rp.RandomString();
		String ln = rp.RandomString();
		String em = rp.randomAplhanumeric();
		String phn = rp.RandomNumber();
		String pass = rp.RandomString()+"x123@";
		
		System.out.println(em);
		System.out.println(pass);
		
		Thread.sleep(2000);
		
		rp.input_firstname(fn);
		log.info("Entered firstname");
		rp.input_lastname(ln);
		log.info("Entered lastname");
		rp.input_email(em);
		log.info("Entered email");
		rp.input_phonenumber(phn);
		log.info("Entered phone number");
		rp.selectradio();
		log.info("selected radio button");
		rp.input_pass(pass);
		log.info("Entered password");
		rp.input_confirmpass(pass);
		log.info("Entered confirm password");
		rp.clickcheckbox();
		log.info("clicked checkbox");
		rp.clickOccupation();
		log.info("clicked occupation");
		rp.selectOptionByVisibleText(rp.occupation(), "Engineer");
		log.info("selecting Engineer from dropdown");
		Thread.sleep(3000);
		rp.clickRegisterButton();
		log.info("clicked Register button");
		
		Assert.assertEquals(rp.getconfirmationmesg().trim(), "Account Created Successfully");
		log.info("validated Account creating mesgg successfully");
		}
		catch(Exception e)
		{
			log.error("test failed");
			Assert.fail();
		}
		
		log.debug("Ended Application logs");
		log.info("************completed register account verification test******************");
	}

}
