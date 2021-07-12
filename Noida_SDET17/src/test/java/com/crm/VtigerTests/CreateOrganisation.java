package com.crm.VtigerTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericUtils.javaUtility;

public class CreateOrganisation {
	@Test
	public void selectDropDown() {
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()=\"Organizations\"]")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
		driver.findElement(By.name("accountname")).sendKeys("TCS"+javaUtility.getRandomData());
		
		WebElement dropdown = driver.findElement(By.name("industry"));
		
		Select industry_dd=new Select(dropdown);
		
		industry_dd.selectByVisibleText("Finance");
		
		WebElement typedropdown = driver.findElement(By.name("accounttype"));
		
		Select typedropdown_dd=new Select(typedropdown);
		
		typedropdown_dd.selectByVisibleText("Investor");
		
		WebElement ratingdropdown = driver.findElement(By.name("rating"));
		
		Select rating_dd=new Select(ratingdropdown);
		 rating_dd.selectByVisibleText("Active");
		 
			driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		
		
		 
		
		
		
		
	}

}
