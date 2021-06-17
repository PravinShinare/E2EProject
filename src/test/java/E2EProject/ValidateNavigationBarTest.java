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

public class ValidateNavigationBarTest extends Base{
	public WebDriver driver;
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
	}
	
	
	@Test
	public void ValidateNavigationBar() throws IOException
	{
		LandingPage lp = new LandingPage(driver);
		//validate the Navigation Bar available or not.
		Assert.assertTrue(lp.getNavBar().isDisplayed());
		log.info("Navigation bar is displayed");
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		log.info("Browser is closed and Test is ended");
	}

}
