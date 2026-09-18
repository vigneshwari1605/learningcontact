package genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	FileInputStream fis;
	FileOutputStream fos;
	public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception {
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		
	}
	public int getRowCount( String sheetName) throws Exception {
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getPhysicalNumberOfRows();	
	}
	public int getCellCount( String sheetName) throws Exception {
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();	
	}
	public void writeDataInExcistingCell(String sheetName, int rowNum, int cellNum, String value) throws Exception {
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(value);
		fos=new FileOutputStream("./src/test/resources/vtiger.xlsx");
		wb.write(fos);
	}
	public void writeDataInNewCell(String sheetName, int rowNum, int cellNum, String value) throws Exception {
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
		fos=new FileOutputStream("./src/test/resources/vtiger.xlsx");
		wb.write(fos);
	}
	public String formatedDataFromExcell(String
			sheetName, int rowNum, int cellNum) throws Exception {
		DataFormatter df=new DataFormatter();
		fis=new FileInputStream("./src/test/resources/vtiger.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		return df.formatCellValue(wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum));
	}
	
}
