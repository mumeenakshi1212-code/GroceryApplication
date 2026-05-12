package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.TestNGBase;
import pages.HomePage;
import pages.Loginpage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

@Test
public class ManageContactTest extends TestNGBase {
	
	HomePage homepage1;
	ManageContactPage contactpage;
	
	@Test(description ="user is able to click action button")
	public void verifyWhetherUserIsAbleToclickManageContactButton(String mobilenumber) throws IOException
	{
	 String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
	 String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		homepage1=loginpage.clickLoginButton();		
		
		homepage1.clickcontactmoreinfo();
		
		contactpage.actionButton().enterPhonenNumber(mobilenumber).clickUpdatebutton();
		RandomDataUtility randomdata = new RandomDataUtility();
		contactpage=enterAddress(addressfield);
		String mobilenumber1 = randomdata.mobileNumber();
		String addressfield1 = ExcelUtility.readStringData(0, 0, "Contact Us Informations");
		
		Assert.assertTrue(contactpage.isUpdateSuccessfully(),Constant.contactbutton);
	}

}