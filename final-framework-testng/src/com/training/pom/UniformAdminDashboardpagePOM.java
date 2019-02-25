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
	//menubutton
	@FindBy(id="button-menu")
	private WebElement menuButton;
	//catalog
	@FindBy(xpath="//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='catalog']/a[1]")
	private WebElement catalog;
	//category
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	private WebElement category;
	@FindBy(xpath="//i[@class='fa fa-plus']")
	private WebElement addNewCategory;
	//category added message
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement successMessage;
	public boolean displayDashboardPageTitle() {
		// TODO Auto-generated method stub
		dashboardPage.isDisplayed();
		return true;
	}

	public void moveToCategory() {
		// TODO Auto-generated method stub
		menuButton.click();
		catalog.click();
		category.click();
		
		
	}
	public void AddNewCategory() {
		// TODO Auto-generated method stub
		
		addNewCategory.click();
		
	}
	public String getAddedSuccessMessage() {
		return successMessage.getText();
	}

}

