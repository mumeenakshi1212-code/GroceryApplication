package mainproject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;


public class TestNGBase {
	Properties prop;
	FileInputStream file;
	
		public WebDriver driver;
		@BeforeMethod(alwaysRun=true)
		@Parameters("browsers")
	
		public void initializeBrowser(String browser) throws IOException {
			try {
				
			
			prop=new Properties();
			file=new FileInputStream(Constant.configfile);
			prop.load(file);
			} catch(Exception e)
			{
				System.out.println(e);
			}
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver();
				driver=new EdgeDriver();
			}
			 // initialize web driver (CHROME HERE)
		//	driver=new FirefoxDriver(); call browser Fire fox
		  //  driver=new EdgeDriver();
		/*	WebDriverManager.edgedriver() .clearResolutionCache()
			 .forceDownload().setup();
			driver= new EdgeDriver();*/
			//driver.get("https://groceryapp.uniqassosiates.com/admin/login/");//get the page in minimized form
			driver.get(prop.getProperty("url"));
			driver.manage().window().maximize();//to maximize the window
			}
		@AfterMethod(alwaysRun=true)
		public void closeBrowser(ITestResult itestresult) throws IOException{
			if(itestresult.getStatus()==ITestResult.FAILURE) {
				ScreenshotUtility screenshotutility=new ScreenshotUtility();
				screenshotutility.getScreenshot(driver, itestresult.getName());
			}
			 // driver.close();
			//driver.quit();
		}

			}


