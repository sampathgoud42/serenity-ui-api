package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ZIP.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH47_ExtractZipFromStructuralObject.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH47_ExtractZipFromStructuralObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;

    String folderType, folderName, aspectName, programType, programName, title, grade, markets, fileName, actionName,
            folderName2, ComponentBucketApect, item1, item2, incoming, manifestFile, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH47 - Bulk upload to Structural Object")
    public void testHMH47_ExtractZipFromStructuralObject() {
        //Program Bucket folder
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
        //Component Bucket folder
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5); //documentLibrarySteps.viewDetailsClick(folderName2);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(ComponentBucketApect);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();

        //Create Program 
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(programName, title, markets);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refresh();
        //It might be automatically moved to component so watch for it
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickExtract(); // documentLibrarySteps.moreActionMenuClick(actionName, fileName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.waitForZipToFinishExtract(fileName);
        shareHeaderSteps.customWait(120);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
        //go to component bucket folder and check references
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.checkIfAssetIsPresent(item1);
        documentLibrarySteps.checkIfAssetIsPresent(item2);
        documentLibrarySteps.assetFromListClick(item1);
        hmhDocumentDetailsSteps.checkIfIncomingReferenceWasAdded(programName);
        siteHeaderSteps.clickOnDocumentLibraryButton(); //  driver.navigate().back();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(item2);
        hmhDocumentDetailsSteps.checkIfIncomingReferenceWasAdded(programName);
        
      //Delete references
        siteHeaderSteps.clickOnDocumentLibraryButton(); //  driver.navigate().back();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(item1);
        hmhDocumentDetailsSteps.clickOnManageReferenceLink(); //      documentLibrarySteps.moreActionMenuClick(incoming, item1);
        hmhDocumentDetailsSteps.deleteReference(programName);
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(item2);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.clickOnManageReferenceLink();  //    documentLibrarySteps.moreActionMenuClick(incoming, item2);
        hmhDocumentDetailsSteps.deleteReference(programName); 
        hmhDocumentLibrarySteps.refresh();
    //go to component bucket folder and checkIfReferencesListIsEmpty
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(item1);
        hmhDocumentDetailsSteps.checkIfReferencesListIsEmpty(); // need a change
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
    }
}
