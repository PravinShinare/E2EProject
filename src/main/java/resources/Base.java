package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public WebDriver driver;
	public Properties prop; 
	public String projectPath;
	public WebDriver intializeDriver() throws IOException
	{
		//Extract the browser name from the data properties file. 
		prop = new Properties();
		projectPath = System.getProperty("user.dir");
		FileInputStream file = new FileInputStream(projectPath+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		String browserName;
		//set browser parameter from maven execution.
		if(System.getProperty("browser")!=null)
		{
			browserName = System.getProperty("browser");
		}
		else
		{
			browserName = prop.getProperty("browser");
		}

		
		//Set browser properties and load the browser
		if(browserName.contains("chrome"))
		{
			//Load chrome driver
			System.setProperty("webdriver.chrome.driver", projectPath+"\\dependencies\\chromedriver.exe");
			
			//headless test execution
			ChromeOptions options= new ChromeOptions();
			if(browserName.contains("headless"))
			{
			options.addArguments("headless");  //assign headless execution object to the browser driver
			driver = new ChromeDriver(options);
			}
			else {
			driver = new ChromeDriver(options);
			}
			
			driver.manage().window().maximize();
		}
		else if(browserName.equals("IE"))
		{
			//load internet explorer browser
			System.setProperty("webdriver.ie.driver", projectPath+"\\dependencies\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		else if(browserName.equals("firefox"))
		{
			//load firefox browser
			System.setProperty("webdriver.gecko.driver", projectPath+"\\dependencies\\chromedriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		//apply implicit wait to wait 20 second before fail any test
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = projectPath+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile; 
				
	}

}
