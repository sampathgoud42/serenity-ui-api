package com.hmh.automation.tests;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.alfresco.AbstractBaseSiteTest;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.AdvancedSearchSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateContentSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateUserSteps;
import com.ixxus.ipm.automation.steps.alfresco.DashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentDetailsSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibraryLeftPanelSteps;
import com.ixxus.ipm.automation.steps.alfresco.DocumentLibrarySteps;
import com.ixxus.ipm.automation.steps.alfresco.GroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.InviteUsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.MembersSteps;
import com.ixxus.ipm.automation.steps.alfresco.SearchResultsSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteDashboardSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteFinderSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteGroupsSteps;
import com.ixxus.ipm.automation.steps.alfresco.SiteHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.UserEditProfileSteps;
import com.ixxus.ipm.automation.steps.alfresco.UsersSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.EditTaskSteps;
import com.ixxus.ipm.automation.steps.alfresco.workflows.TasksSteps;

@Story(HMHApplication.ManageRoles.Roles.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH02_InviteUsersToMySiteAsDiffrentRoles.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH02_InviteUsersToMySiteAsDiffrentRoles extends com.hmh.automation.tools.AbstractBaseSiteTest {

    @Steps
    private LoginSteps loginSteps;
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
    private UsersSteps usersSteps;
    @Steps
    private CreateUserSteps createUserSteps;
    @Steps
    private UserEditProfileSteps editUserProfileSteps;
    @Steps
    private MembersSteps membersSteps;
    @Steps
    private SiteGroupsSteps siteGroupsSteps;
    @Steps
    private InviteUsersSteps inviteUserSteps;
    @Steps
    private TasksSteps taskSteps;
    @Steps
    private EditTaskSteps editTaskSteps;
    @Steps
    private SiteDashboardSteps siteDashboardSteps;
    @Steps
    private CreateContentSteps createContentSteps;
   
    String username, password, userEmail, userPassword, roleName, taskName, siteTypeTest;
    String newUserName = RandomStringUtils.randomNumeric(7);
    String siteN = siteName;
    
    @Test
    @Title("TestHMH02 - Invite Users to my Site as consumer, contributor, collaborator")
    public void testHMH02_InviteUsersToMySiteAsDiffrentRoles() {
        shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        System.out.println(siteName);
        usersSteps.newUserButtonClick();
        //createUserSteps.createNewUser(newUserName, "", userEmail, newUserName, userPassword, userPassword, "");
        createUserSteps.createNewUser(newUserName, "", userEmail, newUserName, userPassword, userPassword,"", false );
        shareHeaderSteps.siteFinderButtonClick();
        siteFinderSteps.searchForASite(siteName);
        siteHeaderSteps.customWait(5);
        siteFinderSteps.openTheSiteFound(siteName);
        siteHeaderSteps.clickOnMembersButton();
        membersSteps.invitePeopleButtonClick();
        inviteUserSteps.addUser(newUserName);
        inviteUserSteps.checkIfUserWasAddedToLeftPanel(newUserName);
        siteGroupsSteps.selectRole(newUserName, roleName);
        inviteUserSteps.clickToInvite();
        siteHeaderSteps.customWait(5);
        shareHeaderSteps.logoutButtonClick();
        //Collaborator user thing
        loginSteps.login(newUserName, userPassword);
        dashboardSteps.selectTaskFromMyTask(taskName);
        //editTaskSteps.approveButtonClick();
        editTaskSteps.acceptButtonClick();
        
        shareHeaderSteps.siteFinderButtonClick();
        siteFinderSteps.searchForASite(siteName);
        siteHeaderSteps.customWait(5);
        siteFinderSteps.openTheSiteFound(siteName);
        siteDashboardSteps.checkSiteMember(newUserName, roleName);
        siteHeaderSteps.clickOnDocumentLibraryButton();
        if (roleName.contains("Consumer")) {
            createContentSteps.verifyCreateFolderIsDisabled();
        }
        shareHeaderSteps.logoutButtonClick();
        loginSteps.login(username, password);
        shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.adminToolsUsersMenuClick();
        usersSteps.searchUser(newUserName);
        siteHeaderSteps.customWait(5);
        usersSteps.selectUserFromSearchResults(newUserName);
        usersSteps.deleteUserButtonClick();
        shareHeaderSteps.sitesButtonClick();
        shareHeaderSteps.customWait(3);
    }
}
