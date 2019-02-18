package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminLoginpagePOM {
private WebDriver driver; 
	
	public UniformAdminLoginpagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Username']")
	private WebElement username;
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginbutton;
	
	public void sendusername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}
	public void clickLoginButton() {
		this.loginbutton.click(); 
	}
}

