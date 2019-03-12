package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminAddProductpagePOM {
	private WebDriver driver;

	public UniformAdminAddProductpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// product name
	@FindBy(xpath = "//input[@id='input-name1']")
	private WebElement productName;

	// meta tagtitle
	@FindBy(xpath = "//input[@id='input-meta-title1']")
	private WebElement metaTagTitle;

	// Data tab
	@FindBy(xpath = "//a[contains(text(),'Data')]")
	private WebElement dataTab;

	// Model
	@FindBy(xpath = "//input[@id='input-model']")
	private WebElement model;

	// price
	@FindBy(xpath = "//input[@id='input-price']")
	private WebElement price;
	// Quantity
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement quantity;

	// Link tab
	@FindBy(xpath = "//a[contains(text(),'Links')]")
	private WebElement linkTab;
	// categories
	@FindBy(xpath = "//input[@id='input-category']")
	private WebElement category;
	// save button
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	// warning message
		@FindBy(xpath = "//div[@class='alert alert-danger']")
		private WebElement warningmessage;
	
	public void addProductName(String ProductName) {
		// TODO Auto-generated method stub
		productName.sendKeys(ProductName);
	}

	public void addMetaTagTitle(String MetaTagTitle) {
		// TODO Auto-generated method stub
		metaTagTitle.sendKeys(MetaTagTitle);
	}

	public void clickDataTab() {
		// TODO Auto-generated method stub
		dataTab.click();
	}

	public void addModel(String Model) {
		// TODO Auto-generated method stub
		model.sendKeys(Model);
	}

	public void addPrice(String Price) {
		// TODO Auto-generated method stub
		price.sendKeys(Price);
	}

	public void addQuantity(String Quantity) {
		// TODO Auto-generated method stub
		quantity.sendKeys(Quantity);
	}

	public void clickLinksTab() {
		// TODO Auto-generated method stub
		linkTab.click();
	}

	public void addCategory(String Category) {
		// TODO Auto-generated method stub
		category.sendKeys(Category);
	}

	public void clickSaveButton() {
		// TODO Auto-generated method stub
		saveButton.click();
	}
	public String getWarningMessage() {
		return warningmessage.getText();
	}
}
