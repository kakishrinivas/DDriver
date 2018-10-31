package testNG;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	public WebDriver driver;
	@Test(dataProvider ="testdata")
	public void login(String email, String password){
	System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();	
	driver.get("http://www.gcrit.com/build3/login.php");
	driver.findElement(By.name("email_address")).sendKeys(email);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.id("tdb5")).click();
	Assert.assertEquals("http://www.gcrit.com/build3/index.php",driver.getCurrentUrl());
	driver.close();
	}
	   
	@DataProvider(name ="testdata")
	public Object [] [] readExcel() throws BiffException, IOException {
	File f = new File("C:/Users/Nirnay/Desktop/Test/TestData.xls");
	Workbook w = Workbook.getWorkbook(f);
	Sheet s = w.getSheet("Sheet1");
	int rows = s.getRows();
	int columns = s.getColumns();
	//System.out.println(rows);
	//System.out.println(columns);

	String inputData [] [] = new String [rows-1] [columns];
	for (int i=1; i<rows; i++){
	    for (int j=0; j<columns; j++){
	    Cell c = s.getCell(j, i);
	    inputData [i-1][j] = c.getContents();
	    System.out.println(inputData[i-1][j]);
	}
	}
	return inputData;
	}
	}

