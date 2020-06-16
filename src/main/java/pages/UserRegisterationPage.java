package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;




public class UserRegisterationPage extends PageBase{

	public UserRegisterationPage(WebDriver driver) {
		super(driver);
		Jse = (JavascriptExecutor) driver;
	}

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[3]/div[1]/div/label/input")
	WebElement FirstNameTxtbox;

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[3]/div[2]/div/label/input")
	WebElement LastNameTxtbox;

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[4]/label/input")
	WebElement MobileTxtBox;

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[5]/label/input")
	WebElement EmailIDTxtBox;

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[6]/label/input")
	WebElement PasswordTxtBox;

	@FindBy(xpath="//*[@id=\"headersignupform\"]/div[7]/label/input")
	WebElement ConfirmPasswordTxtBox;

	@FindBy(css="button.signupbtn.btn_full.btn.btn-success.btn-block.btn-lg")
	WebElement Registerbutton;

	@FindBy(css="div.resultsignup")
	public WebElement AlreadyExistLabel;


	@FindBy(linkText="Home")
	public WebElement SuccessHomeMessage;

	public void workingwithJavaSCRIPTCODE() throws InterruptedException
	{
		JavascriptExecutor Js2 = (JavascriptExecutor) driver;
		Js2.executeScript("scrollBy(0,3000)");
		Thread.sleep(3000);

	}
	public void CLickRegisteButton()
	{
		Actions.moveToElement(Registerbutton).click().build().perform();
	}
	
	public void userRegisteration(String firstname,String lastname,String Mobile,String Email,String Password,String ConfirmPassword) throws InterruptedException
	{

		SetTextElementText(FirstNameTxtbox, firstname);
		SetTextElementText(LastNameTxtbox, lastname);
		SetTextElementText(MobileTxtBox, Mobile);
		SetTextElementText(EmailIDTxtBox, Email);
		SetTextElementText(PasswordTxtBox, Password);
		SetTextElementText(ConfirmPasswordTxtBox, ConfirmPassword);
		Jse.executeScript("scrollBy(0,300)");
		try {
			Clickbutton(Registerbutton);
		}
		
		catch(NullPointerException e)
		{
			System.out.println(Registerbutton.getTagName().toString());
		}
	}
	public void ClearTextData()
	{
		FirstNameTxtbox.clear();
		LastNameTxtbox.clear();
		MobileTxtBox.clear();
		EmailIDTxtBox.clear();
		PasswordTxtBox.clear();
		ConfirmPasswordTxtBox.clear();
		
	}

}
