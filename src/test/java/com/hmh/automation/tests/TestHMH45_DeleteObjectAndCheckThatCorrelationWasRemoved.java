package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDataListsSteps;
import com.hmh.automation.steps.HMHDmaSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.CustomizeSiteSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Correlations.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH45_DeleteObjectAndCheckThatCorrelationWasRemoved.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH45_DeleteObjectAndCheckThatCorrelationWasRemoved extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHDmaSteps hmhDmaSteps;
    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private CustomizeDashboardSteps customizeDashboardSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private CustomizeSiteSteps customizeSiteSteps;
    @Steps
    private HMHDataListsSteps hmhDataListsSteps;

    String name, rights, grade, language, actionName, standardFolder, standard, type, dashlet, dataList, title, lifecycle, learningStyles,
            interactivityLevel, socialInteraction, resourceType, siteTypeTest, folderType, folderName, aspectName;

    String deleteAction = "Delete Object";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH45 - Delete Object and check that correlation was removed")
    public void testHMH45_DeleteObjectAndCheckThatCorrelationWasRemoved() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(name, title, rights, grade, lifecycle,resourceType);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
 //////////////
        siteHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickCorrelations(); //documentLibrarySteps.moreActionMenuClick(actionName, name);
        hmhDocumentLibrarySteps.clickItemInCorrelationsPane(standardFolder);
        hmhDocumentLibrarySteps.selectStandardToCorrelate(standard);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        siteHeaderSteps.clickOnDataListsButton();
        hmhDataListsSteps.selectStandardFromList(dataList);
     //*   hmhDataListsSteps.checkIfItemWasCorrelatedToStandard(standard, name);// need a change
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
/////////////////
        siteHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickDeleteObject();//documentLibrarySteps.moreActionMenuClick(deleteAction, name);
        documentLibrarySteps.confirmDelete();
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        siteHeaderSteps.clickOnDataListsButton();
        hmhDataListsSteps.selectStandardFromList(dataList);
 //*       hmhDataListsSteps.checkIfStandardHasNoCorrelation(standard); // need a change
        hmhDocumentLibrarySteps.refresh();
    }

}
