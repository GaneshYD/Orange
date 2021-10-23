package A1_Singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


	public class SingletonBrowserClass {

		// instance of singleton class
		private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;
		
		
	    private WebDriver driver;

	    // Constructor
	    private SingletonBrowserClass(){
	    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
	    }

	    // TO create instance of class
	    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
	        if(instanceOfSingletonBrowserClass==null){
	        	instanceOfSingletonBrowserClass = new SingletonBrowserClass();
	        }
	        return instanceOfSingletonBrowserClass;
	    }
	    
	    // To get driver
	    public WebDriver getDriver()
	    {
	    	return driver;
	    }
	    

	   
  
}
