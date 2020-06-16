package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;


public class TestBase {
	
	public static WebDriver driver ;
	
	@BeforeTest
	@Parameters(("browser"))
	public void startdriver(@Optional("chrome") String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		String chromevalue = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromevalue);
		driver = new ChromeDriver();
		
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			String Firefox_value= System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", Firefox_value);
		 driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("ie"))
		{
			String IE_value= System.getProperty("user.dir")+"\\resources\\IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IE_value);
			 driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.phptravels.net/register");
	 
	       
	}
	//Take Screen shot when test case Faile and add it in the Screen shot folder
	@AfterMethod
	public void takescreenshots(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			System.out.println("Failed");
			System.out.println("Taking ScreenShot...");
			Helper.TakeScreenShot(driver, result.getName());
		}
	
	
	}
	
	
	@AfterTest
	public void Stopdriver()
	{
		driver.quit();
	}
	
	

}
