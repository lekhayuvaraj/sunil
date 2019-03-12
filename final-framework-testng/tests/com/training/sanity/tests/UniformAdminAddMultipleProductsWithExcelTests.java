package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformAccountpagePOM;
import com.training.pom.UniformAdminAddProductpagePOM;
import com.training.pom.UniformAdminDashboardpagePOM;
import com.training.pom.UniformAdminLoginpagePOM;
import com.training.pom.UniformChangePasswordpagePOM;
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformAdminAddMultipleProductsWithExcelTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformAdminLoginpagePOM adminLoginPOM;
	private static UniformAdminDashboardpagePOM adminDashboardPOM;
	private static UniformAdminAddProductpagePOM addProductPagePOM;
	

	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminDashboardPOM = new UniformAdminDashboardpagePOM(driver);
		adminLoginPOM = new UniformAdminLoginpagePOM(driver);
		addProductPagePOM = new UniformAdminAddProductpagePOM(driver);

		baseUrl = properties.getProperty("baseURLAdmin");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
		// admin login with credentials
		adminLoginPOM.sendusername("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginButton();
	}

	/*@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}*/

	@Test(dataProvider = "excel-inputs-products", dataProviderClass = LoginDataProviders.class)
	
	public void AddMultipleProductsWithExcel(String ProductName, String MetaTagTitle, String Model, String Price, String Quantity, String Category)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		adminDashboardPOM.clickCatalogue();
		
		adminDashboardPOM.moveToProducts();
		adminDashboardPOM.AddNewProducts();
		addProductPagePOM.addProductName(ProductName);
		addProductPagePOM.addMetaTagTitle(MetaTagTitle);
		addProductPagePOM.clickDataTab();
		addProductPagePOM.addModel(Model);
		addProductPagePOM.addPrice(Price);
		addProductPagePOM.addQuantity(Quantity);
		addProductPagePOM.clickLinksTab();
		addProductPagePOM.addCategory(Category);
		addProductPagePOM.clickSaveButton();
		
		String expected = adminDashboardPOM.getProductAddedSuccessMessage();
		String actual= "Success: You have modified products!";
		Assert.assertTrue(expected.contains(actual));
		screenShot.captureScreenShot("AdminProductsAdded");
		
		
		

		
	}

}
