package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.ProductSet.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH19_CreateProductSet.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH19_CreateProductSet extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private SiteHeaderSteps siteHeaderSteps;
    @Steps
    private DocumentLibrarySteps documentLibrarySteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;
    @Steps
    private HMHSequenceViewSteps hmhSequenceViewSteps;
    @Steps
    private DocumentDetailsSteps documentDetailsSteps;
    @Steps
    private DocumentLibraryLeftPanelSteps documentLibraryLeftPanelSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;

    String type, year, grade, markets, label1, lable1Restart, objectName, aspectName, folderType, folderName, title, siteTypeTest;

    String nameLabel = "Name";
    String gradeLabel = "Grade";
    String yearLabel = "Copyright Year";

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH19 - Create Product Set")
    public void testHMH19_CreateProductSet() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "ProductBucketFolder");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
      //  shareHeaderSteps.customWait(10);
      //  documentLibrarySteps.viewDetailsClick(folderName);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(aspectName);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, lable1Restart, markets, title);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(10);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(10);
        documentLibrarySteps.checkIfAssetIsPresent(objectName);
//        documentLibrarySteps.createNewContent(type);
//        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
//        hmhDocumentLibrarySteps.createProductSet(objectName, year, grade, label1, lable1Restart, markets, title);
//        hmhDocumentLibrarySteps.duplicataNameMessageShow();
//        siteHeaderSteps.clickOnDocumentLibraryButton();
//        documentLibrarySteps.assetFromListClick(folderName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
  //      documentLibrarySteps.viewDetailsClick(objectName);
        documentLibrarySteps.assetFromListClick(objectName);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        documentDetailsSteps.verifyPropertyValue(nameLabel, objectName);
        documentDetailsSteps.verifyPropertyValue(gradeLabel, grade);
        documentDetailsSteps.verifyPropertyValue(yearLabel, year);
        shareHeaderSteps.customWait(10);
    }
}
