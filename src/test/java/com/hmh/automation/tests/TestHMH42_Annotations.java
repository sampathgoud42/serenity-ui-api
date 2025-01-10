package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDmaSteps;
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

@Story(HMHApplication.Annotaions.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH42_Annotations.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH42_Annotations extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private ShareHeaderSteps shareHeaderSteps;

    String programType, ProgramName, grade, actionName, deleteAction, fileName, folderType, folderName, aspectName, message, siteTypeTest;
    String ProgramName2 = RandomStringUtils.randomAlphanumeric(8);
    String fileName1 = "pdf.pdf";
    String optionToSelect = "Annotations";
    String annotation = "baluabcdefg";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH42 - Annotations")
    public void testHMH42_Annotations() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
     //   documentLibrarySteps.viewDetailsClick(folderName);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName1);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentLibrarySteps.selectItem(fileName);
        documentLibrarySteps.selectedItemsClick();
        hmhDocumentLibrarySteps.choseOptionFromSelectedItems(optionToSelect);
        hmhDmaSteps.clickOnCanvasArea();
        hmhDmaSteps.insertComment(annotation);
        hmhDmaSteps.clickOnAddAnnotationCommentButton();
        hmhDmaSteps.selectAnnotation(annotation);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.selectItem(fileName1);
        documentLibrarySteps.selectedItemsClick();
        hmhDocumentLibrarySteps.choseOptionFromSelectedItems(optionToSelect);
        hmhDmaSteps.clickOnCanvasArea();
        hmhDmaSteps.insertComment(annotation);
        hmhDmaSteps.clickOnAddAnnotationCommentButton();
        hmhDmaSteps.selectAnnotation(annotation);
        shareHeaderSteps.customWait(5);
    }
}