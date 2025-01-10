package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
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

@Story(HMHApplication.StructuralAndContentObjects.DeleteStructuralOrContentObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH13_DeleteStructuralObject.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH13_DeleteStructuralObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private ShareHeaderSteps shareHeaderSteps;

    String programType, ProgramName, title, grade, markets, actionName, deleteAction, fileName, folderType, folderName, aspectName, message, siteTypeTest,
            componentBucketAspect, folder2, ProgramName2;
    String aspectName2 = "Content Bucket";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH13 - Delete Structural Object")
    public void testHMH13_DeleteStructuralObject() {

        //delete structural object with no references
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
		documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(ProgramName, title, markets);
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(ProgramName2, title, markets);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
     //   documentLibrarySteps.assetFromListClick(folderName);
    //    documentLibrarySteps.moreActionMenuClick(deleteAction, ProgramName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.clickDeleteFolder();
        documentLibrarySteps.confirmDelete();
//        documentLibrarySteps.moreActionMenuClick(deleteAction, folderName);
//        documentLibrarySteps.confirmDelete();

        //delete a program with a reference
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
		documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(ProgramName, title, markets);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folder2, "");
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folder2);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
		documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(componentBucketAspect);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
     //   driver.navigate().back();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folder2);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(ProgramName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
     //   documentLibrarySteps.viewDetailsClick(ProgramName);
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folder2);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(fileName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folder2);
        shareHeaderSteps.customWait(3);
      //  documentLibrarySteps.assetFromListClick(fileName);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
        shareHeaderSteps.customWait(3);
        hmhDocumentDetailsSteps.deleteObject();
        hmhDocumentDetailsSteps.checkObjectCanNotBeDeleted(message);
        hmhDocumentLibrarySteps.refresh();
        //check references are deleted but the referenced object is still present
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(ProgramName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
       // documentLibrarySteps.viewDetailsClick(ProgramName);
        documentDetailsSteps.deleteDocumentButtonDocumentActionsClick();
        shareHeaderSteps.customWait(3);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        //        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.assetFromListClick(folder2);
        shareHeaderSteps.customWait(3);
       // documentLibrarySteps.assetFromListClick(fileName);
        hmhDocumentLibrarySteps.assetFromListClickSub(fileName);
        hmhDocumentDetailsSteps.clickOnManageReferenceLink();
        hmhDocumentDetailsSteps.checkIfReferencesListIsEmpty();
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
    }

}
