package TestNG.Data_driven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class readExcel {
	
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	@SuppressWarnings("deprecation")
	@Test
	public void fblogin() throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ak398\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.MILLISECONDS);
		
		//import excel sheet
		
		File src = new File("C:\\Users\\ak398\\eclipse-workspace\\Data-driven\\TestData.xlsx");
		
		//load the file
		
		FileInputStream fis = new FileInputStream(src);
		
		//load the workbook
		workbook = new XSSFWorkbook(fis);
		
		//Access my sheet from the workbook
		sheet = workbook.getSheetAt(0);
		
		for(int i = 1;i<=sheet.getLastRowNum();i++) {
			//import the data for email
			cell = sheet.getRow(i).getCell(0);
			
			driver.findElement(By.xpath("//input[@name='email']")).clear();
			
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys(cell.getStringCellValue());
			
			//import the data for password
			cell = sheet.getRow(i).getCell(1);
			
			driver.findElement(By.xpath("//input[@id='pass']")).clear();
			
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(cell.getStringCellValue());
		}
		
		
	}

}
