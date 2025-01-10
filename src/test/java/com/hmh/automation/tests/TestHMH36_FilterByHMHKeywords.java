package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SelectTagsPopUpMenuSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.TagManagerSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Tagging.SearchTags.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH36_FilterByHMHTags.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH36_FilterByHMHKeywords extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private SelectTagsPopUpMenuSteps selectTagsPopUpMenuSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private TagManagerSteps tagManagerSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    
    String ProgramType, SequenceBundleType, title, grade, markets, name1, name2, hmhTag1, hmhTag2, searchTerm, lookFor, folderType, folderName, aspectName,
            aspectName2, siteTypeTest, resourceType, right;

    int waitForSearchResultsSeconds;

    String tag1 = RandomStringUtils.randomNumeric(7);
    String tag2 = RandomStringUtils.randomNumeric(7);
    String description = "test descr";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH36 - Filter search results by HMH kewwords")
    public void testHMH36_FilterByHMHKeywords() {
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.selectAspectForAFolder(aspectName2);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(ProgramType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(name1, title, markets);
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.createNewContent(SequenceBundleType);
        hmhDocumentLibrarySteps.createSequenceBundle(name2, markets, title);
        hmhDocumentLibrarySteps.refresh();
 
        // Create tag 
        
        shareHeaderSteps.customWait(5);
//        documentLibrarySteps.selectToOpenTagsFormFromQuickEditPropertiesForm(name1);
//        selectTagsPopUpMenuSteps.addTag(tag1);
//        documentLibrarySteps.editPropertiesPopUpSaveButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name1);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.selectTagsButtonClick();
        selectTagsPopUpMenuSteps.addNewTag(tag1);
        selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
        shareHeaderSteps.customWait(5);        
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editTitle(title);
        editPropertiesDocumentSteps.saveButtonClick();    
//        siteHeaderSteps.clickOnDocumentLibraryButton();
//        documentLibrarySteps.assetFromListClick(folderName);
//        shareHeaderSteps.customWait(5);
//        documentLibrarySteps.selectToOpenTagsFormFromQuickEditPropertiesForm(name2);
//        selectTagsPopUpMenuSteps.addTag(tag2);
//        documentLibrarySteps.editPropertiesPopUpSaveButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name2);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.selectTagsButtonClick();
        selectTagsPopUpMenuSteps.addNewTag(tag2);
        selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
        shareHeaderSteps.customWait(5);        
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editTitle(title);
        editPropertiesDocumentSteps.saveButtonClick();
        
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        shareHeaderSteps.advancedSearchButtonClick();
        advancedSearchSteps.selectLookForPage(lookFor);
        advancedSearchSteps.inputSearchName(searchTerm);
        advancedSearchSteps.clickSearchButton();
        //        searchResultsSteps.searchInSite(siteName);
        searchResultsSteps.isElementPresentInSearchResult(name1, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.isElementPresentInSearchResult(name2, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.selectFacet(tag2);
        searchResultsSteps.isElementPresentInSearchResult(name2, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.isElementPresentInSearchResult(name1, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);
        shareHeaderSteps.customWait(5);
    }

}
