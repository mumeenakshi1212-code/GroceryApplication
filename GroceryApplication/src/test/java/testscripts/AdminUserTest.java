package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.TestNGBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminUserTest  extends TestNGBase {
	
	HomePage homepage;
	AdminUserPage adminuserpage;


	@Test(description = "user is able to add new adminuser")
	public void verifyWhetherUserIsAbleToAddNewAdminUser() throws IOException
	{
	 String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
	 String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		homepage=loginpage.clickLoginButton();	
	    adminuserpage=homepage.clickOnMoreInfo();
		RandomDataUtility randomdata = new RandomDataUtility();
		String adminusername = randomdata.randomusername();
	    String adminpassword = randomdata.randomPassword();
	    adminuserpage.newButnClick().enterUserName(adminusername).enterUserPassword(adminpassword).userTypeDropdown().clickSaveButton(); 
	    String actualMessage = adminuserpage.getAlertMessage();
	    Assert.assertEquals(actualMessage, Constant.newadminuser);
}
	
	@Test(description ="user is able to search adduser")
	public void verifyWhetherUserIsAbleToSearchTheAddedUser() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
			homepage=loginpage.clickLoginButton();	
		    adminuserpage=homepage.clickOnMoreInfo();
			AdminUserPage adminuserpage = new AdminUserPage(driver);
			String adminvalue = ExcelUtility.readStringData(0, 0, "AdminPage");
		    adminuserpage.clickSearchButton().enterUsername(adminvalue).enterUserType().clickSearchButtn();
		    String actualUsername = adminuserpage.getSearchResultUserName();
		    Assert.assertEquals(actualUsername, Constant.newadduser,
		            "Searched user is not displayed");
		    
	}
}
