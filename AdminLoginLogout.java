package testNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import dataProvider.TestBase;

public class AdminLoginLogout extends TestBase {
	static String browser;
	public static WebDriver driver;

	@Test (priority=1)
	public void launchBrowser() throws IOException{
		String browserdriver=getObject("browserdriver");
		String driverpath=getObject("driverpath");
		System.setProperty(browserdriver,driverpath);
		String browser=getObject("browser");
		if(browser.contains("InternetExplorer")){

			driver = new InternetExplorerDriver();	
		}
		if(browser.contains("Chrome")){

			driver = new ChromeDriver();	
		}

	}


	@Test (priority=8)
	public void closeBrowser(){
		driver.close();
	}

	@Test (priority=3)
	public void launchApp() throws IOException{
		String url=getObject("url");
		driver.get(url);
		System.out.println("Application Launched Successfuly(Title) :"+ driver.getTitle());

	}
	@Test (priority=4)
	public void enterUname() throws IOException{
		String username=getObject("username");
		WebElement uname = driver.findElement(By.name("username"));
		System.out.println("Username Field Dispalyed :" + uname.isDisplayed());
		System.out.println("Username Field Enabled :" + uname.isEnabled());
		uname.sendKeys("xyz");
		uname.getText();
		uname.clear();
		uname.sendKeys(username);
		System.out.println("Return Entered Username Value :"+ uname.getText());
	}
	@Test (priority=5)
	public void enterPassword() throws IOException{
		String password=getObject("password");
		WebElement paswd=driver.findElement(By.name("password"));
		System.out.println("Password Field Dispalyed :" + paswd.isDisplayed());
		System.out.println("Password Field Enabled :"+ paswd.isEnabled());
		paswd.isDisplayed();
		paswd.isEnabled();
		paswd.sendKeys("abcd");
		paswd.getText();
		paswd.clear();
		paswd.sendKeys(password);
		paswd.getText();
		System.out.println("Return Entered Password Value :"+ paswd.getText());

	}
	@Test (priority=6)
	public void clicklogin(){
		WebElement button=driver.findElement(By.id("tdb1"));
		System.out.println("Login Button Dispalyed :" + button.isDisplayed());
		System.out.println("Login Button Enabled :" + button.isEnabled());
		button.getAttribute("value");
		button.click();

	}
	@Test (priority=7)
	public void verifyTitle(){
		Assert.assertEquals("http://www.gcrit.com/build3/admin/index.php",driver.getCurrentUrl());
		System.out.println("Current URL :"+driver.getCurrentUrl());

	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
