package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformHomepagePOM {
private WebDriver driver; 
	
	public UniformHomepagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//i[@class='fa fa-user']")
	private WebElement myaccount;
	@FindBy(xpath="/html[1]/body[1]/nav[1]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[3]/ul[1]/li[1]/a[1]")
	private WebElement register;
	@FindBy(xpath="/html[1]/body[1]/nav[1]/header[1]/div[1]/div[3]/div[1]/ul[1]/li[3]/ul[1]/li[2]/a[1]")
	private WebElement login;
	@FindBy(xpath="//a[@href='http://uniform.upskills.in/']//img[@class='img-responsive']")
	private WebElement shopUniformLink;
	@FindBy(xpath="//img[@title='Regular T-Shirt (Royal Blue)']")
	private WebElement regularTshirtRoyalBlue;
	public void clickMyAccount() {
		this.myaccount.click();
	}
	public void clickRegisterButton() {
		this.register.click(); 
		
	}
	public void clickLoginButton() {
		
		this.login.click(); 
	}
public void clickPremiumUniformShopLink() {
		
		this.shopUniformLink.click(); 
	}
public void clickRegulatTshirtRoyalBlue() {
	
	this.regularTshirtRoyalBlue.click(); 
}
}

