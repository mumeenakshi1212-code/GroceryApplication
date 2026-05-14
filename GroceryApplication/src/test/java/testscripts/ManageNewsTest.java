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
import utilities.RandomDataUtility;

public class ManageNewsTest extends TestNGBase {

	HomePage homepage1;
	ManageNewsPage managenews;

	@Test(description = "User is able to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		homepage1 = loginpage.clickLoginButton();
		managenews = homepage1.clickOnMoreInfoNews();

		String usernamevalue1 = ExcelUtility.readStringData(0, 0, "ManageNews");
		managenews.clickNewButton().addnewsinfield(usernamevalue1).clickOnAdd();

		Assert.assertTrue(managenews.isalertDisplayed(), Constant.addnews);
	}

	@Test(description = "user is able to search added news")
	public void verifyWhetherUserISAbleToSearchTheAddedNews() throws IOException {
		String usernamevalue1 = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue1 = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage1 = new Loginpage(driver);
		loginpage1.verifyValidUsernameonUsernamefield(usernamevalue1)
				.verifyValidPasswordonPasswordfield(passwordvalue1);
		homepage1 = loginpage1.clickLoginButton();
		managenews = homepage1.clickOnMoreInfoNews();

		RandomDataUtility randomdata = new RandomDataUtility();

		managenews.clickSearch().clickSearchnews();

		boolean alertDisplayed = managenews.isalertDisplayed();
		Assert.assertTrue(alertDisplayed, Constant.searchnews);

	}

}
