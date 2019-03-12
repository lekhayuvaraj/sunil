package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.UniformAdminAddCategorypagePOM;
import com.training.pom.UniformAdminDashboardpagePOM;
import com.training.pom.UniformAdminLoginpagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformAdminAddCategoryDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods;
	private static UniformAdminLoginpagePOM adminLoginPOM;
	private static UniformAdminDashboardpagePOM adminDashboardPOM;
	private static UniformAdminAddCategorypagePOM addCategoryPOM;
	
	
	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		adminDashboardPOM = new UniformAdminDashboardpagePOM(driver);
		adminLoginPOM = new UniformAdminLoginpagePOM(driver);
		addCategoryPOM = new UniformAdminAddCategorypagePOM(driver);
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


	@Test(dataProvider = "db-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String categoryname, String description, String metatagtitle, String metatagdescription) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		adminDashboardPOM.moveToCategory();
		adminDashboardPOM.AddNewCategory();
		String categoryname1 = addCategoryPOM.addCategoryName("Sports");
		String CategoryDescription1 = addCategoryPOM.addCategoryDescription("Sports shoes");
		String TagTitle= addCategoryPOM.addCategoryTagTitle("shoes");
		String TagDescription= addCategoryPOM.addCategoryTagDescription("Sports shoes");
		addCategoryPOM.clickSave();
		Assert.assertEquals(categoryname1,categoryname);
		Assert.assertEquals(CategoryDescription1,description);
		Assert.assertEquals(TagTitle,metatagtitle);
		Assert.assertEquals(TagDescription,metatagdescription);
		screenShot.captureScreenShot("AdminCategoryDBTest");
		

	}

}