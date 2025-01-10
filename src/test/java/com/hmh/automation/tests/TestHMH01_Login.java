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
import com.hmh.automation.tools.LoginPage;

import com.hmh.automation.tools.ConstantsHMH;
import com.hmh.automation.tools.HMHApplication;
import com.ixxus.ipm.automation.steps.alfresco.LoginSteps;

@Story(HMHApplication.Login.LoginIntoShare.class)
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = ConstantsHMH.CSV_FILES_BASE_PATH_HMH + "TestHMH01_Login.csv", separator = ConstantsHMH.CSV_SEPARATOR)
public class TestHMH01_Login extends TestCase {

    @Steps
    private LoginSteps loginSteps;

    String username, password, siteTypeTest;
    @Managed(uniqueSession = true)
    public WebDriver driver;
    @ManagedPages(defaultUrl = ConstantsHMH.ALFRESCO_URL)
    public Pages pages;

    @Test
    @Title("TestHMH01 - Login")
    public void test01_Login() {
        loginSteps.login(username, password);
    }
}
