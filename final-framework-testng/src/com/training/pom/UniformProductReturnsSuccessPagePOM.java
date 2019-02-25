package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformProductReturnsSuccessPagePOM {
	private WebDriver driver;

	public UniformProductReturnsSuccessPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Return success1 message
	@FindBy(xpath = "//*[@id=\"content\"]/p[1]")
	private WebElement message1;
	
	//Return success2 message
		@FindBy(xpath = "//*[@id=\"content\"]/p[2]")
		private WebElement message2;

	
	
	public String getSuccessMessage1() {
		return message1.getText();
		
	}
	public String getSuccessMessage2() {
		
		return message2.getText();
	}
}
