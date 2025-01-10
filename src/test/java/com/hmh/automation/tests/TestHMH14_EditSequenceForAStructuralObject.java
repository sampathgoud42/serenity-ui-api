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
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Sequence.EditSequence.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH14_EditSequenceForAStructuralObject.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH14_EditSequenceForAStructuralObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;

    private String objectType, objectName1, objectName2, objectName3, title, grade, markets, actionName,
            aspectName, folderType, folderName, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH14 - Edit Sequence View for a Structural Object")
    public void testHMH14_SequenceViewForComponent() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
       // documentLibrarySteps.viewDetailsClick(folderName);
		documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(objectName1, title, markets);
    //    hmhDocumentLibrarySteps.assetFromListClickSub(objectName1);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(objectName2, title, markets);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(objectName3, title, markets);
        hmhDocumentLibrarySteps.refresh();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(objectName2);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(objectName3);
        hmhDocumentLibrarySteps.refresh();
        
     //   documentLibrarySteps.viewDetailsClick(objectName1);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editSequenceButtonDocumentActionClick();
   //   documentLibrarySteps.moreActionMenuClick(actionName, objectName1);
        hmhSequenceViewSteps.changeSequenceTreeStructure(objectName2, objectName3);
        hmhSequenceViewSteps.checkSequenceTreeStructure(objectName1, objectName3, objectName2);
//        hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(objectName3);
//        hmhSequenceViewSteps.checkIfElementIsDisplayedInSequenceViewGallery(objectName2);
//        hmhSequenceViewSteps.goBackClick();
//        shareHeaderSteps.customWait(5);
//        documentLibrarySteps.assetFromListClick(objectName1);
//        shareHeaderSteps.customWait(5);
//        hmhDocumentLibrarySteps.navBarClick();
    //    hmhDocumentLibrarySteps.viewDetailsClick(objectName1);
   //   documentLibrarySteps.moreActionMenuClick(actionName, objectName1);
        hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(objectName3);
        hmhSequenceViewSteps.checkSequenceTreeStructure(objectName1, objectName3, objectName2);
        hmhSequenceViewSteps.goBackClick();
        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();

    }
}
