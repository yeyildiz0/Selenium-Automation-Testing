package Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
//import Pages.TimeLineMainPage;
import Pages.TimeMachinePage;
import Pages.LocalTimeVerifyPage;
import Pages.TimeLineMainPage;

	public class TimeMachineTest {
		WebDriver driver;
		Properties prop;
		BasePage basePage;
		TimeLineMainPage timeLineMainPage;
		TimeMachinePage timeMachinePage;
		LocalTimeVerifyPage localTimeVerifyPage;
	
		@BeforeMethod
		public void setUp() throws InterruptedException{
			basePage = new BasePage();
			prop = basePage.initialize_properties();
			driver = basePage.initialize_driver(prop);
			timeLineMainPage = new TimeLineMainPage(driver);
			timeMachinePage = new TimeMachinePage(driver);
			localTimeVerifyPage = new LocalTimeVerifyPage(driver);
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		}
		@Test(priority=1)
		public void timeMachine() throws InterruptedException{
			timeMachinePage.userSelections();
			timeMachinePage.tempOfFourAm();
		}
		
		@Test(priority=2)
		public void timeLineMain() throws InterruptedException{
			timeLineMainPage.TimeLineSection();
		}
		
		@Test(priority=3)
		public void LocalTimeVerify() throws InterruptedException{
			localTimeVerifyPage.timeZone();
		}
				
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
	
	
}