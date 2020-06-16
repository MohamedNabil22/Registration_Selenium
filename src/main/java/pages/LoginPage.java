package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[3]/div[1]/label/input")
	WebElement Emaillogin;

	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[3]/div[2]/label/input")
	WebElement Passwordlogin;

	@FindBy(css="button.btn.btn-primary.btn-lg.btn-block.loginbtn")
	WebElement LoginButton;

	@FindBy(css="a.btn.btn-success.br25.btn-block.form-group")
	WebElement RegisterNewAccount;

	@FindBy(css="h3.text-align-left")
	public WebElement successLogin;



	public void LogintoURAccount(String Email,String Password) throws InterruptedException
	{
		SetTextElementText(Emaillogin, Email);
		SetTextElementText(Passwordlogin, Password);
		Thread.sleep(3000);
		Clickbutton(LoginButton);
		
	}
	public void RegisterNewAccount()
	{
		Clickbutton(RegisterNewAccount);
	}

}
