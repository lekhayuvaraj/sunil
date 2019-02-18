package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminDashboardpagePOM {
private WebDriver driver; 
	
	public UniformAdminDashboardpagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h1[contains(text(),'Dashboard')]")
	private WebElement dashboardPage;
	

	public boolean displayDashboardPageTitle() {
		// TODO Auto-generated method stub
		dashboardPage.isDisplayed();
		return true;
	}




}

