package testscripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import mainproject.TestNGBase;
import pages.AdminUserPage;
import pages.HomePage;
import pages.Loginpage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase {

	HomePage homepage;

	@Test
	public void verifyUserLogout() throws IOException {
		String usernamevalue = ExcelUtility.readStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.readStringData(0, 1, "LoginPage");
		Loginpage loginpage = new Loginpage(driver);
		loginpage.verifyValidUsernameonUsernamefield(usernamevalue).verifyValidPasswordonPasswordfield(passwordvalue);
		homepage = loginpage.clickLoginButton();

		homepage.clickOnadminButton();
		loginpage = homepage.clickOnLoginoutButton();

		String expected = "7rmart supermarket";
		String actual = loginpage.isTitleDisplayed();
		Assert.assertEquals(actual, expected, "user is unable to login out");
	}

}
