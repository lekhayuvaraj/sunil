package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminOrderpagePOM {
	private WebDriver driver;

	public UniformAdminOrderpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// customer
	@FindBy(xpath = "//*[@id=\"input-customer\"]")
	private WebElement productName;
	
	//filter button
	@FindBy(xpath = "//*[@id=\"button-filter\"]")
	private WebElement filterButton;
	
	//view button of order
	@FindBy(xpath = "//tr[.//td='24']//a")
	private WebElement viewButtonofOrder;

	
	
	public void enterCustomer(String customer) {
		// TODO Auto-generated method stub
		productName.sendKeys(customer);
	}
	public void clickfilterbutton() {
		// TODO Auto-generated method stub
		filterButton.click();
	}
	
	public void clickviewbuttonofOrder() {
		// TODO Auto-generated method stub
		viewButtonofOrder.click();
	}
}

	