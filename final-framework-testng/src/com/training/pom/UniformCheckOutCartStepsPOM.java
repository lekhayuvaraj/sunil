package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformCheckOutCartStepsPOM {
	private WebDriver driver;

	public UniformCheckOutCartStepsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//step 2-billing details -address
	@FindBy(xpath = "//*[@id=\"collapse-payment-address\"]/div/form/div[1]/label/input")
	private WebElement existingAddress;

	// step 2-billing details -continue button
	@FindBy(xpath = "//*[@id=\"button-payment-address\"]")
	private WebElement step2ContinueButton;

	// step 3-Delivery details -address
	@FindBy(xpath = "//div[@id='collapse-shipping-address']//form[@class='form-horizontal']//div[1]//label[1]//input[1]")
	private WebElement existingAddressStep3;

	// step 3-Delivery details -continue button
	@FindBy(xpath = "//*[@id=\"button-shipping-address\"]")
	private WebElement step3ContinueButton;
	// step 4-Delivery method
	@FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/div[1]")
	private WebElement freeShipping;
	
	//step 4 comments box
	@FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	private WebElement addComments;

	// step 4-Delivery method-continue button
	@FindBy(xpath = "//*[@id=\"button-shipping-method\"]")
	private WebElement step4ContinueButton;
	// step 5-payment method
	@FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[1]/label/input")
	private WebElement cashOnDelivery;
	//select terms checkbox
	@FindBy(xpath = "//input[@name='agree']") 
	//body.checkout-checkout.layout-1:nth-child(2) div.container:nth-child(2) div.row div.col-sm-12 div.panel-group:nth-child(3) div.panel.panel-default:nth-child(5) div.panel-collapse.collapse.in div.panel-body div.buttons:nth-child(5) div.pull-right > input:nth-child(2)
	private WebElement termsCheckbox;

	// step 5-payment method-continue button
	@FindBy(xpath = "//*[@id=\"button-payment-method\"]")
	private WebElement step5ContinueButton;
	// step 6-confirm order
		@FindBy(xpath = "//*[@id=\"button-confirm\"]")
		private WebElement confirmOrderButton;

	public void selectExistingAddressInStep2() {

		//existingAddress.click();
		step2ContinueButton.click();
	}

	public void selectExistingAddressInStep3() {

		//existingAddressStep3.click();
		step3ContinueButton.click();
	}

	public void selectShippingMethod() {

		//freeShipping.click();
		step4ContinueButton.click();
	}
	public void enterAddComments(String addcomment) {

		
		addComments.sendKeys(addcomment);
	}
	public void selectCheckBox() {

		termsCheckbox.click();
		
	}
	public void selectPaymentMethod() {

		
		step5ContinueButton.click();
	}
	public void confirmOrder() {

		confirmOrderButton.click();
	}
}
