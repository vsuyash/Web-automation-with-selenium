package com.toneop.web.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SkinCare {
	
	 WebDriver driver;
	 	
	 	
	    By productName = By.cssSelector("#__next > div:nth-child(7) > div.w-full.bg-white.flex.justify-center.md\\:justify-start > div.flex-1.md\\:mr-5 > div.grid.grid-cols-2.sm\\:grid-cols-2.md\\:grid-cols-3.md\\:gap-7.md\\:ms-7 > div:nth-child(1) > a:nth-child(3) > div"); 
	    By firstaddToCartButton = By.xpath("//*[@id=\"__next\"]/div[5]/div[2]/div[2]/div[3]/div[1]/div[3]/div"); 
	    By secondProductName = By.xpath("//*[@id=\"__next\"]/div[5]/div[2]/div[2]/div[3]/div[2]/a[2]"); 
	    By secondaddToCartButton = By.xpath("//*[@id=\"__next\"]/div[5]/div[2]/div[2]/div[3]/div[2]/div[3]/div");
	    

	    public SkinCare(WebDriver driver) {
	        this.driver = driver;
	    }

	    public String getProductName() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.visibilityOfElementLocated(productName)); 
            
	        
	        return wait1.getText();
	    }

	    public void clickfirstAddToCartButton() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(firstaddToCartButton)); 
            
	        wait1.click();
	        
	    }
	    
	    public void clicksecondAddToCartButton() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(secondaddToCartButton)); 
            
	        wait1.click();
	        
	    }
	    

	    public boolean isProductDetailPageDisplayed() {
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        // Wait until the element is visible
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(productName));
	        
	        // Return true if the element is displayed
	        return element.isDisplayed();
	    }
	    

	    public String getSecondProductName() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement wait1 = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductName)); 
            
	        
	        return wait1.getText();
	    }
	
	

}
