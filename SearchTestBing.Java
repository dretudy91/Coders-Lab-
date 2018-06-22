package com.kurs.selenium.example_002;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import java.util.List;

//import static org.junit.Assert.*;

import org.junit.*;

public class SearchTestBing {

	private WebDriver driver;

	@Before
	public void setUp() {

		// onfigure the driver of the browser
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

		
		// Open a new tab in google chrome
		driver = new ChromeDriver();

		// Maximize the tab of the browser
		driver.manage().window().maximize();
		
		// go to Bing
		driver.get("http://www.bing.com");
	}

	@Test
	public void testGoogleSearch() {
		
		// Search the box where can be made an input
		WebElement element = driver.findElement(By.name("q"));
		
		// Clear any text/string written previously
		element.clear();

		// Write info to be searched
		element.sendKeys("2018 FIFA World Cup Wiki");
		
		// Send the form
		element.submit();
		
		/* XPath Solution
		driver.findElement(By.xpath()).click(); 
		*/
		
		// PartialLinkText Solution 
		driver.findElement(By.partialLinkText("2018 FIFA World Cup - Wikipedia")).click();
		
		//Method for checking and compare the results 
		AssertTrue(driver.findElements(By.cssSelector("firstHeading"))).getText().contains("2018 FIFA World Cup");
		
	}

	private WebElement AssertTrue (List<WebElement> findElements) {
		// TODO Auto-generated method stub
		return null;
	}

	@After
	public void tearDown() throws Exception {
		// Close the tab/browser
		driver.quit();
	}
}
