package com.crm.VtigerTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericUtils.PropertyUtility;
import com.crm.GenericUtils.WebDriverUtility;
import com.crm.GenericUtils.javaUtility;

public class CreatNewLeadByGivingInvalidInputToNoOfEmployee {
	@Test
	public void Lead14() throws Throwable {
		PropertyUtility pUtil=new PropertyUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		       //Launch browser
				WebDriver driver=new FirefoxDriver();
				driver.manage().window().maximize();
				wUtil.waitUntilPageLoad(driver);
				
				//get url
		        driver.get(pUtil.getPropertyKeyValue("url"));
		        
				//login to application
				driver.findElement(By.name("user_name")).sendKeys(pUtil.getPropertyKeyValue("username"));
				driver.findElement(By.name("user_password")).sendKeys(pUtil.getPropertyKeyValue("password"));
				driver.findElement(By.id("submitButton")).click();
				
				//Click on "Lead" then click on "Creat Lead " Image.
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				

				//Enter valid inputs "No Of Employee" and fill the other fields and click on "Save" button

				WebElement sarname = driver.findElement(By.name("salutationtype"));
		        wUtil.selectOption(sarname, 2); 
		        
		        driver.findElement(By.name("firstname")).sendKeys("arpita"+javaUtility.getRandomData()); 
		        driver.findElement(By.name("lastname")).sendKeys("Deka"+javaUtility.getRandomData()); 
		        driver.findElement(By.name("company")).sendKeys("Redefine"+javaUtility.getRandomData());
		        
		        WebElement LeadSource = driver.findElement(By.name("leadsource"));  
		        wUtil.selectOption(LeadSource, "Employee");
		        
		        WebElement industry = driver.findElement(By.name("industry"));
		        wUtil.selectOption(industry, 4);
		        
		        WebElement revenu = driver.findElement(By.name("annualrevenue"));
		        revenu.sendKeys("ydff"+javaUtility.getRandomData());
				
		        //no of employee input 8
		        WebElement noofemployees = driver.findElement(By.name("noofemployees"));
		        noofemployees.sendKeys("ghhk");
		        
		        WebElement secondaryemail= driver.findElement(By.id("secondaryemail"));
		        secondaryemail.sendKeys("arpitadeka09@gmail.com");
		        WebElement phone = driver.findElement(By.name("phone"));
		        phone.sendKeys("8011389524");
		        
		        WebElement mobile = driver.findElement(By.name("mobile"));
		        mobile.sendKeys("8638153723");
		        
		        WebElement fax= driver.findElement(By.id("fax"));
		        fax.sendKeys("651-857-869");
		        
		        WebElement Email= driver.findElement(By.id("email"));
		        Email.sendKeys("arpitadeka09@gmail.com");
		        
		        WebElement website = driver.findElement(By.name("website"));
		        website.sendKeys("qspiders.com");
		        
		        WebElement leadstatus = driver.findElement(By.name("leadstatus"));
		        wUtil.selectOption(leadstatus, 4);
		        
		        WebElement rating = driver.findElement(By.name("rating"));
		        wUtil.selectOption(rating, 2);
		        
		        //click on save button
		        driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		        
		        //click on logout
		        WebElement mOver = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		        wUtil.mouseOver(driver, mOver);
		        driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
