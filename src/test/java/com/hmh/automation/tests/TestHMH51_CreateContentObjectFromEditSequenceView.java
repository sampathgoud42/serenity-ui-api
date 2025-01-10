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
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Sequence.EditSequence.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH51_CreateContentObjectFromEditSequenceView.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH51_CreateContentObjectFromEditSequenceView extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;

    String siteTypeTest, folderType, folderName, programAspect, ComponentAspect, LearningObjectAspect, programType, programName1, title,
            grade, markets, editSequence, programName2, productSetType, ProductSetName, year, levle1, level1Restart, sequenceBundleType, SequenceBundleName,
            learningBundleType, learningBundleName, lifecycle, learningStyle, interactivityLevel, socialInteraction, outgoing, ComponentType, ComponentName,
            rights, language, resourceType, LearningObjectType, learningObjectName, activityType, filename;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH51 - Create Objects from Edit Sequence")
    public void testHMH51_CreateContentObjectFromEditSequenceView() {

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        hmhDocumentLibrarySteps.selectAspectForAFolder(programAspect);
        hmhDocumentLibrarySteps.selectAspectForAFolder(ComponentAspect);
        hmhDocumentLibrarySteps.selectAspectForAFolder(LearningObjectAspect);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(programName1, title, markets);
        hmhDocumentLibrarySteps.refresh();
   ////////////
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editSequenceButtonDocumentActionClick(); //documentLibrarySteps.moreActionMenuClick(editSequence, programName1);
        //create Component in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(ComponentType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(ComponentName, title, rights, grade, lifecycle,resourceType);
        //create learning object in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(LearningObjectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(learningObjectName, grade, rights, markets, title);
        // upload file
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + filename);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        
 //Check references for content objects 
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();//documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(ComponentName);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(learningObjectName);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(filename);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
 //delete references for content objects     
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick(); //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(ComponentName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick(); //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(learningObjectName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();  //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(filename);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
    }

}
