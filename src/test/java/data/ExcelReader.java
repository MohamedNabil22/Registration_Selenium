package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {

	static FileInputStream fis = null ;
	
	public FileInputStream getfileinputstream()
	{
		
		String FilePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.xlsx";
		File srcfile = new File(FilePath);
		try {
			fis = new FileInputStream(srcfile);
		    } 
		catch (FileNotFoundException e) 
		   {
			System.out.println("test data file not found termenating process:Check file pagth of test data"+e.getMessage());
			System.exit(0);
		   }
		return fis;
	}

	public Object[][] getExcelData() throws IOException
	{
		fis = getfileinputstream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int TotalnumberOfRows= (sheet.getLastRowNum()+1);
		int TotalNumberOfColumns = 6;
		String[][] arrayExcelData = new String[TotalnumberOfRows][TotalNumberOfColumns];

		for(int i=0; i<TotalnumberOfRows ;i++)
		{
			for(int j=0 ; j<TotalNumberOfColumns; j++ )
			{
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
