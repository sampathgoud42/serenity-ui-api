package com.hmh.automation.tests;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import net.thucydides.junit.runners.ThucydidesParameterizedRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHAdvancedSearchSteps;
import com.hmh.automation.steps.HMHDocumentDetailsSteps;
import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.steps.HMHSequenceViewSteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Application;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(Application.VersionControl.UploadNewVersion.class)
@RunWith(ThucydidesParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH31_CopyAnObject.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH31_CopyObject extends AbstractBaseSiteTest {

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

    String type, name, grade, year, level1Label, rights, language, ActivityType, folderType,
            folderName, aspectName, CopyAction, Destination,market,title;

    @Test
    @Title("TestHMH31 - Copy a Learning Object")
    public void testHMH31_CopyAnObject() {
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.createNewContent(type);
        hmhDocumentLibrarySteps.createLearningObjectConsumerSite(name, grade, rights, market, title);
        documentLibrarySteps.createNewContent(folderType);
        documentLibrarySteps.createFolder(folderName, "asd");
        siteHeaderSteps.clickOnDocumentLibraryButton();
        documentLibrarySteps.moreActionMenuClick(CopyAction, name);
        documentLibrarySteps.selectPathToCopy(Destination);
        documentLibrarySteps.confirmCopyButtonClick();
        documentLibrarySteps.assetFromListClick(folderName);
        documentLibrarySteps.assetFromListClick(name);
        hmhDocumentDetailsSteps.checkDerivedFrom(name);
    }
}
