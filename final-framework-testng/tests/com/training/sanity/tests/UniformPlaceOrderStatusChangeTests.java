package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.http.impl.conn.tsccm.WaitingThread;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformAccountpagePOM;
import com.training.pom.UniformAdminDashboardpagePOM;
import com.training.pom.UniformAdminEditOrderpagePOM;
import com.training.pom.UniformAdminLoginpagePOM;
import com.training.pom.UniformAdminOrderpagePOM;
import com.training.pom.UniformChangePasswordpagePOM;
import com.training.pom.UniformCheckOutCartPOM;
import com.training.pom.UniformCheckOutCartStepsPOM;
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.pom.UniformOrderHistoryPagePOM;
import com.training.pom.UniformOrderInformationPagePOM;
import com.training.pom.UniformOrderPlacedPagePOM;
import com.training.pom.UniformProductReturnsPagePOM;
import com.training.pom.UniformProductReturnsSuccessPagePOM;
import com.training.pom.UniformRoyalBlueProductPOM;
import com.training.pom.UniformRustProductDetailsPOM;
import com.training.pom.UniformYellowProductDetailsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformPlaceOrderStatusChangeTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformHomepagePOM homepagePOM;
	private static UniformLoginpagePOM loginpagePOM;
	private static UniformAccountpagePOM accountpagePOM;
	private static UniformRoyalBlueProductPOM productPagePOM;
	private static UniformYellowProductDetailsPOM yellowTshirtPagePOM;
	private static UniformRustProductDetailsPOM rustTshirtPagePOM;
	private static UniformCheckOutCartPOM checkoutPOM;
	private static UniformCheckOutCartStepsPOM checkoutStepsPOM;
	private static UniformOrderPlacedPagePOM orderPlacedPOM;
	private static UniformOrderHistoryPagePOM orderHistoryPOM;
	private static UniformOrderInformationPagePOM orderInformationPOM;
	private static UniformProductReturnsPagePOM productReturnsPOM;
	private static UniformProductReturnsSuccessPagePOM productReturnsSuccessPOM;
	private static UniformAdminLoginpagePOM adminLoginPOM;
	private static UniformAdminDashboardpagePOM adminDashboardPOM;
	private static UniformAdminOrderpagePOM adminOrderPOM;
	private static UniformAdminEditOrderpagePOM adminEditOrderPOM;

	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		homepagePOM = new UniformHomepagePOM(driver);
		loginpagePOM = new UniformLoginpagePOM(driver);
		accountpagePOM = new UniformAccountpagePOM(driver);
		productPagePOM = new UniformRoyalBlueProductPOM(driver);
		yellowTshirtPagePOM = new UniformYellowProductDetailsPOM(driver);
		rustTshirtPagePOM = new UniformRustProductDetailsPOM(driver);
		checkoutPOM = new UniformCheckOutCartPOM(driver);
		checkoutStepsPOM = new UniformCheckOutCartStepsPOM(driver);
		orderPlacedPOM = new UniformOrderPlacedPagePOM(driver);
		orderHistoryPOM = new UniformOrderHistoryPagePOM(driver);
		orderInformationPOM = new UniformOrderInformationPagePOM(driver);
		productReturnsPOM = new UniformProductReturnsPagePOM(driver);
		productReturnsSuccessPOM = new UniformProductReturnsSuccessPagePOM(driver);
		adminDashboardPOM = new UniformAdminDashboardpagePOM(driver);
		adminLoginPOM = new UniformAdminLoginpagePOM(driver);
		adminOrderPOM = new UniformAdminOrderpagePOM(driver);
		adminEditOrderPOM = new UniformAdminEditOrderpagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@Test(priority = 1)
	public void OrderProductTest() {
		homepagePOM.clickMyAccount();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepagePOM.clickLoginButton();
		loginpagePOM.sendEmailId("indujayuvaraj@gmail.com");
		loginpagePOM.sendPassword("lekha123");
		loginpagePOM.clickLoginButton();
		accountpagePOM.moveToUniformStore();

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
				homepagePOM.regularTshirtRoyalBlue);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homepagePOM.clickRegulatTshirtRoyalBlue();
		productPagePOM.selectChestSize();
		productPagePOM.clickAddCartButton();
		productPagePOM.viewCart();
		checkoutPOM.clickCheckOutButton();
		// checkout steps
		checkoutStepsPOM.selectExistingAddressInStep2();
		checkoutStepsPOM.selectExistingAddressInStep3();
		checkoutStepsPOM.enterAddComments("Quality Product");
		checkoutStepsPOM.selectShippingMethod();
		checkoutStepsPOM.selectCheckBox();
		checkoutStepsPOM.selectPaymentMethod();
		checkoutStepsPOM.confirmOrder();

		// open admin url in new window
		String adminurl = "http://uniform.upskills.in/admin";
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", adminurl);

		// admin login with credentials
		adminLoginPOM.sendusername("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginButton();
		// move to order
		adminDashboardPOM.moveToOrders();
		// filter the order with name -lekha
		adminOrderPOM.enterCustomer("lekha");
		adminOrderPOM.clickfilterbutton();
		adminOrderPOM.clickviewbuttonofOrder();
		//select the order status
		adminEditOrderPOM.selectOrderStatus();
		adminEditOrderPOM.clickAddHistoryButton();
		
		//open the uniform url application in new tab of browser
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN); 
		driver.findElement(By.linkText(baseUrl)).sendKeys(selectLinkOpeninNewTab);
		
		//login with user credentials
		homepagePOM.clickMyAccount();
		homepagePOM.clickLoginButton();
		loginpagePOM.sendEmailId("indujayuvaraj@gmail.com");
		loginpagePOM.sendPassword("lekha123");
		loginpagePOM.clickLoginButton();
		//move to order history page
		accountpagePOM.goToOrderHistory();
		
		//assert
		String expected = "complete";
		String actual = orderHistoryPOM.getOrderStatus();
		Assert.assertEquals(expected,actual);
	

	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

}
