package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainproject.TestNGBase;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	
	HomePage home;
	
@Test(priority=1,description="User is Trying to Login With Valid Credentials",groups= {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
	 String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
	 String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		home=loginpage.clickLoginButton();	
		
		//assertion functioning
		boolean dashboarddisplayed = loginpage.isDashboardDisplayed();
		Assert.assertTrue(dashboarddisplayed,Constant.validcredentialerror);
	}

@Test(priority=2,description=" User is Trying to Login With  inValid username",retryAnalyzer=retry.Retry.class)
public void verifyUserLoginWithInvalidUserName() throws IOException
{
	 String usernamevalue = ExcelUtility.readStringData(1, 0, "LoginPage");
	 String passwordvalue = ExcelUtility.readStringData(1, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();	
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.invalidcredentialerror);
}

@Test(priority=3,description="user is trying to login with invalid password")
public void verifyUserLoginWithInavlidPassword() throws IOException
{
	 String usernamevalue = ExcelUtility.readStringData(2, 0, "LoginPage");
	 String passwordvalue = ExcelUtility.readStringData(2, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();	
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.invalidcredentialerror);
}

@Test(priority=4,description = "user is trying to login with invalid credentials",groups= {"smoke"},dataProvider="loginProvider")
public void verifyUserLoginWithInvalidCredentials(String usernamevalue,String passwordvalue) throws IOException
{
	// String usernamevalue = ExcelUtility.readStringData(3, 0, "LoginPage");
	 //String passwordvalue = ExcelUtility.readStringData(3, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue).clickLoginButton();	
		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected,Constant.invalidcredentialerror);
}

@DataProvider(name="loginProvider")
public Object[][] getDataFromDataProvider() throws IOException{
		
	return new Object[][] {new Object[] {"admin","admin22"},new Object[] {"admin12","123"},
		// new Object[] (ExcelUtility.getStringData(3,
		//0,"Login"),ExcelUtility.getStringData(3,2,"Login")}
	
};
}
}
