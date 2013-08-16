package com.nioos.leanspool.bdd.jobsmgmt;

import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



/**
 * Tests steps.
 * @author Hipolito Jimenez.
 */
public class CommonBehaviorSteps {
	
	
	/**
	 * The page title.
	 */
	private static final String PAGE_TITLE = "Lean Spooler";
	
	
	/**
	 * Test base URL.
	 */
	private static final String BASE_URL = "http://localhost:8080/leanspool/";
	
	
	/**
	 * Test html page.
	 */
	private static final String HTML_URL = BASE_URL + "jobs-management.html";
	
	
	/**
	 * Chrome web driver.
	 */
	private final transient WebDriver chromeDriver = new ChromeDriver();
	
	
	/**
	 * Firefox web driver.
	 */
	private final transient WebDriver firefoxDriver = new FirefoxDriver();
	
	
	/**
	 * Internet Explorer web driver.
	 */
	private final transient WebDriver internetExplorerDriver =
		new InternetExplorerDriver();
	
	
	/**
	 * Cleanup after the tests.
	 * Close all the browsers.
	 */
	@AfterStories
	public final void afterStories() {
		chromeDriver.quit();
		firefoxDriver.close();
		internetExplorerDriver.quit();
	}
	
	
	/**
	 * Step.
	 * Given the user opens the jobs-management page.
	 */
	@Given("the user opens the jobs-management page")
	public final void givenTheUserOpensTheJobsManagementPage() {
		getHomePage(chromeDriver);
		getHomePage(firefoxDriver);
		getHomePage(internetExplorerDriver);
	}
	
	
	/**
	 * Navigate to the home page.
	 * @param webDriver the web driver (browser).
	 */
	private void getHomePage(final WebDriver webDriver) {
		webDriver.get(HTML_URL);
		checkTitle(webDriver);
	}
	
	
	/**
	 * Checks the page title.
	 * @param driver the web driver (browser).
	 */
	private void checkTitle(final WebDriver driver) {
		final String title = driver.getTitle();
		Assert.assertEquals("Wrong page title", PAGE_TITLE, title);
	}
	
	
}
