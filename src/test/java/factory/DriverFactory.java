package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private  static WebDriver driver;
    
    public  static WebDriver initializeDriver() {
    	
    	System.setProperty("webdriver.chrome.driver", "E:\\Webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://jqueryui.com/" );
		return driver;
    	
    }
    
    public static  WebDriver getDriver() {
		return driver;
    	
    }
}
