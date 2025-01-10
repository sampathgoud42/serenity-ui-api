package com.hmh.automation.tools;

import java.util.concurrent.TimeUnit;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ixxus.ipm.automation.pages.AbstractPage;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

public class LoginPage extends AbstractPage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "username")
	private WebElement userInput;

	@FindBy(name = "password")
	private WebElement passwordInput;

	@FindBy(css = "button[id*='submit-button']")
	private WebElement loginButton;

	@FindBy(css = "div.error")
	private WebElement errorMessageText;

	@FindBy(css = "div#HEADER_HOME")
	private WebElement homeButton;

	@FindBy(css = "div.theme-company-logo")
	private WebElement logo;

	private String logoutCssSelector = "#HEADER_USER_MENU_LOGOUT_text";
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTest.class);

	public void navigateToUrl(String url) {
		getDriver().get(url);
		getDriver().manage().window().maximize();
	}

	public void enterUsername(String userName) {
		element(userInput).waitUntilVisible();
		userInput.clear();
		userInput.sendKeys(userName);
	}

	public void enterPassword(String password) {
		element(passwordInput).waitUntilVisible();
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}

	public void loginButtonClick() {
		element(loginButton).waitUntilVisible();
		element(loginButton).click();
	}

	public void login(String username, String password) {

		ProfilesIni profile = new ProfilesIni(); 
		FirefoxProfile myProfile = profile.getProfile("oneCMS");
		Serenity.useFirefoxProfile(myProfile); 
		LOG.info("oneCMS FF profile selected");
		getDriver().manage().window().maximize();
		Dimension d = new Dimension(1364,768);
		getDriver().manage().window().setSize(d);
		LOG.info("Window Dimension" + d );
		getDriver().manage().deleteAllCookies();

		try {

			if (System.getProperty("webdriver.driver") != null) {
				if (System.getProperty("webdriver.driver").contains("iexplorer")) {
					String currentURL = getDriver().getCurrentUrl();
					if (currentURL.contains("invalidcert")) {
						currentURL = currentURL.split("#")[1];
					}
					String commandLineURL = "";
					if (System.getProperty("webdriver.base.url") != null) {

						commandLineURL = System.getProperty("webdriver.base.url");
					}
					if (currentURL.contentEquals(Constants.ALFRESCO_URL) || currentURL.contentEquals(commandLineURL)) {
						getDriver().navigate().to("javascript:document.getElementById('overridelink').click()");
						waitABit(2000);
						Assert.assertTrue("IE redirect in case of invalidcert did not work",
								getDriver().getCurrentUrl().contentEquals(Constants.ALFRESCO_URL));
					} 

					else { 

						getDriver().navigate().refresh();
						element(By.cssSelector(logoutCssSelector)).waitUntilVisible();
						element(By.cssSelector(logoutCssSelector)).click();
						Assert.assertTrue("Logout in case of failure did not work", loginButton.isDisplayed());
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		enterUsername(username);
		enterPassword(password);
		loginButtonClick();
		waitABit(2000);
		element(homeButton).waitUntilVisible();
		Assert.assertTrue("Home button should exist!", homeButton.isDisplayed());
	}

	public void verifyLogoIsDisplayed() {
		getDriver().manage().window().maximize();
		element(logo).waitUntilVisible();
		Assert.assertTrue("Home button should exist!", logo.isDisplayed());
	}

	public void loginRejected(String username, String password) {
		getDriver().manage().window().maximize();
		enterUsername(username);
		enterPassword(password);
		loginButtonClick();
		waitABit(2000);
		Assert.assertTrue("Error message is not displayed or login was accepted!", errorMessageText.isDisplayed());
	}

	public void verifyThatCorrectErrorMessageIsDisplayed(String expectedMessage) {
		String message = errorMessageText.getText();
		Assert.assertTrue("The message was: " + message, message.contains(expectedMessage));
	}


	public void waitForElement(final String loactor, int timeout, WebDriver driver) {
		getDriver().manage().timeouts().setScriptTimeout(300, TimeUnit.SECONDS);
		new WebDriverWait(driver, timeout) {}.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return isElementPresentAndDisplay(driver, By.cssSelector(loactor));
			}
		});
	}

//Here I am using try catch block with Webdriver function isDisplayed() for catching No Element exception
	private static boolean isElementPresentAndDisplay(WebDriver driver, org.openqa.selenium.By by) {
		try {
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}   







}

//fp = webdriver.FirefoxProfile('C:/Users/264224/AppData/Roaming/Mozilla/Firefox/Profiles/ssu1zook.default')
//	browser = webdriver.Firefox(fp)
//FirefoxProfile qaTest = new FirefoxProfile(new File("C:/Users/264224/AppData/Roaming/Mozilla/Firefox/Profiles/0vrpzf99.qaTest"));

//FirefoxProfile myProfile = new FirefoxProfile();
// myProfile.setPreference("172.17.101.193",8080); //Host: DUBV-CMSQA01
//ProfilesIni profile = new ProfilesIni();        
//	FirefoxProfile myprofile = profile.getProfile("default");
//	Serenity.useFirefoxProfile(myprofile);
/*public void setupProfile() {
	  FirefoxProfile myProfile = new FirefoxProfile();
	  myProfile.setPreference("172.17.101.193",8080);
	  myProfile.setAlwaysLoadNoFocusLib(true);
	  myProfile.setEnableNativeEvents(true);
	  Serenity.useFirefoxProfile(myProfile);
	}*/
