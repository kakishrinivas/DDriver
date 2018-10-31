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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTesting {
	
	 public String baseUrl = "http://gcrit.com/build3/";
	 String driverPath = "E:/chromedriver.exe";
	 public WebDriver driver; 
    
	@Test(dataProvider ="testdata")
	public void login(String firstname, String lastname,String eaddress,String saddress,String postcode,String city,String state ,String telephone,String password,String confirmation) throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver",driverPath);
	driver = new ChromeDriver();
	
	driver.get(baseUrl);
	driver.findElement(By.linkText("create an account")).click();
	driver.findElement(By.xpath(".//*[@id='bodyContent']/form/div/div[2]/table/tbody/tr[1]/td[2]/input[1]")).click();
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("dob")).sendKeys("10/20/1990");
	driver.findElement(By.name("email_address")).sendKeys(eaddress);
	driver.findElement(By.name("street_address")).sendKeys(saddress);
	driver.findElement(By.name("postcode")).sendKeys(postcode);
	driver.findElement(By.name("city")).sendKeys(city);
	driver.findElement(By.name("state")).sendKeys(state);
	Select Dropdown = new Select (driver.findElement(By.name("country")));
	Dropdown.selectByVisibleText("India");
	driver.findElement(By.name("telephone")).sendKeys(telephone);
	driver.findElement(By.name("password")).sendKeys(password);
	driver.findElement(By.name("confirmation")).sendKeys(confirmation);
	driver.findElement(By.id("tdb4")).click();
	Thread.sleep(1000);
	Assert.assertEquals("Your Account Has Been Created!",driver.findElement(By.xpath(".//*[@id='bodyContent']/h1")).getText());
	driver.close();
	}
	   
	@DataProvider(name ="testdata")
	public Object [] [] readExcel() throws BiffException, IOException {
	File f = new File("C:/Users/Nirnay/Desktop/Test/TestData.xls");
	Workbook w = Workbook.getWorkbook(f);
	Sheet s = w.getSheet("Sheet3");
	int rows = s.getRows();
	int columns = s.getColumns();
	//System.out.println(rows);
	//System.out.println(columns);

	String inputData [] [] = new String [rows-1] [columns];
	
	for (int i=1; i<rows; i++){
	    for (int j=0; j<columns; j++){
	    Cell c = s.getCell(j, i);
	    inputData [i-1][j] = c.getContents();
	    //System.out.println(inputData[i][j]);
	}
	}
	
	return inputData;
	}
	}

