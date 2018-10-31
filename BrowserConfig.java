package dataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig extends TestBase {
public static WebDriver driver;
static String browser;

public void setBrowser() throws IOException{
	String browserdriver=getObject("browserdriver");
	browser=browserdriver;	
	}
public void setBrowserConfig(){
	//String projectLocation=System.getProperty("user.dir");
	
	if(browser.contains("Firefox")){
	System.setProperty("webdriver.gecko.driver","E:/geckodriver.exe");
	driver = new FirefoxDriver();	
	}
	if(browser.contains("Chrome")){
	
	System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
	driver = new ChromeDriver();	
	}
	
	}
	public static void main(String[] args) {

			
	}



}
