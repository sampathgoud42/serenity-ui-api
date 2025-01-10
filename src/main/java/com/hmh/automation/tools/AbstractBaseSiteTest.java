package com.hmh.automation.tools;

import com.ixxus.ipm.automation.pages.alfresco.ListViewsPage;
//import com.ixxus.ipm.automation.pages.alfresco.LoginPage;
import com.hmh.automation.tools.LoginPage;
import com.ixxus.ipm.automation.pages.alfresco.ShareHeaderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;
import com.ixxus.ipm.automation.pages.alfresco.myprofile.MyProfilePage;
import com.ixxus.ipm.automation.pages.alfresco.myprofile.UserTrashcanPage;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepEventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public abstract class AbstractBaseSiteTest {
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTest.class);

	@Managed(uniqueSession = false)
	public WebDriver driver;

//	@ManagedPages(defaultUrl = "https://alfresco.demo.ixxus.co.uk:8443/share/page/")
//	@ManagedPages(defaultUrl = "http://10.34.36.46:8080/share/page")
	@ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
	
	public Pages pages;
	protected String siteType;
	protected String siteName;

	public AbstractBaseSiteTest() {
		this.siteName = "";
	}

	public void setSiteType() {
		this.siteType = null;
	}

	@Before
	public void setup() {
		setSiteType();
		((LoginPage) this.pages.currentPageAt(LoginPage.class)).login(
				"automation_user_01", "welcome");
		LOG.info("Done: login");
		if (this.siteType == null) {
			LOG.info("No Site Type");
			this.siteName = ((ShareHeaderPage) this.pages
					.currentPageAt(ShareHeaderPage.class)).createNewSite();
		} else {
			LOG.info("Choosen Site Type");
			this.siteName = ((ShareHeaderPage) this.pages
					.currentPageAt(ShareHeaderPage.class))
					.createNewSiteWithType(this.siteType);
		}
		LOG.info("Done: createNewSite");

		((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
				.clickOnDocumentLibraryButton();
		LOG.info("Done: clickOnDocumentLibraryButton");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.selectAViewFromOptions("Detailed View");
		LOG.info("Done: selectAViewFromOptions");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.verifyCurrentView("Detailed View");
		LOG.info("Done: verifyCurrentView");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.ensureFoldersAreShown();
		LOG.info("Done: ensureFoldersAreShown");
	}

	@After
	public void tearDown() {
		StepEventBus.getEventBus().clearStepFailures();
		LOG.info("Done: clearStepFailures");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.siteFinderButton();
		LOG.info("Done: siteFinderButton");
		((SiteFinderPage) this.pages.currentPageAt(SiteFinderPage.class))
				.searchForASite(this.siteName);
		LOG.info("Done: searchForASite");
		((SiteFinderPage) this.pages.currentPageAt(SiteFinderPage.class))
				.deleteSite(this.siteName, false);
		LOG.info("Done: deleteSite");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.myProfileButtonClick();
		LOG.info("Done: myProfileButtonClick");
		((MyProfilePage) this.pages.currentPageAt(MyProfilePage.class))
				.trashcanMenuClick();
		LOG.info("Done: trashcanMenuClick");
		((UserTrashcanPage) this.pages.currentPageAt(UserTrashcanPage.class))
				.emptyTrashcan();
		LOG.info("Done: emptyTrashcan");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.logoutButtonClick();
		LOG.info("Done: logoutButtonClick");
	}
}









/*package com.hmh.automation.tools;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ixxus.ipm.automation.pages.alfresco.ListViewsPage;
import com.ixxus.ipm.automation.pages.alfresco.LoginPage;
import com.ixxus.ipm.automation.pages.alfresco.ShareHeaderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteFinderPage;
import com.ixxus.ipm.automation.pages.alfresco.SiteHeaderPage;
import com.ixxus.ipm.automation.pages.alfresco.myprofile.MyProfilePage;
import com.ixxus.ipm.automation.pages.alfresco.myprofile.UserTrashcanPage;

//@RunWith(ThucydidesParameterizedRunner.class)
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH02_InviteUsersToMySiteAsDiffrentRoles.csv", separator = ConstantsHMH.CSV_SEPARATOR)



public abstract class AbstractBaseSiteTest {
	private static final Logger LOG = LoggerFactory
			.getLogger(AbstractBaseSiteTest.class);

	String username,password;
	
	@Managed(uniqueSession = false)
	public WebDriver driver;

	@ManagedPages(defaultUrl = "http://10.34.36.46:8080/share/page")
	//@ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
	
	
	public Pages pages;
	protected String siteName;
	

	public AbstractBaseSiteTest() {
		this.siteName = "";
	}
	
	// String username,password;
	
	
	@Before
	
	public void setup() {
	((LoginPage) this.pages.currentPageAt(LoginPage.class)).login(
			"automation_user_01", "welcome");
		
	//	((LoginPage) this.pages.currentPageAt(LoginPage.class)).login(username, password);
		
//		login(String username, String password) {
//			((LoginPage) currentPage()).login(username, password);
		
		
		LOG.info("Done: login");
		this.siteName = ((ShareHeaderPage) this.pages
				.currentPageAt(ShareHeaderPage.class)).createNewSite();
		LOG.info("Done: createNewSite");

		((SiteHeaderPage) this.pages.currentPageAt(SiteHeaderPage.class))
				.clickOnDocumentLibraryButton();
		LOG.info("Done: clickOnDocumentLibraryButton");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.selectAViewFromOptions("Detailed View");
		LOG.info("Done: selectAViewFromOptions");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.verifyCurrentView("Detailed View");
		LOG.info("Done: verifyCurrentView");
		((ListViewsPage) this.pages.currentPageAt(ListViewsPage.class))
				.ensureFoldersAreShown();
		LOG.info("Done: ensureFoldersAreShown");
	}

	@After
	public void tearDown() {
		StepEventBus.getEventBus().clearStepFailures();
		LOG.info("Done: clearStepFailures");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.siteFinderButton();
		LOG.info("Done: siteFinderButton");
		((SiteFinderPage) this.pages.currentPageAt(SiteFinderPage.class))
				.searchForASite(this.siteName);
		LOG.info("Done: searchForASite");
		((SiteFinderPage) this.pages.currentPageAt(SiteFinderPage.class))
			//	.deleteSite(this.siteName); //Removed Argument
				.deleteSite(this.siteName, false); 
		LOG.info("Done: deleteSite");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.myProfileButtonClick();
		LOG.info("Done: myProfileButtonClick");
		((MyProfilePage) this.pages.currentPageAt(MyProfilePage.class))
				.trashcanMenuClick();
		LOG.info("Done: trashcanMenuClick");
		((UserTrashcanPage) this.pages.currentPageAt(UserTrashcanPage.class))
				.emptyTrashcan();
		LOG.info("Done: emptyTrashcan");
		((ShareHeaderPage) this.pages.currentPageAt(ShareHeaderPage.class))
				.logoutButtonClick();
		LOG.info("Done: logoutButtonClick");
	}
}
*/