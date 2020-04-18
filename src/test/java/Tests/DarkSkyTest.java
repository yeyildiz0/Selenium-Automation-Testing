package Tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.LocalTimeVerifyPage;

public class DarkSkyTest {
	
	//Define the class fields
	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LocalTimeVerifyPage darkSkyPage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		darkSkyPage = new LocalTimeVerifyPage(driver);
	}
	
	@Test(priority = 1)
	public void timeZoneVerify() throws InterruptedException {
		darkSkyPage.timeZone();		
	}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
