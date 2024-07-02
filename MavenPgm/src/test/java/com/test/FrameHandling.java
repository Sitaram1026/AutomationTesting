package com.test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class FrameHandling {
	
	@Test

	public void FrameHandle()throws InterruptedException {
		// TODO Auto-generated method stub
		

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.yatra.in");
		
		driver.manage().window().maximize();
		
		//Thread.sleep(8000);
		
		WebElement account = driver.findElement(By.xpath("//a[text()='Support ']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(account).perform();
		
		driver.findElement(By.xpath("//a[text()='Talk To Us']")).click();
		
		driver.switchTo().frame("iframeChatBot");//user inside into the iframe
		
		driver.findElement(By.xpath("//button[text()='Cancellation']")).click();
		
		driver.switchTo().defaultContent(); //come out from theframe
		
		driver.findElement(By.id("chatbot_close_button")).click();
		
		driver.quit();
		
		

	}

}
