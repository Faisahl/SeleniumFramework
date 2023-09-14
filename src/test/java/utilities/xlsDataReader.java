package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class xlsDataReader {
	public static String filePath = System.getProperty("user.dir")+"/src/test/resources/testData/SeleniumTestData.xlsx";
	
	@DataProvider(name="xldata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException 
	{
		String xlSheetName = m.getName();
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(xlSheetName);
		
		int tRows = sheet.getLastRowNum();
		Row rows = sheet.getRow(0);
		int tCols = rows.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		String testData[][] = new String[tRows][tCols];
		
		for(int i = 1; i <= tRows; i++) {
			for(int j = 0; j < tCols; j++) {
				testData[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));
//				System.out.println(testData[i-1][j]);
			}
		}
		return testData;
	}
	
	
	
}
