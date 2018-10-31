package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Briefcase {
	@Test
	public void Offline(){
	System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://localhost:8080/");
	String url=driver.getCurrentUrl();
	System.out.println(url);
	if (url.contains("localhost")){
		System.out.println("Lanuched Offline Succesfuly - Passed");
	}
	else
	{
		System.out.println("Not Lanuched offline Succesfuly - Failed");
	}
	driver.close();
}
}
