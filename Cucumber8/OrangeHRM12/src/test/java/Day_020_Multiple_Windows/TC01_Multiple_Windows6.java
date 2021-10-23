package Day_020_Multiple_Windows;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC01_Multiple_Windows6 {
	
	WebDriver driver;
	
	@Test
	public void testMultipleWindows() throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
		driver.get("https://opensource-demo.orangehrmlive.com/");
		String mainWindow=driver.getWindowHandle();
		
		//below line opens new tab
		((JavascriptExecutor)driver).executeScript("window.open()");
	
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Set<String> set =driver.getWindowHandles();
		
		//ArrayList<String> tabs = new ArrayList<String> (set);
		
		// List<String> aList = new ArrayList<String>(s);
	
			// Using Iterator to iterate with in windows
			Iterator<String> itr= set.iterator();
			while(itr.hasNext()){
				String childWindow=itr.next();
			   	// Compare whether the main windows is not equal to child window. If not equal, we will close.
				if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				driver.get("http://google.com");
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.close();
				}
	}
	// This is to switch to the main window
	driver.switchTo().window(mainWindow);
	}
}