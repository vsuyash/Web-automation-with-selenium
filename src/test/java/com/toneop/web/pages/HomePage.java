package com.toneop.web.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	 WebDriver driver;

	    By dailyFitnessButton = By.xpath("//*[@id=\"__next\"]/header[2]/div/a[3]");
	    By skincareButton = By.cssSelector("#__next > header.w-full.md\\:h-\\[20px\\].bg-\\[\\#ffffff\\].hidden.lg\\:flex.items-end.justify-between.sticky.top-\\[80px\\].transition-transform.duration-300.translate-y-0.z-20.pt-5 > div > a:nth-child(4)");
	    By cartIcon = By.xpath("//*[@id=\"__next\"]/header[1]/div/div/a[2]/div"); 
	    By toneOpIcon = By.xpath("//*[@id=\"__next\"]/header[1]/div/a/img"); 

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    public void clickdailyFitnessButton() {
	    	driver.findElement(dailyFitnessButton).click();
	    	
	    }
	    
	    public void clickskincareButton() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(skincareButton)); 
            
	        wait1.click();
	    	
	    }
	    
	    
	    public void clickCartIcon() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(cartIcon)); 
            
	        wait1.click();
	        
	    }

	    public void clickToneOpIcon() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(toneOpIcon)); 
            
	        wait1.click();
	        
	    }

	    public boolean isHomePageDisplayed() {
	    	
	        return driver.findElement(toneOpIcon).isDisplayed();
	    }
	    
	    public void navigateToHomePage() {
	        driver.get("https://toneop.care/");
	        
	    try {
	    	
	    	
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
           WebElement popupCloseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div/div/div[2]/svg"))); 
           
           popupCloseButton.click();
	    }
	    catch (TimeoutException e) {
            System.out.println("Popup did not appear within the expected time.");
        }
            
	    }
	
	

}
