package naggaroTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.droppablePage;


public class Step_def_1 {
	
	
	//public static final WebDriver driver = new ChromeDriver();
	public WebDriver driver;
	
	//Scenario#1
	@Given("User is on jquery webpage")
	public void user_is_on_jquery_webpage() throws InterruptedException {
		
		System.out.println(driver);
		driver=  DriverFactory.initializeDriver();
		driver.get("https://jqueryui.com/");
		
		 	}

	@When("User clicks on the droppable field on the left menu option")
	public void i_click_on_the_droppable_field_on_the_left_menu_option() {
		driver.findElement((By) droppablePage.droppable).click();
	}

	@Then("the user is naviagted to the droppable page")
	public void the_user_is_naviagted_to_the_droppable_page() {
		String actualTitle= droppablePage.dropTitle.getText();
	     	    Assert.assertEquals("Droppable", actualTitle);
	    System.out.println("Title on this page is"+  actualTitle);
	}

		@And ("the user peforms the drag and drop operation")
	public void the_user_peforms_the_drag_and_drop_operation() throws InterruptedException {
			driver.switchTo().frame(droppablePage.dropFrame);
			Actions action = new Actions(driver);
			//Perform drag and drop
			action.dragAndDrop(droppablePage.fromBox, droppablePage.dropBox).perform();
		}

	@Then("the drop here lable changes to Dropped")
	public void the_drop_here_lable_changes_to() throws InterruptedException {
		String SuccesTitle = droppablePage.droppped.getText();

		if(SuccesTitle.equals("Dropped!")) {
			System.out.println("PASS: Source is dropped to target as expected");
		}else {
			System.out.println("FAIL: Source couldn't be dropped to target as expected");
		}
	driver.close();
	}

	//Scenario#2
		@When("User clicks on Selectable option from the left menu")
	public void user_clicks_on_selectable_option_from_the_left_menu() {
	   WebElement selectable= driver.findElement(By.xpath("//a[normalize-space()='Selectable']"));
	   selectable.click();
	      
	}

	@Then("user is navigated to the Selectable page")
	public void user_is_navigated_to_the_selectable_page() {
	    WebElement SeclectTitle= driver.findElement(By.xpath("//h1[normalize-space()='Selectable']"));
	    String ActualselectTitle= SeclectTitle.getText();
	    Assert.assertEquals("Selectable", ActualselectTitle);
	    System.out.println("On this page th etitle is" + ActualselectTitle);
	}

	@Then("User is able to select item1, item3 and item7 from the given item list")
	public void user_is_able_to_select_item1_item3_and_item7_from_the_given_item_list() {
	 WebElement frameSel= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	 driver.switchTo().frame(frameSel);
	 
	 //perform multiple select
	 Actions multiselect = new Actions(driver);
	 WebElement select = driver.findElement(By.id("selectable"));
	 List<WebElement> options = select.findElements(By.cssSelector("ol#selectable *"));
	 System.out.println(options.size());
	 
	 multiselect.keyDown(Keys.CONTROL)
	 .click(options.get(0))
	 .click(options.get(3))
	 .click(options.get(6))
	 .build()
	 .perform();
	 
	 driver.close();
			 
	 
	}

	
	//Scenario#3
	@When("User clicks on the controlgroup option from the left menu")
	public void user_clicks_on_the_controlgroup_option_from_the_left_menu() {
	    WebElement Controlgrp= driver.findElement(By.xpath("//a[normalize-space()='Controlgroup']"));
	    Controlgrp.click();
	}

	@Then("user is navigated to the controlgroup page")
	public void user_is_navigated_to_the_controlgroup_page() {
		WebElement controlTitle= driver.findElement(By.xpath("//h1[normalize-space()='Controlgroup']"));
	    String ActualcontrolTitle= controlTitle.getText();
	    Assert.assertEquals("Controlgroup", ActualcontrolTitle);
	    System.out.println("On this page th etitle is" +  ActualcontrolTitle); 
	}

	@Then("User is able to select the type of cars with insurance of his choice")
	public void user_is_able_to_select_the_type_of_cars_with_insurance_of_his_choice() {
		WebElement frameSel1= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		 driver.switchTo().frame(frameSel1);
		 
		 WebElement auto= driver.findElement(By.cssSelector("label[for='transmission-automatic']"));
		 auto.click();
		 
		 WebElement insure= driver.findElement(By.cssSelector("label[for='insurance']"));
		 insure.click();
		 
		 WebElement std= driver.findElement(By.cssSelector("label[for='transmission-standard-v']"));
		 std.click();
		 
		 WebElement insurance = driver.findElement(By.cssSelector("label[for='insurance-v']"));
		 insurance.click();
		 
		 WebElement Book = driver.findElement(By.xpath("//button[@id='book']"));
		 Book.click();
		 
		 driver.quit();
	}
}
