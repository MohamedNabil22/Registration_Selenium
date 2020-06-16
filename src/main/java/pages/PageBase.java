package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
public class PageBase {
	
	protected static WebDriver driver;
	public static JavascriptExecutor  Jse ;
	public  Actions Actions;
	
	public  PageBase(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public static void Clickbutton(WebElement button)
	{
		button.click();
	}
	
	public static void SetTextElementText(WebElement TextBox , String Text)
	{
		TextBox.sendKeys(Text);
	}
	
	public static void ScrollToBottom()
	{
		Jse.executeScript("scrollBy(0,1500)");
	}
	public static void SelectOptionbyName(WebElement DropDownList, String Name)
	{
		Select Option = new Select(DropDownList);
		Option.selectByVisibleText(Name);
	}
	

 }


