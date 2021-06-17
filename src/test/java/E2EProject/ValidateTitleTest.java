package E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitleTest extends Base{
	public WebDriver driver;
	LandingPage lp;
	public static Logger log =LogManager.getLogger(Base.class.getName());	
	@BeforeTest
	public void intialize() throws IOException
	{
		//Create driver object and call the initialize method.
		driver=intializeDriver();
		log.info("Driver is Initialized");

		//enter URL in the browser.
		driver.get(prop.getProperty("url")); 
		log.info("navigated on Home Page successfully");
		log.info("Git Demo Changes");
		log.info("Git Demo Changes");
	}
	
	@Test
	public void ValidateTitle() throws IOException
	{
		lp = new LandingPage(driver);
		
		//validate the page title value matches with actual value.
		Assert.assertEquals(lp.getPageTitle().getText(), "FEATURED COURSES");
		log.info("Home page title verified successfully");
		
	}
	
	@Test
	public void ValidateHeader() throws IOException
	{
		lp = new LandingPage(driver);
		//validate the page header value matches with actual value.
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("Home page header verified successfully - Achived clubbing multiple test in same class");
		
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser is closed and Test is ended");
	}



}
