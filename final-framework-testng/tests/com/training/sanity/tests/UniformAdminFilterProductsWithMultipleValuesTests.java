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
import com.training.pom.UniformAdminDashboardpagePOM;
import com.training.pom.UniformAdminLoginpagePOM;
import com.training.pom.UniformChangePasswordpagePOM;
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformAdminFilterProductsWithMultipleValuesTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformAdminLoginpagePOM adminLoginPOM;
	private static UniformAdminDashboardpagePOM adminDashboardPOM;

	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		adminDashboardPOM = new UniformAdminDashboardpagePOM(driver);
		adminLoginPOM = new UniformAdminLoginpagePOM(driver);

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

	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	
	public void FilterProductsWithMultipleValuesTest(String ProductsName, String ProductPrice, String ProductStatus, String ProductModel, String ProductQuantity) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		adminDashboardPOM.clickCatalogue();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		adminDashboardPOM.moveToProducts();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		adminDashboardPOM.enterProductsName(ProductsName);
		adminDashboardPOM.enterProductsPrice(ProductPrice);
		adminDashboardPOM.clickProductsFilter();
		adminDashboardPOM.selectProductsStatus(ProductStatus);
		adminDashboardPOM.enterProductsModel(ProductModel);
		adminDashboardPOM.enterProductsQuantity(ProductQuantity);
		adminDashboardPOM.clickProductsFilter();

		String expected = adminDashboardPOM.enterProductsName(ProductsName);
		String actual = adminDashboardPOM.getfilteredproduct();
		Assert.assertTrue(expected.contains(actual));
		screenShot.captureScreenShot("ProductFiltered"+ProductsName);
	}

}
