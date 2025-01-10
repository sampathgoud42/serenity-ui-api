package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Component.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH20_CreateComponent.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH20_CreateComponent extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;

    private String objectType, objectName, rights, grade, language, folderType, folderName, aspectName,
            title, lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest;
    String nameLabel = "Name";
    String gradeLabel = "Grade";
    String rightsLabel = "Publication Rights";
    String languageLabel = "Language";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH20 - Create Component")
    public void testHMH20_CreateComponent() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
     //   documentLibraryLeftPanelSteps.selectAspectForElement(aspectName);
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createComponentConsumerSite(objectName, title, rights, grade, lifecycle,resourceType);
        hmhDocumentLibrarySteps.refresh();
//        documentLibrarySteps.createNewContent(objectType);
//        hmhDocumentLibrarySteps.createComponentConsumerSite(objectName, title, rights, grade, lifecycle,resourceType);
//        hmhDocumentLibrarySteps.refresh();
//        shareHeaderSteps.customWait(3);
    //    hmhDocumentLibrarySteps.duplicataNameMessageShow();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
  //      documentLibrarySteps.viewDetailsClick(objectName);
        documentLibrarySteps.assetFromListClick(objectName);
        shareHeaderSteps.customWait(3);
        documentDetailsSteps.verifyPropertyValue(nameLabel, objectName);
        documentDetailsSteps.verifyPropertyValue(gradeLabel, grade);
        documentDetailsSteps.verifyPropertyValue(rightsLabel, rights);
  //      documentDetailsSteps.verifyPropertyValue(languageLabel, language);

    }
}
