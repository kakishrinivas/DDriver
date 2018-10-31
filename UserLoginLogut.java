package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserLoginLogut {
	@Test
	public void user(){
			//Instantiate Browser driver
			System.setProperty("webdriver.chrome.driver", "C:/Users/Nirnay/Downloads/chromedriver.exe");
			// Create driver object
			WebDriver driver=new ChromeDriver();
			
			//Launch the gcrit Website
			driver.get("http://www.gcrit.com/build3/login.php");
			
			//Capture the URL and Verify the GCRIT Application Launched
			String url=driver.getCurrentUrl();
			System.out.println(url);
			//Verification code 
				
			System.out.println("Test Case2:Verify the Email Address");
			//Verify the Email Address
			WebElement Email=driver.findElement(By.name("email_address"));
			//Check the Email Address displayed
			Email.isDisplayed();
			//Check the Email Address enabled
			Email.isEnabled();
			//Enter the value in Email Address
			Email.sendKeys("kakishrinivasan@gmail.com");
			//Return the entered value
			Email.getText();
			
			System.out.println("Test Case3:Verify the Password edit box");
			//Verify the Password edit box
			WebElement Password=driver.findElement(By.name("password"));
			//Check the Password edit field displayed
			Password.isDisplayed();
			//Check the Password edit field enabled
			Password.isEnabled();
			//Enter the value in Password edit field
			Password.sendKeys("kaki200");
			//Return the entered value
			Password.getText();
			
			System.out.println("Test Case4:Verify the login button");
			//Verify the login button and click on
			WebElement login=driver.findElement(By.id("tdb5"));
			//check the login button is displayed
			login.isDisplayed();
			//check the login button is enabled status
			login.isEnabled();
			//Return User name
			login.getAttribute("type");
			//Click on login 
			login.click();
			
			url=driver.getCurrentUrl();
			//Verification code 
			System.out.println(url);
			//Verify the user name displayed in the login home page
			String Uname=driver.findElement(By.className("greetUser")).getText();
			//Print a Message to displayed user name in the application
			System.out.println("Test Case6:Verify the Login user name "+Uname);
			//System.out.println(Uname);
			//Close Browser
			driver.close();
		
	}

}
