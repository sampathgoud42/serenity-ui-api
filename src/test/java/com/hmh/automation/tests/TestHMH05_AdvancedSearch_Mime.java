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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.tools.ConstantsHMH;
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
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.ixxus.ipm.automation.tools.alfresco.Application;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(Application.Search.QuickSearch.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH05_AdvancedSearch_Mime.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH05_AdvancedSearch_Mime extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private SearchResultsSteps searchResultsSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private SelectTagsPopUpMenuSteps selectTagsPopUpMenuSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private MyProfileSteps myProfileSteps;
    @Steps
    private UserTrashcanSteps userTrashcanSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;

    String filename, filename2, mime, foundExtenstion, siteTypeTest, folderType, folderName, aspectName, categoryName, description, title, right, resourceType;

    int waitForSearchResultsSeconds;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    };

    @Test
    @Title("Test05 - AdvancedSearch_Mime")
    public void testHMH05_AdvancedSearch_Mime() {
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
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + filename);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + filename2);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(filename);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editTitle(title);
        hmhEditPropertiesSteps.editRight(right);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        shareHeaderSteps.advancedSearchButtonClick();
        advancedSearchSteps.inputSearchName(filename);
        advancedSearchSteps.selectMime(mime);
        advancedSearchSteps.clickSearchButton();
        searchResultsSteps.isElementPresentInSearchResult(filename, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, true);
        searchResultsSteps.isElementPresentInSearchResult(filename2, waitForSearchResultsSeconds, ConstantsHMH.SEARCH_RESULTS_MANUAL_SCROLL, false);
    }
}
