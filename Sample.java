package inputData;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com"); 
        driver.manage().window().maximize(); 

            FileInputStream file = new FileInputStream("C:\\Dhiman\\Automation\\seleniumtest.xls"); 
            HSSFWorkbook workbook = new HSSFWorkbook(file);
            HSSFSheet sheet = workbook.getSheetAt(0);
            int noOfColumns = sheet.getRow(0).getLastCellNum();
            //System.out.println(noOfColumns);
            String[] Headers = new String[noOfColumns];
            for (int j=0;j<noOfColumns;j++){
                Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
            }
                for (int a=0;a<noOfColumns;a++){
                    if(Headers[a].equals("Address")){
                        driver.findElement(By.id("lst-ib")).sendKeys(sheet.getRow(1).getCell(a).getStringCellValue());
                        break;
                        }
}
      workbook.close();
      file.close();
      driver.close();
      System.exit(0);
            }
}
