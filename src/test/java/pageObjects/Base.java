package pageObjects;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {

	public Base(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		 PageFactory.initElements(driver, this);
	}

	public void load(String url) {
		driver.get(url);
	}
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	
}
