package utilities;

import java.io.File;
import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import data.ExcelReader;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignUpAPIRequest {

    
    private  OkHttpClient httpClient = new OkHttpClient();

    @DataProvider(name = "ExcelData")
    public  Object[][] userRegisteData() throws IOException 
	{
		//get Get Data from Excel reader
      ExcelReader ER = new ExcelReader();
      return ER.getExcelData();
    }
   
    

    @Test(priority=1, dataProvider= "ExcelData")
    private void sendPost(String Fname,String Lname,String Mobile,String Email,String Password,String ConfirmPassword) throws IOException {

        // form parameters
    	 RequestBody formBody = new FormBody.Builder()
                 .add("firstname", Fname)
                 .add("lastname", Lname)
                 .add("phone",  Mobile)
                 .add("email", Email)
                 .add("password", Password)
                 .add("confirmpassword", ConfirmPassword)
                 .build();

        Request request = new Request.Builder()
                .url("https://www.phptravels.net/account/signup")
                .addHeader("content-type", "text/plain")
                .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; ) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36")
                .post(formBody)
                .build();
        
      
        Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            {
            // Get response body
            System.out.println("Response body is : "+ response.body().toString());
            System.out.println("Response Code is : "+ response.code());
            
            String responseAsString = response.toString();
          
    		// Creating a target file
    		String filepath = System.getProperty("user.dir")+"/src/test/java/data/targetFileForString.txt";
    		File targetFileForString = new File(filepath);
    		// Writing into files
    		Files.writeFile(responseAsString, targetFileForString);
     
            }
            
           
    			    
    		
    }

}