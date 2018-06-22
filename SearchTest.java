package com.kurs.selenium.example_001;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import org.junit.*;

public class SearchTest {

	private WebDriver driver;

	@Before
	public void setUp() {

		// Configure the driver of the browser 
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");

		
		// Open a new tab in google chrome
		driver = new ChromeDriver();

		// Maximaze the tab of the browser
		driver.manage().window().maximize();
		
		// Go to Google
		driver.get("http://www.google.com");
	}

	@Test
	public void testGoogleSearch() {
		
		// Search the box where can be made an input
		WebElement element = driver.findElement(By.name("q"));
		
		// Clear any text written previously 
		element.clear();

		// Write info to be searched 
		element.sendKeys("Selenium WebDriver");

		// send the form
		element.submit();
		
		WebElement element1 = driver.findElement(By.cssSelector(".rc"));
        String text = element1.getText();
        System.out.println(text);
        
        //Check if the results are matching 
        assertTrue(text.contains("Selenium WebDriver"));

	}

	@After
	public void tearDown() throws Exception {
		// Close the tab/browser
		driver.quit();
	}
}
