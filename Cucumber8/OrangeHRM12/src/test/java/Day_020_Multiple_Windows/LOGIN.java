package Day_020_Multiple_Windows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LOGIN 

{
	
	WebDriver driver;
  @Test
  public void Login() throws Exception
  {
	  
	//Launch Browser
			System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
			//open orangehrm
			driver.get("https://opensource-demo.orangehrmlive.com/");
			

  }
}
