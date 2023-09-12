package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class xlsDataReader {
	public static String filePath = System.getProperty("user.dir")+"/src/test/resources/testData/SeleniumTestData.xlsx";
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		xlsDataReader reader = new xlsDataReader();
		reader.getData("login");
	}
	
	public String[][] getData(String excelSheetName) throws EncryptedDocumentException, IOException {
		File f = new File(filePath);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(excelSheetName);
		
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
