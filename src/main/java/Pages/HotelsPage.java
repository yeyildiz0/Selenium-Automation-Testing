package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.ElementUtil;
import Utilities.JavaScriptUtil;

public class HotelsPage extends BasePage{
	
	// Define the class fields
	WebDriver driver;
	ElementUtil elementUtil;
	
	// Define the locators
	By clsPopup = By.cssSelector("a.footer-continue-link.di-ib.fw-bold"); // Locates the Pop up box
	By searchWord = By.xpath("//*[@id = 'qf-0q-destination']");  // Location of search box
	By searchBtn = By.cssSelector("button.cta.cta-strong"); // Locates the search button
	By firstDropDownCity = By.cssSelector("#citysqm-asi0-s0"); // Locates the first selection in the drop down list
	By hotels3stared = By.id("f-label-star-rating-3"); // Locates the 3 starred hotels check box
	By hotels4stared = By.id("f-label-star-rating-4"); // Locates the 4 starred hotels check box
	By hotels5stared = By.id("f-label-star-rating-5"); // Locates the 5 starred hotels check box
	By hotelTitle = By.cssSelector("a.property-name-link"); // Locates the title of the hotel
	By milesFromCenter = By.cssSelector("ul.property-landmarks li:nth-child(1)"); // Locates the text with mile info in it.
	
	
	public HotelsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public void getHotels3starred() throws InterruptedException  {
		
		elementUtil.doClick(clsPopup);
		elementUtil.doSendKeys(searchWord, "newyork");
		elementUtil.doClick(firstDropDownCity);
		elementUtil.doClick(searchBtn);
		elementUtil.doClick(hotels3stared);
		JavaScriptUtil.scrollDownIterator(driver); // Scrolls the page down
		printResults(hotelTitle, milesFromCenter);
	}
	public List<String> printResults(By hotelTitle, By milesFromCenter) {
		
		
		return null;
		
	}
}
