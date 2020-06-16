package tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase{
	
	HomePage HomepageObject ;
	LoginPage LoginPageObject;
	
	@Test
	public void testloginpage() throws InterruptedException
	{
		HomepageObject = new HomePage(driver);
		//HomepageObject.openrLoginPage();
		LoginPageObject =new LoginPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		LoginPageObject.LogintoURAccount("kieta@gmail.com", "123456");
		Thread.sleep(2000);
	   // HomepageObject.SelectLogout();
	}

}
