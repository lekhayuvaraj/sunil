package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformAccountpagePOM;
import com.training.pom.UniformChangePasswordpagePOM;
import com.training.pom.UniformCheckOutCartPOM;
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.pom.UniformRoyalBlueProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformProductRemovedFromCartTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformHomepagePOM homepagePOM;
	private static UniformRoyalBlueProductPOM productPagePOM;
	private static UniformCheckOutCartPOM checkOutCartPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homepagePOM = new UniformHomepagePOM(driver);
		productPagePOM = new UniformRoyalBlueProductPOM(driver);
		checkOutCartPOM = new UniformCheckOutCartPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void productAddedToCartTest() {
		homepagePOM.clickPremiumUniformShopLink();
		homepagePOM.clickRegulatTshirtRoyalBlue();
		productPagePOM.selectChestSize();
		productPagePOM.clickAddCartButton();
		productPagePOM.displayAddedToCartSuccessAlert();
		productPagePOM.viewCart();
		//display the Added product details
		checkOutCartPOM.displayProductDescription();
		//remove product from cart
		checkOutCartPOM.clickRemoveProductFromcart();
		String actual = "Your shopping cart is empty!";
		String expected = checkOutCartPOM.displayProductRemovedFromcartAlert();
		//assert
		 Assert.assertEquals(actual,expected, "Product description not removed.TestCase failed");
		 
		
		screenShot.captureScreenShot("productremoved");
	}
	
}
