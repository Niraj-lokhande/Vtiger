package commonUtils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("src\\\\test\\\\resources\\\\vtigerData.xlsx");
		Workbook wb = WorkbookFactory.create(fis) ;
		Sheet sh1 = wb.getSheet(sheetName) ;
		Row r1 = sh1.getRow(rowNum);
		Cell c1 = r1.getCell(cellNum) ;
		String value = c1.getStringCellValue() ;
		
		return value ;
	}
}
