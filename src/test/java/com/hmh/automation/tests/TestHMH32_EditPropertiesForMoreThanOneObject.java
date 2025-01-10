package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.ObjectOperations.EditProperties.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH32_EditPropertiesForMoreThanOneObject.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH32_EditPropertiesForMoreThanOneObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private SearchResultsSteps searchResultsSteps;
    @Steps
    private HMHAdvancedSearchSteps hmhAdvancedSearchSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

    String type, programName, folderType, folderName, grade, title, description, actionName, componentName, rights, language,
            lifecycle, learningStyles, interactivityLevel, socialInteraction, resourceType, siteTypeTest, aspectName, folderName2;

    String titleLabel = "Title";
    String descriptionLabel = "Description";
    String componentType = "Component";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH32 - Edit properties for more than one object")
    public void testHMH32_EditPropertiesForMoreThanOneObject() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        hmhDocumentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(componentType);
   //     hmhDocumentLibrarySteps.createComponentConsumerSite(componentName, title, rights, grade, language, lifecycle, learningStyles, interactivityLevel,           socialInteraction, resourceType);
        hmhDocumentLibrarySteps.createComponentConsumerSite(componentName, title, rights, grade, lifecycle,resourceType);

        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.selectAllItems();
     //   documentLibrarySteps.selectedItemsClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.selectAnItemFromSelectedItemsDropDown(actionName);
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editTitle(title);
        editPropertiesDocumentSteps.saveButtonClick();
        hmhEditPropertiesSteps.confirmMultipleEdit();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(componentName);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.verifyPropertyValue(titleLabel, title);
        documentDetailsSteps.verifyPropertyValue(descriptionLabel, description);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName2);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.verifyPropertyValue(titleLabel, title);
        documentDetailsSteps.verifyPropertyValue(descriptionLabel, description);
        siteHeaderSteps.clickOnDocumentLibraryButton();
    }
}
