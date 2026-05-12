package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {

	public WebDriver driver;
	public ManageContactPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
    PageUtility manage = new PageUtility();
	
	@FindBy(xpath="//a[@class='btn btn-sm btn btn-primary btncss']") WebElement actionbutton;
	@FindBy(id="phone")  WebElement phonenumber;
	@FindBy(id="email")  WebElement emailaddress;
	@FindBy(id="content") WebElement address;
	@FindBy (name="Update") WebElement updatebutton;
	@FindBy(xpath = "//div[contains(@class,'alert-success')]")  WebElement successMessage;
	
	

	public ManageContactPage actionButton()
	{
		actionbutton.click();
		return this;
	}
	public ManageContactPage enterPhonenNumber(String mobilenumber)
	{
		phonenumber.clear();
		phonenumber.sendKeys(mobilenumber);
		return this;	
	}
	public ManageContactPage enterEmailAddress( String email, String addressfield)
	{
		emailaddress.clear();
		emailaddress.sendKeys(email);
		return this;
		
	}
	public ManageContactPage enterAddress(String addressfield) {
		address.clear();
		address.sendKeys(addressfield);
		return this;
	}
	public ManageContactPage clickUpdatebutton()
	{
		manage.clickjavascript(updatebutton);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].click();", updatebutton);
		return this;
		
	}
	public boolean isUpdateSuccessfully()
	{
		return successMessage.isDisplayed();
	}
	
}