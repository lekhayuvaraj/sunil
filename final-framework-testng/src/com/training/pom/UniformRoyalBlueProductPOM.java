package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformRoyalBlueProductPOM {
private WebDriver driver; 
	
	public UniformRoyalBlueProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//select[@name='option[389]']")
	private WebElement chestsizeDropdown;
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addCartButton;
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successAlertCartAdded;
	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	private WebElement viewCart;
	
	public void selectChestSize() {
		
		      Select drop = new Select(chestsizeDropdown);
		      drop.selectByIndex(1);  
	
	}
	
	public void clickAddCartButton() {
		this.addCartButton.click(); 
		
	}
	public void displayAddedToCartSuccessAlert() {
		
		this.successAlertCartAdded.getText();
	}
public void viewCart() {
		
		this.viewCart.click(); 
	}

}

