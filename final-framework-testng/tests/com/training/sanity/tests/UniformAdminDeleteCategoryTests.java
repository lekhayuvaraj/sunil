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
import com.training.pom.UniformAdminAddCategorypagePOM;
import com.training.pom.UniformAdminDashboardpagePOM;
import com.training.pom.UniformAdminEditCategorypagePOM;
import com.training.pom.UniformAdminLoginpagePOM;
import com.training.pom.UniformChangePasswordpagePOM;
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformAdminDeleteCategoryTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformAdminLoginpagePOM adminLoginPOM;
	private static UniformAdminDashboardpagePOM adminDashboardPOM;
	private static UniformAdminAddCategorypagePOM addCategoryPOM;
	private static UniformAdminEditCategorypagePOM EditCategoryPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;
	

	@BeforeClass
	public  void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminDashboardPOM = new UniformAdminDashboardpagePOM(driver);
		adminLoginPOM = new UniformAdminLoginpagePOM(driver);
		addCategoryPOM = new UniformAdminAddCategorypagePOM(driver);
		EditCategoryPOM= new UniformAdminEditCategorypagePOM(driver);
		baseUrl = properties.getProperty("baseURLAdmin");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		adminLoginPOM.sendusername("admin");
		adminLoginPOM.sendPassword("admin@123");
		adminLoginPOM.clickLoginButton();
	}

	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void adminEditCategoryTest() {
		
		adminDashboardPOM.moveToCategory();
		addCategoryPOM.selectCheckBoxesOfCategory();
		addCategoryPOM.clickDeleteButton();
		driver.switchTo().alert().accept();
		String expected = adminDashboardPOM.getAddedSuccessMessage();
		String actual= "Success: You have modified categories!";
		Assert.assertTrue(expected.contains(actual));
		screenShot.captureScreenShot("AdminCategoryDeleted");
	
}
}

