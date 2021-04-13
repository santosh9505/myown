package com.tricentis.automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LaunchBrowser {
	
	WebDriver dr;
	
	@Test
	public void launchBrowser()
	{
		//browser path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\karthik\\Desktop\\jarFiles\\Drivers\\chromedriver.exe");
		
		dr = new ChromeDriver();
		
		dr.manage().window().maximize();
		
		dr.get("http://sampleapp.tricentis.com/101/index.php");
	}
	
	@Test(dependsOnMethods ="launchBrowser")
	public void validate_motorCycle_event_VechileData()
	{
		//dr.findElement(By.linkText("Automobile")).click();
		//dr.findElement(By.partialLinkText("tomobile")).click();
		dr.findElement(By.xpath("//a[@id='nav_automobile']")).click();
	}
	@Test(dependsOnMethods = "validate_motorCycle_event_VechileData")
	public void validate_Make_DropDown() throws InterruptedException
	{
		WebElement make=dr.findElement(By.id("make"));
		Select sel = new Select(make);
		
		sel.selectByIndex(13);
		Thread.sleep(2000);
		sel.selectByValue("Ford");
		Thread.sleep(2000);
		sel.selectByVisibleText("Renault");
		
	}
	@Test(dependsOnMethods = "validate_Make_DropDown")
	public void validate_EnginePerformance()
	{
		dr.findElement(By.id("engineperformance")).sendKeys("1000");
	}
	
	@Test(dependsOnMethods = "validate_EnginePerformance")
	public void validate_DateOFManufacture()
	{
		dr.findElement(By.id("dateofmanufacture")).sendKeys("01/01/2020");
		//dr.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
	}
	
	@Test(dependsOnMethods = "validate_DateOFManufacture")
    public void validate_NumberOfSeats()
    {
     WebElement ele = dr.findElement(By.id("numberofseats"));
     Select sel = new Select(ele);
     sel.selectByIndex(2);

WebElement fuel = dr.findElement(By.id("fuel"));
Select sele = new Select(fuel);
sele.selectByIndex(2);

dr.findElement(By.id("listprice")).sendKeys("1500");
	
dr.findElement(By.id("licenseplatenumber")).sendKeys("1626");
	
dr.findElement(By.id("annualmileage")).sendKeys("2000");	

dr.findElement(By.id("nextenterinsurantdata")).click();
	}
	@Test(dependsOnMethods = "validate_NumberOfSeats")
	public void radioButtonAndCheckbox() throws AWTException, InterruptedException
	{
		dr.findElement(By.xpath("//input[@id='gendermale']/..")).click();
		
		dr.findElement(By.xpath("//label[contains(.,'Cliff Diving')]")).click();
		
		
		dr.findElement(By.id("open")).click();
		
		//Robot CLass
		
		Robot robot = new Robot();
		
		StringSelection cb = new StringSelection("C:\\Users\\karthik\\Desktop\\New folder (5)\\CW3A4154.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(cb, null);
		
		Thread.sleep(10000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
				
				
		
	}

}
