package com.hmh.automation.tests;

import junit.framework.TestCase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.AdminToolsNavigationSteps;
import com.ixxus.ipm.automation.steps.alfresco.CreateUserSteps;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;
import com.ixxus.ipm.automation.steps.alfresco.ShareHeaderSteps;
import com.ixxus.ipm.automation.steps.alfresco.UsersSteps;

@Story(HMHApplication.Authentication.CreateUserForTests.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH001_CreateUserForTests.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH001_CreateUserForTests extends TestCase {

    @Managed(uniqueSession = true)
    public WebDriver driver;
    @ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
    public Pages pages;

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private ShareHeaderSteps shareHeaderSteps;
    @Steps
    private UsersSteps usersSteps;
    @Steps
    private AdminToolsNavigationSteps adminToolsNavigationSteps;
    @Steps
    private CreateUserSteps createUserSteps;

    String users;

    @Test
    @Title("TestHMH001 - Create User For Tests")
    public void testHMH001_CreateUserForTests() {
        loginSteps.login(ConstantsHMH.ADMIN_USERNAME, ConstantsHMH.ADMIN_PASSWORD);
        shareHeaderSteps.adminToolsButtonClick();
        adminToolsNavigationSteps.navigateToASpecificTool(users);
        //		adminToolsNavigationSteps.navigateToASpecificSite(users);
        usersSteps.searchUser(ConstantsHMH.TEST_USER_LOGIN);
        if (!usersSteps.checkIfUserExistsInSearchResults(ConstantsHMH.TEST_USER_LOGIN)) {
            usersSteps.newUserButtonClick();
            createUserSteps.createNewUser(ConstantsHMH.TEST_USER_LOGIN, "", ConstantsHMH.TEST_USER_EMAIL,
                    ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN,
                    ConstantsHMH.TEST_PASS_LOGIN, ConstantsHMH.TEST_USER_GROUP, true);
        }
        shareHeaderSteps.logoutButtonClick();
        loginSteps.login(ConstantsHMH.TEST_USER_LOGIN, ConstantsHMH.TEST_PASS_LOGIN);
    }
}
