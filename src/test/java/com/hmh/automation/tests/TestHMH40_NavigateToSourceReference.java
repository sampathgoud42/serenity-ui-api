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
import com.hmh.automation.tools.ConstantsProprtyLabelsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.References.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH40_NavigateToStructureReference.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH40_NavigateToSourceReference extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    
    String objectType, objectName, objectName2, activityType, grade, language, folderType, folderName, aspectName, rights, market,
            learningStyle, interactivityLevel, socialInteraction, resourceType, siteTypeTest, title;

    String ProgramName2 = RandomStringUtils.randomAlphanumeric(8);;
    String programFolder = "Program folder";
    String programBuketApsect = "Program Bucket";
    String fileName2 = "zet.txt";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH40 - Navigate to source by clicking on Reference")
    public void testHMH40_NavigateToSourceReference() {
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
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentDetailsSteps.createLOforConsumer();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectName, grade, rights, market, title);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentDetailsSteps.createLOforConsumer();
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectName2, grade, rights, market, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName2);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.clickOnManageReferenceLink();
        hmhDocumentDetailsSteps.clickItemInReferencesPane(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.selectReference(objectName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName2);
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.clickOnReference("/" + objectName);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.verifyPropertyValue(ConstantsProprtyLabelsHMH.NAME, objectName);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        
    }
}