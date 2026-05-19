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

	HomePage home;
	ManageContactPage contactpage;

	@Test(description = "user is able to click action button")
	public void verifyWhetherUserIsAbleToclickManageContactButton() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue)
				.clickLoginButton();
		contactpage = home.clickcontactmoreinfo();
		RandomDataUtility random = new RandomDataUtility();
		String newpasswordvalue = random.mobileNumber();
		String newemail = random.randomemail();
		contactpage.clickedit().clearphe().phne(newpasswordvalue).clearemail().email(newemail).clickupdate();
		Assert.assertTrue(contactpage.isUpdateSuccessfully(), Constant.contactbutton);
	}

}