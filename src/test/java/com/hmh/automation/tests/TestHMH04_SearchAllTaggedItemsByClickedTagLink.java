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
import com.hmh.automation.steps.HMHEditPropertiesSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.CategoryManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.SelectTagsPopUpMenuSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.TagManagerSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.MyProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.myprofile.UserTrashcanSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Tagging.SearchTags.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH04_SearchAllTaggedItesms.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH04_SearchAllTaggedItemsByClickedTagLink extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
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
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private MyProfileSteps myProfileSteps;
    @Steps
    private UserTrashcanSteps userTrashcanSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private CategoryManagerSteps categoryManagerSteps;
    @Steps
    private TagManagerSteps tagManagerSteps;

    String fileName, fileName2, style, title, siteTypeTest, folderType, folderName, aspectName, resourceType, right, grade;
    String tagName = Constants.PREFIXS_TAG + RandomStringUtils.randomNumeric(7);
 //   String right = "Public Domain";
  //  String grade = "2";
    String description = "test descr";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH04 - Search All Tagged Items By Clicked Tag Link")
    public void testHMH04_SearchAllTaggedItemsByClickedTagLink() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibrarySteps.applyChangesForAspectsButtonClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        // Create tag
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.selectTagsButtonClick();
        selectTagsPopUpMenuSteps.addNewTag(tagName);
        selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
        shareHeaderSteps.customWait(5);        
   //     documentDetailsSteps.editPropertiesButtonDocumentActionsClick();  
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editRight(right);
        hmhEditPropertiesSteps.editGrade(grade);
        hmhEditPropertiesSteps.editTitle(title);
        hmhEditPropertiesSteps.editLearningStyles(style);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick();
     //   documentLibrarySteps.selectToOpenTagsFormFromQuickEditPropertiesForm(fileName);

     //   documentLibrarySteps.editPropertiesPopUpSaveButtonClick();
        // Check tag
        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.tagInListClick(tagName);
        shareHeaderSteps.customWait(20);
        documentLibrarySteps.compareNumberOfOccurrencesOfTag(documentLibraryLeftPanelSteps.getTagNumericValue(tagName),
        documentLibrarySteps.countNumberOfOccurrencesForATag(tagName));
        // upload new file
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName2);
        hmhDocumentLibrarySteps.refreshToExitPopup();
        // Create tag
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName2);
        shareHeaderSteps.customWait(5);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.selectTagsButtonClick();
        selectTagsPopUpMenuSteps.addNewTag(tagName);
        selectTagsPopUpMenuSteps.okButtonOnTagsPopUpClick();
        shareHeaderSteps.customWait(5);        
   //     documentDetailsSteps.editPropertiesButtonDocumentActionsClick();  
        hmhEditPropertiesSteps.editDescription(description);
        hmhEditPropertiesSteps.editRight(right);
        hmhEditPropertiesSteps.editGrade(grade);
        hmhEditPropertiesSteps.editTitle(title);
        hmhEditPropertiesSteps.editLearningStyles(style);
        hmhEditPropertiesSteps.editResourceType(resourceType);
        editPropertiesDocumentSteps.saveButtonClick();
        // Check tag
        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);

        shareHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        // add tag for the newly uploaded file
        shareHeaderSteps.customWait(5);
  //      documentLibrarySteps.addNewTagFromDocLibView(tagName, fileName2);
        shareHeaderSteps.customWait(20);
        documentLibrarySteps.compareNumberOfOccurrencesOfTag(documentLibraryLeftPanelSteps.getTagNumericValue(tagName),
                documentLibrarySteps.countNumberOfOccurrencesForATag(tagName));

        shareHeaderSteps.customWait(10);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.selectTagFilter(tagName);

        // Check if documents are displayed - filter is working
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.checkIfAssetIsPresent(fileName);
        documentLibrarySteps.checkIfAssetIsPresent(fileName2);

//        // Remove tag from fileName2
//        siteHeaderSteps.clickOnDocumentLibraryButton();
//       hmhDocumentLibrarySteps.deleteTagFromDocLibViewHMH(fileName2, tagName);
 //       documentLibrarySteps.deleteTagFromDocLibView(fileName2, tagName);
        documentLibrarySteps.selectTagFilter(tagName);
        
        // The count should be 2
        documentLibrarySteps.compareNumberOfOccurrencesOfTag(documentLibraryLeftPanelSteps.getTagNumericValue(tagName),
                documentLibrarySteps.countNumberOfOccurrencesForATag(tagName));
        shareHeaderSteps.customWait(5);
    }
}
