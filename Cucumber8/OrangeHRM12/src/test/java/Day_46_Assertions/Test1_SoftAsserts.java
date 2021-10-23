package Day_46_Assertions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;

public class Test1_SoftAsserts {
	
	WebDriver driver;
	
  @Test
  public void SOftAsserts() throws Exception{
	  
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SoftAssert softAssert = new SoftAssert();
		 
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//check Asert1 
		String getActualTitle = driver.getTitle();
		String ExpectedTitle= "OrangeHRM";
		softAssert.assertEquals(getActualTitle, ExpectedTitle);
		
		//check Asert2
		String Actual_Login_Text = driver.findElement(By.xpath("//*[@id='forgotPasswordLink']/a")).getText();
		String Expected_Login_Text= "Forgot your password?";
		softAssert.assertEquals(Actual_Login_Text, Expected_Login_Text);
		System.out.println("Forgot Link is displayed   – Assert passed");

		
		//check Asert3
		WebElement LoginButton = driver.findElement(By.id("btnLogin"));
		softAssert.assertEquals(LoginButton.isDisplayed(),true);
		System.out.println("Login button displayed on Login Page – Assert passed");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		//check Asert4
		WebElement AdminLink = driver.findElement(By.xpath("//*[@id='menu_admin_viewAdminModule']/b"));
		softAssert.assertEquals(true, AdminLink.isDisplayed());
		System.out.println("Admin Link is dispolayed or not – Assert passed");
		
		
		
		softAssert.assertAll();
		
		
		
	  
  }
  
  
  
}
