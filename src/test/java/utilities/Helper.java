package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static void TakeScreenShot(WebDriver driver,String ScreenShotName)  
	{
		
		Path dest= Paths.get("./ScreenShots",ScreenShotName+".png");
		try {
			
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
		} catch (IOException e) {
			
			
			System.out.println("exception while taking screen shot" + e.getMessage());
		}
		
		/*if(ITestResult.FAILURE == result.getStatus())
		{
		TakesScreenshot TS = (TakesScreenshot) driver;
		File Source = TS.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Source, new File("./ScreenShots/"+result.getName()+ \".png"));
		}*/
	}

}
