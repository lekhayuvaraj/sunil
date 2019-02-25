package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformOrderPlacedPagePOM {
	private WebDriver driver;

	public UniformOrderPlacedPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//UserIcon Dropdown
	@FindBy(xpath = "//span[contains(text(),'lekha yuvaraj')]") 
	private WebElement userLekha;
	//order history
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right myaccount-menu']//a[contains(text(),'Order History')]")
	private WebElement orderHistory;

	
	public void clickUserName() {

		userLekha.click();
		
	}
	public void moveToOrderHistory() {

		
		orderHistory.click();
	}
}
