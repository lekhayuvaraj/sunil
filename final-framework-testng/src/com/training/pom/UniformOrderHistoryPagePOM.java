package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformOrderHistoryPagePOM {
	private WebDriver driver;

	public UniformOrderHistoryPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//view button for order id 24
	@FindBy(xpath = "//tr[.//td='#24']//a")
	private WebElement viewOrderForOrderID24;
	
	//status for order
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/table/tbody/tr[1]/td[4]")
	private WebElement statusForOrderID24;
	
	

	
	public void clickOnViewOrder() {

		viewOrderForOrderID24.click();
	}
	
	public String getOrderStatus() {

		return statusForOrderID24.getText();
	}
}
