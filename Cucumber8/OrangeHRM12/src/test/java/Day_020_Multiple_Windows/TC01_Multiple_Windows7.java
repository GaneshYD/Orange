package Day_020_Multiple_Windows;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TC01_Multiple_Windows7 {
	
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
		
		ArrayList<String> tabs = new ArrayList<String> (set);
		
		//Switch to New tab
		driver.switchTo().window(tabs.get(1));
		driver.get("http://google.com");
		
		//back to MainWindow
		driver.switchTo().window(tabs.get(0));

		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");

	}
}