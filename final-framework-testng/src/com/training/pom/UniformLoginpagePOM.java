package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformLoginpagePOM {
private WebDriver driver; 
	
	public UniformLoginpagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbutton;
	
	public void sendEmailId(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void clickLoginButton() {
		this.loginbutton.click(); 
	}
}

