package webDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchGmailPage {

	public static void main(String[] args) {
		System.setProperty("webdriver.ie.driver","E:/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://gmail.com/");
		String url=driver.getCurrentUrl();
		System.out.println(url);
		if (url.contains("gmail")){
			System.out.println("Lanuched Gmail Succesfuly - Passed");
		}
		else
		{
			System.out.println("Not Lanuched Gmail Succesfuly - Failed");
		}
	}

}
