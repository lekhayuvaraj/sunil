package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminEditCategorypagePOM {
private WebDriver driver; 
	
	public UniformAdminEditCategorypagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='input-meta-title1']")
	private WebElement metaTagTitle;
	@FindBy(xpath="//textarea[@id='input-meta-description1']")
	private WebElement metaTagDescription;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;
	
	public void clearMetaTagTitle(String tagtitle) {
		// TODO Auto-generated method stub
		metaTagTitle.clear();
		metaTagTitle.sendKeys(tagtitle);
		
	}
	public void clearMetaTagDescription(String  tagdescription) {
		// TODO Auto-generated method stub
		metaTagDescription.clear();
		metaTagDescription.sendKeys(tagdescription);
		
	}
	public void saveCategory() {
		// TODO Auto-generated method stub
		saveButton.click();
		
	}
	
	

}

