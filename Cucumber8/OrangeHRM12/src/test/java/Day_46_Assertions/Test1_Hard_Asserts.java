package Day_46_Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1_Hard_Asserts {
	
	WebDriver driver;
	Boolean str;
	String Str1;
	
  @Test
  public void HardAsserts() throws Exception{
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		//check Asert1 
		String getActualTitle = driver.getTitle();
		String ExpectedTitle= "OrangeHRM New";
		Assert.assertEquals(getActualTitle, ExpectedTitle);
		System.out.println("Assert1 Executed");
		
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//check Asert2
		WebElement HomePage = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
		Boolean str=HomePage.isDisplayed();
		Assert.assertTrue(str);
		System.out.println("Home Page displayed and Login is Success  – Assert passed");
		
		//check Asert3 - Dashboard is displayed or not
		String ExpectedText= "Dashboard";
		String ActualText=driver.findElement(By.xpath("//*[@id='content']/div/div[1]/h1")).getText();
		Assert.assertEquals(ActualText, ExpectedText);
		
		
		
		
	  
  }
  
  
  
}
