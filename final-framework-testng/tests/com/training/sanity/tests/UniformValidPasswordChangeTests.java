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
import com.training.pom.UniformHomepagePOM;
import com.training.pom.UniformLoginpagePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UniformValidPasswordChangeTests {

	private WebDriver driver;
	private String baseUrl;
	private static UniformHomepagePOM homepagePOM;
	private static UniformLoginpagePOM loginpagePOM;
	private UniformAccountpagePOM accountpagePOM;
	private UniformChangePasswordpagePOM changePasswordpagePOM;
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
		loginpagePOM = new UniformLoginpagePOM(driver);
		accountpagePOM = new UniformAccountpagePOM(driver);
		changePasswordpagePOM = new UniformChangePasswordpagePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		homepagePOM.clickMyAccount();
		homepagePOM.clickLoginButton();
		loginpagePOM.sendEmailId("indujayuvaraj@gmail.com");
		loginpagePOM.sendPassword("lekha123");
		loginpagePOM.clickLoginButton();
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	@Test(priority=1)
	public void validChangePasswordTest() {
		accountpagePOM.clickChangePasswordButton();
		changePasswordpagePOM.sendPassword("lekha1234");
		changePasswordpagePOM.sendConfirmPassword("lekha1234");
		changePasswordpagePOM.clickContinueButton();
		
		String expected = "Success: Your password has been successfully updated.";
		String actual = accountpagePOM.displaySuccessAlert();
		//assert
		 Assert.assertEquals(expected,actual, "confirmation password not matched.TestCase failed");
		screenShot.captureScreenShot("PasswordChangedyes");
	}
}
