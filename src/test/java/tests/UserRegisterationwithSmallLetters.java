package tests;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegisterationPage;


public class UserRegisterationwithSmallLetters extends TestBase{

	HomePage HomeObject;


	@DataProvider(name ="ExcelData")
	public  Object[][] userRegisteData() throws IOException 
	{
		//get Get Data from Excel reader
		ExcelReader ER = new ExcelReader();
		return ER.getExcelData();
	}
	@Test(priority=1, dataProvider="ExcelData")
	public void usercanregistersuccessfully(String Fname,String Lname,String Mobile,String Email,String Password,String ConfirmPassword) throws InterruptedException
	{

		HomeObject = new HomePage(driver);
		UserRegisterationPage Registerobject;
		Registerobject = new UserRegisterationPage(driver);
		Registerobject.userRegisteration(Fname,Lname,Mobile,Email,Password,ConfirmPassword);
		Thread.sleep(3000);
		System.	out.println(driver.getCurrentUrl().toString());
		Assert.assertFalse(driver.getCurrentUrl().contains("https://www.phptravels.net/account/"));
		
	}





}
