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
import com.hmh.automation.steps.HMHSearchResultsSteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Search.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH35_FilterSearchResults.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH35_FilterSearchResults extends com.hmh.automation.tools.AbstractBaseSiteTest {

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

    String ProgramType, SequenceBundleType, title, name1, name2, grade, markets, markets2, searchTerm, facet, lookFor, folderType, folderName, aspectName,
            folderName2,
            aspectName2, siteTypeTest;

    int waitForSearchResultsSeconds;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH35 - Filter Search Results")
    public void testHMH35_FilterSearchResults() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
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
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName2, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName2);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(ProgramType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProgram(name1, title, markets);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(SequenceBundleType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createSequenceBundle(name2, markets2, title);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.advancedSearchButtonClick();
        advancedSearchSteps.selectLookForPage(lookFor);
        shareHeaderSteps.customWait(5);
        advancedSearchSteps.inputSearchName(searchTerm);
        advancedSearchSteps.clickSearchButton();
        searchResultsSteps.isElementPresentInSearchResult(name1, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.isElementPresentInSearchResult(name2, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.selectFacet(facet);
        shareHeaderSteps.customWait(5);
        searchResultsSteps.isElementPresentInSearchResult(name1, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);
        searchResultsSteps.isElementPresentInSearchResult(name2, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
    }
}
