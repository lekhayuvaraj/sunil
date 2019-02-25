package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformProductReturnsPagePOM {
	private WebDriver driver;

	public UniformProductReturnsPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//select order error option
	@FindBy(xpath = "//input[@value='3']")
	private WebElement orderError;
//product opened -yes
	
	@FindBy(xpath = "//label[@class='radio-inline']//input[@value='1']")
	private WebElement productOpenedYes;
	//fault or other options
	@FindBy(xpath = "//textarea[@id='input-comment']")
	private WebElement faultComments;
	//checkbox
	@FindBy(xpath = "//div[@class='pull-right']//input[@value='1']")
	private WebElement checkBox;
//submit button
	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submitButton;
	
	public void selectReasonForReturn() {
		orderError.click();		
	}
	public void selectProductOpened() {
		productOpenedYes.click();		
	}
	public void enterFaultComments(String comments) {
		faultComments.sendKeys(comments);
	}
	public void selectCheckBox() {
		checkBox.click();
	}
	public void clickSubmitButton() {
		submitButton.click();
	}
}
