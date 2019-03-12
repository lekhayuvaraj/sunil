package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformAdminEditOrderpagePOM {
	private WebDriver driver;

	public UniformAdminEditOrderpagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//add history button
	@FindBy(xpath="//*[@id=\"button-history\"]")
	private WebElement addHistoryButton;
	
	//select the order status

	public void selectOrderStatus() {
		// TODO Auto-generated method stub
		Select order = new Select(driver.findElement(By.id("input-order-status")));
		order.selectByValue("5");
	}
	
	public void clickAddHistoryButton() {
		// TODO Auto-generated method stub
		addHistoryButton.click();
		
	}
	
}

	