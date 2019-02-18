package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformChangePasswordpagePOM {
private WebDriver driver; 
	
	public UniformChangePasswordpagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	@FindBy(xpath="//input[@id='input-confirm']")
	private WebElement confirmPassword;
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	@FindBy(xpath="//a[@class='btn btn-default']")
	private WebElement backButton;
	
	@FindBy(xpath="//div[@class='text-danger']")
	private WebElement mismatchPasswordAlert;
	
	

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void sendConfirmPassword(String confirmPassword) {
		this.confirmPassword.clear();
		this.confirmPassword.sendKeys(confirmPassword);
	}
	public void clickContinueButton() {
		this.continueButton.click(); 
	}
	public void clickBackButton() {
		this.backButton.click(); 
	}
	
	public String displayPasswordFailureAlert() {
		return this.mismatchPasswordAlert.getText();
	}
}

