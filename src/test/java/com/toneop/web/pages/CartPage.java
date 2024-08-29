package com.toneop.web.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	
	
	WebDriver driver;

    By unitPrice = By.xpath("/html/body/div/main/div[1]/div/div[2]/div/div[2]/div[3]/div[2]/span/span"); 
    By totalPrice = By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div[2]/div/div[2]/div[4]/span"); 
    By quantityIncreaseButton = By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div[2]/div/div[2]/div[3]/div[1]/div[2]/div[3]"); 
    By deleteButton = By.cssSelector("#__next > main > div.w-full.mx-auto.bg-\\[\\#F6F6F6\\].py-5.md\\:py-10 > div > div.flex-1.flex.gap-5.flex-col.overflow-scroll.h-\\[700px\\].scrollbar-hide > div > svg"); 
    By emptyCartMessage = By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div/img"); 
    
    By quantityofProduct = By.xpath("//*[@id=\"__next\"]/main/div[1]/div/div[2]/div/div[2]/div[3]/div[1]/div[2]/div[2]");
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public Double beforeUnitPrice() {
    	
    	WebElement unitPriceText = driver.findElement(unitPrice);
    	
    	String fullText = unitPriceText.getText();
    	String priceString = fullText.replaceAll("[^0-9]", "");
    	
    	 Double price = Double.parseDouble(priceString); 

    	 
    	 return price;
    	 
    	 
    	 
    }
    
    public Double afterUnitPrice() {
    	
    	WebElement unitPriceText = driver.findElement(unitPrice);
    	
    	String fullText = unitPriceText.getText();
    	String priceString = fullText.replaceAll("[^0-9]", "");
    	
    	 Double afterPrice = Double.parseDouble(priceString); 
    	 
    	 return afterPrice;
    	
    }
    
    public Double gettotalPrice() {
    	
    	WebElement totalPriceText = driver.findElement(totalPrice);
    	
    	String fullTextTotal = totalPriceText.getText();
    	String priceStringTotal = fullTextTotal.replaceAll("[^0-9]","");
    	
    	Double priceTotal = Double.parseDouble(priceStringTotal);
    	
    	return priceTotal;
    }
    
    public Double afterTotalPrice() {
    	
    	WebElement totalPriceText = driver.findElement(totalPrice);
    	
    	String fullTextTotal = totalPriceText.getText();
    	String priceStringTotal = fullTextTotal.replaceAll("[^0-9]","");
    	
    	Double afterPriceTotal = Double.parseDouble(priceStringTotal);
    	
    	return afterPriceTotal;
    	
    }
    
    

    public void increasedProductQuantity() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(quantityIncreaseButton)); 
        
        wait1.click();
        
    }
    
    public int actualquantity() {
    	
    	WebElement quantity = driver.findElement(quantityofProduct);
    	
    	String fullText = quantity.getText();
    	
    	int quantityfinal = Integer.parseInt(fullText);
    	 
    	 return quantityfinal;
    	
    }

    public boolean verifyUnitPriceRemainsSame() {
    	
    	double unitPrice = beforeUnitPrice();
    	double unitPrice2 = afterUnitPrice();
    	
    	
    	
		return unitPrice == unitPrice2;
    	 
    }

    public boolean verifyTotalPrice() {
    	
    	double unitPrice = beforeUnitPrice();
    	
    	double totalPrice2 = afterTotalPrice();
    	
    	int quantity = actualquantity();
    	
    	double actualtotalPrice = unitPrice * quantity;
    	
    	
    	
		return totalPrice2 == actualtotalPrice;
    	
		
    }

    public void deleteProduct() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wait1 = wait.until(ExpectedConditions.elementToBeClickable(deleteButton)); 
        
        wait1.click();
        
    }

    public void verifyEmptyCartMessage() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement wait1 = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)); 
        
        String emptyMessage = wait1.getText();
        
        System.out.println(emptyMessage);
        
    }

    public boolean verifyCartIsEmpty() {
        // Add logic to verify the cart is empty
        return driver.findElement(emptyCartMessage).isDisplayed();
    }

    public boolean verifyTwoProductsInCart() {
    	
    	List<WebElement> divElements = driver.findElements(By.xpath("//div[@class='bg-white rounded-md flex flex-col md:flex-row gap-5 p-5 md:p-10 border relative']"));
        
    	if(divElements.size()==2) {
        return true;
        }else {
        	return false;
        }
    }

    public boolean verifyProductNamesInCart(String firstProductName, String secondProductName) {
    	
    	
    	List<WebElement> productElements = driver.findElements(By.xpath("//div[@class='bg-white rounded-md flex flex-col md:flex-row gap-5 p-5 md:p-10 border relative']"));

        boolean firstProductFound = false;
        boolean secondProductFound = false;

        for (WebElement productElement : productElements) {
            String fullProductName = productElement.getText();

            if (fullProductName.contains(firstProductName)) {
                firstProductFound = true;
            }

            if (fullProductName.contains(secondProductName)) {
                secondProductFound = true;
            }
            
            // If both products are found, no need to continue looping
            if (firstProductFound && secondProductFound) {
                return true;
            }
        }

        // If either of the products was not found
        return firstProductFound && secondProductFound;
        
        
    }
	
    public boolean isCartPageDisplayed() {
    	
    	
        return driver.findElement(unitPrice).isDisplayed();
    }
	

}
