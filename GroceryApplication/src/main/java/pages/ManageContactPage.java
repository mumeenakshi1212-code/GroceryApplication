package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	public WebDriver driver;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement editbutton;
	@FindBy(id = "phone")
	WebElement phne;
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailfield;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updatebtn;

	public ManageContactPage clickedit() {
		editbutton.click();
		return this;
	}

	public ManageContactPage clearphe() {
		phne.clear();
		return this;
	}

	public ManageContactPage phne(String newpasswordvalue) {
		phne.sendKeys(newpasswordvalue);
		return this;
	}

	public ManageContactPage clearemail() {
		emailfield.clear();
		return this;
	}

	public ManageContactPage email(String email) {
		emailfield.sendKeys(email);
		return this;
	}

	PageUtility page = new PageUtility();

	public void clickupdate() {
		page.clickjavascript(driver, updatebtn);
		// JavascriptExecutor js = (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", updatebtn);
	}

	public boolean isUpdateSuccessfully() {
		return updatebtn.isDisplayed();
	}

}