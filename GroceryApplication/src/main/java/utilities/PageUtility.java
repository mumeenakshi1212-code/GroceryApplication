package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {// its a page helper class

	public WebDriver driver;

	public void selectDragDropWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
	}

	public void selectDragDropWithIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
	}

	public void selectvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public boolean selectRadiobutton(WebElement radiobutton) {
		return radiobutton.isSelected();

	}

	public void clickjavascript(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void alertconfirmation(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	public void alertcancel(WebDriver driver) {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

}
