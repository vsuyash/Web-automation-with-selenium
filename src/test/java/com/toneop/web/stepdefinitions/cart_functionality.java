package com.toneop.web.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.toneop.web.pages.CartPage;
import com.toneop.web.pages.DailyFitness;
import com.toneop.web.pages.HomePage;
import com.toneop.web.pages.SkinCare;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class cart_functionality {
	
	 WebDriver driver;
	    HomePage homePage;
	    DailyFitness DailyFitness;
	    SkinCare SkinCare;
	    CartPage cartPage;

	    String firstProductName;
	    String secondProductName;

	    public cart_functionality() {
	    	
	    	System.setProperty("webdriver.chrome.driver", "C://Users//91883//Downloads//chromedriver-win32 (1)//chromedriver-win32//chromedriver.exe");
	    	WebDriver driver = new ChromeDriver();
	    	
	    	
//	    	WebDriverManager.chromedriver().setup();
//	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	        
	        homePage = new HomePage(driver);
	        DailyFitness = new DailyFitness(driver);
	        SkinCare = new SkinCare(driver);
	        cartPage = new CartPage(driver);
	    }

	    @Given("the user navigates to the ToneOp website")
	    public void the_user_navigates_to_the_toneop_website() {
	    	homePage.navigateToHomePage();
	    }

	    @When("the user clicks on the daily fitness button")
	    public  void the_user_clicks_on_the_button() throws InterruptedException {
	        homePage.clickdailyFitnessButton();
	        
	    }


	    @Then("the user clicks on add to cart")
	    public void the_user_clicks_on_add_to_cart() throws InterruptedException {
	    	
	    	
	    	DailyFitness.scrolldown();
	    	
	        DailyFitness.clickOnAddtoCartforDailyFitness();
	        Thread.sleep(3000);
	    }

	    @When("the user clicks on the cart icon")
	    public void the_user_clicks_on_the_cart_icon() throws InterruptedException {
	    	
	    	DailyFitness.scrollup();
	    	
	    	Thread.sleep(2000);
	        homePage.clickCartIcon();
	        
	        Thread.sleep(3000);
	    }

	    @Then("the user should be navigated to the shopping cart page")
	    public void the_user_should_be_navigated_to_the_shopping_cart_page() {
	        Assert.assertTrue(cartPage.isCartPageDisplayed());
	        
	        cartPage.beforeUnitPrice();
	        cartPage.gettotalPrice();
	        
	        
	    }

	    @When("the user increases the product quantity")
	    public void the_user_increases_the_product_quantity_by_clicking() {
	        cartPage.increasedProductQuantity();
	    }

	    @Then("the unit price should remain the same")
	    public void the_unit_price_should_remain_the_same() {
	        Assert.assertTrue(cartPage.verifyUnitPriceRemainsSame());
	    }

	    @Then("the total price should be the unit price multiplied by the quantity")
	    public void the_total_price_should_be_the_unit_price_multiplied_by_the_quantity() {
	        Assert.assertTrue(cartPage.verifyTotalPrice());
	    }

	    @When("the user clicks on the delete button")
	    public void the_user_clicks_on_the_delete_button() {
	        cartPage.deleteProduct();
	    }

	    @Then("the Empty cart message should appear")
	    public void the_empty_cart_message_should_appear() {
	        cartPage.verifyEmptyCartMessage();
	    }

	    @Then("the cart should be empty with no products listed")
	    public void the_cart_should_be_empty_with_no_products_listed() {
	        Assert.assertTrue(cartPage.verifyCartIsEmpty());
	    }

	    @When("the user clicks on the ToneOp icon")
	    public void the_user_clicks_on_the_toneop_icon() {
	        homePage.clickToneOpIcon();
	    }

	    @Then("the user should be navigated back to the homepage")
	    public void the_user_should_be_navigated_back_to_the_homepage() throws InterruptedException {
	        Assert.assertTrue(homePage.isHomePageDisplayed());
	        
	        Thread.sleep(3000);
	    }
	    
	    @When("the user clicks on the skincare button")
	    public void the_user_clicks_on_the_skincare_button() throws InterruptedException {
	        // Write code here that turns the phrase above into concrete actions
	    	homePage.clickskincareButton();
	    	
	    	Thread.sleep(5000);
	    }
	    
	    @Then("the user should be navigated to the skincare catalog page")
	    public void the_user_should_be_navigated_to_the_skincare_catalog_page() throws InterruptedException {
	    	
	    	DailyFitness.scrolldown();
	    	
	    	Thread.sleep(3000);
	    	
	    	Assert.assertTrue(SkinCare.isProductDetailPageDisplayed());
	    	
	    	
	        // Write code here that turns the phrase above into concrete actions
	        
	    }

	    @When("the user fetches the product name and adds it to the cart")
	    public void the_user_fetches_the_product_name_and_adds_it_to_the_cart() {
	        firstProductName = SkinCare.getProductName();
	        
	        
	        SkinCare.clickfirstAddToCartButton();
	    }
	   
	    @And("the user adds a second product to the cart")
	    public void the_user_adds_a_second_product_to_the_cart() {
	        secondProductName = SkinCare.getSecondProductName();
	        
	       
	        SkinCare.clicksecondAddToCartButton();
	    }
	    
	    @And("the user clicks again on the cart icon")
	    public void the_user_clicks_again_on_the_cart_icon() throws InterruptedException {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	DailyFitness.scrollup();
	    	
	    	Thread.sleep(2000);
	        homePage.clickCartIcon();
	        
	        Thread.sleep(3000);
	        
	     
	       
	        
	    }
	  
	    @Then("the user should see two products in the cart")
	    public void the_user_should_see_two_products_in_the_cart() {
	    	
	        Assert.assertTrue(cartPage.verifyTwoProductsInCart());
	    }

	    @Then("both products should match the previously fetched names")
	    public void both_products_should_match_the_previously_fetched_names() {
	        Assert.assertTrue(cartPage.verifyProductNamesInCart(firstProductName, secondProductName));
	        
	        
	        driver.quit();
	    }
	    
	    

}
