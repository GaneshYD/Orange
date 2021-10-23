package Day_020_Multiple_Windows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Test1_Naukri {
	
	static WebDriver driver;
	
	 @Test
	  public void test1Naukri() throws Exception {
		 
		 
		 	Test1_Naukri T1=new Test1_Naukri();
		 	
		 	try
		 	{
		 		driver = TestBrowser.OpenChromeBrowser();
		 		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 		T1.Naukri_Open();
		 		T1.Naukri_Login();
		 		T1.Naukri_Search_Hyderabad_jobs();
		 		T1.Naukri_Hyderabad_jobs_Apply();
		 		
		 	}
		    catch (Exception e)
		 	{
		    	System.out.println("Exception :"+e.getMessage());
		 	}
		 	finally
		 	{
		 	//	T1.Naukri_Logout();
		 		driver.quit();
		 	}
	    


				
		    }
			
		   
		  
	
	 
	 
	 
	 public void Naukri_Open() throws Exception 
	 {
			//Login 
		    driver.get("https://www.naukri.com/jobs-by-location");
	 }
	 
	 public void Naukri_Login() throws Exception 
	 {

	    	driver.findElement(By.xpath("//*[@id='login_Layer']/div")).click();
	    	//driver.findElement(By.xpath("//a[@id='login_Layer']/div")).click();
		    findElement(By.xpath("//*[@id='usernameField']")).click();
		    findElement(By.xpath("//*[@id='usernameField']")).clear();
		    findElement(By.xpath("//*[@id='usernameField']")).sendKeys("lsskrishnav@gmail.com");
		    
		    findElement(By.xpath("//*[@id='passwordField']")).click();
		    findElement(By.xpath("//*[@id='passwordField']")).clear();
		    findElement(By.xpath("//*[@id='passwordField']")).sendKeys("6309691460");
		    findElement(By.xpath("//*[@id='loginForm']/div[2]/div[3]/div/button[1]")).click();
		    
		    Thread.sleep(3000);
	 }
	 
	 
	 public void Naukri_Search_Hyderabad_jobs() throws Exception 
	 {

	 
	 //SearchCenter
	    findElement(By.xpath("//*[@id='skill']/div[1]/div[2]/input")).click();
	    findElement(By.xpath("//*[@id='skill']/div[1]/div[2]/input")).clear();
	    findElement(By.xpath("//*[@id='skill']/div[1]/div[2]/input")).sendKeys("selenium");
	  //  findElement(By.xpath("//div[@id='sugDrp_qsb-keyskill-sugg']/ul/li/div/strong")).click();
	    findElement(By.xpath("//*[@id='location']/div[1]/div[2]/input")).click();
	    findElement(By.xpath("//*[@id='location']/div[1]/div[2]/input")).clear();
	    findElement(By.xpath("//*[@id='location']/div[1]/div[2]/input")).sendKeys("hyderabad");
	    //findElement(By.xpath("//div[@id='sugDrp_qsb-location-sugg']/ul/li/div/strong")).click();
	    findElement(By.xpath("//*[@id='qsbFormBtn']")).click();
	    
	 
	 }
	 
	 
	 
	 
	 
	 public void Naukri_Hyderabad_jobs_Apply() throws Exception 
	 {
			     //No.of rows 
				 String EmpRows_Page1="//a[@class='title fw500 ellipsis']";
			    List<WebElement>   rows = driver.findElements(By.xpath(EmpRows_Page1)); 
				System.out.println("Number of Rows value : " +rows.size());
			    
				for(WebElement option : rows){
					
					System.out.println("Dropdown value : " +option.getText());
					
					WebElement elem=findElement(By.linkText(option.getText()));
					//((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
					
					//Actions actions = new Actions(driver);
					//actions.moveToElement(elem).click().build().perform();
					
					findElement(By.linkText(option.getText()));
					Thread.sleep(4000);
					findElement(By.linkText(option.getText())).click();
					Thread.sleep(6000);
					ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
					
					//Switch to New tab
					driver.switchTo().window(tabs.get(1));
					//findElement(By.linkText(option.getText()));
					driver.close();
					Thread.sleep(1000);
					driver.switchTo().window(tabs.get(0));
					Thread.sleep(1000);
				 	}
				
				
				
				
	  }
	 
	 public void Naukri_Logout() throws Exception 
	 {
		 findElement(By.xpath("//*[@id='root']/div[1]/div/ul[2]/li[2]/div/ul[1]/li[3]/a"));
		 findElement(By.xpath("//*[@id='root']/div[1]/div/ul[2]/li[2]/div/ul[1]/li[3]/a")).click();
		 
		 findElement(By.xpath("//*[@id='root']/div[1]/div/ul[2]/li[2]/div/ul[2]/li[5]/a"));
		 findElement(By.xpath("//*[@id='root']/div[1]/div/ul[2]/li[2]/div/ul[2]/li[5]/a")).click();
	 }
	
	
	 
	 
	 
	 public  WebElement findElement(By by) throws Exception 
		{
	
			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
				
				
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
			 //((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", elem);
			}
			return elem;
		}

	
	

}
