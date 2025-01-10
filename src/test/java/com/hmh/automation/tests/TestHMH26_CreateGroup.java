package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.steps.HMHDocumentLibrarySteps;
import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.GroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.tools.alfresco.Constants;

@Story(HMHApplication.Groups.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH26_CreateGroups.csv", separator = Constants.CSV_SEPARATOR)
public class TestHMH26_CreateGroup extends com.hmh.automation.tools.AbstractBaseSiteTest {

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
    private AdvancedSearchSteps advancedSearchSteps;
    @Steps
    private SearchResultsSteps searchResultsSteps;
    @Steps
    private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
    private GroupsSteps groupsSteps;
    @Steps
    private HMHDocumentLibrarySteps hmhDocumentLibrarySteps;

    String newGroup, siteTypeTest;

    @Override
    public void setSiteType() {
        siteType = siteTypeTest;
    }

    @Test
    @Title("TestHMH26 - Create_Group")
    public void testHMH26_Create_Group() {
        shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsGroupsMenuClick();
        groupsSteps.browseButtonClick();
        shareHeaderSteps.customWait(5);
        groupsSteps.newGroupButtonClick();
        groupsSteps.groupIdentifierInsert(newGroup);
        groupsSteps.groupNameInsert(newGroup);
        groupsSteps.createGroupButtonClick();
        hmhDocumentLibrarySteps.refresh();
        groupsSteps.checkIfGroupExists(newGroup);
        groupsSteps.deleteGroup(newGroup);
        hmhDocumentLibrarySteps.refresh();
    }

}
