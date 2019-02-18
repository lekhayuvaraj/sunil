package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAccountpagePOM {
private WebDriver driver; 
	
	public UniformAccountpagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	private WebElement editAccountInfo;
	@FindBy(xpath="//a[contains(text(),'Change your password')]")
	private WebElement changePassword;
	@FindBy(xpath="//a[contains(text(),'Modify your address book entries')]")
	private WebElement modifyAddress;
	@FindBy(xpath="//a[contains(text(),'Modify your wish list')]")
	private WebElement modifyWishlist;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successPasswordAlert;
	

	public void clickEditAccountInfoButton() {
		this.editAccountInfo.click(); 
	}
	public void clickChangePasswordButton() {
		this.changePassword.click(); 
	}
	public void clickModifyAddressButton() {
		this.modifyAddress.click(); 
	}
	public void clickModifyWishlistButton() {
		this.modifyWishlist.click(); 
	}
	public String displaySuccessAlert() {
		return this.successPasswordAlert.getText();
	}
}

