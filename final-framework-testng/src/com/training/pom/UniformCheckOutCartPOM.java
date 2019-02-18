package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformCheckOutCartPOM {
private WebDriver driver; 
	
	public UniformCheckOutCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	
	
	@FindBy(xpath="//table[@class='table table-bordered']//a[contains(text(),'Regular T-Shirt (Royal Blue)')]")
	private WebElement productName;
	
	@FindBy(xpath="//span[@class='input-group-btn']//button[@type='button']")
	private WebElement productRemovalFromCart;
	@FindBy(xpath="//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
	private WebElement productRemovedSuccessAlert;
	
	
	
	public String displayProductDescription() {
		
		      
		      return this.productName.getText();
		      
			
	}
	
	
	
	public String displayProductRemovedFromcartAlert() {
		
	      
		return productRemovedSuccessAlert.getText();
}
	public void clickRemoveProductFromcart() {
		// TODO Auto-generated method stub
		this.productRemovalFromCart.click();
	}
}

