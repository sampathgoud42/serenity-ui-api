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
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.CompositeLearningObject.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH59_CreateCompositeLearningObject.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH59_CreateCompositeLearningObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private SiteFinderSteps siteFinderSteps;
    @Steps
    private SiteDashboardSteps siteDashboardSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;

    private String objectType, objectName, activityType, grade, language, folderType, folderName, aspectName, market, lifecycle, learningStyle,
            interactivityLevel, socialInteraction, rights, title, siteTypeTest, resourceType;

    String nameLabel = "Name";
    String gradeLabel = "Grade";
    String activityLabel = "Activity Type";
    String languageLabel = "Language";
    String CodeLabel = "Code Repository URL";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH59 - Create Composite Learning Object")
    public void testHMH59_CreateCompositeLearningObject() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(objectType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(objectName, grade, rights, market, title);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(objectName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.verifyPropertyValue(nameLabel, objectName);
        documentDetailsSteps.verifyPropertyValue(gradeLabel, grade);
        shareHeaderSteps.customWait(5);
        
    }
}
