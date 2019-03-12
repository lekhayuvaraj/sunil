package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminDashboardpagePOM {
	private WebDriver driver;

	public UniformAdminDashboardpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	private WebElement dashboardPage;
	// menubutton
	@FindBy(id = "button-menu")
	private WebElement menuButton;
	// catalog
	@FindBy(xpath = "//body/div[@id='container']/nav[@id='column-left']/ul[@id='menu']/li[@id='catalog']/a[1]")
	private WebElement catalog;

	// products webelement
	@FindBy(xpath = "//li[@class='active open']//a[contains(text(),'Products')]")
	private WebElement products;

	// productsfield - name
	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement productsName;

	// productsfield - price
	@FindBy(xpath = "//input[@id='input-price']")
	private WebElement productsPrice;

	// productsfield - status
	@FindBy(xpath = "//select[@id='input-status']")
	private WebElement productsStatus;

	// productsfield - Model
	@FindBy(xpath = "//input[@id='input-model']")
	private WebElement productsModel;

	// productsfield - Quantity
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement productsQuantity;

	// productsfield - Filter Button
	@FindBy(xpath = "//button[@id='button-filter']")
	private WebElement productsFilterButton;

	// products Add new Button
		@FindBy(xpath = "//i[@class='fa fa-plus']")
		private WebElement productsAddNewButton;
	
	// category
	@FindBy(xpath = "//a[contains(text(),'Categories')]")
	private WebElement category;
	@FindBy(xpath = "//i[@class='fa fa-plus']")
	private WebElement addNewCategory;
	// category added message
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement successMessage;
	//Product added success message
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement productSuccessMessage;
	

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

	// click catalogue
	public void clickCatalogue() {
		// TODO Auto-generated method stub
		menuButton.click();
		catalog.click();
	}

	// move to products
	public void moveToProducts() {
		// TODO Auto-generated method stub
		// products mouseover
		Actions builder = new Actions(driver);
		WebElement products1 = driver.findElement(By.xpath("//*[@id=\"catalog\"]/ul/li[2]/a"));
		builder.moveToElement(products1).build().perform();
		products1.click();

	}
	
	// move to orders
		public void moveToOrders() {
			// TODO Auto-generated method stub
			// orders mouseover
			Actions builder = new Actions(driver);
			WebElement orders = driver.findElement(By.xpath("//*[@id=\"sale\"]/ul/li[1]/a"));
			builder.moveToElement(orders).build().perform();
			orders.click();

		}
	
	
	// Enter products Name
	public String enterProductsName(String ProductName) {
		// TODO Auto-generated method stub

		productsName.sendKeys(ProductName);
		return this.productsName.getAttribute("value");
	}

	// Enter products price
	public void enterProductsPrice(String ProductPrice) {
		// TODO Auto-generated method stub

		productsPrice.sendKeys(ProductPrice);
	}

	// select products status
	public void selectProductsStatus(String ProductStatus) {
		// TODO Auto-generated method stub

		productsStatus.sendKeys(ProductStatus);
	}

	// Enter products model
	public void enterProductsModel(String ProductModel) {
		// TODO Auto-generated method stub

		productsModel.sendKeys(ProductModel);
	}

	// Enter products Quantity
	public void enterProductsQuantity(String ProductQuantity) {
		// TODO Auto-generated method stub

		productsQuantity.sendKeys(ProductQuantity);
	}

	// click products filter button
	public void clickProductsFilter() {
		// TODO Auto-generated method stub

		productsFilterButton.click();
	}

	public void AddNewCategory() {
		// TODO Auto-generated method stub

		addNewCategory.click();

	}
	public void AddNewProducts() {
		// TODO Auto-generated method stub

		productsAddNewButton.click();

	}

	public String getAddedSuccessMessage() {
		return successMessage.getText();
	}

	public String getProductAddedSuccessMessage() {
		return productSuccessMessage.getText();
	}
	
	public String getfilteredproduct() {
		
	WebElement productfiltered1 = driver.findElement(By.xpath("//td[contains(text(),'blazer')]"));
		return productfiltered1 .getText();
	}
}
