package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubscriptonPage {
	public WebDriver driver;
	private By closePopUp = By.cssSelector("[class='sumome-react-svg-image-container']");
	
	
	public SubscriptonPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement closeSubscriptionPopUp()
	{
		return driver.findElement(closePopUp);
	}

}
