package webDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Launcg Gmail Login Page");
		driver.get("https://gmail.com/");
		System.out.println("Enter Email");
		driver.findElement(By.name("identifier")).sendKeys("kakishrinivasan@gmail.com");
		System.out.println("Click on Next Button");
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(5000);
		System.out.println("Enter Password");
		driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("nirnay17");
		System.out.println("Click on Next Button");
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(5000);
		System.out.println("Click on User Profile icon");
		driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div/div[2]/div/a")).click();
		System.out.println("Return the user name and display");
		String UserName=driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[6]/div[1]/div/div[1]")).getText();
		System.out.println("User Login Successful:"+ UserName);
		System.out.println("Click on Sent");
		driver.findElement(By.linkText("Sent")).click();
		Thread.sleep(5000);
		System.out.println("Click on Inbox");
		driver.findElement(By.linkText("Inbox")).click();
		System.out.println("Click on user profile icon");
		driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[3]/div/div[2]/div/a")).click();
		System.out.println("Click on Sign out");
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		System.out.println("Close Browser");
		driver.close();
		
	}

}
