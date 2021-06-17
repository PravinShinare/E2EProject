package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.tools.sjavac.Log;

import pageObjects.ForgotPasswordPage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.SubscriptonPage;
import resources.Base;

public class LoginTest extends Base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());	
	
	@BeforeTest
	public void intialize() throws IOException
	{
		//Create driver object and call the initialize method.
		driver=intializeDriver();
		log.info("Driver is Initialized");

	}
	
	@Test(dataProvider = "loginData")
	public void LoginPage(String userName, String Password) 
	{

		//enter URL in the browser.
		driver.get(prop.getProperty("url")); 
		log.info("navigated on Home Page successfully");
		//create Suscription popup Page class object and click on the 'X' icon.		
		//SubscriptonPage sbpopup = new SubscriptonPage(driver);
		//sbpopup.closeSubscriptionPopUp().click();
		//create Landing page class object and click on the signin button. 
		LandingPage lp = new LandingPage(driver);
		
		LoginPage login = lp.getLogin();
		log.info("Sign in linked clicked");
		
		//Create Login page object and access the methods. Do login to application.
		login.getEmailAddress().sendKeys(userName);
		log.info("Email address is entered successfully");
		
		login.getPassword().sendKeys(Password);
		log.info("Password is entered Successfully");
		
		login.getLogin().click();
		log.info("Login Button clicked");
		
		//Click on forgot to password page Link.
		ForgotPasswordPage fp = login.ForgotPassword();
		fp.EmailAddress().sendKeys(userName);
		Log.info("Username is entered");
		fp.SendMeInstruction().click();
		Log.info("Send me instruction is clicked");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser is closed and Test Demo is ended");
	}

	
	@DataProvider
	public Object[][] loginData()
	{
		//rows with how many type of data
		//column stands for the how many columns per test
		Object[][] data=new Object[2][2];
		
		//First User
		data[0][0]="validuser@gmail.com";
		data[0][1]="ValidUserPassword";
		
		//Second User
		data[1][0]="Invaliduser@gmail.com";
		data[1][1]="InValidUserPassword";
		
		return data;
		
	}

}
