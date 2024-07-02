package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultiTest {
	
	WebDriver driver;
	
	@BeforeClass
	public void Initalization()
	{
		 driver = new ChromeDriver();

		driver.get("https://www.amazon.in");

		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public void SelectDropDown() {
		

		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		Select sel = new Select(dropdown);

		sel.selectByIndex(3);

		sel.selectByValue("search-alias=audible");

		sel.selectByVisibleText("Electronics"); //
		
		
	}
	
	@Test(priority=2)
	public void MouseHovering() throws InterruptedException
	{

		
		//Thread.sleep(8000);
		
		WebElement account = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(account).perform(); //hover on account list
		
		//driver.findElement(By.xpath("//span[text()='Your Orders']")).click();
		
		List<WebElement> li = driver.findElements(By.xpath("//div[@class='nav-title']|//a[@class='nav-link nav-item']"));
		
		System.out.println(li.size());
		
		for(int i = 0 ; i<li.size();i++)
		{
			System.out.println(li.get(i).getText());
		}
		
		//driver.quit();
		
		//driver.f
	}
	
	@AfterClass
	public void CleanUp()
	{
		driver.quit();
	}
	
	

}
