package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		Jse = (JavascriptExecutor) driver;
		Actions =new Actions(driver);
	}
	@FindBy(css="div.dropdown.dropdown-login.dropdown-tab")
	WebElement menu;
	


	public void SelectLogout()
	{
		Clickbutton(menu);
		menu.findElement(By.linkText("Logout")).click();
	
	}

	
	
}
