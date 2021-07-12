package com.crm.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class contains Webdriver specific generic method
 * @author arpita
 *
 */

public class WebDriverUtility {
	/**
	 * this method will wait for 20sec for page loading
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	/**
	 * this method wait for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	/**
	 * this method will wait for given time and click
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndclick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<50) {
			try {
				element.click();
				break;
			}
			catch(Throwable e) {
				Thread.sleep(5000);
				count++;
							
			}
		}
		
	}
	/**
	 * this method will select on the basis of visible text
	 * @param element
	 * @param option
	 */
	public void selectOption(WebElement element, String option) {
		Select sel=new Select(element);
		sel.selectByVisibleText(option);
		
		
	}
	/**
	 * this method enable user to handle dropdown using index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will perfrom mouseover action
	 * @param driver
	 * @param element
	 */
	
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method perfrom right click
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * this method will switch the window
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window=driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext()) {
			String winId=it.next();
			String title=driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWinTitle)) {
				break;
			}
		}
		
	}
	/**
	 * this method will accept the popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert();
	}
	/**
	 * this method  will cancel popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used for scrolling action
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
		
		}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
		
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
		
	}
	public void pressEnterKey(KeyEvent key) throws AWTException {
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void takeScreenshot(WebDriver driver, String screenshootname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
	   File src= ts.getScreenshotAs(OutputType.FILE);
	   File dest=new File("./screenshot/"+screenshootname+".PNG");
	   Files.copy(src, dest);
	   
	    }
	

}
