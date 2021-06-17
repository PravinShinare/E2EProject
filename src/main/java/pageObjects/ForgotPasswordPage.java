package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
	public WebDriver driver;
	
	private By EmailAddress = By.cssSelector("[id='user_email']");	
	private By SendMeInstruction = By.cssSelector("[type='submit']");
	
	public ForgotPasswordPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement EmailAddress()
	{
		return driver.findElement(EmailAddress);
	}
	
	public WebElement SendMeInstruction()
	{
		return driver.findElement(SendMeInstruction);
	}

}
