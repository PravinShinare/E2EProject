package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	private By SignIn = By.linkText("Login");
	private By PageTitle = By.cssSelector("div[class='text-center']");	
	private By NavBar = By.cssSelector(".nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div[class*='video-banner'] h3");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}


	public LoginPage getLogin()
	{
		driver.findElement(SignIn).click();
		return new LoginPage(driver);
	}
	
	public WebElement getPageTitle()
	{
		return driver.findElement(PageTitle);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(NavBar);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}

}
