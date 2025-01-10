package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.steps.HMHSearchResultsSteps;
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

@Story(HMHApplication.Search.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH30_AdvancedSearchForAProgram.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH30_AdvancedSearchForStructuralObject extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;

    String type, name, title, grade, markets, year, level1Label, rights, language, ActivityType, folderType, folderName, aspectName,
            lifecycle, learningStyle, interactivityLevel, socialInteraction, resourceType, siteTypeTest, lable1Restart;
    String learningBundleAspect = "Learning Bundle Bucket";
    String description = "SearchProgram";

    int waitForSearchResultsSeconds;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH30 - Advanced Search For a Structural Object")
    public void testHMH30_AdvancedSearchForStructuralObject() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        switch (type) {

        case "Product Set":
            documentLibrarySteps.createNewContent(folderType);
            documentLibrarySteps.createFolder(folderName, "");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.customWait(3);
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
            shareHeaderSteps.customWait(3);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            documentLibrarySteps.selectAspectForAFolder(aspectName);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createProductSet(name, year, grade, level1Label, lable1Restart, markets, title);
            hmhDocumentLibrarySteps.refresh();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            advancedSearchSteps.inputSearchName(name);
            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
            hmhAdvancedSearchSteps.selectYearInAdvancedSearch(year);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(8);
            //            searchResultsSteps.searchInSite(siteName);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            break;

        case "Learning Bundle":
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(folderType);
            documentLibrarySteps.createFolder(folderName, "");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.customWait(3);
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
            shareHeaderSteps.customWait(3);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            documentLibrarySteps.selectAspectForAFolder(aspectName);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createLearningBundleConsumerSite(name, grade, markets, title);
            hmhDocumentLibrarySteps.refresh();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            advancedSearchSteps.inputSearchName(name);
            shareHeaderSteps.customWait(3);
            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(8);
            //            searchResultsSteps.searchInSite(siteName);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            break;

        case "Sequence Bundle":
            documentLibrarySteps.createNewContent(folderType);
        
            documentLibrarySteps.createFolder(folderName, "");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.customWait(3);
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
            shareHeaderSteps.customWait(3);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            documentLibrarySteps.selectAspectForAFolder(aspectName);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createSequenceBundle(name, markets, title);
            hmhDocumentLibrarySteps.refresh();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            advancedSearchSteps.inputSearchName(name);
            shareHeaderSteps.customWait(3);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(8);
            //            searchResultsSteps.searchInSite(siteName);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            break;

        case "Program":
            documentLibrarySteps.createNewContent(folderType);
            documentLibrarySteps.createFolder(folderName, "dddQA");
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.customWait(3);
            documentLibrarySteps.assetFromListClick(folderName);
            hmhDocumentLibrarySteps.navBarClick();
            shareHeaderSteps.customWait(3);
            documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
            hmhDocumentLibrarySteps.selectAspectForAFolder(aspectName);
            documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
            siteHeaderSteps.clickOnDocumentLibraryButton();
            documentLibrarySteps.createNewContent(type);
            hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
            hmhDocumentLibrarySteps.createProgram(name, title, markets);
            hmhDocumentLibrarySteps.refresh();      
            siteHeaderSteps.clickOnDocumentLibraryButton();
            shareHeaderSteps.advancedSearchButtonClick();
            advancedSearchSteps.selectLookForPage(type);
            shareHeaderSteps.customWait(5);
            advancedSearchSteps.inputSearchName(name);
            shareHeaderSteps.customWait(5);
//            hmhAdvancedSearchSteps.selectGradeInAdvancedSearch(grade);
            shareHeaderSteps.customWait(3);
            advancedSearchSteps.clickSearchButton();
            shareHeaderSteps.customWait(8);
            //            searchResultsSteps.searchInSite(siteName);
            searchResultsSteps.isElementPresentInSearchResult(name, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
            hmhSearchResultsSteps.checkIfThumbnailIsDisplayed(type);
            break;
        }
        shareHeaderSteps.customWait(3);
    }
}