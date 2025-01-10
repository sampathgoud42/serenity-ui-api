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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH38_BulkUpload.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH38_BulkUploadZip extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

    String fileName, item1, item2, title1, language1, rights1, grade1, folderType, folderName, aspectName, programType, programName, grade, nameLabel,
            titleLabel, languageLabel, rightsLabel, gradeLabel, outgoing, actionName, objectName, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH38 - Bulk Upload")
    public void testHMH38_BulkUploadZip() {
        siteHeaderSteps.clickOnDocumentLibraryButton();

        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.viewDetailsClick(folderName);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refresh();
        //Following method will upload the file and hover to find the  More button and then click on Extract action
//////////////       
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName);
        hmhDocumentLibrarySteps.clickExtract();  //  documentLibrarySteps.moreActionMenuClick(actionName, fileName);       
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.waitForZipToFinishExtract(fileName); //check this step
        shareHeaderSteps.customWait(120);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.checkIfAssetIsPresent(item1);
        documentLibrarySteps.checkIfAssetIsPresent(item2);
        documentLibrarySteps.assetFromListClick(item1);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(nameLabel, item1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(titleLabel, title1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(languageLabel, language1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(rightsLabel, rights1);
        hmhDocumentDetailsSteps.verifyHMHPropertyValue(gradeLabel, grade1);
        siteHeaderSteps.clickOnDocumentLibraryButton();
    }
}
