 package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExcelUtils {
	   public static File fis = null;
	   public static FileInputStream read_file=null;
	    public static FileOutputStream fos = null;
	    public static XSSFWorkbook workbook = null;
	    public static XSSFSheet sheet = null;
	    public static XSSFRow row = null;
	    public static XSSFCell cell = null;
		static WebDriver driver;
	    static String xlFilePath="G:\\GIRI\\Selenium\\sample2.xlsx";

	    /************** Take screenshot ****************/
		public static void takeScreenShot(String filepath) {
			TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
			File srcFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(filepath);
			try {
				FileUtils.copyFile(srcFile, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/************** Write a single dimensional array to excel sheet ****************/
		public static void writeExcel(String[] data, String sheetName,
				String heading) {
			String[][] newData = new String[data.length][1];
			String[] headings = new String[1];
			headings[0] = heading;
			for (int i = 0; i < data.length; ++i) {
				newData[i][0] = data[i];
			}
			writeExcel(newData, sheetName, headings);
		}

		/************** Write a double dimensional array to excel sheet ****************/
		 public static void writeExcel(String[][] data, String sheetName,String headings[]) {		
				fis = new File(xlFilePath);
				boolean fileExists = false;
				try {
							//Checking if output excel file already exists
					if (fis.isFile()) {		
						//Read existing excel workbook
						read_file = new FileInputStream(fis);
						workbook = new XSSFWorkbook(read_file);
						fileExists = true;
					} else {		
						//Create new excel workbook
						workbook = new XSSFWorkbook();
					}
					int rowStart = 0;		
					//Checking if sheet already exists
					if (workbook.getSheet(sheetName) == null)			
						//Creating new sheet, setting row start to first cell
						sheet = workbook.createSheet(sheetName);
					else{		
						//Getting required sheet, setting row to last empty cell
						sheet = workbook.getSheet(sheetName);
						rowStart = sheet.getLastRowNum()+2;
					}					
//					//Setting headings for the output data
					row = sheet.createRow(rowStart);
					for (int i = 0; i < data[0].length; ++i) {
						row.createCell(i).setCellValue(headings[i]);
					}					
					//Writing data to the sheet
					for (int i = 0; i < data.length; ++i) {
						row = sheet.createRow(i +rowStart+ 1);
						for (int j = 0; j < data[0].length; ++j) {
							row.createCell(j).setCellValue(data[i][j]);
						}
					}				
					//Auto resize each column
					for (int i = 0; i < data[0].length; ++i) {
						sheet.autoSizeColumn(i);
					}					
					//Writing workbook to required file
					fos = new FileOutputStream(xlFilePath);
					workbook.write(fos);					
					//Closing FileInputStream, FileOutputStream and XSSFWorkbook
					fos.close();
					workbook.close();
					if (fileExists)
						read_file.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
}
