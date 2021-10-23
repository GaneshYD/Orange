package A1_Singleton;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


	public class SingletonDemo 
	{
	
		WebDriver driver;	

		@Test
		public void login_test() throws Exception
		{
			
			SingletonBrowserClass sbc1= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
			WebDriver driver1 = sbc1.getDriver();
			driver1.get("https://www.amazon.in");
		    
		}
		
		@Test
		public void login_test2() throws Exception
		{
			
	
			SingletonBrowserClass sbc2= SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
			WebDriver driver2 = sbc2.getDriver();
			driver2.get("https://www.google.com");
		      
		}
		
		
}


