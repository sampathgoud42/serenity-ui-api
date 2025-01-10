package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.Constants;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.CustomizeDashboard.Dashlets.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH03_SavedSearchDashlet.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH03_SavedSearchDashlet extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private CustomizeDashboardSteps customizeDashboardSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
	private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    
    
String fileName, siteTypeTest, folderType, folderName, aspectName;
String dashlet = "Saved Search";

@Override
public void setSiteType() {
    siteType = siteTypeTest;
}    
    
    @Test
    @Title("TestHMH03 - Saved Search Dashlet")
    public void testHMH03_SavedSearchDashlet() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        shareHeaderSteps.homeButtonClick();
        dashboardSteps.customizeDashboardButtonClick();
        customizeDashboardSteps.clickAddDashletsButton();
        customizeDashboardSteps.dragAndDropToColumn1Dashlet(dashlet);
        customizeDashboardSteps.finalizeAddingNewDashlet();
        customizeDashboardSteps.editSavedSearchDashlet(fileName);
         dashboardSteps.customizeDashboardButtonClick();
         customizeDashboardSteps.deleteDashlet(dashlet);
         customizeDashboardSteps.finalizeAddingNewDashlet();
         shareHeaderSteps.customWait(10);

    }

}
    
    
