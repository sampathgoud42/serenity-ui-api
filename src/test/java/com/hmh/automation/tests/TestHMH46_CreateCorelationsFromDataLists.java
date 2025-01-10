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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH46_CreateCorelationsFromDataLists.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH46_CreateCorelationsFromDataLists extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

    String name, rights, grade, language, actionName, standardFolder, standard, type, dashlet, dataList, level1, documentLibraryLevel, title, lifecycle,
            learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest, folderType, folderName, aspectName;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH46 - Create Corealtion from Data Lists")
    public void testHMH46_CreateCorelationsFromDataLists() {
    	
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
        //hmhDocumentLibrarySteps.createComponentConsumerSite(name, title, rights, grade, language, lifecycle, learningStyles, interactivityLevel,socialInteraction, resourceType);
        hmhDocumentLibrarySteps.createComponentConsumerSite(name, title, rights, grade, lifecycle, resourceType);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        siteHeaderSteps.clickOnDataListsButton();
        hmhDataListsSteps.selectStandardFromList(dataList);
        hmhDataListsSteps.editButtonForStandardClick(standard);
        hmhDataListsSteps.selectCorrleationButtonClick();
        shareHeaderSteps.customWait(5);
        hmhDataListsSteps.navigateInCorelationsDialgoBox(level1);
        hmhDataListsSteps.navigateInCorelationsDialgoBox(siteName);
        hmhDataListsSteps.navigateInCorelationsDialgoBox(documentLibraryLevel);
        hmhDataListsSteps.navigateInCorelationsDialgoBox(folderName);
        hmhDataListsSteps.addItemToCorrelate(name);
        hmhDataListsSteps.editCorrelationPaneSaveButtonClick();
        shareHeaderSteps.customWait(5);
     //**   hmhDataListsSteps.checkIfItemWasCorrelatedToStandard(standard, name);  // need a change
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        siteHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        siteHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickCorrelations();    //documentLibrarySteps.moreActionMenuClick(actionName, name);
        shareHeaderSteps.customWait(10);
        hmhDocumentLibrarySteps.checkIfStandardWasAdded(standard);
        hmhDocumentLibrarySteps.refresh();
    }
}
