package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	PageUtility page = new PageUtility();

	// new user actions
	@FindBy(xpath = "//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']")
	WebElement newuser;
	@FindBy(xpath = "//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']")
	WebElement newButnClick;
	@FindBy(id = "username")
	WebElement adminusername1;
	@FindBy(id = "password")
	WebElement adminpassword1;
	@FindBy(id = "user_type")
	WebElement userTypeDropdown;
	@FindBy(name = "Create")
	WebElement saveButton;

	// search button actions
	@FindBy(xpath = "//a[@href='javascript:void(0)'and@class='btn btn-rounded btn-danger']")
	WebElement searchButton;
	@FindBy(id = "un")
	WebElement enterusrname;
	@FindBy(id = "ut")
	WebElement usertype;
	@FindBy(name = "Search")
	WebElement search;

	public AdminUserPage newButnClick() {
		newButnClick.click();
		return this;
	}

	public AdminUserPage enterUserName(String adminusername) {
		adminusername1.sendKeys(adminusername);
		return this;
	}

	public AdminUserPage enterUserPassword(String adminpassword) {
		adminpassword1.sendKeys(adminpassword);
		return this;
	}

	public AdminUserPage userTypeDropdown() {
		page.selectDragDropWithIndex(userTypeDropdown, 1);
		// Select select = new Select(userTypeDropdown);
		// select.selectByIndex(1);
		return this;
	}

	public AdminUserPage clickSaveButton() {
		saveButton.click();
		return this;
	}

//Search function
	public AdminUserPage clickSearchButton() {
		searchButton.click();
		return this;
	}

// Enter username
	public AdminUserPage enterUsername(String adminvalue) {

		enterusrname.sendKeys(adminvalue);
		return this;
	}

	public AdminUserPage enterUserType() {
		page.selectDragDropWithIndex(usertype, 1);
		// Select object = new Select(usertype);
		// object.selectByIndex(1);
		return this;
	}

// Click search submit
	public AdminUserPage clickSearchButtn() {
		search.click();
		return this;
	}

	public String getAlertMessage() {
		WebElement alertmessage = null;
		return alertmessage.getText();
	}

	public String getSearchResultUserName() {

		return null;
	}

}
