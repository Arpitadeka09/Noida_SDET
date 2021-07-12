package com.crm.VtigerTests;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VtigerWindowHandle {
	@Test
	public void vtigerWindowhandle() {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		
		 driver.findElement(By.name("user_name")).sendKeys("admin");
         driver.findElement(By.name("user_password")).sendKeys("admin");
         driver.findElement(By.id("submitButton")).click();
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
         driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
         
         
         driver.findElement(By.name("accountname")).sendKeys("Arpita123");
         driver.findElement(By.id("phone")).sendKeys("8011236534");
         
         driver.findElement(By.xpath("//img[@title='Select']")).click();
         Set<String> li= driver.getWindowHandles();
         System.out.println(li.size());// find size
         ArrayList<String> ar=new ArrayList<String>(li); // add all in array list
         driver.switchTo().window(ar.get(1));
         
         driver.findElement(By.xpath("//a[text()='Arpita']")).click();
         
         driver.switchTo().alert().accept();
         
         driver.switchTo().window(ar.get(0));
         
         
         driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
         
         
         
	
		
	}

}
