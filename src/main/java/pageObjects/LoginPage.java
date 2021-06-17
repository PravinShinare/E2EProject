package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By EmailAddress = By.id("user_email");
	private By Password = By.cssSelector("input[type='password']");
	private By Login = By.cssSelector("input[value='Log In']");
	private By ForgotPassword = By.cssSelector("[href*='password/new']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getEmailAddress()
	{
		return driver.findElement(EmailAddress);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(Password);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(Login);
	}
	
	public ForgotPasswordPage ForgotPassword()
	{
		driver.findElement(ForgotPassword).click();
		ForgotPasswordPage fp = new ForgotPasswordPage(driver);
		return fp;

	}
	

}
