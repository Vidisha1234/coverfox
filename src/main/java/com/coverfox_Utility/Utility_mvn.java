package com.coverfox_Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;


public class Utility_mvn {
	
	public static void ss(WebDriver driver , String ssname) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("ddMMyyyy").format( new Date());
		
		File dest =new File(System.getProperty("user.dir")+"\\Coverfox_Screenshots\\"+ ssname+timestamp+".png");
		
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		System.out.println(dest);
		Reporter.log("Taking Screenshot", true);
		
	}
	
		public static String readExcel (String sheetname, int row, int cell) throws EncryptedDocumentException, IOException{
			
			FileInputStream myfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestData\\New Microsoft Excel Worksheet.xlsx");//testdata is folder and new micro is file name
//			FileInputStream myfile = new FileInputStream("D:\\Apache\\New Microsoft Excel Worksheet.xlsx");

			Sheet mysheet = WorkbookFactory.create(myfile).getSheet(sheetname);
           String mydata = mysheet.getRow(row).getCell(cell).getStringCellValue();
            return mydata;
          
		}
		
		public static String readDataFromPropFile(String key) throws IOException {
			
			Properties prop = new Properties();
			FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\cf.properties");
			prop.load(propFile);
			String value = prop.getProperty(key); 
			Reporter.log("Reading data from properties file", true);
			return value;
			
		}
		
		public static void implicitwait(WebDriver driver, int timeInMillis) {
			Reporter.log("waiting for "+timeInMillis, true);
			driver.manage().timeouts().implicitlyWait(Duration.ofMillis(timeInMillis));
			
			
		}
	    } 	



