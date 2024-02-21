package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDTTestCase extends BaseClass{
	
	LoginPage lp;
	HomePage hp;
	
	@Test(dataProvider="dp" ,dataProviderClass=DataProviders.class, groups = {"master"})
	public void LoginDDT(String email, String password, String expres, String exestatus) throws IOException
	{
		
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		
		if(exestatus.equalsIgnoreCase("Y")) {
		
		log.info("*********Started Login DDT*************");
		try {
		lp.inputUsername(email);
		log.info("Entered username");
		lp.inputPassword(password);
		log.info("Entered password");
		lp.clickLoginBtn();
		log.info("clicked on login button");
		
		boolean targetpage = hp.isDisplay();
		
		if(expres.equalsIgnoreCase("valid")) {
			
			if (targetpage==true)
			{
				hp.clickSignOutBtn();
				Assert.assertTrue(true);
				log.info("logged in successfully");
			}
			else
			{
				Assert.fail();
				log.info("logged in successfully bt target page not found");
			}
		}
		else if(expres.equalsIgnoreCase("Invalid")){
			
			if(targetpage==true)
			{
				hp.clickSignOutBtn();
				Assert.fail();
				log.info("invalid log in");
			}
			else
			{
				Assert.assertTrue(true);
				log.info("invalid credentials");
			}
		}

	} catch (Exception e) {
		Assert.fail();
	}	
	}
	else
	{
		log.info("Please select execution status as Y in excel for the data to execute");
		Assert.fail();
	}
	}
}
