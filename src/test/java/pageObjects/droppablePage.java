package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class droppablePage  {
	//public  droppablePage(WebDriver driver) {
		
	
	public static @FindBy (css = "a[href='http://jqueryui.com/droppable/'") WebElement droppable;
	public static @FindBy (xpath = "//h1[@class='entry-title']") WebElement dropTitle;
	public static @FindBy (xpath = "//*[@id=\\\"content\\\"]/iframe") WebElement dropFrame;
	public static @FindBy (id = "draggable") WebElement fromBox;
	public static @FindBy (id = "droppable") WebElement dropBox;
	public static @FindBy (xpath = "//p[normalize-space()='Dropped!'])[1]") WebElement droppped;

	
}
