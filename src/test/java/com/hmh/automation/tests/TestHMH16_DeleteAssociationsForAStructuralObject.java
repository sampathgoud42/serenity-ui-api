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

@Story(HMHApplication.Associations.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH15_EditAssociations.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH16_DeleteAssociationsForAStructuralObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

    private String objectType, objectName1, grade, title, markets, folderType, folderName, aspectName,
            componentType, componentName, rights, language, outgoing, aspectName2, folderType2, folderName2,
            lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH16 - Delete Association")
    public void testHMH16_DeleteAssociation() {

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType2);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName2);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName2);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(objectName1, title,  markets);
        hmhDocumentLibrarySteps.refresh();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
		documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.createNewContent(componentType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(componentName, title, rights, grade, lifecycle,resourceType);
        hmhDocumentLibrarySteps.refresh();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        hmhDocumentDetailsSteps.outgoingReferencesClick();
        //documentLibrarySteps.moreActionMenuClick(outgoing, objectName1);
        
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(componentName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        hmhDocumentDetailsSteps.outgoingReferencesClick();
    //    documentLibrarySteps.moreActionMenuClick(outgoing, objectName1);
        
        hmhDocumentDetailsSteps.deleteReference(componentName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName2);
        
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(objectName1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        hmhDocumentDetailsSteps.outgoingReferencesClick();
    //    documentLibrarySteps.moreActionMenuClick(outgoing, objectName1);
    //    hmhDocumentDetailsSteps.checkIfReferencesListIsEmpty();
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        
    }
}
