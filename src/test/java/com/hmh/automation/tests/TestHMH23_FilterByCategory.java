package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Categories.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH23_FilterByCategory.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH23_FilterByCategory extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private DashboardSteps dashboardSteps;
    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private SiteFinderSteps siteFinderSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private SiteDashboardSteps siteDashboardSteps;
    @Steps
    private MyProfileSteps myProfileSteps;
    @Steps
    private UserTrashcanSteps userTrashcanSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;

    String username, password, siteName, fileName, title, categoryName, right, grade, sitTypeTest, style, folderType, folderName, aspectName, resourceType, siteTypeTest;
    String description = "test descr";
    
    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("Test23HMH - FilterByCategory")
    public void testHMH23_FilterByCategory() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.selectCategories();
        categoryManagerSteps.addCategoryFromEditProperties(categoryName);
        categoryManagerSteps.saveCategoriesButtonClick();
        shareHeaderSteps.customWait(3);
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editRight(right);
        hmhEditPropertiesSteps.editGrade(grade);
        hmhEditPropertiesSteps.editTitle(title);
        hmhEditPropertiesSteps.editLearningStyles(style);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick();
        shareHeaderSteps.customWait(3);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
        documentLibrarySteps.checkIfCategoryWasAdded(fileName, categoryName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(3);
        hmhDocumentLibrarySteps.filterByCategory(categoryName);
        documentLibrarySteps.checkIfDocumentIsPresent(fileName);
        hmhDocumentLibrarySteps.refresh();
        shareHeaderSteps.customWait(3);
    }
}
