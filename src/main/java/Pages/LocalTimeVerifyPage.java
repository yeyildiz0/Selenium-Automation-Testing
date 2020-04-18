package Pages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePage.BasePage;
import Utilities.ElementUtil;

public class LocalTimeVerifyPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By hoursSet = By.cssSelector("div.hours span.hour");
	By searchBox = By.cssSelector("input[type='text']");
	By searchButton = By.cssSelector("a.searchButton");

	public LocalTimeVerifyPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public void timeZone() throws InterruptedException {

		elementUtil.doSendKeys(searchBox, "North Park Street, Reno, NV");
		elementUtil.doClick(searchButton);
		Thread.sleep(4000);

		List<WebElement> hours = driver.findElements(hoursSet);
		List<String> ListHours = new ArrayList<String>();

		for (int i = 0; i < hours.size(); i++) {
			String h = hours.get(i).getText();
			if (!h.isEmpty()) {
				ListHours.add(h);
			}
		}
		System.out.println(ListHours);
		String secondTime = ListHours.get(1);
		String output = null;
		String  timeCity = secondTime.substring(0, secondTime.length() - 2); // Time without am or pm
		int timeRint = Integer.parseInt(timeCity);  // Convert to integer 

		if (timeRint == 1) {
			output = (secondTime.contains("am")) ? "11pm" : "11am";
		}
		else if (timeRint == 2) {
			output = (secondTime.contains("am")) ? "12pm" : "12am";		
		}
		else if (timeRint == 12) {
			output = (secondTime.contains("am")) ? "10pm" : "10am";
		}
		else {
			output =  (timeRint - 2) + secondTime.substring(secondTime.length()-2);
		}
		System.out.println("Darksky time is --> " + output);
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("haa");
        String finalDate = sdf.format(cal.getTime());
		System.out.println("RENO time is --> " + finalDate.toLowerCase());
	}
}
