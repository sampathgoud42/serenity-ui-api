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
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.TagManagerSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Search.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH49_AdvancedSearchForAContentObject.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH49_AdvancedSearchForContentObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private HMHSearchResultsSteps hmhSearchResultsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private TagManagerSteps tagManagerSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
  

    String type, name, title, grade, markets, year, level1Label, rights, language, ActivityType, folderType, folderName, aspectName,
            lifecycle, learningStyle, interactivityLevel, socialInteraction, resourceType, siteTypeTest, componentAspect;

    int waitForSearchResultsSeconds;
    String learningBundleAspect = "Learning Bundle Bucket";
    String description = "test descr";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH49 - Advanced Search For a Content Object")
    public void testHMH49_AdvancedSearchForContentObject() {
        siteHeaderSteps.clickOnDocumentLibraryButton();

        switch (type) {

        case "Component":
            siteHeaderSteps.clickOnDocumentLibraryButton();

            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(folderType);
            documentLibrarySteps.createFolder(folderName, "");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
    		shareHeaderSteps.customWait(5);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            documentLibrarySteps.selectAspectForAFolder(componentAspect);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.assetFromListClick(folderName);
            documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createComponentConsumerSite(name, title, rights, grade, lifecycle, resourceType);
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.assetFromListClick(folderName);
            shareHeaderSteps.customWait(5);  
            documentLibrarySteps.assetFromListClick(name);
            shareHeaderSteps.customWait(5);  
            documentDetailsSteps.editPropertiesButtonDocumentActionsClick();     
            hmhEditPropertiesSteps.editDescription(description);
            editPropertiesDocumentSteps.saveButtonClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            advancedSearchSteps.inputSearchName(name);
            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(5);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            shareHeaderSteps.customWait(5);
            break;

        case "Learning Object":
            documentLibrarySteps.createNewContent(folderType);
            documentLibrarySteps.createFolder(folderName, "");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
    		shareHeaderSteps.customWait(5);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            documentLibrarySteps.selectAspectForAFolder(aspectName);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            hmhDocumentDetailsSteps.createLOforConsumer();
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createLearningObjectConsumerSite(name, grade, rights, markets, title);
            
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.assetFromListClick(folderName);
            shareHeaderSteps.customWait(5);  
            documentLibrarySteps.assetFromListClick(name);
            shareHeaderSteps.customWait(5);  
            documentDetailsSteps.editPropertiesButtonDocumentActionsClick();     
            hmhEditPropertiesSteps.editDescription(description);
            hmhEditPropertiesSteps.editResourceType(resourceType);
            editPropertiesDocumentSteps.saveButtonClick();
            
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            advancedSearchSteps.inputSearchName(name);
            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(5);
        //    searchResultsSteps.searchInSite(siteName);
            shareHeaderSteps.customWait(5);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            shareHeaderSteps.customWait(5);
            break;

        }

    }
}
