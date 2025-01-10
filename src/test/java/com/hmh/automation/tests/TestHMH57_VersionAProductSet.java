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
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.EditPropertiesDocumentSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;

@Story(HMHApplication.Authentication.CreateSite.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH57_VersionAProductSet.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH57_VersionAProductSet extends com.hmh.automation.tools.AbstractBaseSiteTest {
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
    private HMHDocumentDetailsSteps hmhDocumentDetailsSteps;
    @Steps
    private EditPropertiesDocumentSteps editPropertiesDocumentSteps;
    @Steps
    private HMHEditPropertiesSteps hmhEditPropertiesSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;

    String siteTypeTest, folderType, folderName, productSetAspect, productSetType, name, year, grade, levle1,
            level1Restart, market, title, fileName, versionAction, componentAspect, firstVersion, versionTwo, versionThree, versionFour, description, right;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH57 - Version a product set")
    public void testHMH57_VersionAProductSet() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.navBarClick();
		shareHeaderSteps.customWait(5); //documentLibrarySteps.viewDetailsClick(folderName);
        documentDetailsSteps.manageAspectsButtonDocumentActionsClick();
        documentLibrarySteps.selectAspectForAFolder(productSetAspect);
        documentLibrarySteps.selectAspectForAFolder(componentAspect);
        documentLibraryLeftPanelSteps.aspectsChangesApplyClick();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.createNewContent(productSetType);
        hmhDocumentLibrarySteps.createObjectWhenNotAllMandatoryMetadataFieldsAreFilled();
        hmhDocumentLibrarySteps.createProductSet(name, year, grade, levle1, level1Restart, market, title);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        documentDetailsSteps.documentActionClick(versionAction);
        hmhDocumentLibrarySteps.refresh();
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);

        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.uploadDocument(ConstantsHMH.TESTDATA_FILES_BASE_PATH_HMH + fileName);
        hmhDocumentLibrarySteps.refresh();
 
   //version
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.clickonVersion(); //documentLibrarySteps.moreActionMenuClick(versionAction, name);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(fileName);
        siteHeaderSteps.customWait(10);
        hmhDocumentDetailsSteps.checkLatestVersion(firstVersion);
        documentDetailsSteps.editPropertiesButtonDocumentActionsClick();
        editPropertiesDocumentSteps.editDescripton(description);
        hmhEditPropertiesSteps.editRight(right);
        editPropertiesDocumentSteps.saveButtonClick();
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick();
        shareHeaderSteps.customWait(5);
        hmhDocumentDetailsSteps.clickonVersion(); //documentLibrarySteps.moreActionMenuClick(versionAction, name);
        hmhDocumentLibrarySteps.refresh();
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        shareHeaderSteps.customWait(5);
        documentLibrarySteps.assetFromListClick(name);
        shareHeaderSteps.customWait(5);
        hmhDocumentLibrarySteps.navBarClick(); // documentLibrarySteps.viewDetailsClick(name);
        hmhDocumentDetailsSteps.checkLatestVersion(versionThree);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.assetFromListClick(folderName);
        hmhDocumentLibrarySteps.refresh();
        documentLibrarySteps.assetFromListClick(fileName);
        hmhDocumentDetailsSteps.checkLatestVersion(versionTwo);
        siteHeaderSteps.customWait(5);
        siteHeaderSteps.clickOnDocumentLibraryButton();

    }
}
