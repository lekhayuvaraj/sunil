package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformYellowProductDetailsPOM {
private WebDriver driver; 
	
	public UniformYellowProductDetailsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//select[@name='option[382]']")
	private WebElement chestsizeDropdown;
	//quantity
	@FindBy(xpath="//input[@id='input-quantity']")
	private WebElement quantity;
	@FindBy(xpath="//*[@id=\"button-cart\"]") 
	private WebElement addCartButton;
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successAlertCartAdded;
	@FindBy(xpath="//a[contains(text(),'shopping cart')]")
	private WebElement viewCart;
	
	public void selectChestSize() {
		
		      Select drop = new Select(chestsizeDropdown);
		      drop.selectByIndex(3);  
	
	}
	
	public void clickAddCartButton() {
		this.addCartButton.click(); 
		
	}
	
public void viewCart() {
		
		this.viewCart.click(); 
	}
public void enterTheQuantity(String i) {
	this.quantity.clear();
	this.quantity.sendKeys(""+i);
}



}

