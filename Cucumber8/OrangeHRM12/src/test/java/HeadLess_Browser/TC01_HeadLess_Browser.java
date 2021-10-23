package HeadLess_Browser;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TC01_HeadLess_Browser {
	
	WebDriver driver;
	
  @Test
  public void HeadLess_Test()throws Exception {
	  
		//Launch Browser
	  
	 // ChromeOptions options = new ChromeOptions();
	 
	  
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--headless");
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver =new ChromeDriver(options);
		
		
		driver.manage().window().maximize() ;	
		
		//Open Orange HRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Login
		findElement(By.id("txtUsername")).sendKeys("Admin");
		findElement(By.id("txtPassword")).sendKeys("admin123");
		findElement(By.id("btnLogin")).click();
		
		System.out.println("Passed");
		
		
  }
  
  
  
  
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}



  
  
}
