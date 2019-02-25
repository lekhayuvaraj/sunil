package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UniformOrderInformationPagePOM {
	private WebDriver driver;

	public UniformOrderInformationPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//return for model'TBSM'
	@FindBy(xpath = "//tr[.//td='TBSM-NUR-3rdSTD']//a[2]")
	private WebElement returnlinkForTBSM;
	

	
	public void clickToReturnProduct() {
		returnlinkForTBSM.click();
		
	}
}
