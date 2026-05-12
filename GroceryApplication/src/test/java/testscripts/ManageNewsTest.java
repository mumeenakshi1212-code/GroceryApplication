package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.TestNGBase;
import pages.HomePage;
import pages.Loginpage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase {
	
	HomePage homepage1 ;
	ManageNewsPage managenews ;
	@Test (description = "User is able to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
			Loginpage loginpage = new Loginpage(driver);
			loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
			homepage1=loginpage.clickLoginButton();	
			homepage1.clickOnMoreInfoNews();
			managenews.clickNewButton().addnewsinfield("new news headlines").clickOnAdd();
			Assert.assertTrue(managenews.isalertDisplayed(),Constant.addnews);
	               
	    String usernamevalue1 = ExcelUtility.readStringData(0, 0, "LoginPage");
	    String passwordvalue1 = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage1 = new Loginpage(driver);
		loginpage1.verifyValidUsernameonUsernamefield(usernamevalue1).verifyValidPasswordonPasswordfield(passwordvalue1);
		homepage1=loginpage1.clickLoginButton();
		
	
		
		
	}

}
