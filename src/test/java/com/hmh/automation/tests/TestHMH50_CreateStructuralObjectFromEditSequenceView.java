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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH50_CreateProgramFromEditSequenceView.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH50_CreateStructuralObjectFromEditSequenceView extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

    String siteTypeTest, folderType, folderName, programAspect, productSetBucket, SequenceBundleBucket, LearningBundleBucket, programType, programName1, title,
            grade, markets, editSequence, programName2, productSetType, ProductSetName, year, levle1, level1Restart, sequenceBundleType, SequenceBundleName,
            learningBundleType, learningBundleName, lifecycle, learningStyle, interactivityLevel, socialInteraction, outgoing;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH50 - Create Objects from Edit Sequence")
    public void testHMH50_CreateStructuralObjectFromEditSequenceView() {

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
     //   documentLibraryLeftPanelSteps.selectAspectForElement(programAspect);
        documentLibrarySteps.selectAspectForAFolder(programAspect);
        documentLibrarySteps.selectAspectForAFolder(productSetBucket);
        documentLibrarySteps.selectAspectForAFolder(SequenceBundleBucket);
        documentLibrarySteps.selectAspectForAFolder(LearningBundleBucket);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(programName1, title, markets);
        hmhDocumentLibrarySteps.refresh();

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editSequenceButtonDocumentActionClick(); // documentLibrarySteps.moreActionMenuClick(editSequence, programName1);
      
        //create program in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(programType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(programName2, title,  markets);
        //create product set in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(productSetType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(ProductSetName, year, grade, levle1, level1Restart, markets, title);
        //create sequence Bundle in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(sequenceBundleType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createSequenceBundle(SequenceBundleName, markets, title);
        //create Learning Bundle in edit sequence
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(learningBundleType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningBundleConsumerSite(learningBundleName, grade, markets, title);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
 
  //Check references
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();//   documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(programName2);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(ProductSetName);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(SequenceBundleName);
        hmhDocumentDetailsSteps.checkIfReferenceWasAdded(learningBundleName);
        siteHeaderSteps.clickOnDocumentLibraryButton();

 //Delete references
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        hmhDocumentDetailsSteps.deleteReference(programName2);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick(); //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(ProductSetName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick(); //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(SequenceBundleName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(programName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.outgoingReferencesClick(); //documentLibrarySteps.moreActionMenuClick(outgoing, programName1);
        hmhDocumentDetailsSteps.deleteReference(learningBundleName);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();

    }

}
