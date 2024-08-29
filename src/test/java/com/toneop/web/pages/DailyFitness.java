package com.toneop.web.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DailyFitness {
	
	 WebDriver driver;

	    
	    By AddtoCartDailyFitness = By.cssSelector("#__next > div:nth-child(7) > div.w-full.bg-white.flex.justify-center.md\\:justify-start > div.flex-1.md\\:mr-5 > div.grid.grid-cols-2.sm\\:grid-cols-2.md\\:grid-cols-3.md\\:gap-7.md\\:ms-7 > div:nth-child(1) > div.w-full.flex.items-center.md\\:justify-center.gap-2.md\\:gap-5 > div > svg");
	    
	    
	    
	   
	    
	    public DailyFitness(WebDriver driver) {
	        this.driver = driver;
	    }
	    
	    public void scrolldown() {
	    	
	    	 Actions actions = new Actions(driver);


	         actions.sendKeys(Keys.PAGE_DOWN).perform();
	         

	    }

	   public void scrollup() {
		   
		   Actions actions = new Actions(driver);
		   
		   actions.sendKeys(Keys.PAGE_UP).perform();
		   
		   
	   }
	    
	    public void clickOnAddtoCartforDailyFitness() {
	    	
	    	 
	         
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(AddtoCartDailyFitness));
	        
            
	        wait1.click();
	        //driver.findElement(AddtoCartDailyFitness).click();
	    	
	    }

	  
	
	

}
