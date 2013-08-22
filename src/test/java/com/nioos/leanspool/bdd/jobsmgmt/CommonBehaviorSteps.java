package com.nioos.leanspool.bdd.jobsmgmt;



import java.io.File;

import javax.sql.DataSource;

import org.dbunit.database.DatabaseDataSourceConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nioos.leanspool.dao.DataSourceUtils;



/**
 * Tests steps.
 * @author Hipolito Jimenez.
 */
public class CommonBehaviorSteps { // NOPMD
	
	
	/**
	 * Sleep on the first load.
	 */
	private static final int SLEEP = 1000;
	
	
	/**
	 * TimeOut.
	 */
	private static final int TIMEOUT = 5;
	
	
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
	 * Setup before the tests.
	 * Cleanup and fill the database.
	 * @throws Exception on error.
	 */
	@BeforeStories
	public final void beforeStories() throws Exception { // NOPMD
		final DataSource dataSource =
				DataSourceUtils.buildDataSource("/jdbc.properties");
		final IDatabaseConnection dbConnection =
			new DatabaseDataSourceConnection(dataSource);
		final FlatXmlDataSetBuilder flatXmlDataSetBuilder =
			new FlatXmlDataSetBuilder();
		final IDataSet printersDataSet =
			flatXmlDataSetBuilder.build(
				new File("./src/test/resources/dbunit/PrintersTest.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, printersDataSet);
		final IDataSet printJobsDataSet =
			flatXmlDataSetBuilder.build(
				new File("./src/test/resources/dbunit/PrintJobsTest.xml"));
		DatabaseOperation.CLEAN_INSERT.execute(dbConnection, printJobsDataSet);
		dbConnection.getConnection().commit();
		dbConnection.close();
	}
	
	
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
	 * Given the user opens the url $url.
	 * @param url the url.
	 */
	@Given("the user opens the url $url")
	public final void givenTheUserOpensTheUrl(final String url) {
		navigateTo(chromeDriver, url);
		navigateTo(firefoxDriver, url);
		navigateTo(internetExplorerDriver, url);
	}
	
	
	/**
	 * Navigate to the given url.
	 * @param webDriver the web driver (browser).
	 * @param url the url.
	 */
	private void navigateTo(final WebDriver webDriver, final String url) {
		webDriver.get(url);
		webDriver.manage().window().maximize();
	}
	
	
	/**
	 * Step.
	 * When the user waits for page to be loaded.
	 */
	@When("the user waits for page to be loaded")
	public final void whenTheUserWaitsForPageToBeLoaded() {
		waitsForTheTreeToBeDisplayed(chromeDriver);
		waitsForTheTreeToBeDisplayed(firefoxDriver);
		waitsForTheTreeToBeDisplayed(internetExplorerDriver);
	}
	
	
	/**
	 * Step.
	 * When the user waits for the tree $tree to be loaded.
	 * @param tree the tree.
	 */
	@When("the user waits for the tree $tree to be loaded")
	public final void whenTheUserWaitsForTheTreeToBeLoaded(final String tree) {
		waitsForTheDataToBeLoaded(chromeDriver, tree);
		waitsForTheDataToBeLoaded(firefoxDriver, tree);
		waitsForTheDataToBeLoaded(internetExplorerDriver, tree);
	}
	
	
	/**
	 * Waits for the tree to be displayed.
	 * @param webDriver the web driver.
	 */
	private void waitsForTheTreeToBeDisplayed(final WebDriver webDriver) {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException exc) {
			System.out.println(exc); // NOPMD
		}
		waitsForTheDataToBeLoaded(webDriver, "allJobsTree");
	}
	
	
	/**
	 * Waits for the data to be loaded.
	 * @param webDriver the web driver.
	 * @param tree the tree.
	 */
	private void waitsForTheDataToBeLoaded(final WebDriver webDriver,
			final String tree) {
		final WebDriverWait wait = new WebDriverWait(webDriver, TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(tree)));
	}
	
	
	/**
	 * Step.
	 * And the user clicks the first node in the tree $tree.
	 * @param tree the tree.
	 */
	@When("the user clicks the first node in the tree $tree")
	public final void whenTheUserClicksTheFirstNodeInTheTree(
			final String tree) {
		final By treeLocator = By.id(tree);
		clicksTheFirstNodeInTheTree(treeLocator, chromeDriver);
		clicksTheFirstNodeInTheTree(treeLocator, firefoxDriver);
		clicksTheFirstNodeInTheTree(treeLocator, internetExplorerDriver);
	}
	
	
	/**
	 * Clicks the first node in the tree.
	 * @param treeLocator the tree locator.
	 * @param webDriver the web driver.
	 */
	private void clicksTheFirstNodeInTheTree(final By treeLocator,
			final WebDriver webDriver) {
		final WebElement treeWebElement = webDriver.findElement(treeLocator);
		final WebElement firstNode =
			treeWebElement.findElement(By.xpath("./div"));
		firstNode.click();
	}
	
	
	/**
	 * Step.
	 * And the user orders the grid by the $field field.
	 * @param field the field.
	 */
	@When("the user orders the grid by the $field field")
	public final void whenTheUserOrdersTheGridByThe(final String field) {
		final By headerLocator = By.xpath("//span[text()=\"" + field + "\"]");
		clicksOn(chromeDriver, headerLocator);
		clicksOn(firefoxDriver, headerLocator);
		clicksOn(internetExplorerDriver, headerLocator);
	}
	
	
	/**
	 * Clicks on something.
	 * @param webDriver the web driver.
	 * @param locator the locator.
	 */
	private void clicksOn(final WebDriver webDriver, final By locator) {
		final WebElement webElement = webDriver.findElement(locator);
		webElement.click();
	}
	
	
	/**
	 * Step.
	 * Then the user views $text as the first grid row text
	 * @param text the first grid row text.
	 */
	@Then("the user views $text as the first grid row text")
	public final void thenTheUserViewsTheFirstGridRowText(final String text) {
		checksFirstGridRowText(chromeDriver, text);
		checksFirstGridRowText(firefoxDriver, text);
		checksFirstGridRowText(internetExplorerDriver, text);
	}
	
	
	/**
	 * Checks the first grid row text.
	 * @param webDriver the web driver.
	 * @param text the text.
	 */
	private void checksFirstGridRowText(final WebDriver webDriver,
			final String text) {
		final By gridLocator = By.id("printJobsGrid");
		final WebElement gridElement = webDriver.findElement(gridLocator);
		final By locator = By.className("x-grid-cell-first");
		final WebElement webElement = gridElement.findElement(locator);
		final String rowText = webElement.getText();
		Assert.assertEquals("Wrong grid row text", text, rowText);
	}
	
	
	/**
	 * Step.
	 * Then the page title is $title.
	 * @param title the page title.
	 */
	@Then("the page title is $title")
	public final void thenThePageTitleIs(final String title) {
		checkTitle(chromeDriver, title);
		checkTitle(firefoxDriver, title);
		checkTitle(internetExplorerDriver, title);
	}
	
	
	/**
	 * Checks the page title.
	 * @param driver the web driver (browser).
	 * @param title the title.
	 */
	private void checkTitle(final WebDriver driver, final String title) {
		final String pageTitle = driver.getTitle();
		Assert.assertEquals("Wrong page title", title, pageTitle);
	}
	
	
	/**
	 * Step.
	 * And the user clicks on the $tab accordion tab.
	 * @param tab the tab.
	 */
	@When("the user clicks on the $tab accordion tab")
	public final void whenTheUserClicksOnTheAccordionTab(final String tab) {
		final By tabLocator = By.id(tab);
		clicksOn(chromeDriver, tabLocator);
		clicksOn(firefoxDriver, tabLocator);
		clicksOn(internetExplorerDriver, tabLocator);
	}
	
	
	/**
	 * Step.
	 * And the user double clicks the first node in the tree $tree.
	 * @param tree the tree.
	 */
	@When("the user double clicks the first node in the tree $tree")
	public final void whenTheUserDoubleClicksTheFirstNodeInTheTree(
			final String tree) {
		final By treeLocator = By.id(tree);
		doubleClicksTheFirstNodeInTheTree(treeLocator, chromeDriver);
		doubleClicksTheFirstNodeInTheTree(treeLocator, firefoxDriver);
		doubleClicksTheFirstNodeInTheTree(treeLocator, internetExplorerDriver);
	}
	
	
	/**
	 * Double clicks the first node in the tree.
	 * @param treeLocator the tree locator.
	 * @param webDriver the web driver.
	 */
	private void doubleClicksTheFirstNodeInTheTree(final By treeLocator,
			final WebDriver webDriver) {
		final WebElement treeWebElement = webDriver.findElement(treeLocator);
		final WebElement firstNode =
			treeWebElement.findElement(By.xpath("./div"));
		firstNode.click();
		final Actions actions = new Actions(webDriver);
		actions.doubleClick(firstNode);
		actions.perform();
	}
	
	
}
