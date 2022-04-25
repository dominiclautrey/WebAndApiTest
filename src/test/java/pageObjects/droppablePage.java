package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class droppablePage extends Base {
	 @FindBy (css = "a[href='http://jqueryui.com/droppable/'") private WebElement droppable;
	 @FindBy (xpath = "//h1[@class='entry-title']") private WebElement dropTitle;
	 @FindBy (xpath = "//*[@id=\\\"content\\\"]/iframe")   WebElement dropFrame;
	 @FindBy (id = "draggable") private WebElement fromBox;
	 @FindBy (id = "droppable") private WebElement dropBox;
	 @FindBy (xpath = "//p[normalize-space()='Dropped!'])[1]") private WebElement droppped;

	public droppablePage(WebDriver driver) {
		super(driver);
	}
	
	public void clickDroppable() {
		wait.until(ExpectedConditions.elementToBeClickable(droppable)).click();
	}
	
	public String drop_title() {
		return wait.until(ExpectedConditions.visibilityOf(dropTitle)).getText();
	}
	
	
}
