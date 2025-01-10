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
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH29_ViewMetadataInEditSequence.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH29_ViewMetadataInEditSequence extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;

    String programType, ProgramName, title, grade, markets, actionName, componentType,
            folderName2, aspectName2, Name, rights, Language, folderType, folderName, aspectName,
            lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest;

    String folderName3 = "Folder333";
    String nameLabel = "Name";
    String gradeLabel = "Grade";
    String rightsLabel = "Publication Rights";
    String languageLabel = "Language";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH29 - ViewMetadtaInEditSequence")
    public void testHMH29_ViewMetadataInEditSequence() {

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName2);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(programType);
        shareHeaderSteps.customWait(3);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(ProgramName, title, markets);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(componentType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(Name, title, rights, grade, lifecycle, resourceType);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(ProgramName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(3);
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(Name);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(ProgramName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(3);
        documentDetailsSteps.editSequenceButtonDocumentActionClick();
        hmhSequenceViewSteps.clickOnAnElementInTheSequenceView(Name);
        shareHeaderSteps.customWait(3);
//        documentDetailsSteps.verifyPropertyValue(nameLabel, Name);
//        documentDetailsSteps.verifyPropertyValue(gradeLabel, grade);
//        documentDetailsSteps.verifyPropertyValue(rightsLabel, rights);
        hmhSequenceViewSteps.goBackClick();
        shareHeaderSteps.customWait(3);

    }
}
