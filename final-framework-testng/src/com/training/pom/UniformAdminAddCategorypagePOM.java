package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformAdminAddCategorypagePOM {
private WebDriver driver; 
	
	public UniformAdminAddCategorypagePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="input-name1")
	private WebElement categoryName;
	@FindBy(xpath="//div[@class='note-editable panel-body']")
	private WebElement categoryDescription;
	@FindBy(id="input-meta-title1")
	private WebElement categoryMetatagTitle;
	@FindBy(id="input-meta-description1")
	private WebElement categoryMetatagDescription;
	@FindBy(xpath="//i[@class='fa fa-save']")
	private WebElement categorySave;
	//edit button of blazer3-5
	@FindBy(xpath="//tr[.//td='Blazers Test(5-7)']//a")
	private WebElement editBlazers;

	//checkbox of dfc
	@FindBy(xpath="//tr[.//td='dfc']//input")
	private WebElement categorydfc;
	//checkbox of to delete 1
	@FindBy(xpath="//tr[.//td='to delete1']//input")
	private WebElement categorytodelete1;
	//delete button
	@FindBy(xpath="//div[@class='pull-right']//button[@type='button']")
	private WebElement deletebutton;
	
	
	public String addCategoryName(String categoryname) {
		// TODO Auto-generated method stub
		categoryName.sendKeys(categoryname);
		return this.categoryName.getAttribute("value");
		
	}
	public String addCategoryDescription(String description) {
		// TODO Auto-generated method stub
		categoryDescription.sendKeys(description);
		return this.categoryDescription.getAttribute("value") ;
		
	}
	
	public String addCategoryTagTitle(String tagtitle) {
		// TODO Auto-generated method stub
		categoryMetatagTitle.sendKeys(tagtitle);
		return categoryMetatagTitle.getAttribute("value") ;
	}
	public String addCategoryTagDescription(String tagdescription) {
		// TODO Auto-generated method stub
		categoryMetatagDescription.sendKeys(tagdescription);
		return categoryMetatagDescription.getAttribute("value");
	}
	public void clickSave() {
		// TODO Auto-generated method stub
		categorySave.click();
	}
	public void clickEditBlazers() {
		// TODO Auto-generated method stub
		editBlazers.click();
		
	}
	public void selectCheckBoxesOfCategory() {
		// TODO Auto-generated method stub
		categorydfc.click();
		categorytodelete1.click();
	}
	public void clickDeleteButton() {
		// TODO Auto-generated method stub
		deletebutton.click();
	}
}

